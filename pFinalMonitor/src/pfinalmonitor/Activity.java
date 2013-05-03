
package pfinalmonitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Activity extends JPanel {
    private static Point mouse = new Point(0,0);
    public Polygon2D pg = new Polygon2D();
    public ArrayList<String[]> data;
    public int arraySize;
    public int mouseDragged = 1;
    public int[] xPoints;
    public int[] yPoints;
    
    private int width;
    private int x;

    private JPanel sensorPanel;
    private boolean hover;
    private Color color;

    public Activity(JPanel sensorPanel, ArrayList<String[]> data) throws IOException {
        this.sensorPanel = sensorPanel;
        this.data = data;

        //pg.addPoint(0f, 120f);
        //pg.addPoint(0f, (float)sensorPanel.getHeight());

        Random r = new Random();

        color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        
        setVisible(false);

        addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                hover = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {

                hover = false;
            }
        });        
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                advancedSensorPanelMouseMoved(evt);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                advancedSensorPanelMouseDragged(e);
            }
        });
    }
    
       
    private void advancedSensorPanelMouseDragged(java.awt.event.MouseEvent evt) {
        
        mouseDragged = ((evt.getX() > x) ? 1 : -1);
        x = evt.getX();
        
    }    
    private void advancedSensorPanelMouseMoved(java.awt.event.MouseEvent evt) {
        mouse = evt.getPoint();
    }
    
    @Override
    public void paint(Graphics g){ 
    	width = sensorPanel.getWidth();
        int height = getHeight();
        
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;

//        // for antialiasing geometric shapes
//        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
//            RenderingHints.VALUE_ANTIALIAS_ON );

        // for antialiasing text
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                              RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

        GradientPaint gp;
        //gp = new GradientPaint(0,0,new Color(135, 206, 250),0, 0, new Color(135, 206, 250));
        g2d.setPaint(color);
        g2d.drawRoundRect(1, 2, width - 3, getHeight() - 4, 5, 5);

        g2d.setPaint(Color.BLACK);

        g2d.setStroke(new BasicStroke(2.0f));
        //g2d.drawPolyline(xPoints, yPoints, yPoints.length - 1);

        int[] newYPoints = new int[]{getHeight() - 2, getHeight() - 2};
        int[] yPoly = concat(newYPoints, yPoints);

        int[] newXPoints = new int[]{0, yPoints.length};
        int[] xPoly = concat(newXPoints, xPoints);

        gp = new GradientPaint(0,0,new Color(255, 255, 255), 0, getHeight(), color);
        g2d.setPaint(gp);

        g2d.fillPolygon(xPoly, yPoly, yPoly.length - 1);


        g2d.setStroke(new BasicStroke(1.0f));
                g2d.setColor(Color.DARK_GRAY);

        g2d.setColor(Color.DARK_GRAY);
        Font font = new Font(getFont().getFamily(), Font.PLAIN, 10);
        g2d.setFont(font);

        Rectangle rect = new Rectangle(0, 0, width, height);
        
        g2d.setColor(Color.DARK_GRAY);

        if (rect.contains(mouse)) {
            g2d.setColor(Color.RED.darker());
            g2d.drawLine(mouse.x + 1, 2, mouse.x + 1, getHeight() - 3);
        }

        mouseOver(g2d);

        gp = new GradientPaint(0,0,new Color(255, 255, 255), 0, 25,new Color(135, 206, 250));
        g2d.setPaint(gp);
        //g2d.fillRoundRect(width - 39, 5, 40, 25, 5, 5);

        g2d.setColor(new Color(135, 206, 250, 0xFF));
        //g2d.drawRoundRect(width - 39, 5, 40, 25, 5, 5);
        
        super.repaint();
    }

    static int[] concat(int[] a, int[] b) {
        final int alen = a.length;
        final int blen = b.length;
        final int[] result = (int[]) java.lang.reflect.Array.
                newInstance(a.getClass().getComponentType(), alen + blen);
        System.arraycopy(a, 0, result, 0, alen);
        System.arraycopy(b, 0, result, alen, blen);
        return result;
    }

    private void mouseOver(Graphics2D g2d) {
        GradientPaint gp;
        Font font;        
        if (hover) {
            gp = new GradientPaint(0,-10,new Color(135, 206, 250), 0, getHeight(), new Color(255, 255, 255));
            g2d.setPaint(gp);

            gp = new GradientPaint(0,-10,new Color(255, 255, 255), 0, getHeight(), new Color(255, 255, 255));
            g2d.setPaint(gp);

            gp = new GradientPaint(0, getHeight() / 2,new Color(135, 206, 250,0x30), 0, getHeight(), new Color(255, 255, 255, 0x2A));
            g2d.setPaint(gp);
            g2d.fillRect(0, getHeight() / 2, width, (getHeight() / 2) - 1);

            gp = new GradientPaint(0, getHeight(),new Color(135, 206, 250,0x2F), 0, 0, new Color(255, 255, 255, 0x2A));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, getHeight() / 2);

            gp = new GradientPaint(0,0,new Color(135, 206, 250),0, 0, new Color(135, 206, 250));
            g2d.setPaint(gp);
            g2d.drawRoundRect(1, 2, width-3, getHeight()-4, 5, 5);

            font = new Font(getFont().getFamily(), Font.PLAIN, getHeight() / 10);
            g2d.setFont(font);

            g2d.drawString(data.get(data.size() - 1)[1], 15, 20);

            gp = new GradientPaint(0,0,new Color(135, 206, 250), 0, 25, new Color(255, 255, 255));
            g2d.setPaint(gp);

            gp = new GradientPaint(0,0,new Color(255, 255, 255), 0, getHeight(), new Color(255, 255, 255));
            g2d.setPaint(gp);
            g2d.setColor(Color.white);
            g2d.fillRect(width - 31, 10, 13, 4);
            g2d.setColor(new Color(135, 206, 250));
            g2d.drawRect(width - 31, 10, 13, 4);
        }
    }
}
