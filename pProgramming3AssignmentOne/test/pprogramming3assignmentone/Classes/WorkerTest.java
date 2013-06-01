
package pprogramming3assignmentone.Classes;

import pprogramming3assignmentone.Worker;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AdamCharlton
 */
public class WorkerTest {
    Worker instance = new Worker("E:\\Share\\Documents\\sensor.csv");
    
    public WorkerTest() {
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
     * Test of load method, of class Worker.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        
        boolean expResult = true;
        boolean result = instance.load();
        assertEquals(expResult, result);
    }

    /**
     * Test of getData method, of class Worker.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        
        ArrayList expResult = null;
        ArrayList result = instance.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFilename method, of class Worker.
     */
    @Test
    public void testSetFilename() {
        System.out.println("setFilename");
        String filename = "E:\\Share\\Documents\\sensor.csv";
        instance.setFilename(filename);
        
        String expResult = filename;
        String result = instance.getFilename();        
        assertEquals(expResult, result);
    }

    /**
     * Test of getFilename method, of class Worker.
     */
    @Test
    public void testGetFilename() {
        System.out.println("getFilename");
        String expResult = "E:\\Share\\Documents\\sensor.csv";
        String result = instance.getFilename();
        assertEquals(expResult, result);
    }
}