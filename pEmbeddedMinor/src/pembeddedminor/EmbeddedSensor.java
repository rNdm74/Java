/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pembeddedminor;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rndm
 */
class EmbeddedSensor extends JPanel {
    int i = 0;
    JPanel panel;
    JLabel label;
    
    public int mouse;
    public int mouseDragged = 0;
    public Point cursor = new Point();
    	
    private static int[] xPoints;
    private static int[] yPoints;
    
    private static int[] xPoly;
    private static int[] yPoly;
	
	
    
    public EmbeddedSensor(JPanel panel, JLabel label){
        this.panel = panel;
        this.label = label;
        this.setOpaque(false);
        
        this.setBounds(0, 0, 300, 256);
        
        xPoints = new int[5];
        xPoly = new int[7];
                
        yPoints = new int[]{255, 
                            200, 
                            200,
                            200,
                            200};
        
        yPoly = new int[]{255, 
                          200, 
                          200,
                          200,
                          200,
                            0,
                            0};
        
        this.setBorder(BorderFactory.createEtchedBorder(1));
        
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        
        String value;
        
        xPoints[0] = 0;
        xPoints[1] = 75;
        xPoints[2] = this.getWidth() / 2;
        xPoints[3] = 225;
        xPoints[4] = this.getWidth();
        
        xPoly[0] = xPoints[0];
        xPoly[1] = xPoints[1];
        xPoly[2] = xPoints[2];
        xPoly[3] = xPoints[3];
        xPoly[4] = xPoints[4];
        xPoly[5] = this.getWidth();
        xPoly[6] = 0;
        
        yPoly[5] = this.getHeight();
        yPoly[6] = this.getHeight();
        
//        yPoints[0] = new Random().nextInt(255);
//        yPoints[1] = new Random().nextInt(255);
//        yPoints[2] = new Random().nextInt(255);
//        yPoints[3] = new Random().nextInt(255);
        yPoints[4] = Integer.parseInt(label.getText());
        yPoly[4] = yPoints[4];
        
        i = Integer.parseInt(label.getText());
        
        value = new StringBuilder().append(i).toString();
        
        //GradientPaint g2g = new GradientPaint(0, 0, panel.getBackground(), 300, 0, Color.LIGHT_GRAY);

        //g2d.setPaint(g2g);
        //g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        GradientPaint w2w = new GradientPaint(0,0,new Color(230,230,230, 0xA0),366, 0,new Color(255,255,255));
        g2d.setPaint(w2w);
        g2d.fill (new Rectangle(0, 0, this.getWidth(), this.getHeight()));

        
        
        GradientPaint gr2gr = new GradientPaint(0,0,new Color(223,255,219,0x0),0, 400, panel.getBackground());
        g2d.setPaint(gr2gr);
        
        
        Polygon p = new Polygon(xPoly, yPoly, xPoly.length);
        g2d.fillPolygon(p);
        
        
        g2d.setColor(panel.getBackground().darker());
        g2d.drawString(value, xPoints[xPoints.length - 1] - 30, yPoints[yPoints.length - 1]);
        
        g2d.drawPolyline(xPoints, yPoints, xPoints.length);        
               
        //g2d.setPaint(Color.GRAY);
        //g2d.drawRect(0, 0, 300, 400);
        
        super.repaint();
    }     
}
