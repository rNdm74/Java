/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pbox;

/**
 *
 * @author rNdm
 */
public class BoxApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Box box1 = new Box(1, 2, 3);        
        Box box2 = new Box(9, 5);        
        Box box3 = new Box(5);
        
        System.out.println(box1.toString());
        System.out.println(box2.toString());
        System.out.println(box3.toString());
    }
}
