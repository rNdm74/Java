
package pfinalmonitor;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

/**
 *
 * @author rNdm
 */
public class FinalMonitorApp {
    private static final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static final int desktopWidth = gd.getDisplayMode().getWidth();
    private static final int desktopHeight = gd.getDisplayMode().getHeight();
    
    protected static final Dimension size = new Dimension(desktopWidth, desktopHeight);
    
    protected static Main monitor;
    
    public static void main(String[] args) throws IOException {        

        monitor = new Main();
    }
}
