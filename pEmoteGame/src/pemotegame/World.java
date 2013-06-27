package pemotegame;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rndm
 * Date: 27/06/13
 * Time: 9:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class World {
    public static final Vector2 GRAVITY = new Vector2(0.0f, 10.8f);
    public ArrayList<PhysicalEntity> entities;

    public World(PhysicalEntity p)
    {
        entities = new ArrayList<>();
        entities.add(p);
    }

    public synchronized void draw(Graphics2D g){
        g.setColor(Color.WHITE);

        for (int i = 0; i < entities.size(); i++)
        {
            entities.get(i).draw(g);
        }
    }

    public synchronized void update(float delta)
    {
        Vector2 frameGravity = new Vector2(GRAVITY.x * delta, GRAVITY.y * delta);

        for (int i = 0; i < entities.size(); i++)
        {
            entities.get(i).applyAcceleration(frameGravity);
            entities.get(i).update(delta);
        }
    }
}
