
package pfinalmonitor;

import java.awt.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author rNdm
 */
public class Task implements Runnable{       
    private Sensor sensor;

    private int min_temp = -15;
    private int max_temp = 40;

    private int min_light = 0;
    private int max_light = 1023;

    private long time = 0;

    private int count = 0;

    private int startPos;

    private Float xmlData = 0f;

    private ArrayList<Float> xmlDataList;
    
    public static long delay = 100;
    public static boolean pause;

    private XML xml;
    private String data;
    private String timeStamp;
    
    public Task(Sensor sensor){
        startPos = Main.sensorpanel.getWidth() - 1;
        this.sensor = sensor;
        xmlDataList = new ArrayList<>();
        xml = new XML();
    }
        
    @Override
    public void run() {        
        if(time > delay && !pause){
            data = new XML().scanData(sensor.name);
            timeStamp = new GregorianCalendar().getTime().toString();
                      
            sensor.data.add(new String[]{data, timeStamp.substring(0,20)});

            if (sensor.name.contains("temp")) {
                xmlData = Float.parseFloat(data.substring(0, 2));
            }
            else {
                xmlData = Float.parseFloat(data);
            }

            xmlDataList.add(xmlData);

            sensor.activity.yPoints = new int[xmlDataList.size()];
            sensor.activity.xPoints = new int[xmlDataList.size()];

            for (int i = 0; i < sensor.activity.xPoints.length; i++) {
                sensor.activity.xPoints[(xmlDataList.size() - 1) - i] =  i;
                sensor.activity.yPoints[i] = Math.round(map(xmlDataList.get((xmlDataList.size() - 1) - i),
                        (sensor.name.contains("temp")) ? min_temp : min_light,
                        (sensor.name.contains("temp")) ? max_temp : max_light,
                        sensor.activity.getHeight(), 0));
            }

            time  = 0;

            count++;
        }

        if (xmlDataList.size() > Main.sensorpanel.getWidth()){
            xmlDataList.remove(0);
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
