package rover.map;


import java.util.Random;

/**
 * Represents the Map / Mars that the rover moves on.
 */
public class Mars {
    public static final char ROCK = '#';
    private static final int MAX_Y_SIZE = 80;
    private static final int MAX_X_SIZE = 80;

    private char[][] marsMap;
    private Mars mars = null;

    /**
     * Singleton instance of the mars, because the Mars never changes after initalized once.
     *
     * @return the mars.
     */
    public Mars getInstance() {
        if (mars == null) {
            mars = new Mars(MAX_X_SIZE, MAX_Y_SIZE);
        }
        return mars;
    }

    public Mars(int maxXSize, int maxYSize) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        marsMap = new char[maxXSize][maxYSize];

        for (int x = 0; x < maxXSize; x++) {
            for (int y = 0; y < maxYSize; y++) {
                final boolean isStartingPos = x == maxXSize / 2 || y == maxYSize / 2;

                if (random.nextDouble() < 0.25 && !isStartingPos) {
                    marsMap[x][y] = ROCK;
                }
            }
        }
    }

    public char getObjectAtPosition(int x, int y) {
        return marsMap[x][y];
    }

    public void updateObjectAtPosition(char newObject, int x, int y) {
        final String errorMessage = "Invalid arg for %s Coordinate. Expected to be positive and smaller than %d"
        if (x >= MAX_X_SIZE) {
            throw new IllegalArgumentException(String.format(errorMessage, "x", MAX_X_SIZE));
        } if (y >= MAX_Y_SIZE) {
            throw new IllegalArgumentException(String.format(errorMessage, "y", MAX_Y_SIZE));
        }
        marsMap[x][y] = newObject;
    }
}
