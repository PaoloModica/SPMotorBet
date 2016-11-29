/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
public class clientSPMotorbetTest {
    
    public clientSPMotorbetTest() {
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
     * Test of GeneraID method, of class clientSPMotorbet.
     */
    @Test
    public void testGeneraID() {
        System.out.println("GeneraID");
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        String result = instance.GeneraID();
        assertNotNull(result);
    }

    /**
     * Test of login method, of class clientSPMotorbet.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "SAVED4";
        String password = "mWXtrb9n";
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        boolean expResult = true;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);
    }

    
      @Test
    public void testLogin_Utente_non_presente() {
        System.out.println("login_utente_non_presente");
        String username = "saveddff";
        String password = "gfrgdfg";
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        boolean expResult = false;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of logout method, of class clientSPMotorbet.
     */

  
    /**
     * Test of popolaCampionato method, of class clientSPMotorbet.
     */
    @Test
    public void testPopolaCampionato() throws Exception {
        System.out.println("popolaCampionato");
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        List<String> result = instance.popolaCampionato();
        assertNotNull(instance.popolaCampionato());
    }

    /**
     * Test of popolaGara method, of class clientSPMotorbet.
     */
    @Test
    public void testPopolaGara() throws Exception{
        System.out.println("popolaGara");
        String selCampionato = "MotoGP";
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        assertNotNull(instance.popolaGara(selCampionato));
    }

    /**
     * Test of popolaPilota method, of class clientSPMotorbet.
     */
    @Test
    public void testPopolaPilota() throws Exception{
        System.out.println("popolaPilota");
        String selCampionato = "MotoGP";
        String selGara = "Commercial Bank Grand Prix of Qatar";
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        boolean valore_att = false;
        assertNotNull(instance.popolaPilota(selCampionato,selGara));
    }

    /**
     * Test of popolaQuote method, of class clientSPMotorbet.
     */
    @Test
    public void testPopolaQuote() throws Exception{
        System.out.println("popolaQuote");
        String selCampionato = "MotoGP";
        String selGara = "Commercial Bank Grand Prix of Qatar";
        String[] selPilota = {"Valentino", "Rossi"};
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        assertNotNull(instance.popolaQuote(selCampionato,selGara,selPilota));
    }

    /**
     * Test of aggPuntata method, of class clientSPMotorbet.
     */
  
/**
     * Test of aggPuntata method, of class clientSPMotorbet.
     */
    
    /**
     * Test of confermaGiocata method, of class clientSPMotorbet.
     */
    @Test
    public void testConfermaGiocata() {
        System.out.println("confermaGiocata");
        String nomepilota = "Vale";
        String cognomepilota = "Rossi";
        String campionato = "MotoGP";
        String gara = "Commercial Bank Grand Prix of Qatar";
        int posizione = 1;
        float quota = 1.2F;
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        instance.istanzaBet();
        instance.clienteCorrente = new Cliente();
        instance.clienteCorrente.setCodicefiscale("qttsvt93h27b202b");
        instance.clienteCorrente.setContoPersonale();
        instance.clienteCorrente.getContoPersonale().setSaldo(5.0f);
        BetLine bl1 = new BetLine(nomepilota, cognomepilota, campionato, gara, posizione, quota);
        instance.istanzaBet();
        boolean res = instance.aggPuntata(nomepilota, cognomepilota, campionato, gara, posizione, quota);
        instance.getClienteCorrente().getContoPersonale().aggiungiMovimento(-4.0f);
        boolean expectedResult = true;
        assertEquals(expectedResult, res);
    }
    
    /**
     * Test of aggPuntata method, of class clientSPMotorbet.
     */
    @Test
    public void testAggPuntata_NonPresente() {
        System.out.println("aggPuntata_non_presente");
        String nomepilota = "Valentino";
        String cognomepilota = "Rossi";
        String campionato = "MotoGP";
        String gara = "Commercial Bank Grand Prix of Qatar";
        int posizione = 1;
        float quota = 1.2F;
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        instance.clienteCorrente = new Cliente();
        instance.clienteCorrente.setCodicefiscale("qttsvt93h27b202b");
        instance.clienteCorrente.setContoPersonale();
        instance.clienteCorrente.getContoPersonale().setSaldo(5.0f);
        instance.istanzaBet();
        BetLine bl1 = new BetLine(nomepilota, cognomepilota, campionato, gara, posizione, quota);
        instance.istanzaBet();
        instance.aggPuntata(nomepilota, cognomepilota, campionato, gara, posizione, quota);
        instance.getClienteCorrente().getContoPersonale().aggiungiMovimento(-1.0f);
        boolean expResult = true;
        boolean result = instance.aggPuntata(nomepilota, cognomepilota, campionato, gara, 3, quota);
        assertEquals(expResult, result);
    }
/**
     * Test of aggPuntata method, of class clientSPMotorbet.
     */
    @Test
    public void testAggPuntata_GiaPresente() {
       System.out.println("aggPuntata_gia_presente");
        String nomepilota = "Valentino";
        String cognomepilota = "Rossi";
        String campionato = "MotoGP";
        String gara = "Commercial Bank Grand Prix of Qatar";
        int posizione = 1;
        float quota = 1.2F;
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        instance.clienteCorrente = new Cliente();
        instance.clienteCorrente.setCodicefiscale("qttsvt93h27b202b");
        instance.clienteCorrente.setContoPersonale();
        instance.clienteCorrente.getContoPersonale().setSaldo(5.0f);
        instance.istanzaBet();
        BetLine bl1 = new BetLine(nomepilota, cognomepilota, campionato, gara, posizione, quota);
        instance.istanzaBet();
        instance.aggPuntata(nomepilota, cognomepilota, campionato, gara, posizione, quota);
        instance.getClienteCorrente().getContoPersonale().aggiungiMovimento(-1.0f);
        boolean expResult = false;
        boolean result = instance.aggPuntata(nomepilota, cognomepilota, campionato, gara, posizione, quota);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of visScommesse method, of class clientSPMotorbet.
     */
    @Test
    public void testVisScommesse() throws Exception {
        System.out.println("visScommesse");
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        List<Bet> listaBet = new ArrayList<Bet>();
        listaBet = instance.DaoBet.caricaListaBet("qttsvt93h27b202b");
        assertNotNull( listaBet);
    }

    /**
     * Test of visDetScommessa method, of class clientSPMotorbet.
     */
    @Test
    public void testVisDetScommessa(){
        System.out.println("visDetScommessa");
        String id = "2aWEIvbYgR";
        clientSPMotorbet instance = clientSPMotorbet.getInstance();
        instance.clienteCorrente = new Cliente();
        instance.clienteCorrente.setCodicefiscale("qttsvt");
        instance.listaBet = instance.visScommesse();
        List<BetLine> result = instance.visDetScommessa(id);
        assertNotNull(result);
    }
    
}