
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
    
    private ArrayList<GameText> stage; 
    private ArrayList<GameText> choose;
    private ArrayList<ArrayList<GameText>> menuItems;
    
    private ArrayList<Rectangle> rects;
    
    private boolean hover = false;
    
    private Game game;
    private Dimension d;    
    
    private GameText selectLeft;
    private GameText selectRight;
            
    public Menu(FontManager fm, LabelManager lm, Game game){
            this.game = game;
            d = game.getContentPaneDimensions();
            
            rects = new ArrayList<>();

            for (int y = 0; y < 6; y++) {  
                Point p = new Point(400,  50 + (90 * y));
                rects.add(new Rectangle(p, new Dimension(250,50)));                
            }
            
            selectLeft = fm.getLetter('>');
            selectRight = fm.getLetter('<');
            choose = lm.choose;            
            //stage = lm.choose;
            menuItems = lm.menuLabels;   
    }
    
    public void update(Graphics2D g, Point mousePoint){
        this.mousepoint = mousePoint;
        
        updateMenuItems(g);
        
        updateChoose(g);
        //updateStage(g);
        
        if (!mousePressed)updateSelect(g);
        
        game.drawBird(g);
    }
    
    private void updateSelect(Graphics2D g) {       
        
        if (selectRight != null) {
            selectRight.update(); 
            selectRight.setCenter(resetPosition);
            selectRight.draw(g);
        }
        
        if (selectLeft != null) {
            selectLeft.update();
            selectLeft.setCenter(resetPosition);
            selectLeft.draw(g);
        }
    }
    
    private void updateChoose(Graphics2D g) {
        Point p = new Point(50, 50);
        
        if (choose != null) {
            for (int i = 0; i < choose.size(); i++) {
                choose.get(i).update();
                choose.get(i).setCenter(new Point((p.x) + (40 * i), p.y));            
                choose.get(i).draw(g);
            }
        }
    }
    
    private void updateStage(Graphics2D g) {
        if (stage != null) {
            for (int i = 0; i < stage.size(); i++) {
                stage.get(i).update();
                stage.get(i).setCenter(new Point((50) + (40 * i),
                        d.height - 150
                ));
            
                stage.get(i).draw(g);
            }
        }
    }
    
    public void updateSelectTimesTableItem(){
        for (int i = 0; i < menuItems.size(); i++) {                        
            if(rects.get(i).contains(mousePosition)){                
                //Point leftPoint = new Point(rects.get(i).x  - 25, rects.get(i).y + 25);
                Point rightPoint = new Point(rects.get(i).x  + 275, rects.get(i).y + 25);
                //selectLeft.setCenter(leftPoint);
                selectRight.setCenter(rightPoint);
            }
            
            if (rects.get(i).contains(mousepoint)) {                
                game.validateSound.play();
                
                game.pickedTimesTable = i * 12;
                
                int[] wrongAnswers = game.pickRandomAnswer();
                game.wrongAnswer1 = wrongAnswers[0];
                game.wrongAnswer2 = wrongAnswers[1];
                
                game.answeredFalse = false;
                game.answeredTrue = false;
                
                game.menu = Display.PLAY;
                game.resetAnswersPosition();
                     
                game.setMousePointer(new Point(150, 300));
                MainApp.music.loop();
                game.setPlayerScore(0);
                mousepoint = new Point();
            }            
        }
    }

    private void updateMenuItems(Graphics2D g) {         
        for (int i = 0; i < menuItems.size(); i++) {
            for (int c = 0; c < menuItems.get(i).size(); c++) {
                menuItems.get(i).get(c).update();
                menuItems.get(i).get(c).setCenter(new Point(
                        (rects.get(i).x + (rects.get(i).width / 2) - 70) + (40 * c), 
                         rects.get(i).y + 25));
            
                menuItems.get(i).get(c).draw(g);                
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    int previousSelectItem;
    int currentSelectItem;
    
    @Override
    public void mouseMoved(MouseEvent me) {
        mousePosition = me.getPoint(); 
        for (int i = 0; i < menuItems.size(); i++) {
            if(new CollisionDetection().pointContained(mousePosition, rects.get(i)) &&
                game.menu.equals(Display.MENU)){  
                currentSelectItem = i;
                
                if (currentSelectItem != previousSelectItem) {
                    game.selectSound.play();
                }
                
                previousSelectItem = currentSelectItem;
            }
        }
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
