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

public class RightCargoClose extends CommandGroup {
  /**
   * Starts from the right, goes to the closest cargo slot, goes to depot, picks up ball
   */
  public RightCargoClose(DriveTrain dt, AHRS navx, CargoElevator ca) {
    //drives off level 2 platform
    addSequential(new DriveDistance(dt, navx, 36));
    //drives to closest cargo slot
    addSequential(new DriveDistance(dt, navx, -50));
    addSequential(new DriveDistance(dt, navx, 84));
    addSequential(new TurnAngle(dt, navx, 15, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 61));
    
    //turns to slot
    addSequential(new TurnAngle(dt, navx, -105, EndAngleMeaning.RELATIVE));
    //drives forward to slot
    addSequential(new DriveDistance(dt, navx, 12));
    //ejects ball
    addSequential(new ScoreCargoCargoship(ca));
    //drives to depot
    addSequential(new DriveDistance(dt, navx, -12));
    addSequential(new TurnAngle(dt, navx, -90, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 92));
    addSequential(new TurnAngle(dt, navx, -90, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 32));
    addSequential(new TurnAngle(dt, navx, 90, EndAngleMeaning.RELATIVE));
    addSequential(new DriveDistance(dt, navx, 35));
    addSequential(new TurnAngle(dt, navx, 45, EndAngleMeaning.RELATIVE));
    
    //extends intake
    addSequential(new ExtendIntake(ca));
    //drives to ball and intakes
    addParallel(new IntakeCargo(ca));
    addSequential(new DriveDistance(dt, navx, 18));
  }
}
