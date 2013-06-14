/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pembeddedminor;

import java.util.ArrayList;
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
    private JLabel label1;
    private ArrayList<Integer> list;
    
    public Task(ArrayList<Integer> list,
                JLabel label,
                JLabel label1){        
        this.label = label;
        this.label1 = label1;
        this.list = list;
    }
    
    public Task(ArrayList<Integer> list,
                JLabel label){        
        this.label = label;
        this.list = list;
    }
    
    @Override
    public void run() {
        String s;
        int r = new Random().nextInt(110)+ 5;
        s = new StringBuilder().append(r).toString();
        label.setText(s);
        
        if (label1 != null) {
            label1.setText(s);
        }
        
        list.add(r);
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
