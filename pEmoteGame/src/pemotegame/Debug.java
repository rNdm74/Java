package pemotegame;

import java.awt.*;

/**
 * Created by
 * Adam Charlton
 */
public class Debug {
    public static Point point = new Point();
    private Graphics2D g;
    private final Game game;

    public Debug(Game game) {
        this.game = game;
    }

    public void invoke(Graphics2D g) {
        //new SpeechBubble(new Rectangle(50, 100, 50, 50), s, g, new Point(100,0));
        g.setColor(Color.RED.darker());
        //g.drawString("DEBUG", 20, 20);
        g.drawString("RESOLUTION", 20, 20);
        g.drawString("width=" + String.valueOf(game.superBirdiePoop.getWidth()) + "," +
                     "height=" + String.valueOf(game.superBirdiePoop.getHeight()), 150, 20);

        g.drawString("FPS", 20, 50);
        g.drawString(String.valueOf(game.fps), 150, 50);

        g.drawString("PLAYER POSITION", 20, 100);
        g.drawString("x=" + String.valueOf((int)game.hero.clip.getCenter().getX()) + ",y=" + String.valueOf((int)game.hero.clip.getCenter().getY()), 150, 100);

        g.drawString("MOUSE POINT", 20, 125);
        g.drawString("x=" + String.valueOf((int)point.getX()) + ",y=" + String.valueOf((int)point.getY()), 150, 125);

        g.drawString("F4  BOUNDS", 20, 175);
        g.drawString((game.showBounds) ? "ON" : "OFF", 150, 175);

        g.drawString("F3  LINES", 20, 200);
        g.drawString((game.showLines) ? "ON" : "OFF", 150, 200);

        g.drawString("F2  V-SYNC", 20, 225);
        g.drawString((game.vsync) ? "ON" : "OFF", 150, 225);

        g.drawString("F1  ANTI-ALIASING", 20, 250);
        g.drawString((game.alias) ? "ON" : "OFF", 150, 250);
    }
}
