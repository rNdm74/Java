
package pemotegame;

import java.awt.Graphics2D;


public class Poop extends Character {

    public Poop(float x, float y, float width, float height) {
        super(x, y, width, height);
    }
    
    public void draw(Graphics2D g){
        g.draw(clipping);
        //g.draw(bounds);
        //g.drawLine((int)p.getX(), (int)p.getY(), (int)center.getX(), (int)center.getY());
        g.drawLine((int)center.getX(), (int)center.getY(), (int)center.getX(), (int)center.getY());
    }
}
