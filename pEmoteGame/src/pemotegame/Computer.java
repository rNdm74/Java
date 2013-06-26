
package pemotegame;

import java.awt.*;
import java.util.ArrayList;

import static pemotegame.Game.poops;

class Computer extends Character {
    public float speedX = Constants.SPEED;
    
    public boolean playerInBounds;
    
    private final ArrayList<Boolean> hitPoop;

    public boolean crap;

    private long directionTrigger;
    private long waitTrigger;
    private long poopTrigger;

    protected String talk = "";

    public Computer(Rectangle rect, Game game) {
        super(rect, game);
        hitPoop = new ArrayList<>();
    }
    
    public synchronized void draw(Graphics2D g){
        //BOUNDS
        if(game.showBounds){
            g.setColor(Color.CYAN.darker());
            if(playerInBounds)g.setColor(Color.PINK.darker());
            g.draw(bounds);
        }

        //CLIPPING
        g.setColor(Color.GREEN.darker());
        g.draw(clipping);

        //TALK
        if(!talk.isEmpty()) new SpeechBubble(clipping, talk, g, center);
    }

    public synchronized void update(Player p, ArrayList<Poop> poops){
        talk = "";
        updateBounds();
        computerWait();
        computerClippingCheck(poops);
        computerBoundsCheck(p);
        randomizeDirection();
        screenBoundsCheck();
        groundPoop();
        poopCheck();
        move();       
    }

    private synchronized void updateBounds() {
        bounds.setFrame(
                clipping.getCenterX() - (Constants.DEFAULT_CLIPPING_SIZE/2),
                (clipping.getY() + height) - (game.getHeight() - Constants.GROUND_HEIGHT),
                Constants.DEFAULT_CLIPPING_SIZE,
                game.getHeight() - Constants.GROUND_HEIGHT);
    }

    private synchronized void screenBoundsCheck() {
        if (clipping.getX() < 1) speedX *= Constants.DIRECTION;
        
        if ((clipping.getX() + Constants.PEDESTRIAN_WIDTH) > game.getBounds().width) speedX *= Constants.DIRECTION;
    }

    private synchronized void computerClippingCheck(ArrayList<Poop> poops) {
        hitPoop.clear();
        for (Poop poop: poops) hitPoop.add(clipping.contains(poop.center));
    }
    
    
    
    private synchronized void computerBoundsCheck(Player p) {
        if(bounds.contains(p.center)){            
            playerInBounds = true;
            talk = "PRETTY BIRDIE!";
        }
        else{
            playerInBounds = false;
        }
    }



    private synchronized void poopCheck(){
        for (Poop poop: poops) if (top.intersects(poop.clipping)) poopTrigger = System.currentTimeMillis();

        if (poopTrigger > 0) {
            talk ="OH CRAP!";
            if(new Sleep(this).start(Constants.POOP_DELAY, poopTrigger)){
                poopTrigger = 0;
                crap = true;
            }            
        }
    }
    
    private synchronized void randomizeDirection() {
        directionTrigger = new Sleep(this).invoke("I WANNA GO THIS WAY!", directionTrigger, Constants.MAXIMUM);
    }

    private synchronized void computerWait(){
        waitTrigger = new Sleep(this).invoke("WHAT A LOVELY DAY!", waitTrigger, Constants.MAXIMUM);
    }


    private synchronized void move() {
        x += speedX;        
    }

    private synchronized void groundPoop() {
        for(boolean hp: hitPoop) if(hp)talk = "THERE IS POOP ON THE GROUND!";
    }
}
