
package pprogramming3assignmentone;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam Charlton
 */
public class FindTest {
    private ArrayList<Object[]> data;
    Find instance;
    
    public FindTest() {        
        data = new ArrayList<>(); 
        
        data.add(0, new String[]{ Integer.toString(5) });
        
        for (int i = 1; i < 10; i++) {
            data.add(0, new String[]{ Integer.toString(i) });
        }  
        
        instance = new Find(data);
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
     * Test of returnStats method, of class Find.
     */
    @Test
    public void testReturnStats() {
        System.out.println("returnStats");
        
        int column = 0;
        
        Object[] expResult = {
            data.get(column)[column],
            instance.max(),
            instance.min(),
            instance.mean(),
            instance.median(),
            instance.mode(),
            instance.range(instance.max(), instance.min()) 
        };
    
        Object[] result = instance.returnStats(column);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of max method, of class Find.
     */
    @Test
    public void testMax() {
        System.out.println("max");        
        String expResult = "8.0";
        String result = instance.max();
        assertEquals(expResult, result);
    }

    /**
     * Test of min method, of class Find.
     */
    @Test
    public void testMin() {
        System.out.println("min");
        String expResult = "1.0";
        String result = instance.min();
        assertEquals(expResult, result);
    }

    /**
     * Test of mean method, of class Find.
     */
    @Test
    public void testMean() {
        System.out.println("mean");
        String expResult = "7.2";
        String result = instance.mean();
        assertEquals(expResult, result);
    }

    /**
     * Test of median method, of class Find.
     */
    @Test
    public void testMedian() {
        System.out.println("median");
        String expResult = "3.5";
        String result = instance.median();
        assertEquals(expResult, result);
    }

    /**
     * Test of mode method, of class Find.
     */
    @Test
    public void testMode() {
        System.out.println("mode");
        String expResult = "5.0";
        String result = instance.mode();
        assertEquals(expResult, result);
    }

    /**
     * Test of range method, of class Find.
     */
    @Test
    public void testRange() {
        System.out.println("range");
        String max = instance.max();
        String min = instance.min();
        String expResult = "7.0";
        String result = instance.range(max, min);
        assertEquals(expResult, result);
    }
}