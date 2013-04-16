/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panimal;

/**
 *
 * @author rndm
 */
public class AnimalApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SeaLion seaLion = new SeaLion("Bob");
        Dog dog = new Dog("Bill");
        
        System.out.println(seaLion.toString());
        System.out.println(dog.toString());
    }
}
