package pemotegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 * Adam Charlton
 */
public class UpdateRectangles implements ActionListener {
    private Game game;
    private long updateTime;

    public UpdateRectangles(Game game){
        this.game = game;
        this.updateTime = System.currentTimeMillis();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getWhen() - updateTime > Constants.UPDATE_INTERVAL) {
            game.player.update();
            game.player.bounds();

            for(Poop poop: game.poops){
                poop.update();
                poop.bounds();
            }

            for(Computer comp: game.pedestrian){
                comp.update();
                comp.bounds();
            }

            updateTime = e.getWhen();
        }

        if(game.vsync)game.repaint();

        try {
            e.wait(10);
        } catch (Exception ex) {}
    }
}
