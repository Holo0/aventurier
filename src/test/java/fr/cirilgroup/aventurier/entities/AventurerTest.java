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
        this.aventurer.move(EnumDirection.N);
        Assert.assertEquals(Integer.valueOf(-1), this.aventurer.getY());
    }

    @Test
    public void testMoveSud() throws Exception {
        this.aventurer.move(EnumDirection.S);
        Assert.assertEquals(Integer.valueOf(1), this.aventurer.getY());
    }

    @Test
    public void testMoveEst() throws Exception {
        this.aventurer.move(EnumDirection.E);
        Assert.assertEquals(Integer.valueOf(1), this.aventurer.getX());
    }

    @Test
    public void testMoveOuest() throws Exception {
        this.aventurer.move(EnumDirection.O);
        Assert.assertEquals(Integer.valueOf(-1), this.aventurer.getX());
    }
}
