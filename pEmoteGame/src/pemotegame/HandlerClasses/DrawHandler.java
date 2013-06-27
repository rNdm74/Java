package pemotegame.HandlerClasses;

import pemotegame.Game;

import java.awt.*;

/**
 * Created by
 * Adam Charlton
 */
public class DrawHandler {
    public static Point point = new Point();
    public static boolean exited;
    private final Game game;

    public DrawHandler(Game game){
        this.game = game;
    }
    public void invoke(Graphics2D g) {
        g.setColor(Color.WHITE);

        game.world.draw(g);

        g.drawLine(
            (int) game.hero.clip.getCenter().getX(),
            (int) game.hero.clip.getCenter().getY(),
            (int) point.getX()-(int)6.5,
            (int) point.getY()-(int)28.5
        );


        //GROUND
        g.setColor(Color.ORANGE.darker());
        g.fillRect(0, game.superBirdiePoop.getHeight() - (int)game.ground, game.getWidth(), game.superBirdiePoop.getHeight() - (int)game.ground);

        //MOUSE CURSOR
        if (!exited)g.drawRect((int)point.getX()-8, (int)point.getY()-30, 5, 5);

        g.dispose();
    }
}
