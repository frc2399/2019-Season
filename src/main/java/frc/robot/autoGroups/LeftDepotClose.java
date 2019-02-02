/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoGroups;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;
import frc.robot.cargoCommands.*;


public class LeftDepotClose extends CommandGroup {
  /**
   * Starts from the left depot, goes to closest cargo slot
   */
  public LeftDepotClose(DriveTrain dt, AHRS navx, CargoElevator ca) {
    //drives to closest cargo slot

    //turns to slot

    //ejects ball
    addSequential(new ScoreCargoCargoship(ca));
  }
}
