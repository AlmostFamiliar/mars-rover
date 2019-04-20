package rover.rover;

import rover.map.Position;

public class WestRover extends Rover {
    private static final char ROVER_ORIENTATION = '<';

    WestRover(Position position) {
        super(position);
    }

    @Override
    public Rover moveForward() {
        final Position position = new Position(getPosition().getxCoordinate() - 1, getPosition().getyCoordinate());
        return new WestRover(position);
    }

    @Override
    public Rover moveBackward() {
        final Position position = new Position(getPosition().getxCoordinate() + 1, getPosition().getyCoordinate());
        return new WestRover(position);
    }

    @Override
    public Rover turnLeft() {
        return new SouthRover(getPosition());
    }

    @Override
    public Rover turnRight() {
        return new NorthRover(getPosition());
    }

    @Override
    public char getRoverOrientation() {
        return ROVER_ORIENTATION;
    }
}
