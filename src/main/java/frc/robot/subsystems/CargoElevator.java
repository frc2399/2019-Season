/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CargoElevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //motor for lower system
  //motor for higher system
  //pneumatics for intake + higher pulley

  private TalonSRX lowerConveyerRotation, upperConveyerRotation;
  private DoubleSolenoid intakeExtendRetract, upperConveyerFlip;
  private DigitalInput cargoPossessionSensor;
  public boolean isIntakeExtended, isUpperConveyerExtended;

  public CargoElevator(){

    // lowerConveyerRotation = new TalonSRX(RobotMap.CAN.LOWER_CA_ID);
    // upperConveyerRotation = new TalonSRX(RobotMap.CAN.UPPER_CA_ID);
    // intakeExtendRetract = new DoubleSolenoid(RobotMap.CAN.PCM, RobotMap.PCM.CA_INTAKE_RETRACT, RobotMap.PCM.CA_INTAKE_EXTEND);
    // upperConveyerFlip = new DoubleSolenoid(RobotMap.CAN.PCM, RobotMap.PCM.CA_UPPER_CONVEYER_VERTICAL, RobotMap.PCM.CA_UPPER_CONVEYER_HORIZONTAL);
    // cargoPossessionSensor = new DigitalInput(RobotMap.DIO.CARGO_SENSOR);

    isIntakeExtended = false;
    isUpperConveyerExtended = false;
  }

  //set lower system speed
  public void setRotationLowerConveyer(double speed){
    lowerConveyerRotation.set(ControlMode.PercentOutput, speed);
  }

  //set higher system speed
  public void setRotationUpperConveyer(double speed){
    upperConveyerRotation.set(ControlMode.PercentOutput, speed);
  }

  //extend intake
  public void extendIntake(){
    intakeExtendRetract.set(DoubleSolenoid.Value.kForward);
    isIntakeExtended = true;
  }

  //retract intake
  public void retractIntake(){
    intakeExtendRetract.set(DoubleSolenoid.Value.kReverse);
    isIntakeExtended = false;
  }

  //extend pulley
  public void flipHorizontalUpperConveyer(){
    upperConveyerFlip.set(DoubleSolenoid.Value.kForward);
    isUpperConveyerExtended = true;
  }

  //retract pulley
  public void flipVerticalUpperConveyer(){
    upperConveyerFlip.set(DoubleSolenoid.Value.kReverse);
    isUpperConveyerExtended = false;
  }

  public boolean isCargoReadyToBeEjected(){
    return !cargoPossessionSensor.get();
  }

  public void initDefaultCommand(Command c) {
		setDefaultCommand(c);
	}

  @Override
  public void initDefaultCommand() {
  }
}
