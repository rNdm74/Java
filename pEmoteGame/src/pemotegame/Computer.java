
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

    private String talk = "";
    
    

    public Computer(Rectangle rect, Game game) {
        super(rect, game);
        
        hitPoop = new ArrayList<>();
    }
    
    public void draw(Graphics2D g){
        //BOUNDS
        //g.setColor(Color.CYAN.darker());
        //if(playerInBounds)g.setColor(Color.PINK.darker());
        //g.draw(bounds);
        
        //CLIPPING

        g.draw(clipping);
        g.setColor(Color.GREEN.darker());
        g.fill(clipping);
        
        //TALK
        if(!talk.isEmpty()){
            new SpeechBubble(clipping, talk, g, this);
        }
    }

    public void update(Player p, ArrayList<Poop> poops){
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

    private void updateBounds() {
        bounds.setFrame(
                clipping.getCenterX() - Constants.GROUND_HEIGHT/2,
                (clipping.getY() + height) - (game.getHeight() - Constants.GROUND_HEIGHT),
                Constants.DEFAULT_CLIPPING_SIZE,
                game.getHeight() - Constants.GROUND_HEIGHT);
    }

    private void screenBoundsCheck() {        
        if (clipping.getX() < 1) {
            speedX *= Constants.DIRECTION;
        } 
        
        if ((clipping.getX() + Constants.PEDESTRIAN_WIDTH) > game.getBounds().width) {
            speedX *= Constants.DIRECTION;
        }       
    }

    private void computerClippingCheck(ArrayList<Poop> poops) {
        hitPoop.clear();
        for (Poop poop: poops) hitPoop.add(clipping.contains(poop.center));
    }
    
    
    
    private void computerBoundsCheck(Player p) {
        if(bounds.contains(p.center)){            
            playerInBounds = true;
            talk = "PRETTY BIRDIE!";
            
//            if (p.center.getX() < center.getX()) {
//                //speedX *= -speedX;
//            }
//
//            if (p.center.getX() > center.getX()) {
//                //speedX *= speedX;
//            }
        }
        else{
            playerInBounds = false;
        }
    }


    
    void poopCheck(){
        for (Poop poop: poops) {
            if (top.intersects(poop.clipping)) {
                poopTrigger = System.currentTimeMillis();
            }
        }
                
        if (poopTrigger > 0) {
            talk ="OH CRAP!";
            if(new CompWait().start(Constants.POOP_DELAY, poopTrigger)){
                poopTrigger = 0;
                crap = true;
            }            
        }
    }
    
    private void randomizeDirection() {
        directionTrigger = new CompWait().invoke("I WANNA GO THIS WAY!", directionTrigger, (int)(Math.random() * Constants.MAXIMUM));
    }

    private void computerWait(){
        waitTrigger = new CompWait().invoke("WHAT A LOVELY DAY!", waitTrigger, (int)(Math.random() * Constants.MAXIMUM));
    }


    private void move() {
        x += speedX;        
    }

    private void groundPoop() {
        for(boolean hp: hitPoop) if(hp)talk = "THERE IS A POOP!";
    }

    public class CompWait {
        public boolean start(int waitTime, long trigger){
            long moveTime = System.currentTimeMillis() - trigger;
            //COMPUTER STOP
            speedX = 0f;

            //COMPUTER START
            if (moveTime > waitTime) {
                //System.out.println("start");
                speedX = 1f;
                return true;
            }

            return false;
        }

        public long invoke(String text, long trigger, int max) {
            int rand = (int)(Math.random() * max);

            if(rand == Constants.MINIMUM) trigger = System.currentTimeMillis();

            if(trigger > 0) {
                talk = text;
                if(start(Constants.WAIT_DELAY, trigger)){
                    speedX *= Constants.DIRECTION;
                    return 0;
                }
            }

            return trigger;
        }
    }
}
