/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinalmonitor;

import java.util.GregorianCalendar;
import java.util.TimerTask;

/**
 *
 * @author rNdm
 */
public class Task extends TimerTask {       
    private Sensor sensor;  
    
    public Task(Sensor sensor){
        this.sensor = sensor;
    }        
        
    @Override
    public void run() { 
        if(sensor.button3){
           //sensor.time = new GregorianCalendar().getTime().toString().substring(0,20);
           String[] s = {new XML().scanData(sensor.name), new GregorianCalendar().getTime().toString().substring(0,20)}; 
           sensor.data.add(s); 
        }        
    }
}
