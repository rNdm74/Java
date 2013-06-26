package pemotegame;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Created by
 * Adam Charlton
 */
public class ComponentHandler implements ComponentListener {
    private final Game game;
    public ComponentHandler(Game game){
        this.game = game;
    }

    //<editor-fold defaultstate="collapsed" desc=" COMPONENT ">
    @Override
    public void componentResized(ComponentEvent ce) {
        game.w = game.superBirdiePoop.getWidth();
        game.h = game.superBirdiePoop.getHeight();

        double scale = (game.h / Constants.DEFAULT_SCREEN_Y_SIZE);

        game.player.width = Constants.PLAYER_WIDTH * scale;
        game.player.height = Constants.PLAYER_HEIGHT * scale;

        game.ground = (100 * scale);

        for (Computer ped : game.pedestrian){

            ped.width = 25 * scale;
            ped.height = 50 * scale;
            ped.y = (game.getHeight() - ped.height - game.ground);

            game.currentPed = new Rectangle(0, (int)ped.y, (int)ped.width, (int)ped.height);
        }
    }
    @Override
    public void componentMoved(ComponentEvent ce) {

    }
    @Override
    public void componentShown(ComponentEvent ce) {

    }
    @Override
    public void componentHidden(ComponentEvent ce) {

    }
    //</editor-fold>
}
