
package S6TimesTables;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author rNdm
 */
public class GameText{
        private char c;
        
        private Point center = new Point();
        
        private Point location = new Point(); 
        
        private Dimension size;
        
        private Rectangle bounds;
        
        private BufferedImage image;
        
        public GameText(char c, BufferedImage image){
            this.c = c;
            this.image = image;
            size = new Dimension(image.getWidth(), image.getHeight());
            bounds = new Rectangle(location,size);
            
            location = bounds.getLocation();
        }
        
        public void update(){
            if (image != null) {
                bounds = new Rectangle(
                    center.x - size.width / 2,
                    center.y - size.height / 2,
                    size.width,
                    size.height
                );
            }
        }
        
        public void draw(Graphics2D g){
            location = bounds.getLocation();
            
            if (image != null) {
                g.drawImage(image, 
                    location.x,
                    location.y,
                    image.getWidth(), 
                    image.getHeight(), 
                    null
                );
                
                //g.draw(bounds);
            }            
        }

        public Rectangle getBounds() {
            return bounds;
        }

        public Point getCenter() {
            return center;
        }
        
        public void setCenter(Point c) {
            this.center = c;
        }
        
        public void setCenter(int x, int y) {
            this.center.x = x;
            this.center.y = y;
        }

        public char getChar() {
            return c;
        }
    }
