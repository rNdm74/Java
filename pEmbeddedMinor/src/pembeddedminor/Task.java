/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pembeddedminor;

import java.util.Random;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author rNdm
 */
public class Task extends TimerTask {
    int time = 0;
    
    private JLabel label;
    
    public Task(JLabel label){
        this.label = label;
    }
    
    @Override
    public void run() {
        String value;
        //time++;
        value = new StringBuilder().append(new Random().nextInt(255)).toString();
        label.setText(value);
        //System.out.println(value);
//        times++;
//        
//        if (times <= 5) {
//            System.out.println("I'm alive...");
//        } else {
//            System.out.println("Timer stops now...");
// 
//            //Stop Timer.
//            this.cancel();
//        }    
    }
}
