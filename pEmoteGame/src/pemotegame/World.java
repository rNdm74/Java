package pemotegame;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rndm
 * Date: 27/06/13
 * Time: 9:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class World {
    public static final Vector2 GRAVITY = new Vector2(0.0f, -9.8f);
    private ArrayList<PhysicalEntity> entities;

    public World()
    {
        entities = new ArrayList<PhysicalEntity>();
    }

    public void update(float delta)
    {
        Vector2 frameGravity = new Vector2(GRAVITY.x * delta, GRAVITY.y * delta);
        for (int i = 0; i < entities.size(); i++)
        {
            entities.get(i).applyAcceleration(frameGravity);
            entities.get(i).update(delta);
        }
    }
}
