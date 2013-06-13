
package xml;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import xml.Game.Display;

/**
 *
 * @author rNdm
 */
public class EndGame {
    private Point mousepoint = new Point();
    
    private Rectangle bound;
    
    private Dimension backSize;
    
    private Dimension wellDoneSize;
    
    private Equation back = new Equation(new Object[]{"BACK",""});
    private Equation wellDone = new Equation(new Object[]{"WELL","DONE"});
    
    public EndGame(FontManager fm){
        back.updateQuestion(fm);            
        backSize = back.getQuestionSize();
        
        wellDone.updateQuestion(fm);            
        wellDoneSize = wellDone.getQuestionSize();
    }  
    
    public void update(Graphics2D g, Point mousePoint, Game game){
        this.mousepoint = mousePoint;
                        
        bound = new Rectangle(new Point(
                (getBack().getQuestionLocation().x) - 35,
                (getBack().getQuestionLocation().y) - (backSize.height / 2)),
                backSize
        );
        
        //g.draw(bound);
                
        getBack().drawQuestion(g);
            
        if (bound.contains(mousepoint)) {
            game.menu = Display.MENU;
            mousePoint = new Point(0,0);
        }                  
    }

    /**
     * @return the back
     */
    public Equation getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(Equation back) {
        this.back = back;
    }
}
