
package pemotegame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Computer extends Character {
    private int DIRECTION = -1;
    private float speedX = 1f;
    private int speedY = 1;
    
    private Color c;

    public Computer(float x, float y, float width, float height) {
        super(x, y, width, height);
        
        int red = new Random().nextInt(255);
        int green = new Random().nextInt(255);
        int blue = new Random().nextInt(255);
        
        c = new Color(red, green, blue);
    }
    
    public void draw(Graphics2D g){
        g.setColor(c);
        g.draw(clipping);        
        g.fill(clipping);
//        g.drawLine(
//                (int)center.getX(), 
//                (int)center.getY(), 
//                (int)center.getX(), 
//                (int)center.getY()
//        );
    }

    public void update(Player p){
        move();
        
        randomizeDirection();
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

    private void computerBoundsCheck(Player p) {
        if(super.bounds.contains(p.center)){
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
    }

    private void randomizeDirection() {
        int rand = new Random().nextInt(500);
        
        if (rand == 0) {
            //System.out.println("RANDOM TIME");
            speedX *= DIRECTION;
            speedY *= DIRECTION;
        }
    }

    private void move() {
        y += speedY;
        x += speedX;
    }
}
