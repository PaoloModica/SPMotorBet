/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmotorbet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of salva method, of class Cliente.
     * @throws java.text.ParseException
     */
    @Test
    public void testSalva() throws ParseException {
        System.out.println("salva");
        DAOCliente DC = new DAOCliente();
        DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Cliente instance = new Cliente();
        instance.setCognome("rossi");
        instance.setNome("mario");
        instance.setCodicefiscale("mssl");
        instance.setIndirizzo("via etnea");
        instance.setPassword("password");
        instance.setData_di_nascita(format2.parse("27/06/1993"));
        instance.setUsername("user");
        instance.setTelefono("320");
        instance.setContoPersonale();
        boolean expResult = true;
        boolean result = instance.salva(DC, format2);
  
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getUsername method, of class Cliente.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Cliente instance = new Cliente();
        String expResult = "user";
        instance.setUsername("user");
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setUsername method, of class Cliente.
     */


    /**
     * Test of getPassword method, of class Cliente.
     */
    
   
    
    
    
    
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Cliente instance = new Cliente();
        String expResult = "password";
        instance.setPassword("password");
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPassword method, of class Cliente.
     */
   

    /**
     * Test of getNome method, of class Cliente.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Cliente instance = new Cliente();
        String expResult = "mario";
        instance.setNome("mario");
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setNome method, of class Cliente.
     */


    /**
     * Test of getCognome method, of class Cliente.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Cliente instance = new Cliente();
        String expResult = "rossi";
        instance.setCognome("rossi");
        String result = instance.getCognome();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setCognome method, of class Cliente.
     */
   
    /**
     * Test of getCodicefiscale method, of class Cliente.
     */
    
     
    
    @Test
    public void testGetCodicefiscale() {
        System.out.println("getCodicefiscale");
        Cliente instance = new Cliente();
        String expResult = "mssl";
        instance.setCodicefiscale("mssl");
        String result = instance.getCodicefiscale();
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of setCodicefiscale method, of class Cliente.
     */


    /**
     * Test of getData_di_nascita method, of class Cliente.
     */
    
    
    


    /**
     * Test of setData_di_nascita method, of class Cliente.
     */
    @Test
    public void testGetData_di_nascita() throws ParseException {
         DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        System.out.println("setData_di_nascita");
        Date data_di_nascita =  format2.parse("27/06/1993");
        Cliente instance = new Cliente();
        Date expResult= format2.parse("27/06/1993");
        instance.setData_di_nascita(data_di_nascita);
        Date result = instance.getData_di_nascita();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getTelefono method, of class Cliente.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Cliente instance = new Cliente();
        String expResult = "320";
        instance.setTelefono("320");
        String result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setTelefono method, of class Cliente.
     */
 

    /**
     * Test of getIndirizzo method, of class Cliente.
     */
    @Test
    public void testGetIndirizzo() {
        System.out.println("getIndirizzo");
        Cliente instance = new Cliente();
        String expResult = "via";
        instance.setIndirizzo("via");
        String result = instance.getIndirizzo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setIndirizzo method, of class Cliente.
     */
   

    /**
     * Test of getContoPersonale method, of class Cliente.
     */
    @Test
    public void testGetContoPersonale() {
        System.out.println("getContoPersonale");
        Cliente instance = new Cliente();
        String expResult = "5.0";
        instance.setContoPersonale();
        instance.getContoPersonale().aggiungiMovimento(5.0f);
        String result = instance.getContoPersonale().getSaldo().toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setContoPersonale method, of class Cliente.
     */
 
    
}