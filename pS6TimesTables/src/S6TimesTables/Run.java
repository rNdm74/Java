
package S6TimesTables;

import java.applet.AudioClip;
import javax.swing.JApplet;

/**
 *
 * @author rNdm
 */
public class Run extends JApplet {
    private AudioClip bird;
    public static AudioClip music;
    private AudioClip eat;
    private AudioClip newLevel;
    private AudioClip wrong;
        
    //<editor-fold defaultstate="collapsed" desc=" Applet Overrides ">
    @Override
    public void init() {        

        setSize(1366, 768);
        setFocusable(true);
        requestFocusInWindow();
        
        
        bird = getAudioClip(getClass().getResource("wing_flap.wav"));        
        music = getAudioClip(getClass().getResource("music.wav"));
        eat = getAudioClip(getClass().getResource("eat.wav"));
        newLevel = getAudioClip(getClass().getResource("level.wav"));
        wrong = getAudioClip(getClass().getResource("wrong.wav"));
        
        Object[] sounds = {
            bird,
            eat,
            newLevel,
            wrong
        };
        
        setContentPane(new Game(this, sounds));
    }
    
    @Override
    public void start() {
        this.requestFocusInWindow();
        //getMusic().loop();        
    }
    
    @Override
    public void stop(){
        bird.stop();
        getMusic().stop();
        eat.stop();
        newLevel.stop();
        wrong.stop();
    }
    
    @Override
    public void destroy(){}
    //</editor-fold>    

    public AudioClip getMusic() {
        return music;
    }

}
