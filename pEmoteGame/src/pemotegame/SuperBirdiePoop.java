
package pemotegame;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Character;

/**
 *
 * @author Adam Charlton
 */
public class SuperBirdiePoop extends JFrame {

    public SuperBirdiePoop() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Dimension size = new Dimension(Constants.DEFAULT_SCREEN_X_SIZE, Constants.DEFAULT_SCREEN_Y_SIZE);
        setResizable(false);
        setSize(size);
        setMinimumSize(size);
        setLocation(Constants.SCREEN_WIDTH/2 - getWidth()/2, Constants.SCREEN_HEIGHT/2 - getHeight()/2);
        setVisible(Constants.DEFAULT_VISIBILITY);

        Game game = new Game(this);
        
        setContentPane(game);        
        addKeyListener(game);
        addMouseListener(game);
        addMouseMotionListener(game);
        addComponentListener(game);
    }        
}
