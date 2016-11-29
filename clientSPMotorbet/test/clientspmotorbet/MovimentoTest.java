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
public class MovimentoTest {
    
    public MovimentoTest() {
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
     * Test of salva method, of class Movimento.
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        String cf = "";
        Movimento instance = new Movimento(5);
        boolean expResult = true;
        boolean result = instance.salva(cf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getImporto method, of class Movimento.
     */
    @Test
    public void testGetImporto() {
        System.out.println("getImporto");
        Movimento instance = new Movimento(5);
        float expResult = 5.0F;
        float result = instance.getImporto();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setImporto method, of class Movimento.
     */
   
    
}