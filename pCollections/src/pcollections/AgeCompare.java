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
public class AgeCompare implements Comparator<Month>{

    @Override
    public int compare(Month o1, Month o2) {
//        if (o1.getYear() != null && o2.getYear() != null) {
//            return o1.getYear() - o2.getYear();
//        }
//        else
//        {
//            return 0;
//        }
        return (o1.getYear() != null && o2.getYear() != null) 
                ? o1.getYear() - o2.getYear() : 0;
    }    
}
