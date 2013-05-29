/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcollections;

import java.util.Comparator;

/**
 *
 * @author rndm
 */
public class GenderCompare implements Comparator<Friend> {
    
    @Override
    public int compare(Friend o1, Friend o2) {
        return (o1.getGender() !=  '\u0000' && o2.getGender() != '\u0000') ? 
                o1.getGender() - o2.getGender() : 0;
    }
}
