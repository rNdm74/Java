
package pfinalmonitor;

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

    private Float xmlData;

    private ArrayList<Float> xmlDataList;

    private int[] xPoints;
    private int[] yPoints;
    
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

            xmlData = Float.parseFloat((sensor.name.contains("temp")) ? data.substring(0, 2): data);

            xmlDataList.add(xmlData);

            yPoints = new int[xmlDataList.size()];
            xPoints = new int[xmlDataList.size()];

            for (int i = 0; i < xPoints.length; i++) {
                xPoints[i] =  i+3;

                int mappedData = Math.round(map(xmlDataList.get(i),
                        (sensor.name.contains("temp")) ? min_temp : min_light,
                        (sensor.name.contains("temp")) ? max_temp : max_light,
                        sensor.activity.getHeight(), 0));

                yPoints[i] = mappedData;
            }

            int[] newYPoints = new int[]{sensor.activity.getHeight() - 2, sensor.activity.getHeight() - 2};
            int[] newXPoints = new int[]{yPoints.length +1, 4};

            sensor.activity.xPoints = concat(newXPoints, xPoints);
            sensor.activity.yPoints = concat(newYPoints, yPoints);

            time  = 0;

            count++;
        }



        if (xmlDataList.size() > sensor.sensorpanel.getWidth() - 5 && xmlDataList.size() > 20){
            xmlDataList.remove(0);
        }

        time++;
    }

    private int[] concat(int[] a, int[] b) {
        final int alen = a.length;
        final int blen = b.length;
        final int[] result = (int[]) java.lang.reflect.Array.
                newInstance(a.getClass().getComponentType(), alen + blen);
        System.arraycopy(a, 0, result, 0, alen);
        System.arraycopy(b, 0, result, alen, blen);
        return result;
    }
        
    public float map(float x, float in_min, float in_max, float out_min, float out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}
