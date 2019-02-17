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
import frc.robot.commands.TurnAngle.EndAngleMeaning;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;
import frc.robot.cargoCommands.*;

public class RightDepotClose extends CommandGroup {
  /**
   * Starts from the right depot, goes to closest cargo slot
   */
  public RightDepotClose(DriveTrain dt, AHRS navx, CargoElevator ca) {
    //drives to closest cargo slot
    addSequential(new TurnAngle(dt, navx, 90, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 20));
    addSequential(new TurnAngle(dt, navx, -45, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 207.3));
    //turns to slot
    addSequential(new TurnAngle(dt, navx, -90, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 57.85));

    //ejects ball
    addSequential(new ScoreCargoCargoship(ca));
  }
}
