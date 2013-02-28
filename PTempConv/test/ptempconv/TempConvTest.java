/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptempconv;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Tanvi
 */
public class TempConvTest {
    
    public TempConvTest() {
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
     * Test of getCel method, of class TempConv.
     */
    @Test
    public void testGetCel() 
    {
        System.out.println("getCel");
        TempConv instance = new TempConv(20.30);
        double expResult = 20.30;
        double result = instance.getCel();
        assertEquals(expResult, result, 0.5);
    }

    /**
     * Test of getFah method, of class TempConv.
     */
    @Test
    public void testGetFah() 
    {
        System.out.println("getFah");
        TempConv instance = new TempConv(20.30);
        double expResult = 68.54;
        double result = instance.getFah();
        assertEquals(expResult, result, 0.5);
    }

    /**
     * Test of getKel method, of class TempConv.
     */
    @Test
    public void testGetKel() 
    {
        System.out.println("getKel");
        TempConv instance = new TempConv(20.30);
        double expResult = 293.45;
        double result = instance.getKel();
        assertEquals(expResult, result, 0.5);
     }

    /**
     * Test of setCel method, of class TempConv.
     */
    @Test
    public void testSetCel() 
    {
        System.out.println("setCel");
        double cel = 0.0;
        TempConv instance = new TempConv(20);
        instance.setCel(20);
        double result1 = instance.getCel();
        double result2=instance.getFah();
        double result3=instance.getKel();
        assertEquals(20, result1, 0.5);
        assertEquals(68, result2, 0.5);
        assertEquals(293.15, result3, 0.5);
    }

    /**
     * Test of setFah method, of class TempConv.
     */
    @Test
    public void testSetFah() 
    {
        System.out.println("setFah");
        double fah = 0.0;
        TempConv instance = new TempConv(68);
        instance.setFah(68);
        double result1 = instance.getCel();
        double result2=instance.getFah();
        double result3=instance.getKel();
        assertEquals(20, result1, 0.5);
        assertEquals(68, result2, 0.5);
        assertEquals(293.15, result3, 0.5);
    }

    /**
     * Test of setKel method, of class TempConv.
     */
    @Test
    public void testSetKel() 
    {
        System.out.println("setKel");
        double kel = 0.0;
        TempConv instance = new TempConv(293.15);
        instance.setKel(293.15);
        double result1 = instance.getCel();
        double result2=instance.getFah();
        double result3=instance.getKel();
        assertEquals(20, result1, 0.5);
        assertEquals(68, result2, 0.5);
        assertEquals(293.15, result3, 0.5);
     }

    /**
     * Test of toString method, of class TempConv.
     */
    
    @Test
    public void testToString1() 
    {
        System.out.println("toString");
        TempConv instance = new TempConv(22.32);
        String expResult = "Celsius is 22.32 Fahrenheit is 72.176 Kelvin is 295.32";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
