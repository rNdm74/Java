/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcollections;

import java.util.ArrayList;

/**
 *
 * @author rndm
 */
public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        
        myList.add("Dunedin");
        myList.add("Christchurch");
        myList.add("Wellington");
        myList.add("Auckland");
                
        System.out.println(myList);
        
        myList.add("Hamilton");
        
        System.out.println(myList);
            
        myList.remove(0);
        
        System.out.println(myList);
        
        //myList.
    }    
}
