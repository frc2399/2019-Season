/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.intakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Conveyer;

public class spinLowIn extends Command {
  
  Conveyer con;
  
  public spinLowIn(Conveyer con) {
    this.con = con;
    requires(this.con);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    con.setSpeedHighSys(1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return con.isBallInPosition;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    con.setSpeedHighSys(0);
  }
}
