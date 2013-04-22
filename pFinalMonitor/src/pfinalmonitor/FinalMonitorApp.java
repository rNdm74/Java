/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinalmonitor;

import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Timer;
import javax.swing.JFrame;

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
        
        int size = new XML().getnList();
           // does layout of components.
        
        //g.setContentPane(null);
        
        
        
        
        Sensor[] sensors = new Sensor[size];
            
        //sensors[0].setState(jFrame.ICONIFIED);
        sensors[0] = new Sensor(Color.orange, "temp1");
        sensors[1] = new Sensor(Color.green, "temp2");
        sensors[2] = new Sensor(Color.cyan, "temp3");
        sensors[3] = new Sensor(Color.white, "light");
        //g.add(sensors[0]);        
        
        Task t1 = new Task(sensors[0]);
        Task t2 = new Task(sensors[1]);
        Task t3 = new Task(sensors[2]);
        Task t4 = new Task(sensors[3]);
        
        timer.schedule(t1, 0, 1000);
        timer.schedule(t2, 0, 1000);
        timer.schedule(t3, 0, 1000);
        timer.schedule(t4, 0, 1000);
        
        
        for(Sensor s: sensors){
            s.setLocation(width / 2 - s.getWidth() / 2, height / 2 - s.getHeight() / 2);
            s.setVisible(true);            
        }
        
        for (int i = 0; i < sensors.length; i++) {
            sensors[i].setLocation(sensors[i].getLocation().x, sensors[i].getLocation().y + sensors[0].getHeight() * i);
        }        
    }
}
