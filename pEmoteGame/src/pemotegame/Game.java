
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

    static boolean debug;
    static boolean alias;
    static boolean vsync;
    static boolean showBounds;
    static boolean showLines;

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
        if (alias) Aliasing(g);
        if(debug)new Debug(g).invoke();


        g.setColor(Color.BLACK);
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
                if(showLines)
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

        if(!vsync)super.repaint();

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

    private void Aliasing(Graphics2D g) {
        // for antialiasing geometric shapes
        g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON );
        // for antialiasing text
        g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        // to go for quality over speed
        g.setRenderingHint( RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY );
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

        if (key == KeyEvent.VK_BACK_QUOTE) {
            debug = !debug;
        }

        if (key == KeyEvent.VK_F1) {
            alias = !alias;
        }

        if (key == KeyEvent.VK_F2) {
            vsync = !vsync;
            super.repaint();
        }

        if (key == KeyEvent.VK_F4) {
            showBounds = !showBounds;
        }

        if (key == KeyEvent.VK_F3) {
            showLines = !showLines;
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
        //System.out.println(e.getWhen());

        long gameTime = e.getWhen() - gameStartTime;
        if(gameTime > 10000) {
            pedestrian.add(createComputer());
            gameStartTime = e.getWhen();
        }

        long currentTime = e.getWhen();
        if (currentTime - beforeTime > Constants.UPDATE_INTERVAL) {
            //PLAYER
            player.bounds();
            player.move();
            player.update();
            
            //POOP
            for (Poop poop: poops) {
                poop.update();                
            }

            //PEDESTRIANS
            for(Computer comp: pedestrian){
                comp.bounds();
                comp.update(player, poops);
                comp.update(); 
            }

            //PEDESTRIANS HIT
            for (int i = 0; i < pedestrian.size(); i++) {
                if (pedestrian.get(i).crap) {
                    pedestrian.remove(i);
                }
            }
            
            beforeTime = e.getWhen();
        }
               
        if(vsync)super.repaint();

        try {
            e.wait(10);
        } catch (Exception e1) {}
    }
    private Computer createComputer(){
        return new Computer(currentPed, this);
    }

    private Poop createPoop(){
        Point point = new Point((int) player.center.getX(),(int) player.center.getY());
        Dimension dimension = new Dimension(Constants.POOP_WIDTH, Constants.POOP_HEIGHT);
        return new Poop(new Rectangle(point, dimension), this);
    }


    private class Debug {
        private Graphics2D g;

        public Debug(Graphics2D g) {
            this.g = g;
        }

        public void invoke() {
            //new SpeechBubble(new Rectangle(50, 100, 50, 50), s, g, new Point(100,0));
            g.setColor(Color.RED.darker());
            //g.drawString("DEBUG", 20, 20);
            g.drawString("PEDESTRIANS", 20, 20);
            g.drawString(String.valueOf(pedestrian.size()), 150, 20);

            g.drawString("FPS", 20, 50);
            g.drawString(String.valueOf(fps), 150, 50);

            g.drawString("X", 20, 100);
            g.drawString(String.valueOf(player.center.getX()), 150, 100);

            g.drawString("Y", 20, 125);
            g.drawString(String.valueOf(player.center.getY()), 150, 125);

            g.drawString("F4 - BOUNDS", 20, 175);
            g.drawString((showBounds) ? "ON" : "OFF", 150, 175);

            g.drawString("F3 - LINES", 20, 200);
            g.drawString((showLines) ? "ON" : "OFF", 150, 200);

            g.drawString("F2 - VSYNC", 20, 225);
            g.drawString((vsync) ? "ON" : "OFF", 150, 225);

            g.drawString("F1 - ALIAS", 20, 250);
            g.drawString((alias) ? "ON" : "OFF", 150, 250);
        }
    }
}
