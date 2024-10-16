package fr.cirilgroup.aventurier.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AventurerTest {
    private Aventurer aventurier;

    public AventurerTest() {
    }

    @Before
    public void setUp() {
        this.aventurier = new Aventurer(0, 0);
    }

    @Test
    public void testMoveNord() throws Exception {
        this.aventurier.move("N");
        Assert.assertEquals(Integer.valueOf(-1), this.aventurier.getY());
    }

    @Test
    public void testMoveSud() throws Exception {
        this.aventurier.move("S");
        Assert.assertEquals(Integer.valueOf(1), this.aventurier.getY());
    }

    @Test
    public void testMoveEst() throws Exception {
        this.aventurier.move("E");
        Assert.assertEquals(Integer.valueOf(1), this.aventurier.getX());
    }

    @Test
    public void testMoveOuest() throws Exception {
        this.aventurier.move("O");
        Assert.assertEquals(Integer.valueOf(-1), this.aventurier.getX());
    }

    @Test(expected = Exception.class)
    public void testMoveWrongDirection() throws Exception {
        this.aventurier.move("X");
    }
}
