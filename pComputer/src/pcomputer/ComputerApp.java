/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcomputer;

/**
 *
 * @author rndm
 */
public class ComputerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Laptop[] laptops = new Laptop[5];
                
        laptops[0] = new Laptop("Intel", "950", 4096, 1, 27.0, 100);
        laptops[1] = new Laptop("AMD", "A10", 4096 * 2, 1, 27.0, 100);
        laptops[2] = new Laptop("Intel", "2600k", 4096, 3, 27.0, 100);
        laptops[3] = new Laptop("Intel", "920", 4096 * 3, 1, 27.0, 100);
        laptops[4] = new Laptop("AMD", "A50", 4096, 4, 27.0, 100);
        
        for (int i = 0; i < laptops.length; i++) {
            System.out.println(laptops[i].toString());
        }
        
        System.out.println(Laptop.getCount());        
    }
}
