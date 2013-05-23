
package pprogramming3assignmentone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rndm
 */
public class Worker {
    private ArrayList<Object[]> data;
    private String filename;
    public boolean loadComplete;
    
    public Worker(String filename) throws FileNotFoundException, IOException { 
        this.filename = filename; 
    } 
    
    public boolean load() throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            data = new ArrayList<>();
            
            String line;
            
            while((line = br.readLine()) != null){            
                data.add(dataType(line));
            }
            
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }        
    }
    
    private Object[] dataType(String line){
        String[] s = line.split(",");
        
        Object[] o = new Object[s.length];
        
        for (int i = 0; i < o.length; i++) {
            o[i] = (isNumber(s[i])) ? Double.parseDouble(s[i]) : s[i];
        }   
        
        return o;
    }
    
    private boolean isNumber(String s){
        try{
           Double.parseDouble(s);
           return true;
        }
        catch(Exception e){
           return false; 
        }        
    }

    public ArrayList<Object[]> getData() {
        return data;
    }        

    public String getFilename() {
        return filename;
    }
}
