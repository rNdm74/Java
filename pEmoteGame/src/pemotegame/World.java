package pemotegame;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Adam Charlton
 */
public class World {
    public static Vector2 GRAVITY = new Vector2(0.0f, 9.8f);
    public ArrayList<PhysicalEntity> entities;

    public World(){
        entities = new ArrayList<>();
    }

    public synchronized void draw(Graphics2D g){
        g.setColor(Color.WHITE);
        for (int i = 0; i < entities.size(); i++) entities.get(i).draw(g);
    }

    public synchronized void update(float delta){
        Vector2 frameGravity = new Vector2(GRAVITY.x * delta, GRAVITY.y * delta);

        for (int i = 0; i < entities.size(); i++)
        {
            entities.get(i).applyAcceleration(frameGravity);
            entities.get(i).update(delta);
        }


    }
}
