package pemotegame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by
 * Adam Charlton
 */
public class KeyHandler implements KeyListener {
    private KeyEvent e;
    private int choice = 1;
    private Game g;

    public KeyHandler(Game g) {
        this.g = g;
    }

    public void invoke(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            g.poops.add(g.createPoop());
        }

        if (key == KeyEvent.VK_C) {
            g.pedestrian.add(g.createComputer());
        }

        if (key == KeyEvent.VK_B) {
            g.poops.clear();
        }

        if (key == KeyEvent.VK_V) {
            if(!g.pedestrian.isEmpty()) g.pedestrian.clear();
        }

        if (key == KeyEvent.VK_BACK_QUOTE) {
            g.debug = !g.debug;
        }

        if (key == KeyEvent.VK_F1) {
            g.alias = !g.alias;
        }

        if (key == KeyEvent.VK_F2) {
            g.vsync = !g.vsync;
            g.repaint();
        }

        if (key == KeyEvent.VK_F4) {
            g.showBounds = !g.showBounds;
        }

        if (key == KeyEvent.VK_F3) {
            g.showLines = !g.showLines;
        }

        if (key == KeyEvent.VK_ADD) {
            if(choice < 4)choice++;
            g.superBirdiePoop.setSize(changeResolution(choice));
            g.superBirdiePoop.setLocation(Constants.SCREEN_WIDTH/2 - (int)changeResolution(choice).getWidth()/2,
                    Constants.SCREEN_HEIGHT/2 - (int)changeResolution(choice).getHeight()/2);
            g.superBirdiePoop.revalidate();
        }

        if (key == KeyEvent.VK_SUBTRACT) {
            if(choice > 1)choice--;
            g.superBirdiePoop.setSize(changeResolution(choice));
            g.superBirdiePoop.setLocation(Constants.SCREEN_WIDTH / 2 - (int) changeResolution(choice).getWidth() / 2,
                    Constants.SCREEN_HEIGHT / 2 - (int) changeResolution(choice).getHeight() / 2);
            g.superBirdiePoop.revalidate();
        }

        e.consume();
    }

    private Dimension changeResolution(int choice){
        switch (choice){
            case 1:
                return new Dimension(800,600);
            case 2:
                return new Dimension(1024,768);
            case 3:
                return new Dimension(1366,768);
            case 4:
                return new Dimension(1920,1080);
            default:
                return new Dimension(640,480);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        invoke(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
