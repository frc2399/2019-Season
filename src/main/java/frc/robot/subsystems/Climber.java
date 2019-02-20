/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  VictorSPX climberLeft, climberRight;
  

  public Climber(){
    climberLeft = new VictorSPX(RobotMap.CAN.LEFT_CL_ID);
    climberRight = new VictorSPX(RobotMap.CAN.RIGHT_CL_ID);
  }

  public void setPercent(double percent){
    climberLeft.set(ControlMode.PercentOutput, percent * RobotMap.Physical.Climber.LEFT_FORWARD);
    climberRight.set(ControlMode.PercentOutput, percent * RobotMap.Physical.Climber.RIGHT_FORWARD);
  }


  public void initDefaultCommand(Command c) {
    setDefaultCommand(c);
  }

  @Override
  public void initDefaultCommand() {
  }
}
