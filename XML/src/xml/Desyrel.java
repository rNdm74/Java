
package xml;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author rNdm
 */
public class Desyrel{
        private String letter;
        
        private Point c = new Point();
        
        private Point p = new Point(); 
        
        private Dimension d;
        
        private Rectangle b;
        
        private BufferedImage image;
        
        public Desyrel(String letter, BufferedImage image){
            this.letter = letter;
            this.image = image;
            d = new Dimension(image.getWidth(), image.getHeight());
            b = new Rectangle(p,d);
            
            p = b.getLocation();
        }
        
        public void update(){
            if (image != null) {
                b = new Rectangle(
                    c.x - d.width / 2,
                    c.y - d.height / 2,
                    d.width,
                    d.height
                );
            }
        }
        
        public void draw(Graphics2D g){
            p = b.getLocation();
            
            if (image != null) {
                g.drawImage(image, 
                    p.x,
                    p.y,
                    image.getWidth(), 
                    image.getHeight(), 
                    null
                );
            }            
        }

        public Rectangle getBounds() {
            return b;
        }

        public Point getCentre() {
            return c;
        }
        
        public void setCentre(Point c) {
            this.c = c;
        }

        public String getLetter() {
            return letter;
        }
    }
