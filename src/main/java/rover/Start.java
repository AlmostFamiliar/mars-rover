package rover;

import rover.map.Mars;
import rover.map.Position;
import rover.rover.Command;
import rover.rover.NorthRover;
import rover.rover.Rover;

public class Start {

    public static void main(String[] args) {
        final String commandSequence = args[0];
        final Mars mars = Mars.getInstance();
        final Position middleOfMars = new Position(Mars.MAX_X_SIZE / 2, Mars.MAX_Y_SIZE / 2);

        mars.print();
        Rover rover = new NorthRover(middleOfMars);
        for (int i = 0; i < commandSequence.length(); i++) {
            final Command command = Command.convertCharToCommand(commandSequence.charAt(i));
            rover = rover.move(command);
            mars.print();
        }
    }
}
