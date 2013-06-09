
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
    private boolean isCorrect;
    private boolean isHit;
    
    private Point location;
    
    private Dimension bounds = new Dimension(50, 50);
    
    Rectangle clipping;
        
    private FontManager fm;
    
    private TimesTable table;
    
    private int question;
    
    public Answer(TimesTable table, int question, FontManager fm){
        this.table = table;
        this.question = question;
        this.fm = fm;
    }
    
    public void update(Graphics2D g){        
        if (!isHit) draw(g);                
    }
    private void draw(Graphics2D g){
        table.getTimesTable().get(question).setAnswerLocation(location);
        table.getTimesTable().get(question).updateAnswer(fm);        
        table.getTimesTable().get(question).drawAnswer(g);
        clipping = new Rectangle(new Point(
                location.x - bounds.width / 2, 
                location.y - bounds.height / 2), 
                bounds);
        
        g.draw(clipping);
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean isIsHit() {
        return isHit;
    }

    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
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
}
