package fr.cirilgroup.aventurier.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game("carte v2.txt", "deplacement.txt");
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
    public void testValidMoves() throws Exception {
        game.processMoves("SSSSEEEEEENN");
        assertEquals(Integer.valueOf(9), game.getAventurer().getX());
        assertEquals(Integer.valueOf(2), game.getAventurer().getY());
    }

    @Test
    public void testInvalidMove() throws Exception {
        game.processMoves("W");
        assertEquals(Integer.valueOf(3), game.getAventurer().getX());
        assertEquals(Integer.valueOf(0), game.getAventurer().getY());
    }

    @Test
    public void testMixedMoves() throws Exception {
        game.processMoves("SSSEENNWW");
        assertEquals(Integer.valueOf(3), game.getAventurer().getX());
        assertEquals(Integer.valueOf(1), game.getAventurer().getY());
    }
}
