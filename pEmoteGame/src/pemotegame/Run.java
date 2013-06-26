package pemotegame;


import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by
 * Adam Charlton
 */
public class Run implements Runnable{
    private ActionListener actionListener;

    public Run(ActionListener actionListener){
        this.actionListener = actionListener;
    }

    @Override
    public void run() {
        Timer timer = new Timer(Constants.TIMER_INTERVAL, actionListener);
        timer.start();
    }
}
