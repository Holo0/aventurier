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
    private EnumDirection[] moves;

    public Game(String mapFile, String moveFile) throws IOException, Exception {
        this.map = new Map(mapFile);
        this.readMoveFile(moveFile);
    }

    public void processMoves(EnumDirection[] moves) throws Exception {
        for (EnumDirection move : moves) {
            int[] nextPosition = aventurer.getNextPosition(move);
            if (isValidMove(nextPosition[0], nextPosition[1])) {
                aventurer.move(move);
            }
            displayPosition();
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

    public EnumDirection[] getMoves() {
        return moves;
    }

    // PRIVATE

    private void readMoveFile(String moveFile) throws Exception {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(moveFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        if (inputStream == null) {
            throw new Exception("Le fichier n'a pas été trouvé dans le dossier resources");
        }
        List<String> lines = reader.lines().collect(Collectors.toList());
        String[] coordonees = lines.get(0).split(",");

        int startX = Integer.valueOf(coordonees[0]);
        int startY = Integer.valueOf(coordonees[1]);

        // Validate coordinates
        if (!isValidStart(startX, startY)) {
            throw new Exception("Les coordonnées initiales sont en dehors des limites de la grille ou sur un arbre");
        }
        this.aventurer = new Aventurer(startX, startY);

            this.moves = EnumDirection.fromChar(lines.get(1).toCharArray());
    }

    public boolean isValidMove(int x, int y) {
        return map.isValidPosition(x, y);
    }
    
    private boolean isValidStart(int x, int y) {
        return map.isValidPosition(x, y);
    }
}