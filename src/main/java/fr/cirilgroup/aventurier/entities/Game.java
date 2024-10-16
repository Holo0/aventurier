package fr.cirilgroup.aventurier.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import fr.cirilgroup.aventurier.Main;

public class Game {
    private Map map;
    private Aventurer aventurer;
    private char[] moves;

    public Game(String mapFile, String moveFile) throws IOException, Exception {
        this.map = new Map(mapFile);
        this.readMoveFile(moveFile);
    }

    private void readMoveFile(String moveFile) throws Exception {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(moveFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        if (inputStream == null) {
            throw new Exception("Le fichier n'a pas été trouvé dans le dossier resources");
        }
        List<String> lines = reader.lines().collect(Collectors.toList());
        String[] coordonees = lines.get(0).split(",");
        this.aventurer = new Aventurer(Integer.valueOf(coordonees[0]), Integer.valueOf(coordonees[1]));

        this.moves = lines.get(1).toCharArray();
    }

    public void processMoves(char[] moves) throws Exception {
        for (char move : moves) {
            Direction direction = Direction.fromChar(move);
            int[] nextPosition = aventurer.getNextPosition(direction);
            if (map.isValidMove(nextPosition[0], nextPosition[1])) {
                aventurer.move(direction);
            }
        }
    }

    public void displayPosition() {
        System.out.println("Character is at (" + aventurer.getX() + ", " + aventurer.getY() + ")");
    }

    public Map getMap() {
        return map;
    }

    public Aventurer getAventurer() {
        return aventurer;
    }

    public char[] getMoves() {
        return moves;
    }
}