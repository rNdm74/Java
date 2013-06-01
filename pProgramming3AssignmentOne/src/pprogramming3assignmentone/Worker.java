
package pprogramming3assignmentone;

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
    
    /**
     *
     * @param filename receives string that specifies the file path of a file
     */
    public Worker(String filename) { 
        this.filename = filename; 
    } 
    
    /**
     *
     * @return true false if file is loaded successfully
     */
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
    
    /**
     *
     * @return the loaded data arraylist
     */
    public ArrayList<Object[]> getData() {
        return data;
    } 
    
    /**
     *
     * @param filename sets the filename that is used by the file reader
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     *
     * @return returns the current filename
     */
    public String getFilename() {
        return filename;
    }
}
