
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

    /**
     * @return the clipping
     */
    public Rectangle getClipping() {
        return clipping;
    }

    /**
     * @param clipping the clipping to set
     */
    public void setClipping(Rectangle clipping) {
        this.clipping = clipping;
    }

    /**
     * @return the speed
     */
    public Point getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(Point speed) {
        this.speed = speed;
    }

//    /**
//     * @return the mousePointer
//     */
//    public Point getMousePointer() {
//        return mousePointer;
//    }
//
//    /**
//     * @param mousePointer the mousePointer to set
//     */
//    public void setMousePointer(Point mousePointer) {
//        this.mousePointer = mousePointer;
//    }
    private enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    
    // Variables
    private Direction birdDirection = Direction.RIGHT;
    
    private Rectangle center;
    private Rectangle clipping;
    
    private Point speed = new Point();    
    private Point birdCenter = new Point();
    private Point birdPosition = new Point();
    //private Point mousePointer = new Point();
    
    private Animation animator;
    
    
    
//    public void hitDetection(Game game){
//        //if (menu.equals(Game.Display.PLAY) && menu != null) hitDetection();
//        try {
//            if (getClipping().intersects(correctAnswer.getClipping())) {             
//                answeredCorrect = true;            
//                correctAnswer.setHit(answeredCorrect);
//                eat.play();            
//                reset(getPlayerScore() + 100, "correct");
//            }
//            else if (getClipping().intersects(falseAnswer1.getClipping()) ||
//                getClipping().intersects(falseAnswer2.getClipping())) {            
//                answeredWrong = true;  
//                falseAnswer1.setHit(answeredWrong);
//                falseAnswer2.setHit(answeredWrong);            
//                wrong.play();            
//                reset(getPlayerScore() - 50, "wrong");
//            }
//            } catch (Exception e) {} 
//        
//    }
    
    public void move(Point mousePointer){
        // bird movement
        if (!center.contains(mousePointer)) {

        // move right                
        if (birdCenter.x < mousePointer.x) {                    
            birdDirection = Direction.RIGHT;
            speed.x = 5;
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
            speed.x = -5;
        }
        else{
            if (birdCenter.x > mousePointer.x - 20 &&
                birdCenter.x < mousePointer.x + 20) {
                birdCenter.x = mousePointer.x;
            }                    
        }

        // move down
        if (birdCenter.y < mousePointer.y) {
            speed.y = 5;
        }
        else{
            if (birdCenter.y > mousePointer.y - 20 &&
                birdCenter.y < mousePointer.y + 20) {
                birdCenter.y = mousePointer.y;
            }
        }

        // move up
        if (birdCenter.y > mousePointer.y) {
            speed.y = -5;
        }
        else{
            if (birdCenter.y > mousePointer.y - 20 &&
                birdCenter.y < mousePointer.y + 20) {
                birdCenter.y = mousePointer.y;
            }
        }
            // is stationary
        }else{
            birdDirection = Direction.RIGHT;
            birdCenter = mousePointer;
            speed.x = 0;
            speed.y = 0;
        }
    }
    
    public void update(Graphics2D g){
        
    }
    
    public void updateBird(Graphics2D g) {        
        if (animator != null) {
            animator.update(System.currentTimeMillis());
            
            birdCenter.x += getSpeed().x;
            birdCenter.y += getSpeed().y;
            
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
                    
                    setClipping(new Rectangle(
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
                    
                    setClipping(new Rectangle(
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
            
            g.draw(center);
            g.draw(clipping);
        }
    }
}
