
package pemotegame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 *
 * @author Adam Charlton
 */
public class Game extends JPanel implements ActionListener, KeyListener, MouseListener,ComponentListener{

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Point2D p2d = me.getPoint();
        p.p.setLocation(p2d.getX() - 8, p2d.getY() - 30);
        //System.out.println(me.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
        
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
    
    private Dimension size;
    
    private boolean north, south, east, west;
    
    public Game(Dimension size){   
        this.size = size;
        
        c = new Computer[10];
        
        p = new Player(size.width / 2, size.height / 2, 50, 50);
        p.r = new Rectangle(0, 0, size.width, size.height);
        
        for (int i = 0; i < c.length; i++) {
            c[i] = new Computer(
                    new Random().nextInt(size.width),
                    new Random().nextInt(size.height), 
                    25, 
                    25
            );
            
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
    public void componentResized(ComponentEvent ce) {
        size = getSize();
        p.r = new Rectangle(0, 0, size.width, size.height);
        for (int i = 0; i < c.length; i++) {            
            c[i].r = new Rectangle(0, 0, size.width, size.height);
        }
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
        
    }

    @Override
    public void componentShown(ComponentEvent ce) {
        
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        
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
