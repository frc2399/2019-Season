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

public class LeftCargoMiddle extends CommandGroup {
  /**
   * Starts from the left, goes to the middle cargo slot, goes to depot, picks up ball
   */
  public LeftCargoMiddle(DriveTrain dt, AHRS navx, CargoElevator ca) {
    //drives off level 2 platform
    addSequential(new DriveDistance(dt, navx, 48));
    //drives to closest cargo slot
    addSequential(new DriveDistance(dt, navx, -8.5));
    addSequential(new DriveDistance(dt, navx, 134));
    addSequential(new TurnAngle(dt, navx, -15, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 90.6));
    
    //turns to slot
    addSequential(new TurnAngle(dt, navx, 105, EndAngleMeaning.RELATIVE));
    //drives forward to slot
    addSequential(new DriveDistance(dt, navx, 24.35));
    //ejects ball
    addSequential(new ScoreCargoCargoship(ca));
    //drives to depot
    addSequential(new DriveDistance(dt, navx, -57.85));
    addSequential(new TurnAngle(dt, navx, 90, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 230.3));
    addSequential(new TurnAngle(dt, navx, -45, EndAngleMeaning.RELATIVE));
    
    //extends intake
    addSequential(new ExtendIntake(ca));
    //drives to ball and intakes
    addParallel(new IntakeCargo(ca));
    addSequential(new DriveDistance(dt, navx, 20));
  }
}
