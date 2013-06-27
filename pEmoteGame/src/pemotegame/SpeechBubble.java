
package pemotegame;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Adam Charlton
 */
class SpeechBubble {

    public SpeechBubble(VectorRect clip, String text, Graphics2D g){

        Font font = new Font(Font.SANS_SERIF, Font.ITALIC, Constants.DEFAULT_FONT_SIZE);
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);

        int width = (int) font.getStringBounds(text, frc).getWidth();
        int height = (int) font.getStringBounds(text, frc).getHeight();

        Rectangle bounds = new Rectangle();
        bounds.x = (int)(clip.x + Constants.DEFAULT_X_PADDING);
        bounds.y = (int)(clip.y - Constants.DEFAULT_Y_PADDING);
        bounds.width = width + Constants.DEFAULT_X_PADDING;
        bounds.height = height + Constants.DEFAULT_X_PADDING;

        Point2D center = new Point();
        center.setLocation(bounds.getCenterX(), bounds.getCenterY());

        g.drawLine(
                (int) center.getX(),
                (int) center.getY(),
                (int) clip.getCenter().getX(),
                (int) clip.getCenter().getY()
                );
        
        g.setFont(font);
        //g.setColor(Color.DARK_GRAY);
        
        g.setColor(Color.WHITE);
        g.fill3DRect(bounds.x, bounds.y, bounds.width, bounds.height, true);
        g.setColor(Color.BLACK);           
        g.drawString(text, (bounds.x + bounds.width/2) - (width/2), (bounds.y + (bounds.height/2) + (height/2)));
        g.setColor(Color.WHITE);
    }    
}
