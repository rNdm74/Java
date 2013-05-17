
package pfinalmonitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rndm
 */
public class CSV {
    private ArrayList<String[]> csvData;
        
    public CSV() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/rndm/Work/Pi_Bak/thunderhead/sensor.csv"))) {
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
