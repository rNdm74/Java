/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdice;

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
public class DiceTest {
    
    public DiceTest() {
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
     * Test of roll method, of class Dice.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        Dice instance = new Dice();                
        int result = instance.roll();
        assertTrue("range acceptable", result < 7 && result > 0);
    }

    /**
     * Test of setFaceValue method, of class Dice.
     */
    @Test
    public void testSetFaceValue() {
        System.out.println("setFaceValue");
        int value = 2;
        Dice instance = new Dice();
        instance.setFaceValue(value);
        int expResult = 2;
        int result = instance.getFaceValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFaceValue method, of class Dice.
     */
    @Test
    public void testGetFaceValue() {
        System.out.println("getFaceValue");
        Dice instance = new Dice();
        int expResult = 1;
        int result = instance.getFaceValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Dice.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Dice instance = new Dice();
        String expResult = "You rolled a";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
