package fr.cirilgroup.aventurier.entities;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MapTest {
    private Map map;

    public MapTest() {
    }

    @Before
    public void setUp() throws IOException {
        this.map = new Map("carte v2.txt");
    }

    @Test
    public void testLoadMap() {        
        // Contenu attendu du fichier carte v2.txt
        char[][] expectedMap = {
            {'#','#','#',' ',' ',' ',' ','#','#','#','#','#','#',' ',' ',' ',' ','#','#','#'},
            {'#','#','#',' ',' ',' ',' ',' ',' ','#','#',' ',' ',' ',' ',' ',' ','#','#','#'},
            {'#','#',' ',' ',' ',' ',' ','#','#',' ',' ','#','#',' ',' ',' ',' ',' ','#','#'},
            {'#',' ',' ',' ',' ',' ',' ','#','#',' ',' ','#','#',' ',' ',' ',' ',' ',' ','#'},
            {'#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#'},
            {'#','#','#','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','#','#','#'},
            {'#','#','#','#','#','#',' ','#','#',' ',' ','#','#',' ',' ','#','#','#','#','#'},
            {' ','#',' ',' ',' ',' ',' ','#','#','#','#','#','#',' ',' ',' ',' ',' ','#',' '},
            {' ',' ',' ',' ',' ','#','#','#','#','#','#','#','#',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ','#','#','#','#','#','#','#','#','#','#','#','#',' ',' ',' ',' '},
            {' ',' ',' ',' ','#','#','#','#','#','#','#','#','#','#','#','#',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ','#','#','#','#','#','#','#','#',' ',' ',' ',' ',' ',' ','#'},
            {' ','#',' ',' ',' ',' ',' ','#','#','#','#','#','#',' ',' ',' ',' ',' ','#','#'},
            {'#','#','#','#','#','#',' ','#','#',' ',' ','#','#',' ','#','#','#','#','#','#'},
            {'#','#','#','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','#','#','#'},
            {'#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#'},
            {'#',' ',' ',' ','#','#',' ','#',' ',' ',' ',' ','#',' ','#','#',' ',' ',' ','#'},
            {'#','#',' ',' ',' ','#','#',' ',' ',' ',' ',' ',' ','#','#',' ',' ',' ','#','#'},
            {'#','#','#',' ',' ',' ',' ','#',' ',' ',' ',' ','#',' ',' ',' ',' ','#','#','#'},
            {'#','#','#',' ',' ',' ',' ','#','#','#','#','#','#',' ',' ',' ',' ','#','#','#'}
        };

        // Comparaison du contenu de la carte chargée avec le contenu attendu
        for (int i = 0; i < expectedMap.length; i++) {
            assertArrayEquals(expectedMap[i], this.map.getMap()[i]);
        }
    }

    @Test
    public void testIsValidMove() {
        assertTrue(this.map.isValidPosition(3, 0)); // 3,0 is a valid move
        assertFalse(this.map.isValidPosition(2, 0)); // 2,0 is an impassable area
        
        assertFalse(this.map.isValidPosition(-1, 0)); // Out of bounds
        assertFalse(map.isValidPosition(10, 10)); // Out of bounds
    }
}
