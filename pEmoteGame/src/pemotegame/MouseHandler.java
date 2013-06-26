package pemotegame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * Created by
 * Adam Charlton
 */
public class MouseHandler implements Serializable, MouseListener, MouseMotionListener {
    private final Game game;

    public MouseHandler(Game game) {
        this.game = game;
    }

    //<editor-fold defaultstate="collapsed" desc=" MOUSE ">
    @Override
    public void mouseClicked(MouseEvent me) {
    }
    @Override
    public void mousePressed(MouseEvent me) {
        Point2D p2d = me.getPoint();
        game.player.p.setLocation(p2d.getX() - 8, p2d.getY() - 30);
    }
    @Override
    public void mouseReleased(MouseEvent me) {
    }
    @Override
    public void mouseEntered(MouseEvent me) {
        game.drawHandler.exited = false;
    }
    @Override
    public void mouseExited(MouseEvent me) {
        game.drawHandler.exited = true;
    }
    @Override
    public void mouseDragged(MouseEvent me) {
    }
    @Override
    public void mouseMoved(MouseEvent me) {
        Debug.point = me.getPoint();
        game.drawHandler.point = me.getPoint();
    }
    //</editor-fold>

}
