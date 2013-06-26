
package pemotegame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.*;
import java.lang.Character;

/**
 *
 * @author Adam Charlton
 */
public class SuperBirdiePoop extends JFrame {

    public SuperBirdiePoop() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point hotSpot = new Point(0,0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");
        setCursor(invisibleCursor);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Dimension size = new Dimension(Constants.DEFAULT_SCREEN_X_SIZE, Constants.DEFAULT_SCREEN_Y_SIZE);
        setResizable(false);
        setSize(size);
        setMinimumSize(size);
        setLocation(Constants.SCREEN_WIDTH/2 - getWidth()/2, Constants.SCREEN_HEIGHT/2 - getHeight()/2);
        setVisible(Constants.DEFAULT_VISIBILITY);
        setBackground(Color.BLACK);
        Game game = new Game(this);
        
        setContentPane(game);

        addKeyListener(new KeyHandler(game));
        addMouseListener(new MouseHandler(game));
        addMouseMotionListener(new MouseHandler(game));
        addComponentListener(new ComponentHandler(game));
    }        
}
