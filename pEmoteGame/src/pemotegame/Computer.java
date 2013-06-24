
package pemotegame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import static pemotegame.Game.c;
import static pemotegame.Game.poops;

public class Computer extends Character {
    private static int DIRECTION = -1;
    
    public float speedX = 1f;
    
    public boolean playerInBounds;
    
    private ArrayList<Boolean> hitPoop;
    
    public Color color;
    
    private SpeechBubble s;
        
    public String talk = "";
    
    

    public Computer(Rectangle rect, Game game) {
        super(rect, game);
        
        this.hitPoop = new ArrayList<>();        
    }
    
    public void draw(Graphics2D g){
        //BOUNDS
        g.setColor(Color.CYAN.darker());        
        if(playerInBounds)g.setColor(Color.PINK.darker());        
        //g.draw(bounds);
        
        //CLIPPING
        g.setColor(Color.GREEN.darker()); 
        
        g.draw(clipping);
        g.fill(clipping);
        
        //TALK
        if(!talk.isEmpty()){            
            s = new SpeechBubble(clipping, talk, g, this);
        }
    }

    public void update(Player p, ArrayList<Poop> poops){  
        talk = "";
        
        computerWait();
        computerClippingCheck(poops);
        computerBoundsCheck(p);
        randomizeDirection();
        screenBoundsCheck();
        groundPoop();
        poopCheck();
        move();       
    }

    private void screenBoundsCheck() {        
        if (clipping.getX() < 1) {
            speedX *= DIRECTION;            
        } 
        
        if ((clipping.getX() + width) > game.getBounds().width) {            
            speedX *= DIRECTION;            
        }       
    }

    private void computerClippingCheck(ArrayList<Poop> poops) {
        hitPoop.clear();
        
        for (Poop poop: poops) {
            hitPoop.add(clipping.contains(poop.center));
//            if (top.intersects(poop.clipping)) {
//                System.out.println("foo");
//                game.c.remove(game.c.indexOf(this));
//            }
        }
    }
    
    
    
    private void computerBoundsCheck(Player p) {
        
        if(bounds.contains(p.center)){            
            playerInBounds = true;
            talk = "PRETTY BIRDIE!";
            
            if (p.center.getX() < center.getX()) {
                //speedX *= -speedX;
            }
            
            if (p.center.getX() > center.getX()) {
                //speedX *= speedX;
            }            
        }
        else{
            playerInBounds = false;
            //talk = "";
        }
    }

    public Pause pause = new Pause(this);
    public boolean ohcrap;
    long directionTrigger;
    long waitTrigger;
    long poopTrigger;
    int minimum = 0;
    int maximum = 500;
    
    private long poopCheckTrigger;
    
    public void poopCheck(){        
        for (Poop poop: poops) {
            if (top.intersects(poop.clipping)) {
                poopCheckTrigger = System.currentTimeMillis();
            }
        }
                
        if (poopCheckTrigger > 0) {
            talk ="OH CRAP!";
            if(pause.start(500, poopCheckTrigger)){
                poopCheckTrigger = 0;
                ohcrap = true;
            }            
        }
        
        //ohcrap = false;
    }
    
    private void randomizeDirection() {
        maximum = 500;
        
        int rand = minimum + (int)(Math.random()*maximum);
        
        if(rand == maximum -1) directionTrigger = System.currentTimeMillis();
                
        if(directionTrigger > 0){            
            talk ="I WANNA GO THIS WAY!";
            if(pause.start(2000, directionTrigger)){
                directionTrigger = 0;
                speedX*=DIRECTION;
            }            
        }
    }
    
    
    
    private void computerWait(){ 
        maximum = 1000;
        int rand = minimum + (int)(Math.random()*maximum);
        
        if(rand == minimum) waitTrigger = System.currentTimeMillis(); 
        
        if(waitTrigger > 0) {
            talk = "WHAT A LOVELY DAY!";                        
            if(pause.start(2000, waitTrigger)){
                waitTrigger = 0;
            }
        }
    }
    
    
    
    private void move() {
        x += speedX;        
    }

    private void groundPoop() {
        for(boolean hitpoop: hitPoop) if(hitpoop)talk = "THERE IS A POOP!";
    }
}
