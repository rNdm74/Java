/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parrayutilities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rndm
 */
public class ArrayUtilitiesTest {
    
    public ArrayUtilitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findMax method, of class ArrayUtilities.
     */
    @Test
    public void testFindMax() {
        System.out.println("findMax");
        int[] numbers = null;
        ArrayUtilities instance = new ArrayUtilities();
        int expResult = 0;
        int result = instance.findMax(numbers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMin method, of class ArrayUtilities.
     */
    @Test
    public void testFindMin() {
        System.out.println("findMin");
        int[] numbers = null;
        ArrayUtilities instance = new ArrayUtilities();
        int expResult = 0;
        int result = instance.findMin(numbers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findIt method, of class ArrayUtilities.
     */
    @Test
    public void testFindIt() {
        System.out.println("findIt");
        int[] numbers = null;
        int wanted = 0;
        ArrayUtilities instance = new ArrayUtilities();
        String expResult = "";
        String result = instance.findIt(numbers, wanted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
