package rover.rover;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public enum Command {
    FORWARD('f', Rover::moveForward),
    BACK('b', Rover::moveBackward),
    LEFT('l', Rover::turnLeft),
    RIGHT('r', Rover::turnRight);

    private char charRepresentation;
    private UnaryOperator<Rover> movementFunction;

    Command(char charRepresentation, UnaryOperator<Rover> movementFunction) {
        this.charRepresentation = charRepresentation;
        this.movementFunction = movementFunction;
    }

    public static Command convertCharToCommand(char programArg) {
        for (Command command : Command.values()) {
            if (command.getCharRepresentation() == programArg) {
                return command;
            }
        }

        throw new IllegalArgumentException(String.format("Unkown argument %s!", programArg));
    }

    public Rover apply(Rover rover){
        return movementFunction.apply(rover);
    }

    public char getCharRepresentation() {
        return charRepresentation;
    }
}
