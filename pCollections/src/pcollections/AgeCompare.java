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
public class AgeCompare implements Comparator<Friend>{

    @Override
    public int compare(Friend o1, Friend o2) {
//        if (o1.getBirthdate() != null && o2.getBirthdate() != null) {
//            return o1.calculateAge() - o2.calculateAge();
//        }
//        else
//        {
//            return 0;
//        }
        return (o1.getBirthdate() != null && o2.getBirthdate() != null) 
                ? o1.calculateAge() - o2.calculateAge() : 0;
    }    
}
