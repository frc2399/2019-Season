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

public class MiddleCargoLeftMiddle extends CommandGroup {
  /**
   * Starts from the middle, goes to the middle left cargo slot, goes to depot, picks up ball
   */
  public MiddleCargoLeftMiddle(DriveTrain dt, AHRS navx, CargoElevator ca) {
    //drives off level 1 platform
    addSequential(new DriveDistance(dt, navx, RobotMap.Autonomous.OFF_FIRST_PLATFORM));
    //drives to middle left cargo slot

    //turns to slot

    //ejects ball
    addSequential(new ScoreCargoCargoship(ca));
    //drives to depot

    //extends intake
    addSequential(new ExtendIntake(ca));
    //picks up ball
    addSequential(new IntakeCargo(ca));
  }
}
