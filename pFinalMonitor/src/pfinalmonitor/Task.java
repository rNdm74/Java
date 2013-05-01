
package pfinalmonitor;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author rNdm
 */
public class Task implements Runnable{       
    private Sensor sensor; 
    private long time = 0;
    private int count = 0;
    private int startPos;
    private int xpoint = 0;
    private int ypoint = 0;
    //public int[] xPoints;
    //public int[] yPoints;
    
    private ArrayList<Integer> xpoints;
    private ArrayList<Integer> ypoints;
    
    public static long delay = 10;
    public static boolean pause;
    
    public Task(Sensor sensor){
        this.sensor = sensor;
        xpoints = new ArrayList<>();
        ypoints = new ArrayList<>();        
    }        
        
    @Override
    public void run() {        
        if(time > delay && !pause){ 
           String data = new XML().scanData(sensor.name);
           
           String timeStamp = new GregorianCalendar().getTime().toString();
                      
           sensor.data.add(new String[]{data, timeStamp.substring(0,20)}); 
           
           startPos = sensor.getWidth();
           
           xpoint = startPos - count;
           
            if (xpoint < 0) {
                //xpoint = 0;
            }
           
            if (xpoints.size() > sensor.getWidth()){
                //xpoints.remove(sensor.getWidth());
                //ypoints.remove(sensor.getWidth());
                //System.out.println(ypoints.get(0));
            }

           ypoint = (sensor.name.contains("temp")) ? 
                   (int) Math.round(map(Float.parseFloat(data.substring(0, 2)), 
                            sensor.activity.min_temp, 
                            sensor.activity.max_temp, 
                            sensor.activity.getHeight(), 0)):       
                   (int) Math.round( map( Float.parseFloat(data), 
                            sensor.activity.min_light, 
                            sensor.activity.max_light, 
                            sensor.activity.getHeight(), 0));   
           
           xpoints.add(xpoint);
           ypoints.add(ypoint);
           
           sensor.activity.xPoints = new int[ypoints.size()];
           sensor.activity.yPoints = new int[ypoints.size()];
        
           for (int i = 0; i < ypoints.size(); i++) {                    
                 sensor.activity.xPoints[i] = xpoints.get(i);
                 sensor.activity.yPoints[(ypoints.size() - 1) - i] = (int) ypoints.get(i);                 
           }

           time  = 0;
           
           count++;
        }  
        
        time++;
    }
        
    public float map(float x, float in_min, float in_max, float out_min, float out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    
    private float getCurrentData(int j) throws NumberFormatException {
         return Float.parseFloat(sensor.activity.data.get(sensor.activity.arraySize - (j + 1))[0].substring(0, 2));
    }
}
