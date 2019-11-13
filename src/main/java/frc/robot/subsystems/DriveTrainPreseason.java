/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Drivetrain for preseason
 */
public class DriveTrainPreseason extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //global variables
  private IMotorControllerEnhanced leftBackTalon;
  private IMotorController leftFrontTalon;
  private IMotorControllerEnhanced rightBackTalon;
  private IMotorController rightFrontTalon;
  //constructor
  public DriveTrainPreseason(){
  //initialize talons
    leftBackTalon = new TalonSRX(RobotMap.CAN.LEFT_DT_BACK_ID);
    leftFrontTalon = new TalonSRX(RobotMap.CAN.LEFT_DT_FRONT_ID);
    rightBackTalon = new TalonSRX(RobotMap.CAN.RIGHT_DT_BACK_ID);
    rightFrontTalon = new TalonSRX(RobotMap.CAN.RIGHT_DT_FRONT_ID);
    
    //front follows back
    leftFrontTalon.follow(leftBackTalon);
    rightFrontTalon.follow(rightBackTalon);
  }

  // drive percent
  public void drivePercent(double leftPercent, double rightPercent) {
    double rightPercentForward = rightPercent * RobotMap.Physical.DriveTrain.RIGHT_FORWARD;
    double leftPercentForward = rightPercent * RobotMap.Physical.DriveTrain.LEFT_FORWARD;
 
    leftBackTalon.set(ControlMode.PercentOutput, leftPercentForward);
    rightBackTalon.set(ControlMode.PercentOutput, rightPercentForward);

  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
