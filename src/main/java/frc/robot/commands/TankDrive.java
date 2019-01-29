/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends Command {

  DriveTrain dt;
	DoubleSupplier leftPercent, rightPercent;
	
	public TankDrive(DriveTrain dt, DoubleSupplier leftPercent, DoubleSupplier rightPercent) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.dt = dt;
    	this.leftPercent = leftPercent;
    	this.rightPercent = rightPercent;
    	
    	requires(this.dt);
		setInterruptible(true);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	dt.disableVoltageComp();
    	dt.brakeMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	dt.drivePercent(leftPercent.getAsDouble(), rightPercent.getAsDouble());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
