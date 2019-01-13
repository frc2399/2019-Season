/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Drivetrain extends Subsystem {

  TalonSRX leftFront, leftMiddle, leftBack, rightFront, rightMiddle, rightBack;

  public Drivetrain(){
    leftFront = new TalonSRX(RobotMap.LEFT_FRONT_TALON);
    leftMiddle = new TalonSRX(RobotMap.LEFT_FRONT_TALON);
    leftBack = new TalonSRX(RobotMap.LEFT_FRONT_TALON);

    rightFront = new TalonSRX(RobotMap.RIGHT_FRONT_TALON);
    rightMiddle = new TalonSRX(RobotMap.RIGHT_FRONT_TALON);
    rightBack = new TalonSRX(RobotMap.RIGHT_FRONT_TALON);

    leftMiddle.follow(leftFront);
		leftBack.follow(leftFront);
		rightMiddle.follow(rightFront);
		rightBack.follow(rightFront);
  }

  public void drivePercent(double leftPercent, double rightPercent) {
    
    double leftPercentForward = leftPercent * RobotMap.LEFT_FORWARD;
		double rightPercentForward = rightPercent * RobotMap.RIGHT_FORWARD;
		
		leftFront.set(ControlMode.PercentOutput, leftPercentForward);
    rightFront.set(ControlMode.PercentOutput,rightPercentForward);
    
	}

  public void initDefaultCommand(Command c) {
		setDefaultCommand(c);
	}

  @Override
  public void initDefaultCommand() {
  }
}
