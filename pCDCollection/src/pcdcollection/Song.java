/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcdcollection;

/**
 *
 * @author rndm
 */
public class Song {
    private String title;
    
    public Song(String title){
        this.title = title;
    }
    
    @Override
    public String toString(){
        return title;
    }
}
