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
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author rndm
 */
class EmbeddedSensor extends JPanel {    
    private static Polygon p;
    
    private boolean active;
    
    public int mouse;
    public int mouseDragged = 0;
    
    public Point point = new Point(0,0);
    	
    private static float[] xPoints;
    private static float[] yPoints;
    private float[] get;
    private static int[] xPoly;
    private static int[] yPoly;
    
    private int width;
    private int height;
    
    private int min_temp = -15;
    private int max_temp = 40;
    
    private int arraySize;
    
    public static String v;
	
    private ArrayList<String[]> array;	
    
    public EmbeddedSensor(ArrayList<String[]> array){
        this.array = new ArrayList<>();
        setLocation(30,0);
        
        this.array = array;
        
        this.setBorder(BorderFactory.createEtchedBorder());
        
        xPoints = new float[60];        
        xPoly = new int[62];
                
        yPoints = new float[xPoints.length];
        yPoly = new int[xPoly.length]; 
        
        get = new float[xPoints.length];
        
        for (int i = 0; i < yPoints.length; i++) {
            String[] s = {"0000", "0000"};
            array.add(s);
            yPoints[i] = Float.parseFloat(array.get(i)[0]);
        }          
    }
    
    @Override
    public void paintComponent(Graphics g){
        setLocation(point);
        
        width = getWidth();
        height = getHeight();
                
//        point.x += (!active) ? 
//                   ((point.x >= 0) ? 0 : 2) : 
//                   ((point.x <= -width + 1) ? 0 : -2);
        
        for (int j = 0; j < xPoints.length; j++) {
            xPoints[j] = 4f * j;
            xPoly[j] = (int)xPoints[j];
        }
        
        xPoly[60] = (int)xPoints[xPoints.length - 1];
        xPoly[61] = (int)xPoints[0];
        
        yPoly[60] = height;
        yPoly[61] = height;                
        
        arraySize = array.size();        
        if (arraySize > 2) {            
            for (int j = 0; j < get.length; j++) {
               get[j] = Float.parseFloat(array.get(arraySize - (j + 1))[0]);               
               yPoints[j] = (float) map(get[get.length - (j + 1)], min_temp, max_temp, 120, 0);
               yPoly[j] = (int) map(get[get.length - (j + 1)], min_temp, max_temp, 120, 0);
            }
        }
            
        v = new StringBuilder().append(array.get(arraySize - 1)[0]).toString();
        
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
        
        GradientPaint gp = new GradientPaint(0,0,new Color(230,230,230, 0xA0),width * 2, 0, new Color(255,255,255));
        g2d.setPaint(gp);
        g2d.fill (new Rectangle(0, 0, width, height));   
        
        
        gp = new GradientPaint(0,0,getBackground(),width * 2, height, new Color(223,255,219,0x0));
        g2d.setPaint(gp);
        p = new Polygon(xPoly, yPoly, xPoly.length);
        g2d.fillPolygon(p);
        
        g2d.setColor(getBackground().darker());
        for (int i = 0; i < xPoints.length - 1; i++) {
            g2d.draw(new Line2D.Float(xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1]));
        }
        //g2d.drawPolyline(xPoints, yPoints, xPoints.length);
        g2d.setColor(Color.DARK_GRAY);
        
        int y =  (int) map(0, min_temp, max_temp, 120, 0);
        int y_max =  (int) map(30, min_temp, max_temp, 120, 0);
        int y_min =  (int) map(-10, min_temp, max_temp, 120, 0);
        gp = new GradientPaint(0,0,new Color(230,230,230, 0x90),width * 2, 0, new Color(255,255,255));
        g2d.setPaint(gp);
        g2d.fillRect(1, 1, 33, 120);
        //g2d.fillRect(width - 33, 1, 33, 120);
        g2d.setColor(Color.DARK_GRAY);
        //g2d.drawLine(width - 33, 0, width - 33, 120);
        g2d.drawLine(33, 0, 33, 120);
        g2d.drawLine(27, y, 33, y);
        g2d.drawLine(27, y_max, 33, y_max);
        g2d.drawLine(27, y_min, 33, y_min);
        
        Font font = new Font(getFont().getFamily(), Font.PLAIN, 10);
        g2d.setFont(font);
        
        //g2d.drawString(Sensor.time, 50, 10);
        //g2d.drawString("REAL-TIME", 17, 103);
        g2d.drawString("0°C", 12, y - 2);
        g2d.drawString(Integer.toString(max_temp - 10) + "°C", 6, y_max - 2);
        g2d.drawString(Integer.toString(min_temp + 5) + "°C", 3, y_min - 2);
        g2d.drawString(v + "°C", width - 33, yPoints[yPoints.length - 1] + 1 );
        
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
    
    public float map(float x, float in_min, float in_max, float out_min, float out_max)
    {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}
