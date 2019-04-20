package rover.rover;

import rover.map.Mars;
import rover.map.Position;

public abstract class Rover {
    private final Position position;

    protected Rover(Position position) {
        this.position = position;
    }

    abstract Rover moveForward();

    abstract Rover moveBackward();

    abstract Rover turnLeft();

    abstract Rover turnRight();

    public abstract char getRoverOrientation();

    public Rover move(Command command) {
        final Rover newRover = command.apply(this);

        return Mars.getInstance().moveRover(getPosition(), newRover) ? newRover : this;
    }

    public Position getPosition() {
        return position;
    }
}
