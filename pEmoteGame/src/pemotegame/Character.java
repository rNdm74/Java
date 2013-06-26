
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
    public Point2D center;
    public Rectangle2D clipping;
    final Rectangle bounds;
    final Game game;
    final Line2D top;

    public double x;
    public double y;
    
    public double width;
    public double height;
    
    float velocityX;
    float velocityY;

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
    }
    
    public void bounds() {        
        if(clipping.getX() > game.getBounds().width){
            x = game.getBounds().width;
        }
        
        if(clipping.getX() < game.getBounds().x){
            x = game.getBounds().x;            
        }
        
        if(clipping.getY() + Constants.COMPUTER_HEIGHT > game.getBounds().height - Constants.GROUND_HEIGHT){
            y = game.getBounds().height - Constants.GROUND_HEIGHT - Constants.COMPUTER_HEIGHT;
        }
        
        if(clipping.getY() < game.getBounds().y){
            y = game.getBounds().y;            
        }
    }
}
