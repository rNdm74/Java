
package pemotegame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Computer extends Character {
    private int DIRECTION = -1;
    private int speedX = 1;
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
        g.drawLine(
                (int)center.getX(), 
                (int)center.getY(), 
                (int)center.getX(), 
                (int)center.getY()
        );
    }

    public void move(Player p){
        y += speedY;
        x += speedX;
        
        int rand = new Random().nextInt(1000);
        
        if (rand == 0) {
            System.out.println("RANDOM TIME");
            speedX *= DIRECTION;
            speedY *= DIRECTION;
        }
        
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
}
