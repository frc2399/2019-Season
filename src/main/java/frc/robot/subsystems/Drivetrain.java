/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Drivetrain extends Subsystem {

  TalonSRX leftTalon, rightTalon;
  VictorSPX leftVictor, rightVictor;


  public Drivetrain(){
    leftTalon = new TalonSRX(RobotMap.LEFT_TALON);
    leftVictor = new VictorSPX(RobotMap.LEFT_VICTOR);

    rightTalon = new TalonSRX(RobotMap.RIGHT_TALON);
    rightVictor = new VictorSPX(RobotMap.RIGHT_VICTOR);

    leftVictor.follow(leftTalon);
		rightVictor.follow(rightTalon);
  }

  public void drivePercent(double leftPercent, double rightPercent) {
    
    double leftPercentForward = leftPercent * RobotMap.LEFT_FORWARD;
		double rightPercentForward = rightPercent * RobotMap.RIGHT_FORWARD;
		
		leftTalon.set(ControlMode.PercentOutput, leftPercentForward);
    rightTalon.set(ControlMode.PercentOutput, rightPercentForward);
    
	}

  public void initDefaultCommand(Command c) {
		setDefaultCommand(c);
	}

  @Override
  public void initDefaultCommand() {
  }
}
