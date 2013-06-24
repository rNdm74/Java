
package pemotegame;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Adam Charlton
 */
public class SuperBirdiePoop extends JFrame {
    private Game game;

    public SuperBirdiePoop(Dimension d) {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        setSize(800,600);
        setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);
        setName("SuperBirdiePoop");
        //setResizable(false);                
        setVisible(true);  
        
        game = new Game(getContentPane().getSize());
        
        setContentPane(game);        
        addKeyListener(game);
        addMouseListener(game);
        addMouseMotionListener(game);
        addComponentListener(game);
    }        
}
