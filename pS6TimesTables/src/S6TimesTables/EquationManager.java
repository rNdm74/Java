
package S6TimesTables;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author rNdm
 */
public class EquationManager {
    private boolean correct;
    private boolean hit;
    
    private Point answerLocation = new Point();
    private Point questionLocation = new Point();
    
    private Dimension bounds = new Dimension(50, 50);
    
    private Rectangle clipping;
        
    private FontManager fm;
    
    private TimesTable table;
    
    private int question;
    
    public EquationManager(TimesTable table, int question, FontManager fm){
        this.table = table;
        this.question = question;
        this.fm = fm;
    }
    
    public void drawAnswer(Graphics2D g){
        if (!hit){            
            table.getTimesTable().get(getQuestion()).setAnswerLocation(getAnswerLocation());
            table.getTimesTable().get(getQuestion()).updateAnswer(fm);
            table.getTimesTable().get(getQuestion()).drawAnswer(g);
        }
                
        setClipping(new Rectangle(new Point(
                 getAnswerLocation().x - bounds.width / 2, 
                 getAnswerLocation().y - bounds.height / 2), 
                 bounds));               
    }
    
    public void drawQuestion(Graphics2D g){
        if (!hit){            
            table.getTimesTable().get(getQuestion()).setQuestionLocation(getQuestionLocation());
            table.getTimesTable().get(getQuestion()).updateQuestion(fm);
            table.getTimesTable().get(getQuestion()).drawQuestion(g);
        }
                
        setClipping(new Rectangle(new Point(
                 getAnswerLocation().x - bounds.width / 2, 
                 getAnswerLocation().y - bounds.height / 2), 
                 bounds));             
    }
    
    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean isCorrect) {
        this.correct = isCorrect;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean isHit) {
        this.hit = isHit;
    }
    
    public TimesTable getTable() {
        return table;
    }

    public void setTable(TimesTable table) {
        this.table = table;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public Rectangle getClipping() {
        return clipping;
    }

    public void setClipping(Rectangle clipping) {
        this.clipping = clipping;
    }

    public Point getAnswerLocation() {
        return answerLocation;
    }

    public void setAnswerLocation(Point answerLocation) {
        this.answerLocation = answerLocation;
    }

    public Point getQuestionLocation() {
        return questionLocation;
    }

    public void setQuestionLocation(Point questionLocation) {
        this.questionLocation = questionLocation;
    }
}
