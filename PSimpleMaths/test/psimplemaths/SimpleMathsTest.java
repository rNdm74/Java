/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psimplemaths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author rNdm
 */
public class SimpleMathsTest {
    
    public SimpleMathsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        // Database
    }
    
    @AfterClass
    public static void tearDownClass() {
        // Database
    }
    
    @Before
    public void setUp() {
        // Test method (Data type)
    }
    
    @After
    public void tearDown() {
        // Test method (Data type)
    }

    /**
     * Test of doAddition method, of class SimpleMaths.
     */
    @Test
    public void testDoAddition() {
        System.out.println("doAddition");
        float a = 20.0F;
        float b = -5.0F;
        SimpleMaths instance = new SimpleMaths();
        float expResult = 15.0F;
        float result = instance.doAddition(a, b);
        assertEquals(expResult, result, 0.0);
        //fail("The test case is a prototype.");
        //Testing more numbers
        a=123456.25664F;
        b=0.0000000548F;
        expResult = a+b;
        
        result = instance.doAddition(a, b);
      
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of doSubtraction method, of class SimpleMaths.
     */
    
    @Test
    public void testDoSubtraction() {
        System.out.println("doSubtraction");
        float a = 50.0F;
        float b = 10.0F;
        SimpleMaths instance = new SimpleMaths();
        float expResult = 40.0F;
        float result = instance.doSubtraction(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of doMultiplication method, of class SimpleMaths.
     */
    @Ignore
    @Test
    public void testDoMultiplication() {
        System.out.println("doMultiplication");
        float a = 0.0F;
        float b = 0.0F;
        SimpleMaths instance = new SimpleMaths();
        float expResult = 0.0F;
        float result = instance.doMultiplication(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doDivision method, of class SimpleMaths.
     */
    
    @Test
    public void testDoDivision() {
        System.out.println("doDivision");
        float a = 1.0F;
        float b = 0.5F;
        SimpleMaths instance = new SimpleMaths();
        float expResult = 2.0F;
        float result = instance.doDivision(a, b);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test (expected = ArithmeticException.class)
    public void testDoDivisionByZero() {
        System.out.println("doDivisionByZero");
        float a = 0.0F;
        float b = 0.0F;
        SimpleMaths instance = new SimpleMaths();
        float expResult = 0.0F;
        float result = instance.doDivision(a, b);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getBiggest method, of class SimpleMaths.
     */
    
    @Test
    public void testGetBiggest_float_float() {
        System.out.println("getBiggest");
        float a = 10.0F;
        float b = 5.0F;
        float c = 2.0F;
        
        SimpleMaths instance = new SimpleMaths();
        float expResult = 10.0F;
        float result = instance.getBiggest(a, b);
        assertEquals(expResult, result, 0.0);
        
        expResult = 10.0F;
        result = instance.getBiggest(a, b, c);
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of getAverage method, of class SimpleMaths.
     */
    @Test (expected = NullPointerException.class)
    public void testGetAverage() {
        System.out.println("getAverage");
        int[] numbers = null;
        SimpleMaths instance = new SimpleMaths();
        float expResult = 0.0F;
        float result = instance.getAverage(numbers);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getAverage method, of class SimpleMaths.
     */
    @Test //(expected = ArithmeticException.class)
    public void testGetAveragePopulatedArray() {
        System.out.println("getAveragePopulatedArray");
        int[] numbers = new int[3];//{1,2,3,4,5};
        SimpleMaths instance = new SimpleMaths();
//        float expResult = 3.0F;
//        float result = instance.getAverage(numbers);
//        assertEquals(expResult, result, 0.0);
        
        // numbers[1] = 2;
        // numbers[2] = 4;
        
        float expResult = 0F;
        float result = instance.getAverage(numbers);
        assertEquals(expResult, result, 0.0);
        
    }
}
