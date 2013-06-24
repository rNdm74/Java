
package pemotegame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public class Poop extends Player {

    public Poop(Rectangle rect, Game game) {
        super(rect, game);
    }
    
    @Override
    public void draw(Graphics2D g){
        g.draw(clipping);
        //g.draw(bounds);
        //g.drawLine((int)p.getX(), (int)p.getY(), (int)center.getX(), (int)center.getY());
        g.drawLine((int)center.getX(), (int)center.getY(), (int)center.getX(), (int)center.getY());
    }
    
    @Override
    public void update(){        
        x += velocityX;
        y += velocityY;
        
        //GRAVITY
        if(y <= (game.getSize().height-100)-height){
            y += gravity;
        }  
        
        if (y>=(game.getSize().height-100)-height) {
            y=(game.getSize().height-100)-height;
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
}
