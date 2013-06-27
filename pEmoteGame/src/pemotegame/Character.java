
package pemotegame;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Adam Charlton
 */
abstract class Character{
    public Rectangle2D clipping = new Rectangle();
    public Point2D center = new Point();

    final Rectangle bounds = new Rectangle();
    final Line2D top = new Line2D.Float();

    final Game game;

    public Rectangle rectangle;
    VectorRect vectorRect;
    Vector2 velocity;

    Character(Rectangle rectangle, Game game){
        vectorRect = new VectorRect(rectangle);
        System.out.println(vectorRect.getCenter());

        this.game = game;
    }
    
    public void update(){

        //center.setLocation(rectangle.x, rectangle.y);

        //clipping.setFrame(center.getX(), center.getY(), rectangle.width, rectangle.height);
        
        //center.setLocation(clipping.getCenterX(), clipping.getCenterY());
        
//        top.setLine(clipping.getX(),
//                    clipping.getY(),
//                    clipping.getX() + clipping.getWidth(),
//                    clipping.getY());
    }
    
    public void bounds() {
        //NORTH BOUNDARY
        if(clipping.getY() < 0){
            //y = 1;
        }

        //SOUTH BOUNDARY
        if(clipping.getY() + Constants.COMPUTER_HEIGHT > game.getBounds().height - game.ground){
            //y = game.getBounds().height - game.ground - Constants.COMPUTER_HEIGHT;
        }

        //EAST BOUNDARY
        if(clipping.getX() > game.getBounds().width){
            //x = game.getBounds().width-1;
        }

        //WEST BOUNDARY
        if(clipping.getX() < 0){
            //x = 1;
        }
    }
}
