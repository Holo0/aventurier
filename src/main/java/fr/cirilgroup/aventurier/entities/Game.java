package fr.cirilgroup.aventurier.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import fr.cirilgroup.aventurier.Main;

/**
 * Class representing the game.
 */
public class Game {
    private Map map;
    private Aventurer aventurer;
    private EnumDirection[] moves;

    /**
     * Constructor
     *
     * @param mapFile  The name of the file containing the map.
     * @param moveFile The name of the file containing the moves.
     * @throws IOException If there is an issue reading the files.
     * @throws Exception   If there is an invalid character or coordinates.
     */
    public Game(String mapFile, String moveFile) throws IOException, Exception {
        this.map = new Map(mapFile);
        this.readMoveFile(moveFile);
    }

    /**
     * Processes the moves for the adventurer.
     *
     * @param moves Array of directions to move.
     * @throws Exception If there is an invalid move.
     */
    public void processMoves(EnumDirection[] moves) throws Exception {
        for (EnumDirection move : moves) {
            displayPosition(move);

            int[] nextPosition = aventurer.getNextPosition(move);
            if (isValidMove(nextPosition[0], nextPosition[1])) {
                aventurer.move(move);
            }
        }
        displayPosition(null);
    }

    /**
     * Displays the current position of the adventurer and the move direction.
     *
     * @param move The direction the adventurer is moving. If null, no movement is
     *             indicated.
     */
    public void displayPosition(EnumDirection move) {
        System.out.println("---------------------------------------------------------------------");
        if (move != null) {
            System.out.println(
                    "Character is at (" + aventurer.getX() + ", " + aventurer.getY() + ") and is moving " + move);
        } else {
            System.out.println("Character is at (" + aventurer.getX() + ", " + aventurer.getY() + ")");
        }

        char[][] displayedMap = map.getMap();
        for (int y = 0; y < displayedMap.length; y++) {
            for (int x = 0; x < displayedMap[y].length; x++) {
                if (x == aventurer.getX() && y == aventurer.getY()) {
                    System.out.print('O');
                } else {
                    System.out.print(displayedMap[y][x]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Gets the map of the game.
     *
     * @return The map.
     */
    public Map getMap() {
        return map;
    }

    /**
     * Gets the adventurer in the game.
     *
     * @return The adventurer.
     */
    public Aventurer getAventurer() {
        return aventurer;
    }

    /**
     * Gets the moves in the game.
     *
     * @return The moves.
     */
    public EnumDirection[] getMoves() {
        return moves;
    }

    // PRIVATE

    /**
     * Reads the move file and initializes the adventurer's position and moves.
     *
     * @param moveFile The file containing the moves.
     * @throws Exception If there is an issue reading the file or invalid
     *                   coordinates.
     */
    private void readMoveFile(String moveFile) throws Exception {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(moveFile);
        if (inputStream == null) {
            throw new Exception("Le fichier n'a pas été trouvé dans le dossier resources");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> lines = reader.lines().collect(Collectors.toList());
        String[] coordonees = lines.get(0).split(",");
        int startX = Integer.valueOf(coordonees[0]);
        int startY = Integer.valueOf(coordonees[1]);
        // Validate coordinates
        if (!isValidStart(startX, startY)) {
            throw new Exception("Les coordonnées initiales sont en dehors des limites de la grille ou sur un arbre");
        }
        this.aventurer = new Aventurer(startX, startY);
        // Handle empty moves case
        if (lines.size() > 1 && !lines.get(1).isEmpty()) {
            this.moves = EnumDirection.fromChar(lines.get(1).toCharArray());
        } else {
            this.moves = new EnumDirection[0]; // No moves provided
        }
    }

    /**
     * Checks if the move is valid.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return True if the move is valid, false otherwise.
     */
    public boolean isValidMove(int x, int y) {
        return map.isValidPosition(x, y);
    }

    /**
     * Checks if the start position is valid.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return True if the start position is valid, false otherwise.
     */
    private boolean isValidStart(int x, int y) {
        return map.isValidPosition(x, y);
    }
}
