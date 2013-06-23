
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
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adam Charlton
 */
public class Game extends JPanel 
implements ActionListener, KeyListener, MouseListener, MouseMotionListener, ComponentListener{

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

    @Override
    public void mouseDragged(MouseEvent me) {
//        Point2D p2d = me.getPoint();
//        p.p.setLocation(p2d.getX() - 8, p2d.getY() - 30);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
//        Point2D p2d = me.getPoint();
//        p.p.setLocation(p2d.getX() - 8, p2d.getY() - 30);
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
    
    private ArrayList<Poop> poops;
    private ArrayList<Computer> c;
    
    private Direction d;
    
    private Timer t;
    
    private Dimension size;
    
    private boolean north, south, east, west;
    
    public Game(Dimension size){   
        this.size = size;
        
        
        c = new ArrayList<>();
        poops = new ArrayList<>();
        
        p = new Player(size.width / 2, size.height / 2, 50, 50);
        p.r = new Rectangle(0, 0, size.width, size.height);
        
        for (int i = 0; i < 1; i++) {
            c.add(new Computer(
                    new Random().nextInt(size.width),
                    new Random().nextInt(size.height), 
                    25, 
                    50
            ));
            
            c.get(i).r = new Rectangle(0, 0, size.width, size.height);
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
    
    long beforeTime = System.currentTimeMillis();
    long currentTime;
    
    private void paintComponent(Graphics2D g){
        //PLAYER
        p.draw(g);
        
        
        
        //COMPUTER
        for(Computer comp: c){
            comp.draw(g);
            
            //LINES
            if(comp.playerInBounds){
               g.drawLine(
                (int)p.center.getX(), 
                (int)p.center.getY(), 
                (int)comp.center.getX(), 
                (int)comp.center.getY()
                ); 
            }                       
        }
        
        g.setColor(Color.DARK_GRAY);
        //POOP
        for(Poop poop: poops){
            poop.draw(g);
        }
        
        //GROUND
        g.setColor(Color.GREEN.darker());
        g.drawLine(0, getHeight() - 100, getWidth(), getHeight() - 100);           
                 
        g.dispose();        
    }
    
    @Override
    public void componentResized(ComponentEvent ce) {
        size = getSize();
        p.r = new Rectangle(0, 0, size.width, size.height);
        for (int i = 0; i < c.size(); i++) {            
            c.get(i).r = new Rectangle(0, 0, size.width, size.height);
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
        currentTime = System.currentTimeMillis();
        //System.out.println(currentTime - beforeTime);
        long moveTime = currentTime - beforeTime;
        
        if (moveTime > 15) {
            //PLAYER
            p.bounds();        
            p.move(d);        
            p.update();
            
            //POOP
            for (Poop poop: poops) {
                poop.update(getSize());
                //poop.y++;
                
            }

            //COMPUTERS
            for(Computer comp: c){
                comp.bounds();
                comp.update(p, poops);
                comp.update(getSize());        
            }
            
            beforeTime = System.currentTimeMillis();
            currentTime = 0;
        }
               
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE) {
            poops.add(new Poop(
                    (float)p.center.getX(), 
                    (float)p.center.getY(), 
                    5f, 
                    5f
            ));
        }
        
        if (key == KeyEvent.VK_C) {
            c.add(new Computer(
                    new Random().nextInt(size.width),
                    new Random().nextInt(size.height), 
                    25, 
                    50
            ));
            
            c.get(c.size()-1).r = new Rectangle(0, 0, size.width, size.height);
        }
        
        if (key == KeyEvent.VK_B) {
            poops.clear();
        }
        
        if (key == KeyEvent.VK_V) {
            if(!c.isEmpty())c.remove(0);
        }
        
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
