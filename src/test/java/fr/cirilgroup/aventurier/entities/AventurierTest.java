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
       this.aventurier = Aventurier.getAventurier(0, 0);
    }
 
    @Test
    public void testGetAventurier() {
       Assert.assertNotNull(this.aventurier);
       Assert.assertEquals(this.aventurier, Aventurier.getAventurier(0, 0));
    }
 
    @Test
    public void testBougerNord() throws Exception {
       this.aventurier.bouger("N");
       Assert.assertEquals(Integer.valueOf(1), this.aventurier.getCoordonneeY());
    }
 
    @Test
    public void testBougerSud() throws Exception {
       this.aventurier.bouger("S");
       Assert.assertEquals(Integer.valueOf(-1), this.aventurier.getCoordonneeY());
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
 
    @Test(
       expected = Exception.class
    )
    public void testBougerWrongDirection() throws Exception {
       this.aventurier.bouger("X");
    }

    @Test
   public void testSingleton() {
      Aventurier aventurier1 = Aventurier.getAventurier(0, 0);
      Aventurier aventurier2 = Aventurier.getAventurier(1, 1);
      Assert.assertSame("Les instances devraient \u00eatre les m\u00eames", aventurier1, aventurier2);
   }
}
