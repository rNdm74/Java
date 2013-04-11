/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcdcollection;

import java.util.ArrayList;

/**
 *
 * @author rndm
 */
public class Artist {
    private String name;
    private ArrayList<Song> songs;
        
    public Artist(String name, ArrayList<Song> songs){
        this.name = name;
        this.songs = songs;
    }
    
    @Override
    public String toString(){
        return new StringBuilder().append("\nArtist:\n")
                                  .append(name)
                                  .append("\n")
                                  .append(songs).toString();
    }
}
