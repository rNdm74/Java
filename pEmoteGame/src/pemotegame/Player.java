
package pemotegame;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import static pemotegame.Game.Direction.DOWN;
import static pemotegame.Game.Direction.LEFT;
import static pemotegame.Game.Direction.RIGHT;
import static pemotegame.Game.Direction.STATIONARY;
import static pemotegame.Game.Direction.UP;


public class Player extends Character {
    public Point2D p = new Point();
    private int DIRECTION = -1;
    private int speedX = 2;
    private int speedY = 2;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);        
        p.setLocation(x, y);
    }
    
    public void draw(Graphics2D g){
        g.draw(clipping);
        //g.draw(bounds);
        g.drawLine((int)p.getX(), (int)p.getY(), (int)center.getX(), (int)center.getY());
        g.drawLine((int)center.getX(), (int)center.getY(), (int)center.getX(), (int)center.getY());
    }
    
    public void move(Game.Direction d){
        //y += speedY;
        //x += speedX;
        
        if (center.getX() > p.getX() - 5 &&
            center.getX() < p.getX() + 5) {
            speedX=0;
        }else{
            speedX = 2;
        }
        
        if (center.getY() > p.getY() - 5 &&
            center.getY() < p.getY() + 5) {
            speedY=0;
        }else{
            speedY = 2;
        }
        
        // bird movement
        if (center.distance(p) > 6) {
            
            
            // move right                
            if (center.getX() < p.getX()) { 
                velocityX=speedX;                
            }
            // move left
            if (center.getX() > p.getX()) {
                velocityX=-speedX;
            }
            // move down
            if (center.getY() < p.getY()) {
                velocityY=speedY;
            }
            // move up
            if (center.getY() > p.getY()) {
                velocityY=-speedY;
            }
            
            // is stationary
        }else{
            x=p.getX()-clipping.getWidth()/2;
            y=p.getY()-clipping.getHeight()/2;
            
            velocityX = STOP;
            velocityY = STOP;
        }
                
        switch(d){
            case LEFT:
                velocityX = -SPEED;
                break;
            case RIGHT:
                velocityX = SPEED;
                break;
            case UP:
                velocityY = -SPEED;
                break;
            case DOWN:
                velocityY = SPEED;
                break;
            case STATIONARY:
                //velocityX = STOP;
                //velocityY = STOP;
                break;
            default:                            
        }
    }
}
