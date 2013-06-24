
package pemotegame;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Adam Charlton
 */
abstract class Character{
    final Rectangle2D clipping;
    final Rectangle bounds;
    public final Point2D center;
    
    final Game game;
    
    final Line2D top;
        
    double x;
    public double y;
    
    final double width;
    final double height;
    
    float velocityX;
    float velocityY;
    
    final float gravity = 6;
    
    protected final float STOP = 0;    
    final float SPEED = 3;
    
    Character(Rectangle rect, Game game){
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
