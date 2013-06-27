package pemotegame;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

/**
 * Created by
 * Adam Charlton
 */
public class VectorRect implements Serializable {
    public float x;
    public float y;
    public float width;
    public float height;

    public void setCenter(Point2D point2D){

        x = (float) point2D.getX() - width / 2;
        y = (float) point2D.getY() - height / 2;
    }

    public Point2D getCenter(){

        float xPos = x + width / 2;
        float yPos = y + height / 2;

        return new Point2D.Float(xPos, yPos);
    }

    public Rectangle2D getRectangle2D(){
        return new Rectangle2D.Float(x, y, width, height);
    }

    public boolean contains(Rectangle2D r){
        return new Rectangle2D.Float(x, y, width, height).contains(r);
    }

    public VectorRect(Rectangle2D r2d) {
        this.x = (float)r2d.getX();
        this.y = (float)r2d.getY();
        this.width = (float)r2d.getWidth();
        this.height = (float)r2d.getHeight();
    }

    public VectorRect(Rectangle r) {
        this.x = (float)r.x;
        this.y = (float)r.y;
        this.width = (float)r.width;
        this.height = (float)r.height;
    }

    public VectorRect(Vector2 v, float w, float h) {
        this.x = v.x;
        this.y = v.y;
        this.width = w;
        this.height = h;
    }

    public VectorRect(Vector2 v, Dimension d) {
        this.x = v.x;
        this.y = v.y;
        this.width = d.width;
        this.height = d.height;
    }

    public VectorRect(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
}
