
package xml;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author rNdm
 */
public class Answer {
    private boolean correct;
    private boolean hit;
    
    private Point location = new Point();
    
    private Dimension bounds = new Dimension(50, 50);
    
    private Rectangle clipping;
        
    private FontManager fm;
    
    private TimesTable table;
    
    private int question;
    
    public Answer(TimesTable table, int question, FontManager fm){
        this.table = table;
        this.question = question;
        this.fm = fm;
    }
    
    public void drawAnswer(Graphics2D g){
        if (!hit){            
            table.getTimesTable().get(getQuestion()).setAnswerLocation(location);
            table.getTimesTable().get(getQuestion()).updateAnswer(fm);
            table.getTimesTable().get(getQuestion()).drawAnswer(g);
        }
                
        setClipping(new Rectangle(new Point(
                 location.x - bounds.width / 2, 
                 location.y - bounds.height / 2), 
                 bounds));
                
        //g.draw(getClipping());                
    }
    
    public void drawQuestion(Graphics2D g){
        if (!hit){            
            table.getTimesTable().get(getQuestion()).setQuestionLocation(new Point((1366 / 2) - (40 / 2), 768 - 50));
            table.getTimesTable().get(getQuestion()).updateQuestion(fm);
            table.getTimesTable().get(getQuestion()).drawQuestion(g);
        }
                
        setClipping(new Rectangle(new Point(
                 location.x - bounds.width / 2, 
                 location.y - bounds.height / 2), 
                 bounds));
                
        //g.draw(getClipping());                
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

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
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
}
