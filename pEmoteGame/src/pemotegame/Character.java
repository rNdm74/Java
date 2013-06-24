
package pemotegame;

import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author Adam Charlton
 */
public abstract class Character{
    public Rectangle2D clipping;
    public Rectangle bounds;    
    public Point2D center;
    
    protected Game game;
    
    public Line2D top;
        
    public double x;
    public double y;
    
    public double width;
    public double height;
    
    public float velocityX;
    public float velocityY;
    
    public float gravity = 6;
    
    protected final float STOP = 0;    
    protected final float SPEED = 3;
    
    public Character(Rectangle rect, Game game){        
        this.x = rect.getX();
        this.y = rect.getY();
        
        this.width = rect.getWidth();
        this.height = rect.getHeight();
        
        this.game = game;
        
        clipping = new Rectangle();
        bounds = new Rectangle();        
        center = new Point();
        top = new Line2D.Float();
    }
    
    public void update(){                
        center.setLocation(x, y);
                
        clipping.setFrame(center.getX(), center.getY(), width, height);
        
        center.setLocation(clipping.getCenterX(), clipping.getCenterY());
        
        top.setLine(clipping.getX(), 
                    clipping.getY(),
                    clipping.getX() + clipping.getWidth(), 
                    clipping.getY());
        
        bounds.setFrame(
                clipping.getCenterX() - 200/2, 
                (clipping.getY() + height) - (game.getHeight()-100),
                200,
                game.getHeight() - 100);
    }
    
    public void bounds() {        
        if(clipping.getX() > game.getBounds().width){
            x = game.getBounds().width;
        }
        
        if(clipping.getX() < game.getBounds().x){
            x = game.getBounds().x;            
        }
        
        if(clipping.getY() > game.getBounds().height - 50){
            y = game.getBounds().height - 50;
        }
        
        if(clipping.getY() < game.getBounds().y){
            y = game.getBounds().y;            
        }
    }
}
