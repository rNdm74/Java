
package S6TimesTables;

import java.awt.Rectangle;

/**
 *
 * @author Adam Charlton
 */
public abstract class Sprite {
        
    private float x;    
    private float y;
    
    private int width;
    private int height;
    
    private Rectangle bounds;
    
    public Sprite(){
        
    }
        
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
    
    
}
