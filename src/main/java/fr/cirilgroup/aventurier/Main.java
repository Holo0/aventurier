package fr.cirilgroup.aventurier;

import java.io.IOException;
import fr.cirilgroup.aventurier.entities.Game;

public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game("carte v2.txt", "deuxieme_test.txt");
            game.processMoves(game.getMoves());
        } catch (IOException e) {
            System.err.println("Error loading map file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}