
package S6TimesTables;

import java.applet.AudioClip;
import javax.swing.JApplet;

/**
 *
 * @author rNdm
 */
public class MainApp extends JApplet {
    public static AudioClip music;
    
    private AudioClip back;
    private AudioClip select;
    private AudioClip validate;
    private AudioClip newLevel;
    private AudioClip wrong;
    private AudioClip bird;    
    private AudioClip eat;
        
    //<editor-fold defaultstate="collapsed" desc=" Applet Overrides ">
    @Override
    public void init() {        
        
        setSize(800, 600);
        setPreferredSize(getSize());
        setFocusable(true);
        requestFocusInWindow();
                
        back = getAudioClip(getClass().getResource("back.wav"));
        select = getAudioClip(getClass().getResource("select.wav"));
        validate = getAudioClip(getClass().getResource("validate.wav"));
        bird = getAudioClip(getClass().getResource("wing_flap.wav")); 
        newLevel = getAudioClip(getClass().getResource("level.wav"));
        wrong = getAudioClip(getClass().getResource("wrong.wav"));
        music = getAudioClip(getClass().getResource("music.wav"));
        eat = getAudioClip(getClass().getResource("eat.wav"));
                
        Object[] setup = {
            this,
            bird,
            eat,
            newLevel,
            wrong,
            back,
            select,
            validate
        };
        
        setContentPane(new Game(setup));
        
    }
    
    @Override
    public void start() {
        requestFocusInWindow();
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

    public AudioClip getMusic() {
        return music;
    }
}
