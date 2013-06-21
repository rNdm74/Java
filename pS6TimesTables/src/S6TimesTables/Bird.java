
package S6TimesTables;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Adam Charlton
 */
public class Bird{      
    public Bird(Animation animation){
        this.animation = animation;
        animation.setSpeed(90);
        animation.start();
    }

    public Rectangle getClipping() {
        return clipping;
    }

    public Rectangle getCenter() {
        return center;
    }

    private enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    
    // Variables
    private Direction birdDirection = Direction.RIGHT;
    
    public boolean birdStopped = false;
    
    private Rectangle center = new Rectangle();
    private Rectangle clipping = new Rectangle();
        
    public Point birdCenter = new Point(0,0);
    
    private Point move = new Point();    
    private Point birdPosition = new Point();
    
    private Animation animation;
    
    public Point poopPos;
    
    public int SPEED = 3;
        
    
        
    public void move(Point mousePointer){
        // bird movement
        if (!center.contains(mousePointer)) {

        // move right                
        if (birdCenter.x < mousePointer.x) {                    
            birdDirection = Direction.RIGHT;
            move.x = SPEED;
        }
        else{
            if (birdCenter.x > mousePointer.x - 20 &&
                birdCenter.x < mousePointer.x + 20) {
                birdCenter.x = mousePointer.x;
            }                    
        }

        // move left
        if (birdCenter.x > mousePointer.x) {
            birdDirection = Direction.LEFT;
            move.x = -SPEED;
        }
        else{
            if (birdCenter.x > mousePointer.x - 20 &&
                birdCenter.x < mousePointer.x + 20) {
                birdCenter.x = mousePointer.x;
            }                    
        }

        // move down
        if (birdCenter.y < mousePointer.y) {
            move.y = SPEED;
        }
        else{
            if (birdCenter.y > mousePointer.y - 20 &&
                birdCenter.y < mousePointer.y + 20) {
                birdCenter.y = mousePointer.y;
            }
        }

        // move up
        if (birdCenter.y > mousePointer.y) {
            move.y = -SPEED;
        }
        else{
            if (birdCenter.y > mousePointer.y - 20 &&
                birdCenter.y < mousePointer.y + 20) {
                birdCenter.y = mousePointer.y;
            }
        }
            // is stationary
        }else{
            birdStopped = true;
            birdDirection = Direction.RIGHT;
            birdCenter = mousePointer;
            move.x = 0;
            move.y = 0;
        }
    }
    
    public void update(Graphics2D g){
        
    }
    
    public void updateBird(Graphics2D g) {        
        if (animation != null) {
            animation.update(System.currentTimeMillis());
            
            if (!birdStopped) {
                birdCenter.x += move.x;
                birdCenter.y += move.y;
            }
            
            
            // determines that bird has moved to correct point
            center = new Rectangle(
                    birdCenter.x - 10,
                    birdCenter.y - 10,
                    20,20
            );
                                                 
            
                                                                        
            switch(birdDirection){
                case LEFT:
                    birdPosition.x = (birdCenter.x - animation.sprite.getWidth() / 2) + animation.sprite.getWidth();
                    birdPosition.y = birdCenter.y - animation.sprite.getHeight() / 2;
                    
                    clipping = (new Rectangle(
                         birdCenter.x - 80, 
                         (birdCenter.y) + (animation.sprite.getHeight()/2) - 80,
                         50,
                         50
                     ));
            
                    g.drawImage(animation.sprite, 
                        birdPosition.x, 
                        birdPosition.y, 
                        -animation.sprite.getWidth(), 
                        animation.sprite.getHeight(),                    
                        null
                    );
                    break;
                case RIGHT:
                    birdPosition.x = (birdCenter.x - animation.sprite.getWidth() / 2);
                    birdPosition.y = birdCenter.y - animation.sprite.getHeight() / 2;
                    
                    clipping = (new Rectangle(
                         birdCenter.x + 20, 
                         (birdCenter.y) + (animation.sprite.getHeight()/2) - 80,
                         50,
                         50
                     ));
                    
                    g.drawImage(animation.sprite, 
                        birdPosition.x, 
                        birdPosition.y, 
                        animation.sprite.getWidth(), 
                        animation.sprite.getHeight(),                    
                        null
                    );
                    break;            
            }
            
            //g.draw(getCenter());
            //g.draw(clipping);
        }
    }
}
