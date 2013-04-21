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
    
    
    private String sensor;
    
    private ArrayList<String> list;
        
    public Task(ArrayList<String> list, String sensor){ 
        this.list = list;
        this.sensor = sensor;
    }
        
        
    @Override
    public void run() {
        //String s;
        //int r = new Random().nextInt(110)+ 5;
        //s = new StringBuilder().append().toString();
        //label.setText(s);
        
        //if (label1 != null) {
        //    label1.setText(s);
        //}
        
        //float value = Float.parseFloat();
        
        //System.out.println(value);
        
        list.add(new XML().scanData(sensor));
    }
}
