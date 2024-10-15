package fr.cirilgroup.aventurier.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AventurierTest {
    private Aventurier aventurier;

    public AventurierTest() {
    }

    @Before
    public void setUp() {
        this.aventurier = new Aventurier(0, 0);
    }
    @Test
    public void testBougerNord() throws Exception {
        this.aventurier.bouger("N");
        Assert.assertEquals(Integer.valueOf(-1), this.aventurier.getCoordonneeY());
    }

    @Test
    public void testBougerSud() throws Exception {
        this.aventurier.bouger("S");
        Assert.assertEquals(Integer.valueOf(1), this.aventurier.getCoordonneeY());
    }

    @Test
    public void testBougerEst() throws Exception {
        this.aventurier.bouger("E");
        Assert.assertEquals(Integer.valueOf(1), this.aventurier.getCoordonneeX());
    }

    @Test
    public void testBougerOuest() throws Exception {
        this.aventurier.bouger("O");
        Assert.assertEquals(Integer.valueOf(-1), this.aventurier.getCoordonneeX());
    }

    @Test(expected = Exception.class)
    public void testBougerWrongDirection() throws Exception {
        this.aventurier.bouger("X");
    }
}
