package pemotegame;

import java.awt.*;

/**
 * Created by
 * Adam Charlton
 */
public class Hero extends PhysicalEntity {

    public Vector2 speed = new Vector2(0,0);
    public float jumpSpeed = 5.8f;

    public Hero(Vector2 pos, Dimension size, Game game) {
        super(pos, size, game);
    }

    public synchronized void jump(){
        if (jumping){
            collision = false;
            clip.y -= jumpSpeed;
        }
    }

    public synchronized void collision(){
        if(clip.y > game.superBirdiePoop.getHeight() - game.ground - clip.height && !jumping){
            clip.y = game.superBirdiePoop.getHeight() - game.ground - clip.height;
            collision = true;
            isOnGround = true;
        }
    }

    public synchronized void move(){
        clip.x += speed.x;
    }
}
