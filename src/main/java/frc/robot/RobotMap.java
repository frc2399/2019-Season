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
	public static class CAN {
		public static final int PCM = 1;
		public static final byte PDP = 0;
		
		public static final int LEFT_DT_FRONT_ID = 2;
		public static final int LEFT_DT_BACK_ID = 1;
		public static final int RIGHT_DT_FRONT_ID = 3;
		public static final int RIGHT_DT_BACK_ID = 7;

		// public static final int LOWER_CA_ID = 3;
		// public static final int UPPER_CA_ID = 2;

	}
	
	public static class PCM {
		public static final int CA_INTAKE_EXTEND = 1;
		public static final int CA_INTAKE_RETRACT = 3;
		public static final int CA_UPPER_CONVEYER_HORIZONTAL = 2;
		public static final int CA_UPPER_CONVEYER_VERTICAL = 4;
		
	}

	public static class DIO {
		public static final int CARGO_SENSOR = 0;
	}
	
	public static class Physical {
		public static class DriveTrain {
			public static final double DRIVETRAIN_WHEEL_DIAMETER = 6.0;
			public static final double WHEEL_CIRCUMFERENCE = DRIVETRAIN_WHEEL_DIAMETER * Math.PI;
			public static final double ENCODER_COUNT = 4096;
			
			public static final int LEFT_FORWARD = 1;
			public static final int RIGHT_FORWARD = -1;
			
			public static final double ROBOT_LENGTH = 28.6;
			public static final double ROBOT_WIDTH = 30.5;	
		}
		
	}	

	public static class Autonomous {
		public static final int OFF_SECOND_PLATFORM = 72;
		public static final int OFF_FIRST_PLATFORM = 0;
	}

	public static final double ANGLE_TOLERANCE = 0.75;
	public static final double EJECT_SPEED = 1;
}
