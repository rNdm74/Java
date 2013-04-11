/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pphone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rndm
 */
public class PhoneReader {
    
    public void load(ArrayList<Person> people){
        BufferedReader in;
        String line;
        try{
          in = new BufferedReader(new FileReader("phone.csv")); 
          
          while((line = in.readLine()) != null){
            String[] fields = line.split(",");
            
            people.add(new Person(fields[0],
                                  fields[1],
                                  fields[2],
                                  fields[3],
                                  fields[4]));
          }  
        }
        catch (IOException e){
            System.out.println("There was a problem with the file");
            //e.printStackTrace();
	}catch (NumberFormatException ne) {
            System.out.println("Not a number");
            //ne.printStackTrace();
	}
        
            
    }
    
}
