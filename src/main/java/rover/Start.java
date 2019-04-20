package rover;

import rover.map.Mars;
import rover.map.Position;
import rover.rover.Command;
import rover.rover.states.NorthRover;
import rover.rover.Rover;

import java.util.Random;

public class Start {

    public static void main(String[] args) {
        final String commandSequence = args[0];
        final Random random = new Random();
        if (args.length > 1) {
            random.setSeed(Long.parseLong(args[1]));
        }

        final Mars mars = new Mars(random);
        mars.print();

        final Position middleOfMars = new Position(Mars.MAX_X_SIZE / 2, Mars.MAX_Y_SIZE / 2);
        Rover rover = new NorthRover(middleOfMars);

        for (int i = 0; i < commandSequence.length(); i++) {
            final Command command = Command.convertCharToCommand(commandSequence.charAt(i));
            rover = rover.move(mars, command);
            mars.print();
        }
    }
}
