package pemotegame.HandlerClasses;

import pemotegame.Bird;
import pemotegame.Constants;
import pemotegame.Game;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Created by
 * Adam Charlton
 */
public class ComponentHandler implements ComponentListener{
    private final Game game;
    public ComponentHandler(Game game){
        this.game = game;
    }

    //<editor-fold defaultstate="collapsed" desc=" COMPONENT ">
    @Override
    public void componentResized(ComponentEvent ce) {

        game.w = game.superBirdiePoop.getWidth();
        game.h = game.superBirdiePoop.getHeight();

        float scale = game.h / Constants.DEFAULT_SCREEN_Y_SIZE;

        game.hero.clip.width = Constants.PLAYER_WIDTH * scale;
        game.hero.clip.height = Constants.PLAYER_HEIGHT * scale;

        for (Bird bird: game.birds) bird.clip.width = Constants.PLAYER_WIDTH * scale;
        for (Bird bird: game.birds) bird.clip.height = Constants.PLAYER_HEIGHT * scale;

        //game.hero.speed.x = Constants.PLAYER_SPEED * scale;
        game.hero.jumpSpeed = Constants.DEFAULT_JUMPSPEED * scale;

        game.ground = Constants.GROUND_HEIGHT * scale;

        game.hero.clip.y = game.superBirdiePoop.getHeight() - Game.ground - game.hero.clip.height;
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
