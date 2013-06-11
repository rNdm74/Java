
package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

/**
 *
 * @author rNdm
 */
public class ReadXML {
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document document;
        
    private String[] items;
    private String[] equation = {"equation","answer"};
    private String[] images = {"name","x","y","width","height"};
    private String[] fonts = {"letter","x","y","width","height", "id"};
    
    public ReadXML(String file){         
        try {
            File xml = new File(file);         
                    
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            
            document = documentBuilder.parse(xml);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
        }
    }
    public ArrayList<Equation> getTableData(String tagName){
        ArrayList<Equation> xmlData = new ArrayList<>();
        
        items = equation;
        
        for (int i = 0; i < document.getElementsByTagName(tagName).getLength(); i++) {
            NamedNodeMap namedNodeMap = document.getElementsByTagName(tagName).item(i).getAttributes();
            xmlData.add(new Equation(values(namedNodeMap)));
        }     
        
        return xmlData;   
    }
    
    public ArrayList<Texture> getImageData(String tagName){  
        ArrayList<Texture> xmlData = new ArrayList<>();
        
        items = (tagName.equals("char"))? fonts : images;
        
        for (int i = 0; i < document.getElementsByTagName(tagName).getLength(); i++) {
            NamedNodeMap namedNodeMap = document.getElementsByTagName(tagName).item(i).getAttributes();
            xmlData.add(new Texture(values(namedNodeMap)));
        }     
        
        return xmlData;
    }    
    
    private Object[] values(NamedNodeMap namedNodeMap) throws DOMException {
        Object[] values = new Object[items.length];
        
        for (int item = 0; item < values.length; item++) {
            values[item] = namedNodeMap.getNamedItem(items[item]).getNodeValue();
        }
        
        return values;
    }
}
