
package pemotegame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Adam Charlton
 */
public class Game extends JPanel implements ActionListener, KeyListener{
    
    public enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN,
        STATIONARY,
    }
    
    private Graphics doubleBufferedGraphics;
    private Image doubleBufferedImage;        
        
    private Player p;
    
    private Computer[] c;
    
    private Direction d;
    
    private Timer t;
    
    
    private boolean north, south, east, west;
    
    public Game(Dimension size){    
        c = new Computer[5];
        
        p = new Player(size.width / 2, size.height / 2, 50, 50);
        p.r = new Rectangle(0, 0, size.width, size.height);
        
        for (int i = 0; i < c.length; i++) {
            c[i] = new Computer(50 * i, 150, 50, 50);
            c[i].r = new Rectangle(0, 0, size.width, size.height);
        }
                
        d = Direction.STATIONARY;
        
        t = new Timer(10, this);
        
        t.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        doubleBufferedImage = createImage(getWidth(), getHeight());
        doubleBufferedGraphics = doubleBufferedImage.getGraphics();
        
        paintComponent((Graphics2D)doubleBufferedGraphics);
        
        g.drawImage(doubleBufferedImage, 0,0,null);
    }
    
    private void paintComponent(Graphics2D g){
        p.draw(g);
        
        for(Computer comp: c){
            comp.draw(g);
            g.drawLine(
                (int)p.center.getX(), 
                (int)p.center.getY(), 
                (int)comp.center.getX(), 
                (int)comp.center.getY()
            );           
        }
                 
        g.dispose();        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //PLAYER
        p.bounds();        
        p.move(d);        
        p.update();
        
        //COMPUTERS
        for(Computer comp: c){
            comp.bounds();
            comp.move(p);
            comp.update();        
        }
                
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_A && !west) {
            east = false;
            d = Direction.LEFT;
        }else if(key == KeyEvent.VK_D && !east){
            west = false;            
            d = Direction.RIGHT;
        }else if(key == KeyEvent.VK_W && !north){
            d = Direction.UP;
        }else if(key == KeyEvent.VK_S && !south){
            d = Direction.DOWN;
        }
        
        e.consume();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_A) {
            d = Direction.STATIONARY;
        }else if(key == KeyEvent.VK_D){
            d = Direction.STATIONARY;
        }else if(key == KeyEvent.VK_W){
            d = Direction.STATIONARY;
        }else if(key == KeyEvent.VK_S){
            d = Direction.STATIONARY;
        }  
        
        e.consume();
    }
}
