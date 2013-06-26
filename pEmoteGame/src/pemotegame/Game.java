
package pemotegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Adam Charlton
 */
public class Game extends JPanel implements ActionListener{

    public static Player player;
    public static ArrayList<Poop> poops;
    public static ArrayList<Computer> pedestrian;
    public static SuperBirdiePoop superBirdiePoop;

    public boolean debug;
    public boolean alias;
    public boolean vsync;
    public boolean showBounds;
    public boolean showLines;

    public double ground;

    public int fps;

    private Timer timer;
    protected Rectangle currentPed;

    protected double w;
    protected double h;

    private int frames = 0;

    private long frameBeginTime;
    private long pedestrianSpawnTime;
    private long updateTime;
    private long sTime;

    public DrawHandler drawHandler;
    private Debug debugInfo;

    
    public Game(SuperBirdiePoop superBirdiePoop) {
        this.superBirdiePoop = superBirdiePoop;

        debugInfo = new Debug(this);
        drawHandler = new DrawHandler(this);

        updateTime = System.currentTimeMillis();
        frameBeginTime = System.currentTimeMillis();
        pedestrianSpawnTime = System.currentTimeMillis();



        ground = Constants.GROUND_HEIGHT;

        player = createPlayer();
        pedestrian = new ArrayList<>();
        poops = new ArrayList<>();

        ArrayList<Thread> threads = new ArrayList<>();

        //START MOVEMENT
        threads.add(new Thread(new Run(this, 1)));

        //START UPDATE
        threads.add(new Thread(new Run(new UpdateRectangles(this), Constants.TIMER_INTERVAL)));

        for(Thread thread: threads){
            //thread.setName("Thread:" + thread.getId());
            thread.start();
            //thread.setPriority(Thread.MAX_PRIORITY);
            //if (thread.isAlive()) System.out.println(thread.getName());

        }

        int height = (superBirdiePoop.getContentPane().getHeight() - Constants.GROUND_HEIGHT) - Constants.COMPUTER_HEIGHT;

        Point point = new Point(25, height);

        Dimension dimension = new Dimension(Constants.COMPUTER_WIDTH, Constants.COMPUTER_HEIGHT);
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
    private void paintComponent(Graphics2D g){
        //ORDER IMPORTANT !

        //APPLY ANTI-ALIASING
        if (alias) applyAntiAliasing(g);

        //SHOW DEBUG INFO
        if(debug)debugInfo.invoke(g);

        //PLAYER
        player.move();

        //PEDESTRIANS
        for (Computer comp : pedestrian) comp.move();

        //DRAW OBJECTS
        //new DrawHandler(g).invoke(this);
        drawHandler.invoke(g);

        //TRACK FRAMES PER SECOND
        if(debug)calculateFrameRate();

        //APPLY V-SYNC
        if(!vsync)super.repaint();
    }

    private void applyAntiAliasing(Graphics2D g) {
        // for anti-aliasing geometric shapes
        g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON );
        // for anti-aliasing text
        g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        // to go for quality over speed
        g.setRenderingHint( RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY );
    }
    private void calculateFrameRate() {
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

    public Player createPlayer() {
        return new Player(new Rectangle(Constants.PLAYER_START_X,
                Constants.PLAYER_START_Y,
                Constants.PLAYER_WIDTH,
                Constants.PLAYER_HEIGHT), this);
    }
    public Computer createComputer(){
        return new Computer(currentPed, this);
    }
    public Poop createPoop(){
        Point point = new Point((int) player.center.getX(),(int) player.center.getY());
        Dimension dimension = new Dimension(Constants.POOP_WIDTH, Constants.POOP_HEIGHT);
        return new Poop(new Rectangle(point, dimension), this);
    }

     int count = 1;


    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getWhen() - pedestrianSpawnTime % 1000);
        if (e.getWhen() - pedestrianSpawnTime > 1000 * count){
            System.out.println(count);
            count++;
        }

        //SPAWN PEDESTRIANS
        if(e.getWhen() - pedestrianSpawnTime > 60000) {
            count = 1;
            pedestrian.add(createComputer());
            pedestrianSpawnTime = e.getWhen();
        }


//        //PLAYER
//        player.move();
//
//        //PEDESTRIANS
//        for (Computer comp : pedestrian) comp.move();

        //PEDESTRIANS
        for (Computer comp : pedestrian) comp.changeDirection();

        //PEDESTRIANS HIT
        //for (int i = 0; i < pedestrian.size(); i++) if (pedestrian.get(i).crap) pedestrian.remove(i);

        //RESET TIME
//        updateTime = e.getWhen();

        //MOVE OBJECTS ON SCREEN
//        if (e.getWhen() - updateTime > Constants.UPDATE_INTERVAL) {
//            //PLAYER
//            player.move();
//
//            //PEDESTRIANS
//            for (Computer comp : pedestrian) comp.update(player, poops);
//
//            //PEDESTRIANS HIT
//            //for (int i = 0; i < pedestrian.size(); i++) if (pedestrian.get(i).crap) pedestrian.remove(i);
//
//            //RESET TIME
//            updateTime = e.getWhen();
//        }

        //TURN V-SYNC ON
        //if(vsync)super.repaint();

        //CATCHUP TIME
//        try {
//            e.wait(10);
//        } catch (Exception ex) {}
    }
}
