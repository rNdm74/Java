
package pemotegame;

/**
 *
 * @author rNdm
 */
public class Pause {
    private final Computer comp;
    
    public Pause(Computer comp){
        this.comp = comp;
    }
        
    public boolean start(int waitTime, long trigger){
        long moveTime = System.currentTimeMillis() - trigger;         
        //COMPUTER STOP
        comp.speedX = 0f;
                 
        //COMPUTER START
        if (moveTime > waitTime) { 
            //System.out.println("start");
            comp.speedX = 1f;
            return true;
        }
                
        return false;
    }
    
}
