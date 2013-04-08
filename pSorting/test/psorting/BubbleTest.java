/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psorting;

import org.junit.Ignore;
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
public class BubbleTest {
    
    public BubbleTest() {
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
     * Test of bubbleSortVersion1 method, of class Bubble.
     */
    //@Ignore
    @Test
    public void testBubbleSortVersion1() {
        System.out.println("bubbleSortVersion1");
        int[] arr =  {5, 8, 2, 3, 1};
        int[] expected = {1, 2, 3, 5, 8};
        
        Bubble worker = new Bubble(arr);
        worker.bubbleSortVersion1();
        
        assertArrayEquals(expected, arr);
    }

    /**
     * Test of bubbleSortVersion2 method, of class Bubble.
     */
    //@Ignore
    @Test
    public void testBubbleSortVersion2() {
        System.out.println("bubbleSortVersion2");
        int[] arr =  {5, 8, 2, 3, 1};
        int[] expected = {1, 2, 3, 5, 8};
        
        Bubble worker = new Bubble(arr);
        worker.bubbleSortVersion2();
        
        assertArrayEquals(expected, arr);
    }

    /**
     * Test of bubbleSortVersion3 method, of class Bubble.
     */
    //@Ignore
    @Test
    public void testBubbleSortVersion3() {
        System.out.println("bubbleSortVersion3");
        int[] arr =  {5, 8, 2, 3, 1};
        int[] expected = {1, 2, 3, 5, 8};
        
        Bubble worker = new Bubble(arr);
        worker.bubbleSortVersion3();
        
        assertArrayEquals(expected, arr);
    }

    /**
     * Test of bubbleSortString method, of class Bubble.
     */
    @Test
    public void testBubbleSortString() {
        System.out.println("bubbleSortString");
        String[] arr = {"b", "f", "a", "e", "c", "d"};
        String[] expected = {"a", "b", "c", "d", "e", "f"};
        Bubble instance = new Bubble();
        instance.bubbleSortString(arr);
        
        assertArrayEquals(expected, arr);
    }
}
