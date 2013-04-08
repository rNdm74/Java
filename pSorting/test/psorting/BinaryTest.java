/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psorting;

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
public class BinaryTest {
    
    public BinaryTest() {
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
     * Test of binarySearch method, of class Binary.
     */
    @Test
    public void testBinarySearch_intArr_int_Left() {
        System.out.println("binarySearch");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int wanted = 1;
        Binary instance = new Binary();
        String expResult = "Number found at slot number 0";
        String result = instance.binarySearch(numbers, wanted);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBinarySearch_intArr_int_Right() {
        System.out.println("binarySearch");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int wanted = 9;
        Binary instance = new Binary();
        String expResult = "Number found at slot number 8";
        String result = instance.binarySearch(numbers, wanted);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBinarySearch_intArr_int_Middle() {
        System.out.println("binarySearch");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int wanted = 5;
        Binary instance = new Binary();
        String expResult = "Number found at slot number 4";
        String result = instance.binarySearch(numbers, wanted);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBinarySearch_intArr_int_Outside() {
        System.out.println("binarySearch");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int wanted = 10;
        Binary instance = new Binary();
        String expResult = "Number not found";
        String result = instance.binarySearch(numbers, wanted);
        assertEquals(expResult, result);
    }

    /**
     * Test of binarySearch method, of class Binary.
     */
    @Test
    public void testBinarySearch_StringArr_String_Left() {
        System.out.println("binarySearch");
        String[] words = {"a", "b", "c", "d", "e", "f"};
        String wanted = "a";
        Binary instance = new Binary();
        String expResult = "Word found at slot number 0";
        String result = instance.binarySearch(words, wanted);
        assertEquals(expResult, result);
    }
    @Test
    public void testBinarySearch_StringArr_String_Right() {
        System.out.println("binarySearch");
        String[] words = {"a", "b", "c", "d", "e", "f"};
        String wanted = "f";
        Binary instance = new Binary();
        String expResult = "Word found at slot number 5";
        String result = instance.binarySearch(words, wanted);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBinarySearch_StringArr_String_Middle() {
        System.out.println("binarySearch");
        String[] words = {"a", "b", "c", "d", "e", "f"};
        String wanted = "c";
        Binary instance = new Binary();
        String expResult = "Word found at slot number 2";
        String result = instance.binarySearch(words, wanted);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBinarySearch_StringArr_String_Outside() {
        System.out.println("binarySearch");
        String[] words = {"a", "b", "c", "d", "e", "f"};
        String wanted = "g";
        Binary instance = new Binary();
        String expResult = "Word not found";
        String result = instance.binarySearch(words, wanted);
        assertEquals(expResult, result);
    }
}