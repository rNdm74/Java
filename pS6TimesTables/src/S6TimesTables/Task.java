
package S6TimesTables;

import static S6TimesTables.Game.Display.END;
import static S6TimesTables.Game.Display.MENU;
import static S6TimesTables.Game.Display.PLAY;
import java.util.TimerTask;

/**
 *
 * @author Adam Charlton
 */
public class Task extends TimerTask {
    private Game game;    
    
    public Task(Game g){ 
        this.game = g;
    }
    
    @Override
    public void run() {  
        switch(game.menu){
                case TITLE:
                    game.moveBackground();
                    game.clickPlay();
                    game.getBird().move(game.getMousePointer());
                    game.birdPoop();
                break;
                case MENU:
                    game.moveBackground();
                    game.mainMenu.updateSelectTimesTableItem();
                    game.getBird().move(game.getMousePointer());
                    game.birdPoop();
                    break;
                case PLAY:
                    if (!game.currentlyColliding) game.updateHitDetection();
                    
                    game.checkAnswersLocation();
                    
                    game.moveBackground();
                    
                    game.clickMenu();
                    
                    game.moveAnswers(); 
                    
                    game.getBird().move(game.getMousePointer());
                    
                    game.birdPoop();
                    break;                                        
                case END:
                    game.moveBackground();
                    
                    game.clickMenu();
                    
                    game.getBird().move(game.getMousePointer());
                    
                    game.birdPoop();
                    break;            
            }
        try{
            
        }catch(Exception e){} 
    }
}
