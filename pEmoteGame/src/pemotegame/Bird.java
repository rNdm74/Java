package pemotegame;

import java.awt.*;
import java.util.Random;

/**
 * Created by
 * Adam Charlton
 */
public class Bird extends PhysicalEntity {

    public Vector2 speed = new Vector2(2f,0);
    private long waitTrigger;
    float flightHeight = 120;

    public Bird(Vector2 pos, Dimension size, Game game) {
        super(pos, size, game);
    }

    public synchronized void collision(){
        if(clip.y > flightHeight && !jumping){
            clip.y = flightHeight;
            collision = true;
            //isOnGround = true;
        }
    }

    public synchronized void sleep(){
        waitTrigger = new Sleep(this).invoke("WHO CAN I POOP ON TODAY!", waitTrigger, Constants.MAXIMUM);
    }

    public synchronized void direction() {
        if (clip.x < 0 - 100) {
            //clip.y = 0;
            clip.y = new Random().nextInt(120);
            speed.x = 0;
            speed.x = 2f;
        }

        if (clip.x > game.getBounds().width + 100) {
            //clip.y = 0;
            clip.y =  new Random().nextInt(120);
            speed.x = 0;
            speed.x = -2f;
        }
    }

    public synchronized void move(){
        clip.x += speed.x;
        clip.y += speed.y;
    }
}
