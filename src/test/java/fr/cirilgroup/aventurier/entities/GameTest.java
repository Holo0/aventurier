package fr.cirilgroup.aventurier.entities;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game("carte v2.txt", "premier_test.txt");
    }

    @Test
    public void testInitialization() {
        assertNotNull(game);
        assertNotNull(game.getAventurer());
        assertNotNull(game.getMap());
        assertNotNull(game.getMoves());

        EnumDirection[] directions = { EnumDirection.S, EnumDirection.S, EnumDirection.S, EnumDirection.S,
                EnumDirection.E, EnumDirection.E, EnumDirection.E, EnumDirection.E, EnumDirection.E, EnumDirection.E,
                EnumDirection.N, EnumDirection.N };

        // check move
        assertArrayEquals(directions, game.getMoves());
    }

    @Test
    public void testNoMove() throws IOException, Exception {
        Game game = new Game("carte v2.txt", "no_move.txt");
        assertNotNull(game);
        EnumDirection[] expectedDirections = new EnumDirection[0]; // Empty array for no moves
        assertArrayEquals(expectedDirections, game.getMoves());
    }

    @Test
    public void testValidStartPosition() throws IOException, Exception {
        Game game = new Game("carte v2.txt", "valid_start.txt");
        assertNotNull(game);
        assertEquals(Integer.valueOf(3), game.getAventurer().getX());
        assertEquals(Integer.valueOf(0), game.getAventurer().getY());
    }

    @Test
    public void testInvalidStartPosition() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Game("carte v2.txt", "invalid_start.txt");
        });

        String expectedMessage = "Les coordonnées initiales sont en dehors des limites de la grille ou sur un arbre";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void testInvalidStartPositionOutOfBound() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Game("carte v2.txt", "invalid_start_out.txt");
        });

        String expectedMessage = "Les coordonnées initiales sont en dehors des limites de la grille ou sur un arbre";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void testValidMoves() throws Exception {
        EnumDirection[] moves = {
                EnumDirection.S, EnumDirection.S, EnumDirection.S, EnumDirection.S,
                EnumDirection.E, EnumDirection.E, EnumDirection.E, EnumDirection.E,
                EnumDirection.E, EnumDirection.E,
                EnumDirection.N, EnumDirection.N
        };

        game.processMoves(moves);
        assertEquals(Integer.valueOf(9), game.getAventurer().getX());
        assertEquals(Integer.valueOf(2), game.getAventurer().getY());
    }

    @Test
    public void testInvalidMove() throws Exception {
        EnumDirection[] moves = { EnumDirection.O };
        game.processMoves(moves);
        assertEquals(Integer.valueOf(3), game.getAventurer().getX());
        assertEquals(Integer.valueOf(0), game.getAventurer().getY());
    }

    @Test
    public void testMixedMoves() throws Exception {
        EnumDirection[] moves = {
                EnumDirection.S, EnumDirection.S, EnumDirection.S,
                EnumDirection.E, EnumDirection.E,
                EnumDirection.N, EnumDirection.N,
                EnumDirection.O, EnumDirection.O
        };
        game.processMoves(moves);
        assertEquals(Integer.valueOf(3), game.getAventurer().getX());
        assertEquals(Integer.valueOf(1), game.getAventurer().getY());
    }

    @Test
    public void testInvalidMoveInFile() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Game("carte v2.txt", "invalid_move.txt");
        });

        String expectedMessage = "Invalid direction character: Z";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void testFileNotFound() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Game("carte v2.txt", "no_file_found.txt");
        });

        String expectedMessage = "Le fichier n'a pas été trouvé dans le dossier resources";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }
}
