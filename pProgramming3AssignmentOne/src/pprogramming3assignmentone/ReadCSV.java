/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pprogramming3assignmentone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rndm
 */
public class ReadCSV {
    private ArrayList<String[]> csvData;
        
    public ReadCSV(String filename) throws FileNotFoundException, IOException {        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            csvData = new ArrayList<>();
            
            String line;
            
            while((line = br.readLine()) != null){            
                csvData.add(line.split(","));
            }
        }
    } 

    public ArrayList<String[]> getCsvData() {
        return csvData;
    }        
}
