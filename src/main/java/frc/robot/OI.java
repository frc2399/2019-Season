/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick xBox = new Joystick(0);
	
	public OI(Drivetrain dt){		
	}
	
	public double getLeftStickX() {
		return xBox.getRawAxis(0);
	}
	
	public double getLeftStickY() {
		return xBox.getRawAxis(1) * RobotMap.LEFT_STICK_FORWARD;
	}
	
	public double getRightStickX() {
		return xBox.getRawAxis(4); 
	}
	
	public double getRightStickY() {
		return xBox.getRawAxis(5) * RobotMap.RIGHT_STICK_FORWARD; 
	}
}
