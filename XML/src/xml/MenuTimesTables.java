
package xml;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import xml.Game.Display;

/**
 *
 * @author rNdm
 */
public class MenuTimesTables{
    private Point mousepoint = new Point();
    
    private Desyrel[] gameMenu;
    private Desyrel[] stage;
    
    private Desyrel[] choose;
    private Desyrel a;
    private Desyrel[] table;
    
    private ArrayList<Rectangle> rects;
    
    String[] tableItems = {"Three","Four","Six","Seven","Eight","Nine"};
    
    String selectedItem = "";
    
    private Equation[] menuItems = new Equation[tableItems.length];
//    private Equation four;
//    private Equation six;
//    private Equation seven;
//    private Equation eight;
//    private Equation nine;
    
    private Dimension[] menuItemSizes = new Dimension[tableItems.length];
//    private Dimension fourSize;
//    private Dimension sixSize;
//    private Dimension sevenSize;
//    private Dimension eightSize;
//    private Dimension nineSize;
            
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
            
            for (int i = 0; i < tableItems.length; i++) {
                menuItems[i] = new Equation(new Object[]{tableItems[i],""});
                menuItems[i].updateQuestion(fm);            
                menuItemSizes[i] = menuItems[i].getQuestionSize();
            }
            
            
            
    }
    
    public void update(Graphics2D g, Dimension d, Point mousePoint, Game game){
        this.mousepoint = mousePoint;
        updateStage(d, g);
        updateChoose(d, g);
                        
        rects = new ArrayList<>();
        
        Point[][] p = new Point[2][3];
        
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 3; x++) {
                p[y][x] = new Point((d.width / 2 - 450) + (300 * x), 250 + (200 * y));
                rects.add(new Rectangle(p[y][x], new Dimension(300,200)));
            }            
        }
        
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].setQuestionLocation(new Point(
                    (rects.get(i).x + (rects.get(i).width / 2) - menuItemSizes[i].width / 2), 
                    (rects.get(i).y + (rects.get(i).height / 2) - menuItemSizes[i].height / 2)
            ));
            
            menuItems[i].drawQuestion(g);
            
            if (rects.get(i).contains(mousepoint)) {
                
                if (!selectedItem.equals(menuItems[i].getQuestion())) {
                    game.menu = Display.PLAY;
                    game.setLevel(getLevel(menuItems[i].getQuestion()));
                }
                
                selectedItem = menuItems[i].getQuestion();
            }
        }                  
    }
    
    private int getLevel(String item){
        switch(item){
            case "Three":
                return 0;
            case "Four":
                return 1;
            case "Six":
                return 2;
            case "Seven":
                return 3;
            case "Eight":
                return 4;
            case "Nine":
                return 5;
            default:
                return 6;
        }
    }
    
    private void updateChoose(Dimension d, Graphics2D g) {
        Point p = new Point((d.width / 2) - 380, 150);
        
        if (choose != null) {
            for (int i = 0; i < choose.length; i++) {
                choose[i].update();
                choose[i].setCentre(new Point(p.x + (40 * i), p.y));            
                choose[i].draw(g);
            }
            
            a.update();
            a.setCentre(new Point(p.x + 300, p.y));
            a.draw(g);
            
            for (int i = 0; i < table.length; i++) {
                table[i].update();
                table[i].setCentre(new Point((p.x + 400) + (40 * i), p.y));            
                table[i].draw(g);
            }
        }
    }
    private void updateStage(Dimension d, Graphics2D g) {
        if (stage != null) {
            for (int i = 0; i < stage.length; i++) {
                stage[i].update();
                stage[i].setCentre(new Point(((d.width / 2) - 120) + (40 * i),
                        50
                ));
            
                stage[i].draw(g);
            }
        }
    }
}
