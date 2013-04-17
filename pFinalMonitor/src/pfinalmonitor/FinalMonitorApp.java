/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinalmonitor;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Timer;

/**
 *
 * @author rNdm
 */
public class FinalMonitorApp {

    private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static int width = gd.getDisplayMode().getWidth();
    private static int height = gd.getDisplayMode().getHeight();
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        
        
        Sensor[] sensors = new Sensor[2];
            
        //sensors[0].setState(jFrame.ICONIFIED);
        sensors[0] = new Sensor(Color.yellow);
        sensors[1] = new Sensor(Color.green);
        
        Task t1 = new Task(sensors[0].y1);
        Task t2 = new Task(sensors[1].y1);
        
        timer.schedule(t1, 0, 5000);
        timer.schedule(t2, 0, 5000);
        
        for(Sensor s: sensors){
            s.setLocation(width / 2 - s.getWidth() / 2, height / 2 - s.getHeight() / 2);
            s.setVisible(true);            
        }
    }
}
