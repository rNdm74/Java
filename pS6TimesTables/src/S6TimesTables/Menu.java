
package S6TimesTables;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import S6TimesTables.Game.Display;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author rNdm
 */
public class Menu implements MouseMotionListener, MouseListener{
    private final Point resetPosition = new Point(-50, -50);
    
    private Point mousepoint = new Point();
    private Point mousePosition = new Point();
    private boolean mousePressed = false;
    
    private Desyrel[] stage; 
    private Desyrel[] table;
    
    private ArrayList<Rectangle> rects;
    
    String[] tableItems = {"3","4","6","7","8","9"};    
    String selectedItem = "";
    
    private Equation[] menuItems = new Equation[tableItems.length];    
    private Dimension[] menuItemSizes = new Dimension[tableItems.length];
    
    private Game game;
    private Dimension d;    
    
    private Desyrel selectLeft;
    private Desyrel selectRight;
            
    public Menu(FontManager fm, Game game){
            this.game = game;
            d = game.getContentPaneDimensions();
            
            rects = new ArrayList<>();

            for (int y = 0; y < 6; y++) {  
                Point p = new Point(800 - 100,  50 + (90 * y));
                rects.add(new Rectangle(p, new Dimension(50,50)));
            }
            
            selectLeft = fm.getLetter("[");
            selectRight = fm.getLetter("]");
            
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
                fm.getLetter("s"),
            };
            
            stage = new Desyrel[]{
                fm.getLetter("S"),
                fm.getLetter("t"),
                fm.getLetter("a"),
                fm.getLetter("g"),
                fm.getLetter("e"),
                fm.getLetter("-"),
                fm.getLetter("6")
            };
            
            for (int i = 0; i < tableItems.length; i++) {
                menuItems[i] = new Equation(new Object[]{tableItems[i].toUpperCase(),""});
                menuItems[i].updateQuestion(fm);            
                menuItemSizes[i] = menuItems[i].getQuestionSize();
            }            
    }
    
    public void update(Graphics2D g, Point mousePoint){
        this.mousepoint = mousePoint;
        
        updateMenuItems(g);
        updateChoose(g);
        updateStage(g);
        
        if (!mousePressed)updateSelect(g);
        
        game.drawBird(g);
    }
    
    private int getLevel(String item){
        switch(item.toLowerCase()){
            case "3":
                return 0;
            case "4":
                return 1;
            case "6":
                return 2;
            case "7":
                return 3;
            case "8":
                return 4;
            case "9":
                return 5;
            default:
                return 6;
        }
    }
    
    private void updateSelect(Graphics2D g) {       
        
        if (selectRight != null) {
            selectRight.update(); 
            selectRight.setCentre(resetPosition);
            selectRight.draw(g);
        }
        
        if (selectLeft != null) {
            selectLeft.update();
            selectLeft.setCentre(resetPosition);
            selectLeft.draw(g);
        }
    }
    
    private void updateChoose(Graphics2D g) {
        Point p = new Point(50, d.height - 50);
        
        if (table != null) {
            for (int i = 0; i < table.length; i++) {
                table[i].update();
                table[i].setCentre(new Point((p.x) + (40 * i), p.y));            
                table[i].draw(g);
            }
        }
    }
    
    private void updateStage(Graphics2D g) {
        if (stage != null) {
            for (int i = 0; i < stage.length; i++) {
                stage[i].update();
                stage[i].setCentre(new Point((50) + (40 * i),
                        d.height - 150
                ));
            
                stage[i].draw(g);
            }
        }
    }

    private void updateMenuItems(Graphics2D g) { 
        for (int i = 0; i < menuItems.length; i++) {
            if(rects.get(i).contains(mousePosition)){
                Point leftPoint = new Point(rects.get(i).x  - 20, rects.get(i).y + 25);
                Point rightPoint = new Point(rects.get(i).x  + 90, rects.get(i).y + 25);
                selectLeft.setCentre(leftPoint);
                selectRight.setCentre(rightPoint);
            }
        }
        
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].setQuestionLocation(new Point(
                    (rects.get(i).x + (rects.get(i).width / 2) - (menuItemSizes[i].width / 2) + 30), 
                    ((rects.get(i).y + (rects.get(i).height / 2) - (menuItemSizes[i].height / 2)) + 30)
            ));
            
            menuItems[i].drawQuestion(g);
            
            if (rects.get(i).contains(mousepoint) &&
                game.getBird().getClipping().intersects(rects.get(i))) {
                
                
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

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        mousePosition = me.getPoint();        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent me) {
         mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
