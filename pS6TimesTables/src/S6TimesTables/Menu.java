
package S6TimesTables;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import S6TimesTables.Game.Display;

/**
 *
 * @author rNdm
 */
public class MenuTimesTables{
    private Point mousepoint = new Point();
    
    private Desyrel[] stage;    
    private Desyrel[] choose;
    private Desyrel a;
    private Desyrel[] table;
    
    private ArrayList<Rectangle> rects;
    
    String[] tableItems = {"Three","Four","Six","Seven","Eight","Nine"};
    
    String selectedItem = "";
    
    private Equation[] menuItems = new Equation[tableItems.length];    
    private Dimension[] menuItemSizes = new Dimension[tableItems.length];
            
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
                fm.getLetter("e")
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
                menuItems[i] = new Equation(new Object[]{tableItems[i].toUpperCase(),""});
                menuItems[i].updateQuestion(fm);            
                menuItemSizes[i] = menuItems[i].getQuestionSize();
            }
            
            
            
    }
    
    public void update(Graphics2D g, Dimension d, Point mousePoint, Game game){
        this.mousepoint = mousePoint;
        updateMenuItems(d, g, game);
        game.updateBird(g);
        updateStage(d, g);
        updateChoose(d, g);
    }
    
    private int getLevel(String item){
        switch(item.toLowerCase()){
            case "three":
                return 0;
            case "four":
                return 1;
            case "six":
                return 2;
            case "seven":
                return 3;
            case "eight":
                return 4;
            case "nine":
                return 5;
            default:
                return 6;
        }
    }
    
    private void updateChoose(Dimension d, Graphics2D g) {
        Point p = new Point((d.width / 2) - 380, 250);
        
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
                        100
                ));
            
                stage[i].draw(g);
            }
        }
    }

    private void updateMenuItems(Dimension d, Graphics2D g, Game game) {
        rects = new ArrayList<>();
        
        Point[][] p = new Point[2][3];
        
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 3; x++) {
                p[y][x] = new Point(
                        (d.width / 2 - 350) + (300 * x),
                        400 + (200 * y));
                
                rects.add(new Rectangle(p[y][x], new Dimension(200,50)));
                
            }            
        }
        
        for (int i = 0; i < menuItems.length; i++) {
            //g.draw(rects.get(i));
            
            menuItems[i].setQuestionLocation(new Point(
                    (rects.get(i).x + (rects.get(i).width / 2) - (menuItemSizes[i].width / 2)), 
                    ((rects.get(i).y + (rects.get(i).height / 2) - (menuItemSizes[i].height / 2)) + 30)
            ));
            
            menuItems[i].drawQuestion(g);
            
            if (rects.get(i).contains(mousepoint) &&
                game.getClipping().intersects(rects.get(i))) {
                
                if (!selectedItem.equals(menuItems[i].getQuestion())) {
                    game.menu = Display.PLAY;
                    game.setMousePointer(new Point(150, 768 / 2));
                    Run.music.loop();
                    int level = getLevel(menuItems[i].getQuestion());
                    game.setPlayerScore(0);
                    game.setLevel(level);
                    game.setTable(game.getTimesTables().get(level));                    
                }
                
                selectedItem = menuItems[i].getQuestion();
            }
        }
    }
}
