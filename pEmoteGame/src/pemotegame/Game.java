
package pemotegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Adam Charlton
 */
public class Game extends JPanel 
    implements ActionListener, KeyListener, MouseListener, MouseMotionListener, ComponentListener{
            


    private final Player player;
    public static ArrayList<Poop> poops;
    private static ArrayList<Computer> pedestrian;
    private int fps;
    private int frames = 0;
    private long frameBeginTime;
    private long beforeTime;
    
    public Game(Dimension size){ 
        
        pedestrian = new ArrayList<>();
        poops = new ArrayList<>();
        
        player = new Player(new Rectangle(size.width / 2, 50, 50, 50), this);

        Timer t = new Timer(Constants.TIMER_INTERVAL, this);
        
        t.start();

        frameBeginTime = System.currentTimeMillis();
        beforeTime = System.currentTimeMillis();
    }
    
    @Override
    public void paint(Graphics g){

        super.paint(g);

        Image doubleBufferedImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferedGraphics = doubleBufferedImage.getGraphics();
        
        paintComponent((Graphics2D) doubleBufferedGraphics);
        
        g.drawImage(doubleBufferedImage, 0,0,null);

    }

    long sTime;
    private void paintComponent(Graphics2D g){
        String s = "FPS: " + String.valueOf(fps);
        new SpeechBubble(new Rectangle(50, 100, 50, 50), s, g, new Point(100,0));

        //PLAYER
        player.draw(g);
        
        //POOP
        g.setColor(Color.DARK_GRAY);
        for (Poop poop : poops) {
            poop.draw(g);
        }
        
        // COMPUTER
        for (Computer comp : pedestrian) {
            comp.draw(g);
            if (comp.playerInBounds) {
                g.drawLine(
                        (int) player.center.getX(),
                        (int) player.center.getY(),
                        (int) comp.center.getX(),
                        (int) comp.center.getY()
                );
            }
        }
        
        //GROUND
        g.setColor(Color.ORANGE.darker());
        g.drawLine(0, getHeight() - 100, getWidth(), getHeight() - 100);          
                 
        g.dispose();        
        super.repaint();

        long eTime = System.currentTimeMillis() - frameBeginTime;

        if (eTime < 1000){
            frames++;
        }
        else {
            fps = frames;
            frames = 0;
            frameBeginTime = System.currentTimeMillis();
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc=" COMPONENT ">
    @Override
    public void componentResized(ComponentEvent ce) {
        for (Computer comp : pedestrian) comp.y = (getHeight() - 150);
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
        player.p.setLocation(p2d.getX() - 8, p2d.getY() - 30);
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
    }
    @Override
    public void mouseMoved(MouseEvent me) {
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
            pedestrian.add(createComputer());
        }
        
        if (key == KeyEvent.VK_B) {
            poops.clear();
        }
        
        if (key == KeyEvent.VK_V) {
            if(!pedestrian.isEmpty()) pedestrian.clear();
        }

        e.consume();
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    //</editor-fold>
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - beforeTime > Constants.UPDATE_INTERVAL) {
            //PLAYER
            player.bounds();
            player.move();
            player.update();
            
            //POOP
            for (Poop poop: poops) {
                poop.update();                
            }

            //COMPUTERS
            for(Computer comp: pedestrian){
                comp.bounds();
                comp.update(player, poops);
                comp.update(); 
            }
            
            for (int i = 0; i < pedestrian.size(); i++) {
                if (pedestrian.get(i).crap) {
                    pedestrian.remove(i);
                }
            }
            
            beforeTime = System.currentTimeMillis();
        }
               
        //super.repaint();
    }
    private Computer createComputer(){
        Point point = new Point(0, (getHeight() - Constants.GROUND_HEIGHT) - Constants.PEDESTRIAN_HEIGHT);
        Dimension dimension = new Dimension(Constants.PEDESTRIAN_WIDTH, Constants.PEDESTRIAN_HEIGHT);
        return new Computer(new Rectangle(point, dimension), this);
    }
    private Poop createPoop(){
        Point point = new Point((int) player.center.getX(),(int) player.center.getY());
        Dimension dimension = new Dimension(Constants.POOP_WIDTH, Constants.POOP_HEIGHT);
        return new Poop(new Rectangle(point, dimension), this);
    }  
    
    
    
    
}
