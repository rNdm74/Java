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
public class CDCollection {
    private ArrayList<Artist> artists;
    
    public CDCollection(ArrayList<Artist> artists){
        this.artists = artists;
                
        Reader worker = new Reader();
        worker.load(artists);
    }
    
    @Override
    public String toString(){
        return new StringBuilder().append("CD1<\n")
                                  .append(artists.get(0).toString())
                                  .append("\n\n")
                                  .append("CD2\n")
                                  .append(artists.get(1).toString())
                                  .append("\n>").toString();
    }
}

