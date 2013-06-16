
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
                case MENU:
                    game.moveBackground();
                    game.getBird().move(game.getMousePointer());
                    break;
                case PLAY:
                    game.updateHitDetection();
                    
                    game.moveBackground();
                    //game.updateQuestionAnswers();
                    //game.updateCorrectAnswer();
                    game.moveAnswers(); 
                    
                    game.getBird().move(game.getMousePointer());
                    break;
                    
                case CORRECT:
//                    game.moveBackground();
//                    game.getBird().move(game.getMousePointer());
//                    game.hitDetection();
                    break;
                case END:
                    game.moveBackground();
                    game.getBird().move(game.getMousePointer());
                    break;            
            }
        try{
            
        }catch(Exception e){} 
    }
}
