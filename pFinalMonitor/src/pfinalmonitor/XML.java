package pfinalmonitor;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XML {
    
    private File fXmlFile;        
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;
    private NodeList nList;
    
    public XML(){
        try{
	        fXmlFile = new File("C:/Users/rNdm/Work/Java/pFinalMonitor/src/pfinalmonitor/sensor.xml");	        
	        dbFactory = DocumentBuilderFactory.newInstance();
	        dBuilder = dbFactory.newDocumentBuilder();
	        doc = dBuilder.parse(fXmlFile); 
                doc.getDocumentElement().normalize();
                nList = doc.getElementsByTagName("SENSOR");
                //System.out.println(nList.getLength());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String scanData(String search){
    	
        String value = "";
        
        try {  
            for (int temp = 0; temp < nList.getLength(); temp++) {  

                Node nNode = nList.item(temp);	

                if (nNode.getNodeType() == Node.ELEMENT_NODE) { 

                    Element eElement = (Element) nNode;  

                    if (search == null ? eElement.getElementsByTagName("NAME").item(0).getTextContent() == null : 
                        search.equals(eElement.getElementsByTagName("NAME").item(0).getTextContent())) {
                        value = (eElement.getElementsByTagName("VALUE").item(0).getTextContent());
                    }
                }
            }
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
                
        return value;
    }

    /**
     * @return the nList
     */
    public int getnList() {
        return nList.getLength();
    }
}
