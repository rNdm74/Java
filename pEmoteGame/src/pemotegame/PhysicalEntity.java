package pemotegame;

import java.awt.*;

/**
 *
 * @author Adam Charlton
 */
public abstract class PhysicalEntity {
    public Game game;

    public Vector2 velocity;
    public VectorRect clip;

    public boolean collision;
    public boolean isOnGround;
    public boolean jumping = false;

    public static final float GROUND_FRICTION = 0.9f;
    public static final float AIR_FRICTION = 0.99f;

    protected String talk = "";

    public PhysicalEntity(Vector2 pos, Dimension size, Game game){
        this.game = game;

        clip = new VectorRect(pos, size);
        velocity = new Vector2(0,0);
        isOnGround = false;
    }

    public void draw(Graphics2D g){

        g.draw(clip.getRectangle2D());

        //TALK
        if(!talk.isEmpty()) new SpeechBubble(clip, talk, g);

        //CENTER
        g.drawLine((int) clip.getCenter().getX(), (int) clip.getCenter().getY(),
                   (int) clip.getCenter().getX(), (int) clip.getCenter().getY());
    }

    public void update(float delta)
    {
        //apply friction
        if (isOnGround){
            velocity.x *= 1.0f - ((1.0f - GROUND_FRICTION) * delta);
            velocity.y *= 1.0f - ((1.0f - GROUND_FRICTION) * delta);
        }
        else {
            velocity.x *= 1.0f - ((1.0f - AIR_FRICTION) * delta);
            velocity.y *= 1.0f - ((1.0f - AIR_FRICTION) * delta);
        }

        if (collision){
            velocity.x = 0;
            velocity.y = 0;
        }

        //change position by velocity
        clip.x += velocity.x * delta;
        if(!isOnGround && !jumping) clip.y += velocity.y * delta;
    }

    public void applyAcceleration(Vector2 acceleration){
        velocity.x += acceleration.x;
        if(!isOnGround && !jumping)velocity.y += acceleration.y;
    }
}
