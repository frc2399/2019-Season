package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {	
	
	private static final double CLOSED_LOOP_VOLTAGE_SATURATION = 10;
	private static final int WHEEL_DIAMETER = 4;
	private static final int ENCODER_TICKS_PER_REVOLUTION = 4096;
	private static final double GEAR_RATIO = 1.0 / 1.0;
	private static final int TALON_100MS_IN_1S = 10;
	
	public static final double DRIVETRAIN_FAST_KP = 0.8;
	public static final double DRIVETRAIN_FAST_KI = 0.004;
	public static final double DRIVETRAIN_FAST_KD = 35;
	public static final double DRIVETRAIN_FAST_KF = 0.1;
	
	private static final int PID_IDX = 0;
	private static final int CAN_TIMEOUT = 10;
	
	private double desiredLeftVelPrev;
	private double desiredRightVelPrev;
	private double actualLeftVelPrev;
	private double actualRightVelPrev;
	
	
	private IMotorControllerEnhanced leftTalon;
	private IMotorController leftVictor;
	
	private IMotorControllerEnhanced rightTalon;
	private IMotorController rightVictor;
	
	private IMotorController[] allMotorControllers;
	
	private double fuzz;
	
    public DriveTrain() {
    	
    	leftTalon = new TalonSRX(RobotMap.CAN.LEFT_DT_FRONT_ID);
    	leftVictor = new VictorSPX(RobotMap.CAN.LEFT_DT_BACK_ID);
    	
    	rightTalon = new TalonSRX(RobotMap.CAN.RIGHT_DT_FRONT_ID);
    	rightVictor = new VictorSPX(RobotMap.CAN.RIGHT_DT_BACK_ID);
    	
    	IMotorController[] allMotorControllers = {leftTalon, leftVictor, rightTalon, rightVictor};
    	this.allMotorControllers = allMotorControllers;
    	
		leftVictor.follow(leftTalon);
		rightVictor.follow(rightTalon);
    	
    	// timeout constants
    	leftTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, PID_IDX, CAN_TIMEOUT);
    	rightTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, PID_IDX, CAN_TIMEOUT);
    	leftTalon.setSensorPhase(false);
    	rightTalon.setSensorPhase(false);
    	
    	// timeout constants
		setConstants(DRIVETRAIN_FAST_KP, DRIVETRAIN_FAST_KI, DRIVETRAIN_FAST_KD, DRIVETRAIN_FAST_KF);
		
		for(IMotorController talon : allMotorControllers) {
    		talon.configClosedloopRamp(0.15, CAN_TIMEOUT);
    		talon.configOpenloopRamp(0.15, CAN_TIMEOUT);
    	}
		
		enableVoltageComp();
		brakeMode();
		
		desiredLeftVelPrev = 0;
		desiredRightVelPrev = 0;
		actualLeftVelPrev = 0;
		actualRightVelPrev = 0;
		
		fuzz = 0.001;
    }
    
    public void initDefaultCommand(Command c) {
    	setDefaultCommand(c);
    }
    
    public void drivePercent(double leftPercent, double rightPercent) {
		
		double leftPercentForward = leftPercent * RobotMap.Physical.DriveTrain.LEFT_FORWARD;
		double rightPercentForward = rightPercent * RobotMap.Physical.DriveTrain.RIGHT_FORWARD;
		
		leftTalon.set(ControlMode.PercentOutput, leftPercentForward);
		rightTalon.set(ControlMode.PercentOutput, rightPercentForward);
	
	}
    
    public double toInPerSecFromNativeTalon(double talonNative) {
    	return talonNative * (WHEEL_DIAMETER * (Math.PI / ENCODER_TICKS_PER_REVOLUTION)) * GEAR_RATIO * TALON_100MS_IN_1S;
    }
    
    public double toNativeTalonFromInPerSec(double inPerSec) {
    	// 60.0 / 24.0
    	return inPerSec * (4096.0 / (4.0 * Math.PI)) * (1.0 / 10.0);
    }

    public void driveVelocity(double leftVelocity, double rightVelocity) {
		flipFuzz();
    	
    	double desiredLeftVelocityForward = toNativeTalonFromInPerSec(leftVelocity) * RobotMap.Physical.DriveTrain.LEFT_FORWARD ;
		double desiredRightVelocityForward = toNativeTalonFromInPerSec(rightVelocity) * RobotMap.Physical.DriveTrain.RIGHT_FORWARD;
		
		leftTalon.set(ControlMode.Velocity, desiredLeftVelocityForward);
		rightTalon.set(ControlMode.Velocity, desiredRightVelocityForward);
		
		double actualLeftVelocityForward = leftTalon.getSelectedSensorVelocity(0);
		double actualRightVelocityForward = rightTalon.getSelectedSensorVelocity(0);
		
		double[] leftVelocityArr = {desiredLeftVelocityForward, actualLeftVelocityForward, fuzz};
		double[] rightVelocityArr = {desiredRightVelocityForward, actualRightVelocityForward, fuzz};
		
		SmartDashboard.putNumberArray("leftVelocity", leftVelocityArr);
		SmartDashboard.putNumberArray("rightVelocity", rightVelocityArr);
		
		
		double desiredLeftAccel = desiredLeftVelocityForward - desiredLeftVelPrev;
		double desiredRightAccel = desiredRightVelocityForward - desiredRightVelPrev;
		
		double actualLeftAccel = actualLeftVelocityForward - actualLeftVelPrev;
		double actualRightAccel = actualRightVelocityForward - actualRightVelPrev;
		
		
		double[] leftAccelArr = {desiredLeftAccel, actualLeftAccel, fuzz};
		double[] rightAccelArr = {desiredRightAccel, actualRightAccel, fuzz};
		
		SmartDashboard.putNumberArray("leftAccel",  leftAccelArr);
		SmartDashboard.putNumberArray("rightAccel", rightAccelArr);
		
		
		desiredLeftVelPrev = desiredLeftVelocityForward;
		desiredRightVelPrev = desiredRightVelocityForward;
		
		actualLeftVelPrev = actualLeftVelocityForward;
		actualRightVelPrev = actualRightVelocityForward;
		
    }
    
    public void enableVoltageComp() {
    	for(IMotorController talon : allMotorControllers) {
    		talon.configVoltageCompSaturation(CLOSED_LOOP_VOLTAGE_SATURATION, CAN_TIMEOUT);
    		talon.enableVoltageCompensation(true);
    	}
    }
    
    public void disableVoltageComp() {
    	for(IMotorController talon : allMotorControllers) {
    		talon.enableVoltageCompensation(false);
    	}
    }
    
    public void brakeMode() {
    	for(IMotorController talon : allMotorControllers) {
    		talon.setNeutralMode(NeutralMode.Brake);
    	}
    }
    
    public void coastMode() {
    	for(IMotorController talon : allMotorControllers) {
    		talon.setNeutralMode(NeutralMode.Coast);
    	}
    }
    
    public void setConstants(double p, double i, double d, double f) {
    	leftTalon.configNominalOutputForward(0, CAN_TIMEOUT);
		leftTalon.configNominalOutputReverse(0, CAN_TIMEOUT);
		leftTalon.configPeakOutputForward(1, CAN_TIMEOUT);
		leftTalon.configPeakOutputReverse(-1, CAN_TIMEOUT);

		leftTalon.config_kF(0, f, CAN_TIMEOUT);
		leftTalon.config_kP(0, p, CAN_TIMEOUT);
		leftTalon.config_kI(0, i, CAN_TIMEOUT);
		leftTalon.config_kD(0, d, CAN_TIMEOUT);
		
		rightTalon.configNominalOutputForward(0, CAN_TIMEOUT);
		rightTalon.configNominalOutputReverse(0, CAN_TIMEOUT);
		rightTalon.configPeakOutputForward(1, CAN_TIMEOUT);
		rightTalon.configPeakOutputReverse(-1, CAN_TIMEOUT);

		rightTalon.config_kF(0, f, CAN_TIMEOUT);
		rightTalon.config_kP(0, p, CAN_TIMEOUT);
		rightTalon.config_kI(0, i, CAN_TIMEOUT);
		rightTalon.config_kD(0, d, CAN_TIMEOUT);
    }
    
    private void flipFuzz() {
    	fuzz *= -1;
    }

	@Override
	protected void initDefaultCommand() {
		
	}
}

