
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

    double w;
    double h;
    Timer t;
    Rectangle currentPed;
    private double ground;
    private final Player player;
    public static ArrayList<Poop> poops;
    private static ArrayList<Computer> pedestrian;
    private int fps;
    private int frames = 0;
    private long frameBeginTime;
    private long gameStartTime;
    private long beforeTime;
    private SuperBirdiePoop superBirdiePoop;
    
    public Game(SuperBirdiePoop superBirdiePoop){
        this.superBirdiePoop = superBirdiePoop;
        gameStartTime = System.currentTimeMillis();



        pedestrian = new ArrayList<>();
        poops = new ArrayList<>();
        
        player = new Player(new Rectangle(Constants.DEFAULT_SCREEN_X_SIZE / 2, 50,
                                          Constants.DEFAULT_SCREEN_X_SIZE / 16, Constants.DEFAULT_SCREEN_Y_SIZE / 12), this);

        t = new Timer(Constants.TIMER_INTERVAL, this);
        t.start();

        ground = Constants.GROUND_HEIGHT;

        frameBeginTime = System.currentTimeMillis();
        beforeTime = System.currentTimeMillis();

        Point point = new Point(0, (superBirdiePoop.getContentPane().getHeight() - Constants.GROUND_HEIGHT) - Constants.PEDESTRIAN_HEIGHT);
        Dimension dimension = new Dimension(Constants.PEDESTRIAN_WIDTH, Constants.PEDESTRIAN_HEIGHT);
        currentPed = new Rectangle(point,dimension);
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
        g.drawLine(0, getHeight() - (int)ground, getWidth(), getHeight() - (int)ground);
                 
        g.dispose();        
        //super.repaint();

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
        w = superBirdiePoop.getWidth();
        h = superBirdiePoop.getHeight();

        double scale = (h / Constants.DEFAULT_SCREEN_Y_SIZE);

        player.width = Constants.PLAYER_WIDTH * scale;
        player.height = Constants.PLAYER_HEIGHT * scale;

        ground = (100 * scale);



        for (Computer ped : pedestrian){

            ped.width = 25 * scale;
            ped.height = 50 * scale;
            ped.y = (getHeight() - ped.height - ground);

            currentPed = new Rectangle(0, (int)ped.y, (int)ped.width, (int)ped.height);
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

    int choice = 1;
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

        if (key == KeyEvent.VK_ADD) {
            if(choice < 4)choice++;
            superBirdiePoop.setSize(changeResolution(choice));
            superBirdiePoop.setLocation(Constants.SCREEN_WIDTH/2 - (int)changeResolution(choice).getWidth()/2,
                                        Constants.SCREEN_HEIGHT/2 - (int)changeResolution(choice).getHeight()/2);
            superBirdiePoop.revalidate();
        }

        if (key == KeyEvent.VK_SUBTRACT) {
            if(choice > 1)choice--;
            superBirdiePoop.setSize(changeResolution(choice));
            superBirdiePoop.setLocation(Constants.SCREEN_WIDTH / 2 - (int) changeResolution(choice).getWidth() / 2,
                    Constants.SCREEN_HEIGHT / 2 - (int) changeResolution(choice).getHeight() / 2);
            superBirdiePoop.revalidate();
        }

        e.consume();
    }

    private Dimension changeResolution(int choice){
        switch (choice){
            case 1:
                return new Dimension(800,600);
            case 2:
                return new Dimension(1024,768);
            case 3:
                return new Dimension(1366,768);
            case 4:
                return new Dimension(1920,1080);
            default:
                return new Dimension(640,480);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    //</editor-fold>
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        long gameTime = System.currentTimeMillis() - gameStartTime;
        if(gameTime > 10000) {
            System.out.println(gameTime);
            pedestrian.add(createComputer());
            gameStartTime = System.currentTimeMillis();
        }


        //if((System.currentTimeMillis() - gameStartTime) % 500 == 0) pedestrian.add(createComputer());

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
               
        super.repaint();
    }
    private Computer createComputer(){
        return new Computer(currentPed, this);
    }

    private Poop createPoop(){
        Point point = new Point((int) player.center.getX(),(int) player.center.getY());
        Dimension dimension = new Dimension(Constants.POOP_WIDTH, Constants.POOP_HEIGHT);
        return new Poop(new Rectangle(point, dimension), this);
    }  
    
    
    
    
}
