
package S6TimesTables;

/**
 *
 * @author rNdm
 */
public class Sprite {
    private Animation a;
    
    private float x;    
    private float y;
    private float vx;
    private float vy;
    
    public Sprite(Animation a){
        this.a = a;
    }
    
    // change position
    public void update(long timePassed){
        x += vx * timePassed;
        y += vy * timePassed;
        
        //a.update(timePassed);
    }
}
