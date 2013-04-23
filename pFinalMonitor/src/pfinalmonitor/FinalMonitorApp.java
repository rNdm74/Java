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
        
        Main m = new Main(width, height){};
        //m.setJMenuBar(new Menu());
        
//        for(Sensor s: sensors){
//                        
//        }
        
                
    }
}
