/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinalmonitor;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

/**
 *
 * @author rNdm
 */
public class Task extends TimerTask {
    int time = 0;
    
    private ArrayList<Integer> list;
    
    public Task(ArrayList<Integer> list){ 
        this.list = list;
    }
        
        
    @Override
    public void run() {
        String s;
        int r = new Random().nextInt(110)+ 5;
        s = new StringBuilder().append(r).toString();
        //label.setText(s);
        
        //if (label1 != null) {
        //    label1.setText(s);
        //}
        
        list.add(r);
    }
}
