/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pembeddedminor;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Timer;

/**
 *
 * @author rndm
 */
public class EmbeddedMinorApp {
    private static UI gui = new UI();
    private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static int width = gd.getDisplayMode().getWidth();
    private static int height = gd.getDisplayMode().getHeight();
     
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        Task t = new Task(gui.y1, gui.jLabel1, gui.jLabel1A);
        Task t1 = new Task(gui.y2, gui.jLabel2, gui.jLabel1A1);
        Task t2 = new Task(gui.y3, gui.jLabel3, gui.jLabel1A2);
        Task t3 = new Task(gui.y4, gui.jLabel4, gui.jLabel1A3);
        
        timer.schedule(t, 0, 5000);
        timer.schedule(t1, 0, 5000);
        timer.schedule(t2, 0, 5000);
        timer.schedule(t3, 0, 5000);
        
        gui.setLocation(width / 2 - gui.getWidth() / 2, height / 2 - gui.getHeight() / 2);
        gui.setVisible(true);
    }
}
