
package S6TimesTables;

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
public class ReadXMLTest {
    
    public ReadXMLTest() {
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
     * Test of getTableData method, of class ReadXML.
     */
    @Test
    public void testGetImageData() {
        System.out.println("getImageData");
        
        String tagName = "SubTexture";
        
        ReadXML instance = new ReadXML("atlas.xml");
        instance.getXMLData();
        instance.initDocument();
        
        ReadXML instance1 = new ReadXML("atlas.xml");
        instance1.getXMLData();
        instance1.initDocument();
        
        for(Texture t: instance.getImageData(tagName)){
            Object expResult = t.getText();
            Object result = t.getText();        
            assertEquals(expResult, result);
        }            
    }

    /**
     * Test of getImageData method, of class ReadXML.
     */
    @Test
    public void testGetTableData() {
System.out.println("getImageData");
        
        String[] levels = {
            //"One",
            //"Two",
            "Three",
            "Four",
            //"Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            //"Ten",
            //"Eleven",
            //"Twelve"                        
        };
        
        ReadXML instance = new ReadXML("tables.xml");
        instance.getXMLData();
        instance.initDocument();
        
        ReadXML instance1 = new ReadXML("tables.xml");
        instance1.getXMLData();
        instance1.initDocument();
        
        for (String s: levels) {
            for(Equation t: instance.getTableData(s)){
                Object expResult = t.getQuestion();
                Object result = t.getQuestion();        
                assertEquals(expResult, result);
            }
        }        
    }

    /**
     * Test of initDocument method, of class ReadXML.
     */
    @Test
    public void testInitDocument() {
        System.out.println("initDocument");
        ReadXML instance = new ReadXML("atlas.xml");  
        instance.getXMLData();
        
        boolean expResult = true;
        boolean result = instance.initDocument();
        assertEquals(expResult, result);
    }

    /**
     * Test of getXMLData method, of class ReadXML.
     */
    @Test
    public void testGetXMLData() {
        System.out.println("getXMLData");
        ReadXML instance = new ReadXML("atlas.xml");        
        boolean expResult = true;
        boolean result = instance.getXMLData();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFile method, of class ReadXML.
     */
    @Test
    public void testGetFile() {
        System.out.println("getFile");
        ReadXML instance = new ReadXML("test");
        String expResult = "test";
        String result = instance.getFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFile method, of class ReadXML.
     */
    @Test
    public void testSetFile() {
        System.out.println("setFile");
        String file = "foo";
        ReadXML instance = new ReadXML("test");
        instance.setFile(file);
        
        String expResult = "foo";
        String result = instance.getFile();
        assertEquals(expResult, result);
    }
}