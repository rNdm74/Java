/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pbox;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rNdm
 */
public class BoxTest {    
    
    public BoxTest() {
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
     * Test of getHeight method, of class Box.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Box instance = new Box(5);
        double expResult = 5;
        double result = instance.getHeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLength method, of class Box.
     */    
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Box instance = new Box(9.5);
        double expResult = 9.5;
        double result = instance.getLength();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getWidth method, of class Box.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Box instance = new Box(-5);
        double expResult = -5;
        double result = instance.getWidth();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setbHeight method, of class Box.
     */
    @Test
    public void testSetbHeight() {
        System.out.println("setbHeight");
        double bHeight = 4;        
        Box instance = new Box(5);        
        instance.setbHeight(bHeight);        
        double expResult = 4;        
        double result = instance.getHeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setbLength method, of class Box.
     */
    @Test
    public void testSetbLength() {
        System.out.println("setbLength");
        double bLength = 4.4;
        Box instance = new Box(6);
        instance.setbLength(bLength);
        double expResult = 4.4;        
        double result = instance.getLength();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setbWidth method, of class Box.
     */
    @Test
    public void testSetbWidth() {
        System.out.println("setbWidth");
        double bWidth = -3.3;
        Box instance = new Box(6);
        instance.setbWidth(bWidth);
        double expResult = -3.3;        
        double result = instance.getWidth();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcVolume method, of class Box.
     */
    @Test
    public void testCalcVolume() {
        System.out.println("calcVolume");
        Box instance = new Box(9);
        double expResult = (9*9*9);
        double result = instance.calcVolume();
        assertEquals(expResult, result, 0.0);        
    }

    /**
     * Test of getSurfaceArea method, of class Box.
     */
    @Test
    public void testGetSurfaceArea() {
        System.out.println("getSurfaceArea");
        Box instance = new Box(2);
        double expResult = 24;
        double result = instance.getSurfaceArea();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Box.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Box instance = new Box(5);
        String expResult = (" Height is " + 5.0 + "\n" +
                            " Width is " + 5.0 + "\n" +
                            " Length is " + 5.0 + "\n" + 
                            " Volume is " + 125.0 + "\n" +
                            " Surface Area is " + 150.0 + "\n");
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test (expected = NullPointerException.class)
    public void testToStringBoxIsNull() {
        System.out.println("toStringBoxIsNull");
        Box instance = null;
        String expResult = null;
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
