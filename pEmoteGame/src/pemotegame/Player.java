
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
    
    public void draw(Graphics2D g){
        g.draw(clipping);
        //g.draw(bounds);
        //g.drawLine((int)p.getX(), (int)p.getY(), (int)center.getX(), (int)center.getY());
        g.drawLine((int)center.getX(), (int)center.getY(), (int)center.getX(), (int)center.getY());
    }
    
    public void move(){
        x += velocityX;
        y += velocityY;
        
        mouseMove();
                
//        switch(d){
//            case LEFT:
//                velocityX = -SPEED;
//                break;
//            case RIGHT:
//                velocityX = SPEED;
//                break;
//            case UP:
//                velocityY = -SPEED;
//                break;
//            case DOWN:
//                velocityY = SPEED;
//                break;
//            case STATIONARY:
//                //velocityX = STOP;
//                //velocityY = STOP;
//                break;
//            default:                            
//        }
    }

    private void mouseMove() {

        float speedX;
        int LIMIT = 10;
        if (center.getX() > p.getX() - LIMIT &&
            center.getX() < p.getX() + LIMIT) {
            speedX =0;
        }else{
            speedX = SPEED;
        }

        float speedY;
        if (center.getY() > p.getY() - LIMIT &&
            center.getY() < p.getY() + LIMIT) {
            speedY =0;
        }else{
            speedY = SPEED;
        }
        
        // bird movement
        if (center.distance(p) > 6) {            
            // move right                
            if (center.getX() < p.getX()) { 
                velocityX= speedX;
            }
            // move left
            if (center.getX() > p.getX()) {
                velocityX=-speedX;
            }
            // move down
            if (center.getY() < p.getY()) {
                velocityY= speedY;
            }
            // move up
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
