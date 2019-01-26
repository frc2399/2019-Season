/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Conveyer extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //motor for lower system
  //motor for higher system
  //pneumatics for intake + higher pulley

  private VictorSPX lowSys, highSys;
  private DoubleSolenoid intake, pulley;
  public boolean isIntakeExtended, isPulleyExtended, isBallInPosition;

  public Conveyer(){

    //TODO: find actual IDs
    lowSys = new VictorSPX(0);
    highSys = new VictorSPX(0);
    intake = new DoubleSolenoid(0, 0, 0);
    pulley = new DoubleSolenoid(0, 0, 0);

    isIntakeExtended = false;
    isPulleyExtended = false;
  }

  //set lower system speed
  public void setSpeedLowSys(double speed){
    lowSys.set(ControlMode.PercentOutput, speed);
  }

  //set higher system speed
  public void setSpeedHighSys(double speed){
    highSys.set(ControlMode.PercentOutput, speed);
  }

  //extend intake
  public void extendIntake(){
    intake.set(DoubleSolenoid.Value.kForward);
    isIntakeExtended = true;
  }

  //retract intake
  public void retractIntake(){
    intake.set(DoubleSolenoid.Value.kReverse);
    isIntakeExtended = false;
  }

  //extend pulley
  public void extendPulley(){
    pulley.set(DoubleSolenoid.Value.kForward);
    isPulleyExtended = true;
  }

  //retract pulley
  public void retractPulley(){
    pulley.set(DoubleSolenoid.Value.kReverse);
    isPulleyExtended = false;
  }

  //TODO: isBallInPosition
  public void ballPositioned(){
    isBallInPosition = true;
  }

  public void initDefaultCommand(Command c) {
		setDefaultCommand(c);
	}

  @Override
  public void initDefaultCommand() {
  }
}
