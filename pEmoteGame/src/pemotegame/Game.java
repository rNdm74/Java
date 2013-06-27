
package pemotegame;

import pemotegame.HandlerClasses.DrawHandler;

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

    public SuperBirdiePoop superBirdiePoop;

    public boolean debug;
    public boolean alias;
    public boolean vsync;
    public boolean showBounds;
    public boolean showLines;

    public static float ground;

    public int fps;

    public float w;
    public float h;

    private int frames = 0;

    private long frameBeginTime;
    private long birdSpawnTime;

    public DrawHandler drawHandler;
    private Debug debugInfo;

    public World world;
    public Hero hero;
    public ArrayList<Bird> birds;
    
    public Game(SuperBirdiePoop superBirdiePoop) {
        this.superBirdiePoop = superBirdiePoop;

        debugInfo = new Debug(this);
        drawHandler = new DrawHandler(this);

        Vector2 location = new Vector2(superBirdiePoop.getWidth()/2,superBirdiePoop.getHeight()/2);
        Dimension size = new Dimension(Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);

        hero = new Hero(location, size, this);
        birds = new ArrayList<>();
        birds.add(new Bird(location, size, this));
        birds.add(new Bird(location, size, this));

        world = new World();
        world.entities.add(hero);

        for(Bird bird: birds) world.entities.add(bird);

        ground = Constants.GROUND_HEIGHT;

        ArrayList<Thread> threads = new ArrayList<>();

        //START MOVEMENT
        threads.add(new Thread(new Run(this, Constants.TIMER_INTERVAL)));
        threads.get(0).setPriority(Thread.MAX_PRIORITY);
        threads.get(0).run();
    }



    @Override
    public void paint(Graphics g){
        super.paint(g);

        Image doubleBufferedImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferedGraphics = doubleBufferedImage.getGraphics();
        
        paintComponent((Graphics2D) doubleBufferedGraphics);
        
        g.drawImage(doubleBufferedImage, 0, 0, this);

        g.dispose();
    }
    private synchronized void paintComponent(Graphics2D g){
        //ORDER IMPORTANT !

        //APPLY ANTI-ALIASING
        if (alias) applyAntiAliasing(g);

        //SHOW DEBUG INFO
        if(debug)debugInfo.invoke(g);

        //DRAW OBJECTS
        drawHandler.invoke(g);

        //TRACK FRAMES PER SECOND
        if(debug)calculateFrameRate();
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
    public Poop createPoop(){
        return null;
        //Point point = new Point((int) player.center.getX(),(int) player.center.getY());
        //Dimension dimension = new Dimension(Constants.POOP_WIDTH, Constants.POOP_HEIGHT);
        //return new Poop(new Rectangle(point, dimension), this);
    }

    int count = 1;

    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        if (e.getWhen() - birdSpawnTime > 1000 * count){
            count++;
        }

        //SPAWN PEDESTRIANS
        if(e.getWhen() - birdSpawnTime > 60000) {
            count = 1;
            //bird.add(createComputer());
            birdSpawnTime = e.getWhen();
        }

        //ENTITY START JUMP
        hero.jump();
        for (Bird bird: birds) bird.sleep();
        for (Bird bird: birds) bird.direction();

        //COLLISION GROUND
        hero.collision();
        for (Bird bird: birds) bird.collision();

        //MOVE
        hero.move();
        for (Bird bird: birds) bird.move();

        //UPDATE WORLD ENTITIES
        world.update(0.2f);

        //TURN V-SYNC ON
        super.repaint();

        //CATCHUP TIME
        try {

            //e.wait(10);
        } catch (Exception ex) {}
    }
}
