
package pemotegame;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class Player extends Character {
    public final Point2D p = new Point();

    public Player(Rectangle rect, Game game) {
        super(rect, game);        
        p.setLocation(x, y);
    }
    
    public synchronized void draw(Graphics2D g){
        g.draw(clipping);

        if(game.showBounds)g.draw(bounds);

        if(game.showLines){
            g.drawLine((int)p.getX(), (int)p.getY(), (int)center.getX(), (int)center.getY());
            g.drawLine((int)center.getX(), (int)center.getY(), (int)center.getX(), (int)center.getY());
        }
    }
    
    public void move(){
        mouseMove();

        x += velocityX;
        y += velocityY;
    }

    private void mouseMove() {
        float speedX;

        int LIMIT = 10;

        if (center.getX() > p.getX() - LIMIT &&
            center.getX() < p.getX() + LIMIT) {
            speedX =0;
        }else{
            speedX = Constants.PLAYER_SPEED;
        }

        float speedY;
        if (center.getY() > p.getY() - LIMIT &&
            center.getY() < p.getY() + LIMIT) {
            speedY =0;
        }else{
            speedY = Constants.PLAYER_SPEED;
        }
        
        // bird movement
        if (center.distance(p) > 6) {            
            // fly right
            if (center.getX() < p.getX()) { 
                velocityX= speedX;
            }
            // fly left
            if (center.getX() > p.getX()) {
                velocityX=-speedX;
            }
            // fly down
            if (center.getY() < p.getY()) {
                velocityY= speedY;
            }
            // fly up
            if (center.getY() > p.getY()) {
                velocityY=-speedY;
            }
            
            // is stationary
        }else{
            //x=p.getX()-clipping.getWidth()/2;
            //y=p.getY()-clipping.getHeight()/2;
            
            //velocityX = STOP;
            //velocityY = STOP;
        }
    }
}
