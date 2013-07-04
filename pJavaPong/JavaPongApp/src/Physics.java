import org.newdawn.slick.geom.Rectangle;

/**
 * Created by rNdm on 7/1/13.
 */
public class Physics {
    public static boolean checkCollisions(GameObject o1, GameObject o2){
        Rectangle r1 = new Rectangle(o1.getX(), o1.getY(), o1.getSX(), o1.getSY());
        Rectangle r2 = new Rectangle(o2.getX(), o2.getY(), o2.getSX(), o2.getSY());

        return r1.intersects(r2);
    }
}
