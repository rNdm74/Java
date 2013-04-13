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
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        Task t = new Task(UI.jLabel1, UI.y1);
        Task t1 = new Task(UI.jLabel2, UI.y2);
        Task t2 = new Task(UI.jLabel3, UI.y3);
        Task t3 = new Task(UI.jLabel4, UI.y4);
        
        timer.schedule(t, 0, 1000);
        timer.schedule(t1, 0, 1000);
        timer.schedule(t2, 0, 1000);
        timer.schedule(t3, 0, 1000);
        
        gui.setLocation(width / 2 - gui.getWidth() / 2, height / 2 - gui.getHeight() / 2);
        gui.setVisible(true);
    }
}
