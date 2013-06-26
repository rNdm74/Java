package pemotegame;


import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by
 * Adam Charlton
 */
public class Run implements Runnable{
    private final Timer timer;

    public Run(ActionListener actionListener, int updateInterval){
        timer = new Timer(updateInterval, actionListener);
    }

    @Override
    public void run() {
        timer.start();
    }
}
