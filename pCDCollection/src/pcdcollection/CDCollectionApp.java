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
public class CDCollectionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Artist> artists = new ArrayList<>();
        
        CDCollection cd = new CDCollection(artists);
        
        
        
        
        System.out.print(cd.toString());        
    }
}
