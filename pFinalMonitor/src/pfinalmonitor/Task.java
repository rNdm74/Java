
package pfinalmonitor;

import java.util.GregorianCalendar;

/**
 *
 * @author rNdm
 */
public class Task implements Runnable{       
    private Sensor sensor; 
    private long time = 0;
    public static long delay = 1000;
    public static boolean pause;
    
    public Task(Sensor sensor){
        this.sensor = sensor;
    }        
        
    @Override
    public void run() {
        if(time > delay && !pause){
            
           String data = new XML().scanData(sensor.name);
           data = (sensor.name.contains("temp")) ? 
                   data.substring(0, data.indexOf('.') + 2) + " °C" : data;
           
           String timeStamp = new GregorianCalendar().getTime().toString();
           
           String[] s = {data, timeStamp.substring(0,20)}; 
           
           sensor.data.add(s); 
           
           time  = 0;
           
        }  
        time++;
    }
}
