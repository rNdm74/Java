/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcdcollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rndm
 */
public class Reader {
    private String name;
    
    
    public void load(ArrayList<Artist> artists){
        BufferedReader in;
        String line;        
        try{
          in = new BufferedReader(new FileReader("data.csv")); 
          
          while((line = in.readLine()) != null){
            name = line;
            
            ArrayList<Song> songs = new ArrayList<Song>();
            
            for (int i = 0; i < 3; i++) {
                Song aSong = new Song(in.readLine());
                songs.add(aSong);
            }
              
            artists.add( new Artist(name, songs));
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
