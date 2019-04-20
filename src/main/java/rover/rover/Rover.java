package rover.rover;

import rover.map.Mars;
import rover.map.Position;

/**
 * A rover, who is able to move around on the mars.
 */
public abstract class Rover {
    private final Position position;

    protected Rover(Position position) {
        this.position = position;
    }

    protected abstract Rover moveForward();

    protected abstract Rover moveBackward();

    protected abstract Rover turnLeft();

    protected abstract Rover turnRight();

    public abstract char getRoverOrientation();

    public Rover move(Mars mars, Command command) {
        final Rover newRover = command.apply(this);

        return mars.moveRover(getPosition(), newRover) ? newRover : this;
    }

    public Position getPosition() {
        return position;
    }
}
