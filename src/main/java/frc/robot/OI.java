/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.cargoCommands.*;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.KajDrive;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static final double DEADBAND_WIDTH = 0.1;
	
	public static Button[] getButtons(Joystick controller) {
		Button[] controllerButtons = new Button[controller.getButtonCount() + 1];
		for(int i = 1; i < controllerButtons.length; i++) {
			controllerButtons[i] = new JoystickButton(controller, i);
		}
		return controllerButtons;
	}

	Joystick xBox, stick; 
	Button [] xBoxButtons, stickButtons;
	
	private Command defaultDrive;
	private KajDrive kajDrive;
	private TankDrive tankDrive;

	public OI(DriveTrain dt, CargoElevator ca, AHRS navx) {
		
		xBox = new Joystick(0);
		stick = new Joystick(1);
		
		DoubleSupplier rightShoulder = ()->xBox.getRawAxis(3);
		DoubleSupplier leftShoulder = ()->(xBox.getRawAxis(2));
		DoubleSupplier rightX = ()->(xBox.getRawAxis(4));
		DoubleSupplier rightY = ()->(xBox.getRawAxis(5) * -1);
		DoubleSupplier leftY = ()->(xBox.getRawAxis(1) * -1);
		DoubleSupplier stickY = ()->(stick.getRawAxis(1) * -1);
		DoubleSupplier stickThrottle = ()->(throttleToPositiveRange(stick.getRawAxis(2) * -1));
		
		kajDrive = new KajDrive(dt, leftY, rightX, leftShoulder, rightShoulder);
		tankDrive = new TankDrive(dt, leftY, rightY);
		
		defaultDrive = kajDrive;
		
		xBoxButtons = getButtons(xBox);
		stickButtons = getButtons(stick);

		// xBoxButtons[1].whileHeld(new ScoreCargoRocket(ca));
		// xBoxButtons[2].whileHeld(new ScoreCargoCargoship(ca));
		// xBoxButtons[3].whileHeld(new ReverseIntake(ca));
		// xBoxButtons[4].whenPressed(new IntakeCargo(ca));

		xBoxButtons[1].whenPressed(new DriveDistance(dt, navx, 5));
	}
	
	public static double throttleToPositiveRange(double input) {
		return (input + 1) / 2;
	}

	public static BooleanSupplier thresholdDoubleSupplier(DoubleSupplier d, double threshold) {
		
		return () -> d.getAsDouble() > threshold;
	}

	public Command defaultDrive() {
		return defaultDrive;
	}

}
