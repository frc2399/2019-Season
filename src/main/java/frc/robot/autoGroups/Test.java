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


public class Test extends CommandGroup {
  /**
   * Starts from the left, goes to the closest cargo slot, goes to depot, picks up ball
   */
  public Test(DriveTrain dt, AHRS navx, CargoElevator ca) {
    //addSequential(new DriveDistance(dt, navx, number goes here));
    //addSequential(new TurnAngle(dt, navx, number goes here, EndAngleMeaning.RELATIVE));    
  }
}
