/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.cargoCommands.*;
import frc.robot.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick xBox = new Joystick(0);

  private Button[] xBoxButtons;
	
	public OI(Drivetrain dt, CargoElevator ca){	
		xBoxButtons = getButtons(xBox);
		xBoxButtons[1].whileHeld(new ScoreCargoRocket(ca));
		xBoxButtons[2].whileHeld(new ScoreCargoCargoship(ca));
		xBoxButtons[3].whileHeld(new ReverseIntake(ca));
		xBoxButtons[4].whenPressed(new IntakeCargo(ca));
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
	public static Button[] getButtons(Joystick controller) {
		Button[] controllerButtons = new Button[controller.getButtonCount() + 1];
		for(int i = 1; i < controllerButtons.length; i++) {
			controllerButtons[i] = new JoystickButton(controller, i);
		}
		return controllerButtons;
	}
}
