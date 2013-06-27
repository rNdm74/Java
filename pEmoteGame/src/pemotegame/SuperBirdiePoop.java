
package pemotegame;

import pemotegame.HandlerClasses.ComponentHandler;
import pemotegame.HandlerClasses.KeyHandler;
import pemotegame.HandlerClasses.MouseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Adam Charlton
 */
public class SuperBirdiePoop extends JFrame {
    private final Dimension size = new Dimension(Constants.DEFAULT_SCREEN_X_SIZE, Constants.DEFAULT_SCREEN_Y_SIZE);
    private final Game game = new Game(this);

    public SuperBirdiePoop() {
        //HIDE CURSOR
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point hotSpot = new Point(0,0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");
        URL url = this.getClass().getResource("Empty.png");
        Image img = Toolkit.getDefaultToolkit().getImage(url);


        //ORGANIZE DISPLAY RESOLUTIONS
        ResCompare resCompare = new ResCompare();
        Arrays.sort(Constants.DEFAULT_RESOLUTIONS, resCompare);

        for (int i = 0; i < Constants.DEFAULT_RESOLUTIONS.length - 1; i++){
            if ((Constants.DEFAULT_RESOLUTIONS[i].getWidth() != Constants.DEFAULT_RESOLUTIONS[i+1].getWidth() &&
                 Constants.DEFAULT_RESOLUTIONS[i].getHeight() != Constants.DEFAULT_RESOLUTIONS[i+1].getHeight())){
                 Constants.AVAILABLE_RESOLUTIONS.add(Constants.DEFAULT_RESOLUTIONS[i + 1]);
            }
        }

        //INITIALIZE FRAME
        setBackground(Color.BLACK);
        setContentPane(game);
        setCursor(invisibleCursor);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setMinimumSize(size);
        setSize(size);
        setLocation(Constants.SCREEN_WIDTH/2 - getWidth()/2, Constants.SCREEN_HEIGHT/2 - getHeight()/2);

        setIconImage(img);
        setTitle("SUPER BIRDIE POOP");
        setResizable(false);

        setVisible(Constants.DEFAULT_VISIBILITY);

        //ADD LISTENERS
        addKeyListener(new KeyHandler(game));
        addMouseListener(new MouseHandler(game));
        addMouseMotionListener(new MouseHandler(game));
        addComponentListener(new ComponentHandler(game));
    }
}
