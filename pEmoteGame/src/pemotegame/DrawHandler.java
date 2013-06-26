package pemotegame;

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

        //PLAYER
        game.player.draw(g);

//        //POOP
//        g.setColor(Color.DARK_GRAY);
//        for (Poop poop : game.poops) {
//            poop.draw(g);
//        }

        // COMPUTER
        for (Computer comp : game.pedestrian) {
            comp.draw(g);
            if (comp.playerInBounds) {
                if(game.showLines)
                    g.drawLine(
                            (int) game.player.center.getX(),
                            (int) game.player.center.getY(),
                            (int) comp.center.getX(),
                            (int) comp.center.getY()
                    );
            }
        }

        //GROUND
        g.setColor(Color.ORANGE.darker());
        g.drawLine(0, game.getHeight() - (int)game.ground, game.getWidth(), game.getHeight() - (int)game.ground);

        //MOUSE CURSOR
        if (!exited)g.drawRect((int)point.getX()-8, (int)point.getY()-30, 5, 5);

        g.dispose();
    }
}
