/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probot;

/**
 *
 * @author rNdm
 */
public class RobotApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Making the robots");
        
        Robot machine1 = new Robot("r2d2", "solar");
        Robot machine2 = new Robot("c23", "solar");
        
        System.out.println(machine1.getName() + " runs on " + machine1.getFuel());
        System.out.println(machine2.getName() + " runs on " + machine2.getFuel());
    }
}
