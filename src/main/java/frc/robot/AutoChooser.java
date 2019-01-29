package frc.robot;

import java.util.HashMap;
import java.util.Map;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.autoGroups.*;

public class AutoChooser{
    public static enum Position {LEFT, MIDDLE, RIGHT;}
    public static enum FirstLocation {CARGO_CLOSE, CARGO_MIDDLE, CARGO_FAR;}
    public static enum SecondLocation {CARGO_CLOSE, CARGO_MIDDLE, CARGO_FAR, ROCKET;}
}
