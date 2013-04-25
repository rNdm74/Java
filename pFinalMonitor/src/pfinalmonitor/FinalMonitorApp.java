
package pfinalmonitor;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author rNdm
 */
public class FinalMonitorApp {

    private static final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static final int desktopWidth = gd.getDisplayMode().getWidth();
    private static final int desktopheight = gd.getDisplayMode().getHeight();
    
    public static final Dimension size = new Dimension(desktopWidth, desktopheight);
    
    public static void main(String[] args) {        
        new Main(size);
    }
}
