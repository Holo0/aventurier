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
}
