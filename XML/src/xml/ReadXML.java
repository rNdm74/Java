
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
    
    private ArrayList<Texture> imageData;
    
    public ReadXML(){       
        try {
            File file = new File("atlas.xml");
            
            imageData = new ArrayList<>();            
                    
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            
            document = documentBuilder.parse(file);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
        }
    }
    
    public ArrayList<Texture> getImageData(){        
        for (int i = 0; i < document.getElementsByTagName("SubTexture").getLength(); i++) {
            NamedNodeMap namedNodeMap = document.getElementsByTagName("SubTexture").item(i).getAttributes();
            imageData.add(new Texture(values(namedNodeMap)));
        }          
        return imageData;
    }    
    
    private Object[] values(NamedNodeMap namedNodeMap) throws DOMException {
        Object[] values = {
            namedNodeMap.getNamedItem("name").getNodeValue(),
            namedNodeMap.getNamedItem("x").getNodeValue(),
            namedNodeMap.getNamedItem("y").getNodeValue(),
            namedNodeMap.getNamedItem("width").getNodeValue(),
            namedNodeMap.getNamedItem("height").getNodeValue(),
//            namedNodeMap.getNamedItem("frameX").getNodeValue(),
//            namedNodeMap.getNamedItem("frameY").getNodeValue(),
//            namedNodeMap.getNamedItem("frameWidth").getNodeValue(),
//            namedNodeMap.getNamedItem("frameHeight").getNodeValue()
        };        
        return values;
    }
}
