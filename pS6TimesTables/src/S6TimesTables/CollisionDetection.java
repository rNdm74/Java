/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package S6TimesTables;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author rNdm
 */
public class CollisionDetection {
    private boolean previouslyColliding = false;
    private boolean currentlyColliding = false;
    
    private boolean previouslyContained = false;
    private boolean currentlyContained = false;
    
    public boolean pointContained(Point p, Rectangle r) {        
        currentlyContained = r.contains(p);
        
        if(currentlyContained && !previouslyContained) { 
            return true;
        }
        
        previouslyContained = currentlyContained;
        
        return false;
    }
    
    public boolean hitDetection(Rectangle r1, Rectangle r2) {        
        currentlyColliding = r1.intersects(r2);
        
        if(currentlyColliding && !previouslyColliding) { 
            return true;
        }
        
        previouslyColliding = currentlyColliding;
        
        return false;
    }    
}
