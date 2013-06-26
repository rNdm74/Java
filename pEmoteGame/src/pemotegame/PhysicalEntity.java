package pemotegame;

/**
 * Created with IntelliJ IDEA.
 * User: rndm
 * Date: 27/06/13
 * Time: 9:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class PhysicalEntity {
    private Vector2 position;
    private Vector2 velocity;
    private boolean isOnGround;
    public static final float GROUND_FRICTION = 0.9f;
    public static final float AIR_FRICTION = 0.99f;

    public PhysicalEntity(Vector2 pos)
    {
        position = pos;
        velocity = new Vector2(0,0);
        isOnGround = false;
    }

    public void update(float delta)
    {
        //apply friction
        if (isOnGround)
        {
            velocity.x *= 1.0f - ((1.0f - GROUND_FRICTION) * delta);
            velocity.y *= 1.0f - ((1.0f - GROUND_FRICTION) * delta);
        }
        else
        {
            velocity.x *= 1.0f - ((1.0f - AIR_FRICTION) * delta);
            velocity.y *= 1.0f - ((1.0f - AIR_FRICTION) * delta);
        }

        //change position by velocity
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
    }

    public void applyAcceleration(Vector2 acceleration)
    {
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
    }
}
