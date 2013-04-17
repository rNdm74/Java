/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinalmonitor;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rndm
 */
class EmbeddedSensor extends JPanel {
    
    
    private static int i = 0;
    
    private static Polygon p;
    
    private static int direction = 1;
    
    private static int time = 0;
    
    private int value = 0;
        
    //private JLabel label;
    
    private boolean active;
    
    public int mouse;
    public int mouseDragged = 0;
    
    public Point point = new Point(0,0);
    	
    private static int[] xPoints;
    private static int[] yPoints;
    
    private static int[] xPoly;
    private static int[] yPoly;
	
    private ArrayList<Integer> array = new ArrayList<>();	
    
    public EmbeddedSensor(ArrayList<Integer> array){
        setLocation(30,0);
        
        this.array = array;
        
        this.setBorder(BorderFactory.createEtchedBorder());
        
        xPoints = new int[5];
        
        xPoly = new int[7];
                
        yPoints = new int[xPoints.length];
        yPoly = new int[]{100, 80, 60, 70, 50, 0, 0}; 
        
        array.add(100);
        array.add(80);
        array.add(60);
        array.add(70);
        array.add(50);
        
        for (int i = 0; i < yPoints.length; i++) {
            yPoints[i] = array.get(i);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        if(time < 50){
            if(active){                
                if (active && point.x >= 0) {
                    direction = 0;
                }
                else{
                    direction = 1;
                }
            }
            
            if(!active){
                if (!active && point.x <= -getWidth() + 1) {
                    direction = 0;
                    setVisible(false);
                }
                else{
                    direction = -1;
                }
            }
            
            time = 0;
        }
        
        point.x += direction;
        
        setLocation(point); 
        
        time++;          
        
        int w = getWidth();
        
        xPoints[0] = 0;
        xPoints[1] = (w / 2) / 2;
        xPoints[2] = w / 2;
        xPoints[3] = (w / 2) + (w / 2) / 2;
        xPoints[4] = w;
        
        xPoly[0] = xPoints[0];
        xPoly[1] = xPoints[1];
        xPoly[2] = xPoints[2];
        xPoly[3] = xPoints[3];
        xPoly[4] = xPoints[4];
        xPoly[5] = w;
        xPoly[6] = 0;
        
        yPoly[5] = getHeight();
        yPoly[6] = getHeight();
                
        int get1 = 0;
        int get2 = 0;
        int get3 = 0;
        int get4 = 0;
        int get5 = 0;
        
        if (array.size() > 2) {
            get1 = array.get(array.size() - 1);
            get2 = array.get(array.size() - 2);
            get3 = array.get(array.size() - 3);
            get4 = array.get(array.size() - 4);
            get5 = array.get(array.size() - 5);
            
            yPoints[0] = get5;
            yPoly[0] = get5;
            yPoints[1] = get4;
            yPoly[1] = get4;
            yPoints[2] = get3;
            yPoly[2] = get3;
            yPoints[3] = get2;
            yPoly[3] = get2;
            yPoints[4] = get1;
            yPoly[4] = get1;
        }
        
        String v;        
        v = new StringBuilder().append(get1).toString();
        
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        
        // for antialiasing geometric shapes
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON );
        
        // for antialiasing text
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                              RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

        // to go for quality over speed
        g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
                              RenderingHints.VALUE_RENDER_QUALITY );
        
        GradientPaint gp = new GradientPaint(0,0,new Color(230,230,230, 0xA0),w * 2, 0, new Color(255,255,255));
        g2d.setPaint(gp);
        g2d.fill (new Rectangle(0, 0, w, getHeight()));       
        
        gp = new GradientPaint(0,0,getBackground(),w * 2, getHeight(), new Color(223,255,219,0x0));
        g2d.setPaint(gp);
        p = new Polygon(xPoly, yPoly, xPoly.length);
        g2d.fillPolygon(p);
        
        g2d.setColor(getBackground().darker());
        g2d.drawPolyline(xPoints, yPoints, xPoints.length);
        g2d.setColor(Color.DARK_GRAY);
                
        Font font = new Font(getFont().getFamily(), Font.PLAIN, 10);
        g2d.setFont(font);
        //g2d.drawString("REAL-TIME", 17, 103);
        g2d.drawString("MAX", 10, 15);
        g2d.drawString("MIN", 10, 108);
        //g2d.drawString(v, xPoints[xPoints.length - 1] - 30, 110);
        
        super.repaint();
    }     

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
