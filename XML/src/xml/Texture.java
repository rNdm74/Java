
package xml;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author rNdm
 */
public class Texture {
    private int ID;
    private String name;
    private Point location = new Point();
    private Point frameLocation = new Point();
    private Dimension size = new Dimension();
    private Dimension frameSize = new Dimension();

    public Texture(Object[] items){
        name = (String)items[0];
        location.x = Integer.parseInt((String)items[1]);
        location.y = Integer.parseInt((String)items[2]);
        size.width = Integer.parseInt((String)items[3]);
        size.height = Integer.parseInt((String)items[4]);
        try{
            ID = Integer.parseInt((String)items[5]);
        }catch(Exception e){               
        }

    }

    public String getName() {
        return name;
    }

    public Point getLocation() {
        return location;
    }

    public Point getFrameLocation() {
        return frameLocation;
    }

    public Dimension getSize() {
        return size;
    }

    public Dimension getFrameSize() {
        return frameSize;
    }  
    
    public int getID() {
        return ID;
    }
}
