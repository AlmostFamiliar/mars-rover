package rover.rover;

import rover.map.Position;

public class EastRover extends Rover {
    private static final char ROVER_ORIENTATION = '>';

    EastRover(Position position) {
        super(position);
    }

    @Override
    public Rover moveForward() {
        final Position position = new Position(getPosition().getxCoordinate() + 1, getPosition().getyCoordinate());
        return new EastRover(position);
    }

    @Override
    public Rover moveBackward() {
        final Position position = new Position(getPosition().getxCoordinate() - 1, getPosition().getyCoordinate());
        return new EastRover(position);
    }

    @Override
    public Rover turnLeft() {
        return new NorthRover(getPosition());
    }

    @Override
    public Rover turnRight() {
        return new SouthRover(getPosition());
    }

    @Override
    public char getRoverOrientation() {
        return ROVER_ORIENTATION;
    }
}
