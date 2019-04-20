package rover.rover.states;

import rover.map.Position;
import rover.rover.Rover;

public class NorthRover extends Rover {
    public static final char ROVER_ORIENTATION = '^';

    public NorthRover(Position position) {
        super(position);
    }

    @Override
    public Rover moveForward() {
        final Position position = new Position(getPosition().getxCoordinate(), getPosition().getyCoordinate() - 1);
        return new NorthRover(position);
    }

    @Override
    public Rover moveBackward() {
        final Position position = new Position(getPosition().getxCoordinate(), getPosition().getyCoordinate() + 1);
        return new NorthRover(position);
    }

    @Override
    public Rover turnLeft() {
        return new WestRover(getPosition());
    }

    @Override
    public Rover turnRight() {
        return new EastRover(getPosition());
    }

    @Override
    public char getRoverOrientation() {
        return ROVER_ORIENTATION;
    }
}
