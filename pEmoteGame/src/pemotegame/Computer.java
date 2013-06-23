
package pemotegame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class Computer extends Character {
    private int DIRECTION = -1;
    private float speedX = 1f;
    private float speedY = 1f;
    
    public boolean playerInBounds;
    //public boolean hitPoop;
    private ArrayList<Boolean> hitPoop;
    
    public Color c;

    public Computer(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.hitPoop = new ArrayList<>();
        
        int red = new Random().nextInt(255);
        int green = new Random().nextInt(255);
        int blue = new Random().nextInt(255);
        
        //c = new Color(red, green, blue);
    }
    
    public void draw(Graphics2D g){
        //g.setColor((!playerInBounds)? Color.GREEN.darker(): Color.ORANGE.darker());
        //System.out.println(hitPoop);
        g.setColor(Color.CYAN.darker());
        g.draw(bounds);
        g.setColor(Color.GREEN.darker());
        for(boolean hp: hitPoop){
            if(hp){
                g.drawString("HIT POOP", (float)(clipping.getX() + width + 20), (float)clipping.getY());
                g.setColor(Color.RED.darker());
            } 
            else{
               
            }
        }
        //g.setColor(c);
        g.draw(clipping);
        g.fill(clipping);
        
        
        
        
//        g.drawLine(
//                (int)center.getX(), 
//                (int)center.getY(), 
//                (int)center.getX(), 
//                (int)center.getY()
//        );
    }

    public void update(Player p, ArrayList<Poop> poops){
        move();
        
        //computerWait();
        //randomizeDirection();
        computerClippingCheck(poops);
        computerBoundsCheck(p);
        screenBoundsCheck();        
    }

    private void screenBoundsCheck() {
        if (super.y + 50 > r.height - 1) {
            speedY *= DIRECTION;            
        } 
        
        if (super.y < 1) {
            speedY *= DIRECTION;            
        }
        
        if (super.x + 50 > r.width - 1) {
            speedX *= DIRECTION;            
        } 
        
        if (super.x < 1) {
            speedX *= DIRECTION;            
        }        
    }

    private void computerClippingCheck(ArrayList<Poop> poops) {
        //System.out.println(hitPoop);
        hitPoop.clear();
        //boolean[] hitPoop = new boolean[poops.size()];
        for (int i = 0; i < poops.size(); i++) {
            if(clipping.contains(poops.get(i).center)){
                hitPoop.add(true);
            }
            else{
                hitPoop.add(false);
            }            
        }
        
        
//        for (int i = 0; i < poops.size(); i++) {
//            if(clipping.contains(poops.get(i).center)){
//                //poops.remove(i);
//                
//                hitPoop.set(i, true);
//                //System.out.println(hitPoop);
//            }            
//            
//            if (!clipping.contains(poops.get(i).center)) {
//                hitPoop.set(i, false);
//                
//            }
//        }
        
                
        
        
        
//        if(poops.isEmpty()){
//            hitPoop = false;
//        }
        
        //c = (hitPoop) ? Color.RED.darker() : Color.GREEN.darker();
        
        
        
//        for (boolean b: hitPoop) {
//            if (b) {
//            System.out.println("RED");
//            c = Color.RED.darker();
//            //poops.remove(0);
//            //hitPoop = true;
//            }
//            else{
//                System.out.println("GREEN");
//                c = Color.GREEN.darker();
//                //hitPoop = false;
//            }
//        }
    }
    
    private void computerBoundsCheck(Player p) {
        if(bounds.contains(p.center)){
            c = Color.ORANGE.darker();
            playerInBounds = true;
            if (p.center.getX() < super.center.getX()) {
                speedX *= -speedX;
            }
            
            if (p.center.getY()< super.center.getY()) {
                speedY *= -speedY;
            }
            
            if (p.center.getX() > super.center.getX()) {
                speedX *= speedX;
            }
            
            if (p.center.getY() > super.center.getY()) {
                speedY *= speedY;
            }            
        }
        else{
            //c = Color.GREEN.darker();
            playerInBounds = false;
        }
    }

    private void randomizeDirection() {
        int rand = new Random().nextInt(10000);
        
        if (rand == 0) {
            //System.out.println("RANDOM TIME");
            speedX *= DIRECTION;
            speedY *= DIRECTION;
        }
    }

    long beforeTime = System.currentTimeMillis();
    long currentTime;
    boolean waiting = false;
    
    private void computerWait(){
        
        
        int rand = new Random().nextInt(500);
        
        if (!waiting && rand == 0) { 
            System.out.println("WAITING");
            speedX = 0;  
            waiting = true;
        }
        
        currentTime = System.currentTimeMillis();
        //System.out.println(currentTime - beforeTime);
        long moveTime = currentTime - beforeTime;
        
        if (waiting && moveTime > 10000) {
            System.out.println("FINISHED WAITING");
            speedX = 1f;
            beforeTime = System.currentTimeMillis();
            currentTime = 0;
            waiting = false;
        }
        
        
    }
    
    private void move() {
        
        
        y += speedY;
        x += speedX;
        
    }
}
