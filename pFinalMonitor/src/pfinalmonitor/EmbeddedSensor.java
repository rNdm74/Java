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
import javax.swing.BorderFactory;
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
    	
    private static float[] xPoints;
    private static float[] yPoints;
    
    private static int[] xPoly;
    private static int[] yPoly;
    
    int w;
    
    float get1 = 0;
    float get2 = 0;
    float get3 = 0;
    float get4 = 0;
    float get5 = 0;
    
    int min_temp = -15;
    int max_temp = 40;
    
    int arraySize;
    
    public static String v;
	
    private ArrayList<String> array = new ArrayList<>();	
    
    public EmbeddedSensor(ArrayList<String> array){
        setLocation(30,0);
        
        this.array = array;
        
        this.setBorder(BorderFactory.createEtchedBorder());
        
        xPoints = new float[5];
        
        xPoly = new int[7];
                
        yPoints = new float[xPoints.length];
        yPoly = new int[]{100, 80, 60, 70, 50, 0, 0}; 
        
        array.add("0000");
        array.add("0000");
        array.add("0000");
        array.add("0000");
        array.add("0000");
        
        for (int i = 0; i < yPoints.length; i++) {
            yPoints[i] = Float.parseFloat(array.get(i));
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        setLocation(point);
        
        w = getWidth();
        
        
        if(true){
            if(active){                
                if (active && point.x >= 0) {
                    direction = 0;
                }
                else{
                    direction = 2;
                }
            }
            
            if(!active){
                if (!active && point.x <= -w + 1) {
                    direction = 0;
                    setVisible(false);
                }
                else{
                    direction = -2;
                }
            }
            
            //time = 0;
        }
        
        point.x += direction;
        
         
        
        //time++;          
        
        
        
        xPoints[0] = 0;
        xPoints[1] = (w / 2) / 2;
        xPoints[2] = w / 2;
        xPoints[3] = (w / 2) + (w / 2) / 2;
        xPoints[4] = w;
        
        xPoly[0] = (int)xPoints[0];
        xPoly[1] = (int)xPoints[1];
        xPoly[2] = (int)xPoints[2];
        xPoly[3] = (int)xPoints[3];
        xPoly[4] = (int)xPoints[4];
        xPoly[5] = w;
        xPoly[6] = 0;
        
        yPoly[5] = getHeight();
        yPoly[6] = getHeight();
                
        
        arraySize = array.size();
        int height = getHeight();
        
        if (arraySize > 2) {
//            get1 = Integer.parseInt(array.get(arraySize - 1).substring(0, 2));
//            get2 = Integer.parseInt(array.get(arraySize - 2).substring(0, 2));
//            get3 = Integer.parseInt(array.get(arraySize - 3).substring(0, 2));
//            get4 = Integer.parseInt(array.get(arraySize - 4).substring(0, 2));
//            get5 = Integer.parseInt(array.get(arraySize - 5).substring(0, 2));
//            
//            yPoints[0] = (int) map(get5, 0, 30, 120, 0);
//            yPoly[0] = (int) map(get5, 0, 30, 120, 0);
//            yPoints[1] = (int) map(get4, 0, 30, 120, 0);
//            yPoly[1] = (int) map(get4, 0, 30, 120, 0);
//            yPoints[2] = (int) map(get3, 0, 30, 120, 0);
//            yPoly[2] = (int) map(get3, 0, 30, 120, 0);
//            yPoints[3] = (int) map(get2, 0, 30, 120, 0);
//            yPoly[3] = (int) map(get2, 0, 30, 120, 0);
//            yPoints[4] = (int) map(get1, 0, 30, 120, 0);
//            yPoly[4] = (int) map(get1, 0, 30, 120, 0);
            get1 = Float.parseFloat(array.get(arraySize - 1));
            get2 = Float.parseFloat(array.get(arraySize - 2));
            get3 = Float.parseFloat(array.get(arraySize - 3));
            get4 = Float.parseFloat(array.get(arraySize - 4));
            get5 = Float.parseFloat(array.get(arraySize - 5));
                                   
            yPoints[0] = (float) map(get5, min_temp, max_temp, 120, 0);
            yPoly[0] = (int) map(get5, min_temp, max_temp, 120, 0);
            yPoints[1] = (float) map(get4, min_temp, max_temp, 120, 0);
            yPoly[1] = (int) map(get4, min_temp, max_temp, 120, 0);
            yPoints[2] = (float) map(get3, min_temp, max_temp, 120, 0);
            yPoly[2] = (int) map(get3, min_temp, max_temp, 120, 0);
            yPoints[3] = (float) map(get2, min_temp, max_temp, 120, 0);
            yPoly[3] = (int) map(get2, min_temp, max_temp, 120, 0);
            yPoints[4] = (float) map(get1, min_temp, max_temp, 120, 0);
            yPoly[4] = (int) map(get1, min_temp, max_temp, 120, 0);
        }
        
                
        v = new StringBuilder().append(array.get(arraySize - 1)).toString();
        
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        
        // for antialiasing geometric shapes
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON );
        
        // for antialiasing text
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                              RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

//        // to go for quality over speed
//        g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
//                              RenderingHints.VALUE_RENDER_QUALITY );
        
        GradientPaint gp = new GradientPaint(0,0,new Color(230,230,230, 0xA0),w * 2, 0, new Color(255,255,255));
        g2d.setPaint(gp);
        g2d.fill (new Rectangle(0, 0, w, getHeight()));   
        
        
        gp = new GradientPaint(0,0,getBackground(),w * 2, getHeight(), new Color(223,255,219,0x0));
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
        gp = new GradientPaint(0,0,new Color(230,230,230, 0xA0),w * 2, 0, new Color(255,255,255));
        g2d.setPaint(gp);
        g2d.fillRect(1, 1, 33, 120);
        g2d.setColor(Color.DARK_GRAY);        
        g2d.drawLine(33, 0, 33, 120);
        g2d.drawLine(27, y, 33, y);
        g2d.drawLine(27, y_max, 33, y_max);
        g2d.drawLine(27, y_min, 33, y_min);
        
        Font font = new Font(getFont().getFamily(), Font.PLAIN, 10);
        g2d.setFont(font);
        //g2d.drawString("REAL-TIME", 17, 103);
        g2d.drawString("0°C", 12, y - 2);
        g2d.drawString(Integer.toString(max_temp - 10) + "°C", 6, y_max - 2);
        g2d.drawString(Integer.toString(min_temp + 5) + "°C", 3, y_min - 2);
        g2d.drawString(v + "°C", xPoints[xPoints.length - 1] - 45, yPoints[4] - 6);
        
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
