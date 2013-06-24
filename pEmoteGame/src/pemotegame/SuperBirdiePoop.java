
package pemotegame;

import javax.swing.*;

/**
 *
 * @author Adam Charlton
 */
public class SuperBirdiePoop extends JFrame {

    public SuperBirdiePoop() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        setSize(800,600);
        setLocation(EmoteGameApp.RES.width/2 - getWidth()/2, EmoteGameApp.RES.height/2 - getHeight()/2);
        setName("SuperBirdiePoop");
        //setResizable(false);                
        setVisible(true);

        Game game = new Game(getContentPane().getSize());
        
        setContentPane(game);        
        addKeyListener(game);
        addMouseListener(game);
        addMouseMotionListener(game);
        addComponentListener(game);
    }        
}
