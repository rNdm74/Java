
package pfinalmonitor;

import java.util.GregorianCalendar;

/**
 *
 * @author rNdm
 */
public class Task implements Runnable{       
    private Sensor sensor; 
    private long time = 0;
    private int x = 440;
    public static long delay = 100;
    public static boolean pause;
    
    public Task(Sensor sensor){
        this.sensor = sensor;
    }        
        
    @Override
    public void run() {
        if(time > delay && !pause){
           //System.out.println(sensor.data.s); 
           String data = new XML().scanData(sensor.name);
//           data = (sensor.name.contains("temp")) ? 
//                   data.substring(0, data.indexOf('.') + 2) + " °C" : data;
           
           String timeStamp = new GregorianCalendar().getTime().toString();
                      
           sensor.data.add(new String[]{data, timeStamp.substring(0,20)}); 
           //sensor.activity.xPoints.add(x--);
           //sensor.activity.yPoints.add(Float.parseFloat(data.substring(0, data.indexOf('.') + 2)));
            
           time  = 0;
           
           populateArray(sensor.name);           
        }  
        time++;
        
        
    }
    
    public float map(float x, float in_min, float in_max, float out_min, float out_max)
    {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    
    private void populateArray(String name) throws NumberFormatException {
        for (int j = 0; j < sensor.activity.xPoints.length; j++) {
            sensor.activity.xPoints[j] = j;
        }

        sensor.activity.arraySize = sensor.activity.data.size();  

        if (sensor.activity.arraySize > 2) {            
            for (int j = 0; j < sensor.activity.get.length; j++) {                       
               if (name.contains("temp")) {
                    sensor.activity.get[j] = getCurrentData(j); 
                    sensor.activity.yPoints[j] = map(
                            sensor.activity.get[sensor.activity.get.length - (j + 1)], 
                            sensor.activity.min_temp, 
                            sensor.activity.max_temp, 
                            sensor.activity.getHeight(), 0);              

               }
               else{
                    sensor.activity.get[j] = Float.parseFloat(sensor.activity.data.get(sensor.activity.arraySize - (j + 1))[0]); 
                    sensor.activity.yPoints[j] = map(
                            sensor.activity.get[sensor.activity.get.length - (j + 1)], 
                            sensor.activity.min_light, 
                            sensor.activity.max_light, 
                            sensor.activity.getHeight(), 0);               

               }
            }
        }
    }

    private float getCurrentData(int j) throws NumberFormatException {
         return Float.parseFloat(sensor.activity.data.get(sensor.activity.arraySize - (j + 1))[0].substring(0, 2));
    }
}
