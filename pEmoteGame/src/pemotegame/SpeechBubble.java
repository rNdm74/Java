
package pemotegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Adam Charlton
 */
public class SpeechBubble {
    private AffineTransform affinetransform = new AffineTransform();     
    private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    private Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 14);
    
    public Point2D center = new Point();
    
    private Rectangle bounds = new Rectangle();
    
    public SpeechBubble(Rectangle2D clipping, String text, Graphics2D g, Computer c){
        // for antialiasing text
        g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        
        int width = (int) font.getStringBounds(text, frc).getWidth();
        int height = (int) font.getStringBounds(text, frc).getHeight();
        
        bounds.x = (int)(clipping.getX() + 20);
        bounds.y = (int)(clipping.getY() - 60);
        bounds.width = width + 20;
        bounds.height = height + 20;
        
        center.setLocation(bounds.getCenterX(), bounds.getCenterY()); 
        
        //System.out.println(height);
        g.drawLine(
                (int)center.getX(), 
                (int)center.getY(), 
                (int)c.center.getX(), 
                (int)c.center.getY()
                );
        
        g.setFont(font);
        //g.setColor(Color.DARK_GRAY);
        
        g.setColor(Color.WHITE);
        g.fill3DRect(bounds.x+1, bounds.y+1, bounds.width, bounds.height, true);
        //g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
        
        g.setColor(Color.BLACK);           
        g.drawString(text, (bounds.x + bounds.width/2) - (width/2), (bounds.y + (bounds.height/2) + (height/2)));
    }    
}
