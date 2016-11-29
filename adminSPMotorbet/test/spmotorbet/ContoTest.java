/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmotorbet;

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
public class ContoTest {
    
    public ContoTest() {
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
     * Test of salva method, of class Conto.
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        
        String cf = "mdcpwl";
        Conto instance = new Conto(cf);
        boolean expResult = true;
        boolean result = instance.salva();
        assertEquals(expResult, result);
    }

    /**
     * Test of aggiorna method, of class Conto.
     */
    @Test
    public void testAggiorna() {
        System.out.println("aggiorna");
        String cf = "mdcpwl";
        Conto instance = new Conto(cf);
        boolean expResult = true;
        boolean result = instance.aggiorna();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCf method, of class Conto.
     */
    @Test
    public void testGetCf() {
        System.out.println("getCf");
        String cf = "mdcpwl";
        Conto instance = new Conto(cf);
        String expResult = "mdcpwl";
        String result = instance.getCf();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSaldo method, of class Conto.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        String cf = "mdcpwl";
        Conto instance = new Conto(cf);
        instance.setSaldo(5.0F);
        Float expResult = 5.0F;
        Float result = instance.getSaldo();
        assertEquals(expResult, result);
    }

    /**
     * Test of aggiornaSaldo method, of class Conto.
     */
    @Test
    public void testAggiornaSaldo() {
        System.out.println("aggiornaSaldo");
        String cf = "mdcpwl";
        Conto instance = new Conto(cf);
        instance.setSaldo(5.0F);    
        float importo = 5.0F;
        instance.aggiornaSaldo(importo);
        
        Float expResult = 10.0F;
        Float result = instance.getSaldo();
        assertEquals(expResult, result);
    }

    /**
     * Test of aggiungiMovimento method, of class Conto.
     */
    @Test
    public void testAggiungiMovimento() {
        System.out.println("aggiungiMovimento");
        
        String cf = "mdcpwl";
        Conto instance = new Conto(cf);
        instance.setSaldo(5.0F);    
        float importo = 5.0F;
                
        instance.aggiungiMovimento(importo);
        Float expResult = 10.0F;
        assertEquals(expResult, instance.getSaldo());
    }

    /**
     * Test of getMovimentoCorrente method, of class Conto.
     */
    @Test
    public void testGetMovimentoCorrente() {
        System.out.println("getMovimentoCorrente");
        String cf = "mdcpwl";
        Conto instance = new Conto(cf);
        instance.setSaldo(5.0F);    
        float importo = 5.0F;
                
        instance.aggiungiMovimento(importo);
        Float expResult = 10.0F;
        assertNotNull(instance.getMovimentoCorrente());
    }
    
}
