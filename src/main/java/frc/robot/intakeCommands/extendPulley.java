/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.intakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CargoElevator;

public class extendPulley extends Command {

  private CargoElevator con;
  
  public extendPulley(CargoElevator con) {
    this.con = con;
    requires(this.con);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    con.flipUpUpperConveyer();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }
}