/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.cargoCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CargoElevator;

public class ReverseIntake extends Command {
  
  CargoElevator con;
  
  public ReverseIntake(CargoElevator con) {
    this.con = con;
    requires(this.con);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    con.setRotationLowerConveyer(-1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void interrupted() {
    end();
  }

  @Override
  protected void end() {
    con.setRotationLowerConveyer(0);
  }
}
