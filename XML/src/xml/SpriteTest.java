
package xml;

import java.applet.AudioClip;
import javax.swing.JApplet;

/**
 *
 * @author rNdm
 */
public class SpriteTest extends JApplet {
    private AudioClip bird;
    private AudioClip music;
    private AudioClip eat;
    private AudioClip newLevel;
    private AudioClip wrong;
        
    //<editor-fold defaultstate="collapsed" desc=" Applet Overrides ">
    @Override
    public void init() {
        
        bird = getAudioClip(getDocumentBase(), "wing_flap.wav");
        music = getAudioClip(getDocumentBase(), "music.wav");
        eat = getAudioClip(getDocumentBase(), "eat.wav");
        newLevel = getAudioClip(getDocumentBase(), "level.wav");
        wrong = getAudioClip(getDocumentBase(), "wrong.wav");
        
        Object[] sounds = {
            bird,
            eat,
            newLevel,
            wrong
        };
        
        setContentPane(new Game(sounds));
    }
    
    
        
    @Override
    public void start() {
        this.requestFocusInWindow();
        music.loop();        
    }
    
    @Override
    public void stop(){
        bird.stop();
        music.stop();
        eat.stop();
        newLevel.stop();
        wrong.stop();
    }
    
    @Override
    public void destroy(){}
    //</editor-fold>    
}
