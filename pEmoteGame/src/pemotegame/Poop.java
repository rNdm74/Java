
package pemotegame;

import java.awt.Graphics2D;
import java.awt.Rectangle;


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
        if(y <= (game.getSize().height-Constants.GROUND_HEIGHT)-height){
            y += Constants.GRAVITY;
        }  
        
        if (y>=(game.getSize().height-Constants.GROUND_HEIGHT)-height) {
            y=(game.getSize().height-Constants.GROUND_HEIGHT)-height;
        }
                
        center.setLocation(x, y);
                
        clipping.setFrame(center.getX(), center.getY(), Constants.POOP_WIDTH, Constants.POOP_WIDTH);
        
        center.setLocation(clipping.getCenterX(), clipping.getCenterY());
        
        bounds.setFrame(
                clipping.getCenterX() - Constants.DEFAULT_CLIPPING_SIZE/2,
                clipping.getCenterY() - Constants.DEFAULT_CLIPPING_SIZE/2,
                Constants.DEFAULT_CLIPPING_SIZE,
                Constants.DEFAULT_CLIPPING_SIZE);
    }
}
