
package xml;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author rNdm
 */
public class MenuTimesTables {
    private Desyrel[] gameMenu;
    private Desyrel[] stage;
    
    private Desyrel[] choose;
    private Desyrel a;
    private Desyrel[] table;
    
    private Desyrel[] three;
    private Desyrel[] four;
    private Desyrel[] six;
    private Desyrel[] seven;
    private Desyrel[] eight;
    private Desyrel[] nine;
    
    Equation e;
    
    class Menu{
        private Rectangle clipping;
        
        private Desyrel[] three;
        
        public Menu(){
            
        }
        
        public void update(Graphics2D g){
            
        }
    }
    
    public MenuTimesTables(FontManager fm){
            choose = new Desyrel[]{
                fm.getLetter("C"),
                fm.getLetter("h"),
                fm.getLetter("o"),
                fm.getLetter("o"),
                fm.getLetter("s"),
                fm.getLetter("e")
            };
            
            a = fm.getLetter("a");
            
            table = new Desyrel[]{
                fm.getLetter("T"),
                fm.getLetter("i"),
                fm.getLetter("m"),
                fm.getLetter("e"),
                fm.getLetter("s"),
                fm.getLetter("T"),
                fm.getLetter("a"),
                fm.getLetter("b"),
                fm.getLetter("l"),
                fm.getLetter("e"),
                fm.getLetter(":")
            };
            
            stage = new Desyrel[]{
                fm.getLetter("S"),
                fm.getLetter("T"),
                fm.getLetter("A"),
                fm.getLetter("G"),
                fm.getLetter("E"),
                fm.getLetter("6")
            };
            
            e = new Equation(new Object[]{"three",""});
            e.updateQuestion(fm);
    }
    
    public void update(Graphics2D g, Dimension d){
        updateStage(d, g);
        updateChoose(d, g);
        
        e.setQuestionLocation(new Point(d.width / 2, d.height / 2));
        //e.drawQuestion(g);
        
        ArrayList<Rectangle> rects = new ArrayList<>();
        
        Point[][] p = new Point[2][3];
        
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 3; x++) {
                p[y][x] = new Point((d.width / 2 - 450) + (300 * x), (d.height / 2) + (200 * y));
                rects.add(new Rectangle(p[y][x], new Dimension(300,200)));
            }            
        }
        
        for(Rectangle r: rects){
            g.draw(r);
        }        
    }
    
    private void updateChoose(Dimension d, Graphics2D g) {
        Point p = new Point((d.width / 2) - 380, 400);
        
        if (choose != null) {
            for (int i = 0; i < choose.length; i++) {
                choose[i].update();
                choose[i].setCentre(new Point(p.x + (40 * i), 400));            
                choose[i].draw(g);
            }
            
            a.update();
            a.setCentre(new Point(p.x + 300, p.y));
            a.draw(g);
            
            for (int i = 0; i < table.length; i++) {
                table[i].update();
                table[i].setCentre(new Point((p.x + 400) + (40 * i), 400));            
                table[i].draw(g);
            }
        }
    }
    private void updateStage(Dimension d, Graphics2D g) {
        if (stage != null) {
            for (int i = 0; i < stage.length; i++) {
                stage[i].update();
                stage[i].setCentre(new Point(((d.width / 2) - 120) + (40 * i),
                        200
                ));
            
                stage[i].draw(g);
            }
        }
    }
}
