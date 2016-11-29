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
 * @author paolo
 */
public class QuotazioneTest {
    
    public QuotazioneTest() {
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
     * Test of getPosizione method, of class Quotazione.
     */
    @Test
    public void testGetPosizione() {
        System.out.println("getPosizione");
        Quotazione instance = new Quotazione();
        instance.setPosizione(1);
        int expResult = 1;
        int result = instance.getPosizione();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCognomePilota method, of class Quotazione.
     */
    @Test
    public void testGetCognomePilota() {
        System.out.println("getCognomePilota");
        Quotazione instance = new Quotazione();
        instance.setCognomePilota("Rossi");
        String expResult = "Rossi";
        String result = instance.getCognomePilota();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomePilota method, of class Quotazione.
     */
    @Test
    public void testGetNomePilota() {
        System.out.println("getNomePilota");
        Quotazione instance = new Quotazione();
        instance.setNomePilota("Valentino");
        String expResult = "Valentino";
        String result = instance.getNomePilota();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGara method, of class Quotazione.
     */
    @Test
    public void testGetGara() {
        System.out.println("getGara");
        Quotazione instance = new Quotazione();
        instance.setGara("Qatar");
        String expResult = "Qatar";
        String result = instance.getGara();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCampionato method, of class Quotazione.
     */
    @Test
    public void testGetCampionato() {
        System.out.println("getCampionato");
        Quotazione instance = new Quotazione();
        instance.setCampionato("MotoGP");
        String expResult = "MotoGP";
        String result = instance.getCampionato();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getQuota method, of class Quotazione.
     */
    @Test
    public void testGetQuota() {
        System.out.println("getQuota");
        Quotazione instance = new Quotazione();
        instance.setQuota(1.2F);
        float expResult = 1.2F;
        float result = instance.getQuota();
        assertEquals(expResult, result, 0.0);
    }
    
}
