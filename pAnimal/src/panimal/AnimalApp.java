/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panimal;

import java.util.Random;

/**
 *
 * @author rndm
 */
public class AnimalApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        SeaLion seaLion = new SeaLion("Bob");
//        Dog dog = new Dog("Bill");
//        
//        System.out.println(seaLion.toString());
//        System.out.println(dog.toString());
        
        Animal[] animals = new Animal[4];
        
        animals[0] = new Dog("Fido");
        animals[1] = new SeaLion("George");
        animals[2] = new Tarzier("Ugly");
        animals[3] = new Horse("Spider");
        
        for (Animal a: animals) {
            System.out.println(a.name + " says " +a.speak());
        } 
        
        for (Animal a: animals) {            
            if (a instanceof Domesticated) {
                System.out.println(a.name +
                                   " job is to " + 
                                   ((Domesticated)a).work());
            }
            else{
                System.out.println(a.name + 
                                   " has no job ");
            }
        } 
        
//        
//        for (int i = 0; i < 100; i++) {
//            int dice = (new Random()).nextInt(6) + 1;
//            System.out.println(dice);
//        }
        
    }
}
