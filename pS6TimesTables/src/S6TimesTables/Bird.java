
package S6TimesTables;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Adam Charlton
 */
public class Bird {  
    public Bird(Animation animator){
        this.animator = animator;
        
        animator.setSpeed(90);
        animator.start();
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
    
    public int SPEED = 5;
    
    private Point move = new Point();    
    private Point birdCenter = new Point();
    private Point birdPosition = new Point();
    
    private Animation animator;
    
    //private boolean stop = false;
        
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
        if (animator != null) {
            animator.update(System.currentTimeMillis());
            
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
                    birdPosition.x = (birdCenter.x - animator.sprite.getWidth() / 2) + animator.sprite.getWidth();
                    birdPosition.y = birdCenter.y - animator.sprite.getHeight() / 2;
                    
                    clipping = (new Rectangle(
                         birdCenter.x - 80, 
                         (birdCenter.y) + (animator.sprite.getHeight()/2) - 80,
                         50,
                         50
                     ));
            
                    g.drawImage(animator.sprite, 
                        birdPosition.x, 
                        birdPosition.y, 
                        -animator.sprite.getWidth(), 
                        animator.sprite.getHeight(),                    
                        null
                    );
                    break;
                case RIGHT:
                    birdPosition.x = (birdCenter.x - animator.sprite.getWidth() / 2);
                    birdPosition.y = birdCenter.y - animator.sprite.getHeight() / 2;
                    
                    clipping = (new Rectangle(
                         birdCenter.x + 20, 
                         (birdCenter.y) + (animator.sprite.getHeight()/2) - 80,
                         50,
                         50
                     ));
                    
                    g.drawImage(animator.sprite, 
                        birdPosition.x, 
                        birdPosition.y, 
                        animator.sprite.getWidth(), 
                        animator.sprite.getHeight(),                    
                        null
                    );
                    break;            
            }
            
            g.draw(getCenter());
            g.draw(clipping);
        }
    }
}
