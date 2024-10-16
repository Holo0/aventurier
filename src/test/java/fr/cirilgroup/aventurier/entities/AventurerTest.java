package fr.cirilgroup.aventurier.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AventurerTest {
    private Aventurer aventurer;

    public AventurerTest() {
    }

    @Before
    public void setUp() {
        this.aventurer = new Aventurer(0, 0);
    }

    @Test
    public void testMoveNord() throws Exception {
        this.aventurer.move("N");
        Assert.assertEquals(Integer.valueOf(-1), this.aventurer.getY());
    }

    @Test
    public void testMoveSud() throws Exception {
        this.aventurer.move("S");
        Assert.assertEquals(Integer.valueOf(1), this.aventurer.getY());
    }

    @Test
    public void testMoveEst() throws Exception {
        this.aventurer.move("E");
        Assert.assertEquals(Integer.valueOf(1), this.aventurer.getX());
    }

    @Test
    public void testMoveOuest() throws Exception {
        this.aventurer.move("O");
        Assert.assertEquals(Integer.valueOf(-1), this.aventurer.getX());
    }

    @Test(expected = Exception.class)
    public void testMoveWrongDirection() throws Exception {
        this.aventurer.move("X");
    }
}
