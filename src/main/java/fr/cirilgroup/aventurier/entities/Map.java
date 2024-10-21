package fr.cirilgroup.aventurier.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import fr.cirilgroup.aventurier.Main;

/**
 * Class representing the game map.
 */
public class Map {
    private char[][] map;

    /**
     * Constructor
     *
     * @param mapFile The file containing the map.
     * @throws IOException If there is an issue reading the map file.
     */
    public Map(String mapFile) throws IOException {
        loadMap(mapFile);
    }

    /**
     * Checks if the specified position is valid on the map.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return True if the position is within bounds and not an impassable area,
     *         false otherwise.
     */
    public boolean isValidPosition(int x, int y) {
        // Check if the coordinates are within the boundaries of the map
        boolean withinBounds = y >= 0 && y < map.length && x >= 0 && x < map[0].length;

        // Check if the target position is not an impassable area
        return withinBounds && map[y][x] == ' ';
    }

    /**
     * Gets the map as a 2D character array.
     *
     * @return The map.
     */
    public char[][] getMap() {
        return map;
    }

    // PRIVATE

    /**
     * Loads the map from the specified file.
     *
     * @param mapFile The file containing the map.
     * @throws IOException If there is an issue reading the map file.
     */
    private void loadMap(String mapFile) throws IOException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(mapFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List<char[]> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line.toCharArray());
        }
        reader.close();
        map = lines.toArray(new char[0][]);
    }
}
