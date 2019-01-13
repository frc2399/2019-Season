/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //TODO find real talon IDs
  public final static int LEFT_FRONT_TALON = 0;
  public final static int LEFT_MIDDLE_TALON = 0;
  public final static int LEFT_BACK_TALON = 0;
  public final static int RIGHT_FRONT_TALON = 0;
  public final static int RIGHT_MIDDLE_TALON = 0;
  public final static int RIGHT_BACK_TALON = 0;

  public final static int LEFT_FORWARD = 1;
  public final static int RIGHT_FORWARD = 1;
  
  public final static int LEFT_STICK_FORWARD = 1;
	public final static int RIGHT_STICK_FORWARD = -1;
}
