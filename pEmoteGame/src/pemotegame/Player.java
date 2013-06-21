
package pemotegame;

import java.awt.Graphics2D;
import static pemotegame.Game.Direction.DOWN;
import static pemotegame.Game.Direction.LEFT;
import static pemotegame.Game.Direction.RIGHT;
import static pemotegame.Game.Direction.STATIONARY;
import static pemotegame.Game.Direction.UP;


public class Player extends Character {

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
    }
    
    public void draw(Graphics2D g){
        g.draw(clipping);
        //g.draw(bounds);
        g.drawLine((int)center.getX(), (int)center.getY(), (int)center.getX(), (int)center.getY());
    }
    
    public void move(Game.Direction d){
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
                velocityX = STOP;
                velocityY = STOP;
                break;
            default:                            
        }
    }
}
