/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcollections;

import java.util.Arrays;

/**
 *
 * @author rndm
 */
public class CollectionsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Friend f1 = new Friend("Adam", "Charlton", 1982,10,31, 'M', "Dunedin", "Email", "Single");
        Friend f2 = new Friend("Jo", "Bloggs", 1990,1,1990, 'F', "Dunedin", "Email", "Married");
        Friend f3 = new Friend("Jane", "Bloggs", 1971,5,2, 'M', "Dunedin", "Email", "Married");
        Friend f4 = new Friend("Jen", "Smith", 1979,8,11, 'F', "Christchurch", "Email", "Single");
        Friend f5 = new Friend("Max", "Total", 1989,11,20, 'M', "Auckland", "Email", "Married");
        
        Friend[] friends = {f1,f2,f3,f4,f5};
        
        //Bubble sort = new Bubble();        
        //sort.bubbleSortString(friends);
        
        AgeCompare ageCompare = new AgeCompare();
        GenderCompare genderCompare = new GenderCompare();
        
        Arrays.sort(friends, genderCompare);
        
        for(Friend f: friends){
            System.out.println(f.toString());
        }
    }
}
