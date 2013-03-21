/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parrayutilities;

import java.io.*;
import java.util.*;

/**
 *
 * @author rndm
 */
public class Reader {
    private int[] myArray;
    private int index;
    
    private String line;
    
    private BufferedReader in; 
    
    public Reader(){
        
    }

    /**
     * @return the myArray
     */
    public int[] getMyArray() {
        myArray = new int[1000];
        index = 0;
    
        try
        {            
            in = new BufferedReader(new FileReader("rand.txt"));
            while (((line = in.readLine()) != null) && (index<1000)) {
                myArray[index] = Integer.parseInt(line);
                index++;
            }
        }
        catch (IOException e)
        {
            System.out.println("There was a problem with the file");
            e.printStackTrace();
        }
        catch (NumberFormatException ne)
        {
            System.out.println("Not a number: the string did not convert to a number ");
            ne.printStackTrace();
        }
        
        return myArray;
    }

    /**
     * @param myArray the myArray to set
     */
    private void setMyArray(int[] myArray) {
        this.myArray = myArray;
    }
    
    
}
