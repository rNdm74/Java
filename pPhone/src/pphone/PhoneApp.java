/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pphone;

import java.util.ArrayList;

/**
 *
 * @author rndm
 */
public class PhoneApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        
        PhoneReader worker = new PhoneReader();
        
        worker.load(people);
        
        System.out.println(people);
    }
}
