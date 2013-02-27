/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdice;

import java.util.Scanner;

/**
 *
 * @author rNdm
 */
public class DiceApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dice dice1 = new Dice();
              
        
        for (int i = 0; i < 99; i++) {
            
            int  roll = dice1.roll();
            
            if (roll != 0) {
                dice1.setFaceValue(roll);
            }
            
            System.out.println("Press enter to roll dice: ");
            new Scanner( System.in ).nextLine();            
            System.out.println(dice1.toString() + "\n");
            
            
            
            
        }        
    }
}
