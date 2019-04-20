package rover.rover.states;

import rover.map.Position;
import rover.rover.Rover;

public class SouthRover extends Rover {
    private static final char ROVER_ORIENTATION = 'V';

    SouthRover(Position position) {
        super(position);
    }

    @Override
    public Rover moveForward() {
        final Position position = new Position(getPosition().getxCoordinate(), getPosition().getyCoordinate() + 1);
        return new SouthRover(position);
    }

    @Override
    public Rover moveBackward() {
        final Position position = new Position(getPosition().getxCoordinate(), getPosition().getyCoordinate() - 1);
        return new SouthRover(position);
    }

    @Override
    public Rover turnLeft() {
        return new EastRover(getPosition());
    }

    @Override
    public Rover turnRight() {
        return new WestRover(getPosition());
    }

    @Override
    public char getRoverOrientation() {
        return ROVER_ORIENTATION;
    }
}
