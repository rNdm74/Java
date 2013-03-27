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
public class BucketTest {
    
    public BucketTest() {
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
     * Test of bucketSort method, of class Bucket.
     */
    @Test
    public void testBucketSort() {
        System.out.println("bucketSort");
        int[] arr =  {5, 8, 2, 3, 1};
        int[] expected = {1, 2, 3, 5, 8};
        
        Bucket worker = new Bucket(arr);
        worker.bucketSort();
        
        assertArrayEquals(expected, arr);
    }
}
