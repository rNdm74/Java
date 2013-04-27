package pfinalmonitor;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class XML {
    
    private File fXmlFile;        
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;
    private NodeList nList; 
    
    public XML(){
        try{
                if(System.getProperty("os.name").contains("Windows")){
                    fXmlFile = new File("C:/Users/rNdm/Work/Java/pFinalMonitor/src/pfinalmonitor/sensor.xml");
                }
                else{
                    fXmlFile = new File("/home/rndm/Work/ProjectThunderhead/sensor.xml");
                }
                	        	        
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
    public ArrayList<String> getSensors(){
        ArrayList<String> list = new ArrayList<>();
        
        try {  
            for (int temp = 0; temp < nList.getLength(); temp++) {  

                Node nNode = nList.item(temp);	

                if (nNode.getNodeType() == Node.ELEMENT_NODE) { 

                    Element eElement = (Element) nNode;  

                    //System.out.println(eElement.getElementsByTagName("NAME").item(0).getTextContent());
                    
                    String name = eElement.getElementsByTagName("NAME").item(0).getTextContent();
                    
                    if (!"datetime".equals(name)) {
                        list.add(eElement.getElementsByTagName("NAME").item(0).getTextContent());
                    }                    
                }
            }
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
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
        ArrayList<String> list = getSensors();
        return list.size();
    }
}
