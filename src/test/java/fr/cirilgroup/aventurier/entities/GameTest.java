package fr.cirilgroup.aventurier.entities;

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

        // check move
        assertEquals("SSSSEEEEEENN",  String.copyValueOf(game.getMoves()));
    }

    @Test
    public void testValidStartPosition() throws IOException, Exception {
        Game game = new Game("carte v2.txt", "valid_moves.txt");
        assertNotNull(game);
        assertEquals(Integer.valueOf(3), game.getAventurer().getX());
        assertEquals(Integer.valueOf(0), game.getAventurer().getY());
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
    public void testInvalidStartPosition() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Game("carte v2.txt", "invalid_start.txt");
        });

        String expectedMessage = "Les coordonnées initiales sont en dehors des limites de la grille ou sur un arbre";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }


    @Test
    public void testValidMoves() throws Exception {
        char[] moves = {'S','S','S','S','E','E','E','E','E','E','N','N'};
        game.processMoves(moves);
        assertEquals(Integer.valueOf(9), game.getAventurer().getX());
        assertEquals(Integer.valueOf(2), game.getAventurer().getY());
    }

    @Test
    public void testInvalidMove() throws Exception {
        char[] moves = {'O'};
        game.processMoves(moves);
        assertEquals(Integer.valueOf(3), game.getAventurer().getX());
        assertEquals(Integer.valueOf(0), game.getAventurer().getY());
    }

    @Test
    public void testMixedMoves() throws Exception {
        char[] moves = {'S','S','S','E','E','N','N','O','O'};
        game.processMoves(moves);
        assertEquals(Integer.valueOf(3), game.getAventurer().getX());
        assertEquals(Integer.valueOf(1), game.getAventurer().getY());
    }
    
    @Test(expected = Exception.class)
    public void testWrongMoves() throws Exception {
        char[] moves = {'Z','E','B','E','E','N','N','O','O'};
        game.processMoves(moves);
    }
}
