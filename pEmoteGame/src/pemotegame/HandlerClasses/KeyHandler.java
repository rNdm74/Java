package pemotegame.HandlerClasses;

import pemotegame.Constants;
import pemotegame.Game;

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
    public static long jumpTime = 200l;

    public KeyHandler(Game g) {
        this.g = g;
    }

    public void invokeReleased(KeyEvent e) {
        int key = e.getKeyCode();

        //g.speedVector.x = 0f;

//        if (key == KeyEvent.VK_LEFT) {
//            g.speedVector.x = -1f;
//        }
//        else if (key == KeyEvent.VK_RIGHT) {
//            g.speedVector.x = 1f;
//        }
//        else{
//            g.speedVector.x = 0;
//        }
    }

    class Jump implements Runnable{
        @Override
        public void run() {
            try{
                Thread.sleep(jumpTime);
                g.hero.jumping = false;
            }catch (Exception e){
                e.printStackTrace();
                new Thread(this).start();
                System.exit(0);
            }
        }
    }

    public void invoke(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            g.hero.speed.x = -5f;
        }
        else if (key == KeyEvent.VK_D) {
            g.hero.speed.x = 5f;
        }


        //if (key == KeyEvent.VK_UP && !g.physicalEntity.jumping && g.physicalEntity.isOnGround) {

        //}

        if (key == KeyEvent.VK_DOWN) {

        }

        if (key == KeyEvent.VK_SPACE  && !g.hero.jumping && g.hero.isOnGround) {
            g.hero.jumping = true;
            g.hero.isOnGround = false;
            new Thread(new Jump()).start();
            //g.poops.add(g.createPoop());
        }

        if (key == KeyEvent.VK_C) {
            //g.bird.add(g.createComputer());
        }

        if (key == KeyEvent.VK_B) {
            //g.poops.clear();
        }

        if (key == KeyEvent.VK_V) {
            //if(!g.bird.isEmpty()) g.bird.clear();
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
            if(choice < Constants.AVAILABLE_RESOLUTIONS.size()-1)choice++;

            g.superBirdiePoop.setSize(changeResolution(choice));
            g.superBirdiePoop.setLocation(Constants.SCREEN_WIDTH/2 - (int)changeResolution(choice).getWidth()/2,
                    Constants.SCREEN_HEIGHT/2 - (int)changeResolution(choice).getHeight()/2);
            g.superBirdiePoop.revalidate();
        }

        if (key == KeyEvent.VK_SUBTRACT) {
            if(choice > 0)choice--;
            g.superBirdiePoop.setSize(changeResolution(choice));
            g.superBirdiePoop.setLocation(Constants.SCREEN_WIDTH / 2 - (int) changeResolution(choice).getWidth() / 2,
                    Constants.SCREEN_HEIGHT / 2 - (int) changeResolution(choice).getHeight() / 2);
            g.superBirdiePoop.revalidate();
        }

        e.consume();
    }

    private Dimension changeResolution(int choice){
        return new Dimension(Constants.AVAILABLE_RESOLUTIONS.get(choice).getWidth(),
                             Constants.AVAILABLE_RESOLUTIONS.get(choice).getHeight()
        );
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
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_A) {
            g.hero.speed.x = 0f;
        }

        if (key == KeyEvent.VK_D) {
            g.hero.speed.x = 0f;
        }
    }
}


