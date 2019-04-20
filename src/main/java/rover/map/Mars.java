package rover.map;


import rover.rover.NorthRover;
import rover.rover.Rover;

import java.util.Random;

/**
 * Represents the Map / Mars that the rover moves on.
 */
public class Mars {
    public static final int MAX_Y_SIZE = 15;
    public static final int MAX_X_SIZE = 80;

    private static final char ROCK = '#';
    private static final char EMPTY = ' ';

    private char[][] marsMap;

    public Mars(Random random) {
        marsMap = new char[MAX_X_SIZE][MAX_Y_SIZE];

        for (int y = 0; y < MAX_Y_SIZE; y++) {
            for (int x = 0; x < MAX_X_SIZE; x++) {
                marsMap[x][y] = random.nextDouble() < 0.25 ? ROCK : EMPTY;
            }
        }

        marsMap[MAX_X_SIZE / 2][MAX_Y_SIZE / 2] = NorthRover.ROVER_ORIENTATION; //Garbage code TODO
    }

    public boolean moveRover(Position position, Rover newRover) {
        final Position newRoverPosition = newRover.getPosition();

        boolean isMoved = false;
        if (getField(newRoverPosition) != Mars.ROCK) {
            marsMap[position.getxCoordinate()][position.getyCoordinate()] = EMPTY;
            marsMap[newRoverPosition.getxCoordinate()][newRoverPosition.getyCoordinate()] = newRover.getRoverOrientation();
            isMoved = true;
        }
        return isMoved;

    }

    public void print() {
        StringBuilder output = new StringBuilder();
        for (int y = 0; y < MAX_Y_SIZE; y++) {
            for (int x = 0; x < MAX_X_SIZE; x++) {
                output.append(marsMap[x][y]);
            }
            output.append("\n");
        }

        for(int x = 0; x < MAX_X_SIZE; x++){
            output.append("=");
        }
        output.append("\n");

        System.out.print(output.toString());
    }

    private char getField(Position position) {
        return marsMap[position.getxCoordinate()][position.getyCoordinate()];
    }

}
