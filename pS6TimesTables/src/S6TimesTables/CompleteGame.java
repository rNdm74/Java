
package S6TimesTables;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import S6TimesTables.Game.Display;

/**
 *
 * @author rNdm
 */
public class CompleteGame {
    private Point mousepoint = new Point();
    
    private Rectangle bound;
    
    private Dimension backSize;
    
    private Dimension wellDoneSize;
    
    //private Equation back = new Equation(new Object[]{"BACK",""});
    //private Equation wellDone = new Equation(new Object[]{"WELL","DONE"});
    
    LabelManager lm;
    
    public CompleteGame(LabelManager lm){
//        back.updateQuestion(fm);
        this.lm = lm;
//        backSize = back.getQuestionSize();
//        
//        wellDone.updateQuestion(fm);            
//        wellDoneSize = wellDone.getQuestionSize();
    }  
    
    public void update(Graphics2D g, Point mousepoint, Game game){
        this.mousepoint = mousepoint;
        
        lm.drawGameOver(g);
                        
//        bound = new Rectangle(new Point(
//                (getBack().getQuestionLocation().x) - 35,
//                (getBack().getQuestionLocation().y) - (backSize.height / 2)),
//                backSize
//        );
//                            
//        getBack().drawQuestion(g);
            
        //   
        
        game.drawBird(g);    
    }
}
