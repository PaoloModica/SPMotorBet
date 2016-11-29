/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmotorbet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SPMotorBetTest {
    
    public SPMotorBetTest() {
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
     * Test of prosegui method, of class SPMotorBet.
     */
    @Test
    public void testProsegui_ClienteNonEsistente() { //verifica che i dati del clienti immessi non siano già presenti nel db
        System.out.println("prosegui registrazione cliente non registrato nel sistema");
        String nome = "Paolo";
        String cognome = "Modica";
        String indirizzo = "via dei giardini";
        String cf = "MDCPWL";
        String tel = "340998765";
        String data = "19/06/1992";
        SPMotorBet instance = SPMotorBet.getInstance();
        int expResult = 1; //il test dovrebbe restituire 1 nel caso in cui tutto vada bene
        int result = instance.InsNuovoCliente(nome, cognome, indirizzo, cf, tel, data);
        assertEquals(expResult, result);
    }
    @Test
    public void testProsegui_ClienteEsistente() { //verifica che i dati del clienti immessi siano già presenti nel db
        System.out.println("prosegui registrazione, cliente già registrato nel sistema");
        String nome = "salvo";
        String cognome = "quattro";
        String indirizzo = "via";
        String cf = "qttsvt";
        String tel = "32009";
        String data = "27/06/1993";
        SPMotorBet instance = SPMotorBet.getInstance();
        int expResult = 2; //il test dovrebbe restituire 1 nel caso in cui tutto vada bene, 2 nel caso in cui 
        int result = instance.InsNuovoCliente(nome, cognome, indirizzo, cf, tel, data);
        assertEquals(expResult, result);
    }
        @Test
    public void testProsegui_Cliente_Dati_Errati() { //verifica che i dati del clienti immessi siano già presenti nel db
        System.out.println("prosegui registrazione cliente, dati errati");
        String nome = "salvo";
        String cognome = "quattro";
        String indirizzo = "via";
        String cf = "qttsvt93h27";
        String tel = "32009";
        String data = "27/06-93";
        SPMotorBet instance = SPMotorBet.getInstance();
        int expResult = 3; //il test dovrebbe restituire 1 nel caso in cui tutto vada bene, 3 nel caso in cui vi siano errori nel formato dei dati
        int result = instance.InsNuovoCliente(nome, cognome, indirizzo, cf, tel, data);
        assertEquals(expResult, result);
    }
    /**
     * Test of conferma method, of class SPMotorBet.
     */
@Test
    public void testConferma() throws Exception{
        System.out.println("conferma");
        String username = "saved4";
        DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        SPMotorBet instance = SPMotorBet.getInstance();
        instance.cliente=new Cliente();
        
        instance.cliente.setNome("mario");
        instance.cliente.setCognome("rossi");
        instance.cliente.setCodicefiscale("mss");
        instance.cliente.setData_di_nascita(format2.parse("01/01/1991"));

        instance.cliente.setContoPersonale();
        instance.cliente.setIndirizzo("via etnea");
        instance.cliente.setTelefono("320");
        instance.cliente.setUsername("user");
        instance.cliente.setPassword("password");
        
        instance.cliente.getContoPersonale().aggiungiMovimento(5.0f);
      
        boolean res=instance.ConfermaIscrizione(username, format2);
        assertEquals(true, res);
    }
    /**
     * Test of accredita method, of class SPMotorBet.
     */
    @Test
    public void testAccredita() {           //considerando un conto esistente con saldo di € 10
        System.out.println("accredita");
        SPMotorBet instance = SPMotorBet.getInstance();
        String CodFisc = "mss";
        float imp = 5.0F;
        
        float expResult = 10.0F;
        float result = instance.accredita(CodFisc, imp);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of preleva method, of class SPMotorBet.
     */
    @Test
    public void testPreleva() {     //considerando un conto esistente con saldo di € 15
        System.out.println("preleva");
        SPMotorBet instance = SPMotorBet.getInstance();
        String CodFisc = "mss";
        float imp = 5.0F;
        
        float expResult = 5.0F;
        float result = instance.preleva(CodFisc, imp);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
