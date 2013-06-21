
package pemotegame;

import javax.swing.JFrame;

/**
 *
 * @author Adam Charlton
 */
public class GameWindow extends JFrame{
    private Game game;

    public GameWindow() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        setSize(800,600);
        
        setResizable(false);                
        setVisible(true);  
        
        game = new Game(getContentPane().getSize());
        
        setContentPane(game);        
        addKeyListener(game);
    }        
}
