/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Salvo
 */
public class BetLineTest {
    
    public BetLineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of salva method, of class BetLine.
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        String id = "DKVoAaK0We";
        String cf = "qttsvt93h27b202b";
        BetLine instance = new BetLine();
        instance.setCampionato("MotoGP");
        instance.setCognomepilota("Rossi");
        instance.setNomepilota("Valentino");
        instance.setGara("Commercial Bank Grand Prix of Qatar");
        instance.setPosizione(1);
        instance.setQuota(1.3f);
        boolean expResult = true;
        boolean result = instance.salva(id, cf);
        assertEquals(expResult, result);
    }

    /**
     * Test of setNomepilota method, of class BetLine.
     */
  
    /**
     * Test of getNomepilota method, of class BetLine.
     */
    @Test
    public void testGetNomepilota() {
        System.out.println("getNomepilota");
        BetLine instance = new BetLine();
        String expResult = "Valentino";
        instance.setNomepilota("Valentino");
        String result = instance.getNomepilota();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCognomepilota method, of class BetLine.
     */
    @Test
    public void testGetCognomepilota() {
        System.out.println("getCognomepilota");
        BetLine instance = new BetLine();
        String expResult = "Rossi";
        instance.setCognomepilota("Rossi");
        String result = instance.getCognomepilota();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCampionato method, of class BetLine.
     */
    @Test
    public void testGetCampionato() {
        System.out.println("getCampionato");
        BetLine instance = new BetLine();
        String expResult = "MotoGP";
        instance.setCampionato("MotoGP");
        String result = instance.getCampionato();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGara method, of class BetLine.
     */
    @Test
    public void testGetGara() {
        System.out.println("getGara");
        BetLine instance = new BetLine();
        String expResult = "Commercial Bank Grand Prix of Qatar";
        instance.setGara("Commercial Bank Grand Prix of Qatar");
        String result = instance.getGara();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPosizione method, of class BetLine.
     */
    @Test
    public void testGetPosizione() {
        System.out.println("getPosizione");
        BetLine instance = new BetLine();
        int expResult = 1;
        instance.setPosizione(1);
        int result = instance.getPosizione();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuota method, of class BetLine.
     */
    @Test
    public void testGetQuota() {
        System.out.println("getQuota");
        BetLine instance = new BetLine();
        float expResult = 1.3F;
        instance.setQuota(1.3f);
        float result = instance.getQuota();
        assertEquals(expResult, result, 0.0);
    }
    
}