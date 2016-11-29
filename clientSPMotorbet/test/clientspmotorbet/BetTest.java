/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

import java.util.ArrayList;
import java.util.Random;
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
public class BetTest {
    
    public BetTest() {
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
     * Test of salva method, of class Bet.
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        DAOBet DaoBet = new DAOBet();
        Bet instance = new Bet();
        
        String stringa = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);
        for( int i = 0; i < 10; i++ ) 
            sb.append( stringa.charAt( rnd.nextInt(stringa.length()) ) );
        
        instance.setId(sb.toString());
        boolean expResult = true;
        boolean result = instance.salva(DaoBet);
        assertEquals(expResult, result);
    }

    /**
     * Test of salvaPuntate method, of class Bet.
     */
    @Test
    public void testSalvaPuntate() {
        System.out.println("salvaPuntate");
        Bet instance = new Bet();
        boolean expResult = false;
        boolean result = instance.salvaPuntate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addBetLine method, of class Bet.
     */
    @Test
    public void testAddBetLine() {
        System.out.println("addBetLine");
        String nomepilota = "Valentino";
        String cognomepilota = "Rossi";
        String campionato = "MotoGP";
        String gara = "Qatar";
        int posizione = 1;
        float quota = 1.2F;
        Bet instance = new Bet();
        instance.addBetLine(nomepilota, cognomepilota, campionato, gara, posizione, quota);
        assertNotNull(instance.getBetLineCorrente());
    }

    /**
     * Test of getBetLineCorrente method, of class Bet.
     */
    @Test
    public void testGetBetLineCorrente() {
        System.out.println("getBetLineCorrente");
        Bet instance = new Bet();
        instance.addBetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        BetLine result = instance.getBetLineCorrente();
        assertNotNull(result);
    }

    /**
     * Test of getId method, of class Bet.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Bet instance = new Bet();
        instance.setId("prova");
        String expResult = "prova";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCf method, of class Bet.
     */
    @Test
    public void testGetCf() {
        System.out.println("getCf");
        Bet instance = new Bet();
        instance.setCf("mdcpwl");
        String expResult = "mdcpwl";
        String result = instance.getCf();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImporto method, of class Bet.
     */
    @Test
    public void testGetImporto() {
        System.out.println("getImporto");
        Bet instance = new Bet();
        instance.setImporto(1.5F);
        float expResult = 1.5F;
        float result = instance.getImporto();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getVincitaPotenziale method, of class Bet.
     */
    @Test
    public void testGetVincitaPotenziale() {
        System.out.println("getVincitaPotenziale");
        Bet instance = new Bet();
        instance.setVincitaPotenziale(2.5F);
        float expResult = 2.5F;
        float result = instance.getVincitaPotenziale();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getData method, of class Bet.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Bet instance = new Bet();
        instance.setData("21/02/2016");
        String expResult = "21/02/2016";
        String result = instance.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of addPuntata method, of class Bet.
     */
    @Test
    public void testAddPuntata() {
        System.out.println("addPuntata");
        BetLine puntata = new BetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        Bet instance = new Bet();
        instance.addPuntata(puntata);
        assertNotNull(instance.getPuntata(0));
    }

    /**
     * Test of delPuntata method, of class Bet.
     */
    @Test
    public void testDelPuntata() {
        System.out.println("delPuntata");
        int i = 0;
        Bet instance = new Bet();
        BetLine puntata = new BetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        instance.addPuntata(puntata);
        instance.delPuntata(i);
        int expResult = 0;
        assertEquals(expResult, instance.getPuntate().size());
    }

    /**
     * Test of svuotaListaPuntate method, of class Bet.
     */
    @Test
    public void testSvuotaListaPuntate() {
        System.out.println("svuotaListaPuntate");
        Bet instance = new Bet();
        BetLine puntata1 = new BetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        instance.addPuntata(puntata1);
        BetLine puntata2 = new BetLine("Graziano", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        instance.addPuntata(puntata2);
        int result = instance.getPuntate().size();
        assertEquals(2, result);
        instance.svuotaListaPuntate();
        int expResult = 0;
        int result2 = instance.getPuntate().size();
        assertEquals(expResult, result2);
    }

    /**
     * Test of getDimListaPuntate method, of class Bet.
     */
    @Test
    public void testGetDimListaPuntate() {
        System.out.println("getDimListaPuntate");
        Bet instance = new Bet();
        BetLine puntata1 = new BetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        instance.addPuntata(puntata1);
        BetLine puntata2 = new BetLine("Graziano", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        instance.addPuntata(puntata2);
        int expResult = 2;
        int result = instance.getDimListaPuntate();
        assertEquals(expResult, result);
    }

    /**
     * Test of betLinePresente method, of class Bet.
     */
    @Test
    public void testBetLinePresente() {
        System.out.println("betLinePresente");
        Bet instance = new Bet();
        BetLine puntata1 = new BetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        instance.addPuntata(puntata1);
        BetLine bl1 = new BetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        boolean expResult = true;
        boolean result = instance.betLinePresente(bl1);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPuntata method, of class Bet.
     */
    @Test
    public void testGetPuntata() {
        System.out.println("getPuntata");
        int i = 0;
        Bet instance = new Bet();
        BetLine puntata1 = new BetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        instance.addPuntata(puntata1);
        BetLine expResult = puntata1;
        BetLine result = instance.getPuntata(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of aggQuotaTotale method, of class Bet.
     */
    @Test
    public void testAggQuotaTotale() {
        System.out.println("aggQuotaTotale");
        Bet instance = new Bet();
        instance.setImporto(10.0F);
        BetLine puntata1 = new BetLine("Valentino", "Rossi", "MotoGP", "Qatar", 1, 1.2F);
        instance.addPuntata(puntata1);
        
        float expResult = 1.2F;
        float result = instance.aggQuotaTotale();
        assertEquals(expResult, result, 0.0);
    }
    
}
