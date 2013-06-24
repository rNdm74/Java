
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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Adam Charlton
 */
public class Game extends JPanel 
implements ActionListener, KeyListener, MouseListener, MouseMotionListener, ComponentListener{
            
    public enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN,
        STATIONARY,
    }
    
    private Graphics doubleBufferedGraphics;
    private Image doubleBufferedImage;        
        
    public Player p;
    
    public static ArrayList<Poop> poops;
    public static ArrayList<Computer> c;
    
    private Direction d;
    
    private Timer t;
    
    private long beforeTime = System.currentTimeMillis();
    private long currentTime;
    
    private boolean north, south, east, west;
    
    public Game(Dimension size){ 
        
        c = new ArrayList<>();
        poops = new ArrayList<>();
        
        p = new Player(new Rectangle(size.width / 2, 50, 50, 50), this);
                
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
        //PLAYER
        p.draw(g);
        
        //POOP
        g.setColor(Color.DARK_GRAY);
        for (Iterator<Poop> it = poops.iterator(); it.hasNext();) {
            Poop poop = it.next();
            poop.draw(g);
        }
        
        // COMPUTER
        for (Iterator<Computer> it = c.iterator(); it.hasNext();) {
            Computer comp = it.next();
            comp.draw(g);
            if(comp.playerInBounds){
               g.drawLine(
                (int)p.center.getX(), 
                (int)p.center.getY(), 
                (int)comp.center.getX(), 
                (int)comp.center.getY()
                ); 
            }                       
        }
        
        //GROUND
        g.setColor(Color.ORANGE.darker());
        g.drawLine(0, getHeight() - 100, getWidth(), getHeight() - 100);          
                 
        g.dispose();        
        super.repaint();
    }
    
    //<editor-fold defaultstate="collapsed" desc=" COMPONENT ">
    @Override
    public void componentResized(ComponentEvent ce) {
        for (Iterator<Computer> it = c.iterator(); it.hasNext();) {
            Computer comp = it.next();
            comp.y = (getHeight() - 150);
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
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" MOUSE ">
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
    //</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc=" KEYBOARD ">
    @Override
    public void keyTyped(KeyEvent e) {    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE) {
            poops.add(createPoop());
        }
        
        if (key == KeyEvent.VK_C) {
            c.add(createComputer());
        }
        
        if (key == KeyEvent.VK_B) {
            poops.clear();
        }
        
        if (key == KeyEvent.VK_V) {
            if(!c.isEmpty())c.clear();
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
    //</editor-fold>
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        currentTime = System.currentTimeMillis();
        if (currentTime - beforeTime > 20) {
            //PLAYER
            p.bounds();        
            p.move(d);        
            p.update();
            
            //POOP
            for (Poop poop: poops) {
                poop.update();                
            }

            //COMPUTERS
            for(Computer comp: c){
                
                comp.bounds();
                comp.update(p, poops);
                comp.update(); 
            }
            
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).ohcrap) {
                    c.remove(i);
                }
            }
            
            beforeTime = System.currentTimeMillis();
            currentTime = 0;
        }
               
        //super.repaint();
    }
    private Computer createComputer(){
        return new Computer(new Rectangle(0, (getHeight() - 100) - 50, 25, 50), this);
    }
    private Poop createPoop(){
        Point point = new Point((int)p.center.getX(),(int)p.center.getY());
        Dimension dimension = new Dimension(5, 5);
        
        return new Poop(new Rectangle(point, dimension), this);
    }  
    
    
    
    
}
