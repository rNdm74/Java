
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
                Point p = new Point(500,  50 + (90 * y));
                rects.add(new Rectangle(p, new Dimension(250,50)));                
            }
            
            choose = lm.choose;            
            
            menuItems = lm.menuLabels;   
    }
    
    public void update(Graphics2D g, Point mousePoint){
        this.mousepoint = mousePoint;
        
        updateMenuItems(g);
        
        updateChoose(g);
        
        game.drawBird(g);
    }
        
    private void updateChoose(Graphics2D g) {
        Point p = new Point(50, 50);
        for (int i = 0; i < choose.size(); i++) {
            choose.get(i).update();
            choose.get(i).setCenter(new Point((p.x) + (40 * i), p.y));            
            choose.get(i).draw(g);
        }
    }
    
    private void updateMenuItems(Graphics2D g) {         
        for (int i = 0; i < menuItems.size(); i++) {
            for (int c = 0; c < menuItems.get(i).size(); c++) {
                menuItems.get(i).get(c).update();
                menuItems.get(i).get(c).setCenter(new Point(
                        (rects.get(i).x + (rects.get(i).width / 2) - 80) + (40 * c), 
                         rects.get(i).y + 25));
            
                menuItems.get(i).get(c).draw(g);  
                //g.draw(rects.get(i));
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
        for (int i = 0; i < rects.size(); i++) {
            if(rects.get(i).contains(me.getPoint()) && 
              (game.display.equals(Display.MENU))){   
                Point p = rects.get(i).getLocation();
                game.getBird().birdCenter.setLocation(p.x - 100, p.y);
            }
        }
                
        for (int i = 0; i < menuItems.size(); i++) {
            if(new CollisionDetection().pointContained(me.getPoint(), rects.get(i)) &&
                game.display.equals(Display.MENU)){  
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
        for (int i = 0; i < rects.size(); i++) {
            if (rects.get(i).contains(me.getPoint()) && game.display.equals(Display.MENU)) {                
                game.validateSound.play();
                
                game.pickedTimesTable = i * 12;
                
                int[] wrongAnswers = game.pickRandomAnswer();
                game.wrongAnswer1 = wrongAnswers[0];
                game.wrongAnswer2 = wrongAnswers[1];
                
                game.answeredFalse = false;
                game.answeredTrue = false;
                                
                game.resetAnswersPosition();
                     
                game.setPlayerScore(0);
                
                game.getBird().birdCenter.setLocation(new Point(150, 300));
                game.setMousePointer(new Point(150, 300));
                
                MainApp.music.loop();
                
                game.display = Display.PLAY;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {        
        //mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent me) {
         //mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
