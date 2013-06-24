

package pemotegame;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author Adam Charlton
 */
public class EmoteGameApp {

    private static final GraphicsDevice GD = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static final int WIDTH = GD.getDisplayMode().getWidth();
    private static final int HEIGHT = GD.getDisplayMode().getHeight();
    
    protected static final Dimension RES = new Dimension(WIDTH, HEIGHT);

    public static void main(String[] args) {
        new SuperBirdiePoop();
    }
}
