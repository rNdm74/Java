
package pemotegame;

import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author Adam Charlton
 */
public abstract class Character {
    public Rectangle2D clipping;
    public Rectangle bounds;    
    public Point2D center;
    
    
    
    public Rectangle r;
    
    public double x;
    public double y;
    
    public float width;
    public float height;
    
    public float velocityX;
    public float velocityY;
    
    public float gravity = 3;
    
    protected final float STOP = 0;    
    protected final float SPEED = 3f;
    
    public Character(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        
        this.width = width;
        this.height = height;
                
        clipping = new Rectangle();
        bounds = new Rectangle();        
        center = new Point();
        r = new Rectangle();
    }
            
    public void update(Dimension size){        
        x += velocityX;
        y += velocityY;
        
        if(y <= (size.height-100)-height){
            y += gravity;
        }        
        if (y>=(size.height-100)-height) {
            y=(size.height-100)-height;
        }
        
        center.setLocation(x, y);
                
        clipping.setFrame(center.getX(), center.getY(), width, width);
        
        center.setLocation(clipping.getCenterX(), clipping.getCenterY());
        
        bounds.setFrame(
                clipping.getCenterX() - 200/2, 
                clipping.getCenterY() - 200/2,
                200,
                200);
    }
    
    public void update(){        
        x += velocityX;
        y += velocityY;
                
        center.setLocation(x, y);
                
        clipping.setFrame(center.getX(), center.getY(), width, width);
        
        center.setLocation(clipping.getCenterX(), clipping.getCenterY());
        
        bounds.setFrame(
                clipping.getCenterX() - 200/2, 
                clipping.getCenterY() - 200/2,
                200,
                200);
    }
    
    public void bounds() {        
        if(clipping.getX() > r.width - 50){
            x = r.width - 50;
        }
        
        if(clipping.getX() < r.x){
            x = r.x;            
        }
        
        if(clipping.getY() > r.height - 50){
            y = r.height - 50;
        }
        
        if(clipping.getY() < r.y){
            y = r.y;            
        }
    }
}
