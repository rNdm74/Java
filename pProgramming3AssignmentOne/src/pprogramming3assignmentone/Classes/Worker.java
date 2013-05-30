
package pprogramming3assignmentone.Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adam Charlton
 */
public class Worker {
    private ArrayList<Object[]> data;
    private String filename;
    public boolean loadComplete;
    
    public Worker(String filename) { 
        this.filename = filename; 
    } 
    
    public boolean load(){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            data = new ArrayList<>();
            
            String line;
            
            while((line = br.readLine()) != null){            
                data.add(line.split(","));
            }
            
            return true;
            
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
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
    
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
