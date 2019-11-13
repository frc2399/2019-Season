package frc.robot;

import java.util.HashMap;
import java.util.Map;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.autoGroups.*;
import frc.robot.subsystems.CargoElevator;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;

public class AutoChooser{
    public static enum Position {LEFT, MIDDLE, RIGHT;}
    public static enum Side {LEFT, RIGHT;}
    public static enum FirstLocation {CARGO_CLOSE, CARGO_MIDDLE, CARGO_FAR;}
    public static enum SecondLocation {CARGO_CLOSE, CARGO_MIDDLE, CARGO_FAR, ROCKET;}

    private Map<AutoState, Command[]> map;
	
	public AutoChooser(DriveTrain dt, CargoElevator ca, Climber cl, AHRS navx) {		
        map = new HashMap<>();

        //new Command[]{new LeftCargoClose(), new LeftCargoMiddle()}

        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new LeftCargoClose(dt, navx, ca), new LeftDepotRocket(dt, navx, ca) });
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new LeftCargoClose(dt, navx, ca), new LeftDepotMiddle(dt, navx, ca) });
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new LeftCargoClose(dt, navx, ca), new LeftDepotFar(dt, navx, ca) });
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_CLOSE, SecondLocation.ROCKET, Side.LEFT), new Command[]{new LeftCargoClose(dt, navx, ca), new LeftDepotRocket(dt, navx, ca) });
        
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new LeftCargoMiddle(dt, navx, ca), new LeftDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new LeftCargoMiddle(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new LeftCargoMiddle(dt, navx, ca), new LeftDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_MIDDLE, SecondLocation.ROCKET, Side.LEFT), new Command[]{new LeftCargoMiddle(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});

        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new LeftCargoFar(dt, navx, ca), new LeftDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new LeftCargoFar(dt, navx, ca), new LeftDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new LeftCargoFar(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_FAR, SecondLocation.ROCKET, Side.LEFT), new Command[]{new LeftCargoFar(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});

    
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new LeftCargoClose(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new LeftCargoClose(dt, navx, ca), new LeftDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new LeftCargoClose(dt, navx, ca), new LeftDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_CLOSE, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new LeftCargoClose(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new LeftCargoMiddle(dt, navx, ca), new LeftDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new LeftCargoMiddle(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new LeftCargoMiddle(dt, navx, ca), new LeftDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_MIDDLE, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new LeftCargoMiddle(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});

        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new LeftCargoFar(dt, navx, ca), new LeftDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new LeftCargoFar(dt, navx, ca), new LeftDepotMiddle(dt, navx, ca) });
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new LeftCargoFar(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.LEFT, FirstLocation.CARGO_FAR, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new LeftCargoFar(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});

        // ----------------------------------------------------------------------------------------------------------------------

        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new MiddleCargoLeftClose(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new MiddleCargoLeftClose(dt, navx, ca), new LeftDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new MiddleCargoLeftClose(dt, navx, ca), new LeftDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_CLOSE, SecondLocation.ROCKET, Side.LEFT), new Command[]{new MiddleCargoLeftClose(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new MiddleCargoLeftMiddle(dt, navx, ca), new LeftDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new MiddleCargoLeftMiddle(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new MiddleCargoLeftMiddle(dt, navx, ca), new LeftDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_MIDDLE, SecondLocation.ROCKET, Side.LEFT), new Command[]{new MiddleCargoLeftMiddle(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});

        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_FAR, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new MiddleCargoLeftFar(dt, navx, ca), new LeftDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_FAR, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new MiddleCargoLeftFar(dt, navx, ca), new LeftDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_FAR, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new MiddleCargoLeftFar(dt, navx, ca), new LeftDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_FAR, SecondLocation.ROCKET, Side.LEFT), new Command[]{new MiddleCargoLeftFar(dt, navx, ca), new LeftDepotClose(dt, navx, ca)});


        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new MiddleCargoRightClose(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new MiddleCargoRightClose(dt, navx, ca), new RightDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new MiddleCargoRightClose(dt, navx, ca), new RightDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_CLOSE, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new MiddleCargoRightClose(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new MiddleCargoRightMiddle(dt, navx, ca), new RightDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new MiddleCargoRightMiddle(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new MiddleCargoRightMiddle(dt, navx, ca), new RightDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_MIDDLE, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new MiddleCargoRightMiddle(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});

        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_FAR, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new MiddleCargoRightFar(dt, navx, ca), new RightDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_FAR, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new MiddleCargoRightFar(dt, navx, ca), new RightDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_FAR, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new MiddleCargoRightFar(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.MIDDLE, FirstLocation.CARGO_FAR, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new MiddleCargoRightFar(dt, navx, ca), new RightDepotClose(dt, navx, ca)});
        
        // ----------------------------------------------------------------------------------------------------------------------

        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new RightCargoClose(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new RightCargoClose(dt, navx, ca), new RightDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new RightCargoClose(dt, navx, ca), new RightDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_CLOSE, SecondLocation.ROCKET, Side.LEFT), new Command[]{new RightCargoClose(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new RightCargoMiddle(dt, navx, ca), new RightDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new RightCargoMiddle(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new RightCargoMiddle(dt, navx, ca), new RightDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_MIDDLE, SecondLocation.ROCKET, Side.LEFT), new Command[]{new RightCargoMiddle(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});

        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_CLOSE, Side.LEFT), new Command[]{new RightCargoFar(dt, navx, ca), new RightDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_MIDDLE, Side.LEFT), new Command[]{new RightCargoFar(dt, navx, ca), new RightDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_FAR, Side.LEFT), new Command[]{new RightCargoFar(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_FAR, SecondLocation.ROCKET, Side.LEFT), new Command[]{new RightCargoFar(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});


        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new RightCargoClose(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new RightCargoClose(dt, navx, ca), new RightDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_CLOSE, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new RightCargoClose(dt, navx, ca), new RightDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_CLOSE, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new RightCargoClose(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new RightCargoMiddle(dt, navx, ca), new RightDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new RightCargoMiddle(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_MIDDLE, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new RightCargoMiddle(dt, navx, ca), new RightDepotFar(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_MIDDLE, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new RightCargoMiddle(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});

        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_CLOSE, Side.RIGHT), new Command[]{new RightCargoFar(dt, navx, ca), new RightDepotClose(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_MIDDLE, Side.RIGHT), new Command[]{new RightCargoFar(dt, navx, ca), new RightDepotMiddle(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_FAR, SecondLocation.CARGO_FAR, Side.RIGHT), new Command[]{new RightCargoFar(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});
        map.put(new AutoState(Position.RIGHT, FirstLocation.CARGO_FAR, SecondLocation.ROCKET, Side.RIGHT), new Command[]{new RightCargoFar(dt, navx, ca), new RightDepotRocket(dt, navx, ca)});

    }


    public static class AutoState {
    
        @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((firstLoc == null) ? 0 : firstLoc.hashCode());
			result = prime * result + ((pos == null) ? 0 : pos.hashCode());
            result = prime * result + ((secondLoc == null) ? 0 : secondLoc.hashCode());
            result = prime * result + ((side == null) ? 0 : side.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AutoState other = (AutoState) obj;
			if (firstLoc != other.firstLoc)
				return false;
			if (pos != other.pos)
				return false;
			if (secondLoc != other.secondLoc)
                return false;
            if (side != other.side)
				return false;    
			return true;
		}

        public final Position pos;
        public final FirstLocation firstLoc;
        public final SecondLocation secondLoc;
        public final Side side;
        
        public AutoState (Position pos, FirstLocation firstLoc, SecondLocation secondLoc, Side side) {
            this.pos = pos;
            this.firstLoc = firstLoc;
            this.secondLoc = secondLoc;
            this.side = side;
        }
    
        public Command makeAutoCommand (Position p, FirstLocation s, SecondLocation n, Side si) {		
            return makeAutoCommand(p, s, n, si);
        }
    }



}
