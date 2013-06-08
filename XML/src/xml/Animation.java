
package xml;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author rNdm
 */
class Animation {
    ArrayList<BufferedImage> frames;
    
    BufferedImage sprite;
    
    private volatile boolean running = false;
    
    private long previousTime, speed;
    private int frameAtPause,  currentFrame;
    
    public Animation(ArrayList<BufferedImage> frames){
        this.frames = frames;
    }
    
    public void setSpeed(long speed){
        this.speed = speed;
    }
    
    public void update(long time){
        if(running){
            if (time - previousTime >= speed) {
                // update animation
                currentFrame++;
                try{
                    sprite = frames.get(currentFrame);
                    
                }catch(IndexOutOfBoundsException e){
                    currentFrame = 0;
                    sprite = frames.get(currentFrame);                    
                }                        
                previousTime = time;
            }
        }
    }
    
    public void start(){
        running = true;
        previousTime = 0;
        frameAtPause = 0;
        currentFrame = 0;
    }
    
    public void stop(){
        running = false;
        previousTime = 0;
        frameAtPause = 0;
        currentFrame = 0;
    }
    
    public void pause(){
        frameAtPause = currentFrame;
        //
        running = false;
        
        sprite = frames.get(9);
    }
    
    public void resume(){
        currentFrame = frameAtPause;
        running = true;
    }
}