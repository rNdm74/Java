
package pfinalmonitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author rndm
 */
class EmbeddedSensor extends JPanel {    
    private static Polygon p;
    
    private static boolean active;
    
    private static Point mouse = new Point(0,0);
    public int mouseDragged = 1;
    
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
    
    private int min_light = 0;
    private int max_light = 1023;
    
    private int arraySize;
    
    private int x;
    
    public static String v;
	
    private ArrayList<String[]> array;	
    
    private Color color;
    //private Image img;
    
    
    private Dimension size;
    
    Rectangle rect;

    public EmbeddedSensor(Color color, Dimension size, ArrayList<String[]> array) throws IOException {
        
        //img = new ImageIcon("temp.png").getImage();
        
        
        //setLayout(null);
        this.color = color;
        this.size = FinalMonitorApp.size;        
        this.array = array;
        
        this.setOpaque(false);
        setSize(size);
        
        rect = new Rectangle(4, 0, size.width - 100, getHeight());
        //this.setVisible(false);
        //setLocation(200, 0);
        //this.setBorder(BorderFactory.createEtchedBorder());
        
        setBackground(Color.white);
        
        xPoints = new float[size.width - 100];        
        xPoly = new int[size.width - 100 + 2];
                
        yPoints = new float[xPoints.length];
        yPoly = new int[xPoly.length]; 
        
        get = new float[xPoints.length];
        
        for (int i = 0; i < yPoints.length; i++) {
            String[] s = {"0000", new GregorianCalendar().getTime().toString().substring(0,20)};
            array.add(s);
            yPoints[i] = Float.parseFloat(array.get(i)[0]);
        }
        
        addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                active = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                active = false;
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
                        
        if (evt.getPoint().x < rect.width) {
            //mouse.x = evt.getPoint().x;
        }
        else if(evt.getPoint().x <= 0){
            //mouse.x = 0 ;
        }        
        else{
            //mouse.x = rect.width - 1;
        }
        
        //System.out.println(mouse);
    }
    
    @Override
    public void paint(Graphics g){
        //setLocation(point);
        //setSize(size);
        String name = getName();
        
        width = size.width;
        height = size.height;
                
//        point.x += (!active) ? 
//                   ((point.x >= 0) ? 0 : 2) : 
//                   ((point.x <= -width + 1) ? 0 : -2);
        
        for (int j = 0; j < xPoints.length; j++) {
            xPoints[j] = j;
            xPoly[j] = (int)xPoints[j];
        }
        
        xPoly[xPoly.length-2] = (int)xPoints[xPoints.length - 1];
        xPoly[xPoly.length-1] = (int)xPoints[0];
        
        yPoly[yPoly.length-2] = height;
        yPoly[yPoly.length-1] = height;                
        
        arraySize = array.size();  
                
        if (arraySize > 2) {            
            for (int j = 0; j < get.length; j++) {
               // Converting int to float array
                            
               
               //(name.contains("temp"))? min_temp : min_light)
               //(name.contains("temp"))? max_temp : max_light)
               if (name.contains("temp")) {
                    get[j] = Float.parseFloat(array.get(arraySize - (j + 1))[0].substring(0, 2)); 
                    yPoints[j] = (float) map(get[get.length - (j + 1)], min_temp, max_temp, getHeight(), 0);               
                    yPoly[j] = (int) map(get[get.length - (j + 1)], min_temp, max_temp, getHeight(), 0);
               }
               else{
                    get[j] = Float.parseFloat(array.get(arraySize - (j + 1))[0]); 
                    yPoints[j] = (float) map(get[get.length - (j + 1)], min_light, max_light, getHeight(), 0);               
                    yPoly[j] = (int) map(get[get.length - (j + 1)], min_light, max_light, getHeight(), 0);
               }
                       
                   
               
            }
        }
            
        
        
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        
        // for antialiasing geometric shapes
        //g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
        //                      RenderingHints.VALUE_ANTIALIAS_ON );
        
        // for antialiasing text
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                              RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

//        // to go for quality over speed
//        g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
//                              RenderingHints.VALUE_RENDER_QUALITY );
        
        GradientPaint gp = new GradientPaint(0,0,new Color(230,230,230, 0xA0),width * 2, 0, new Color(255,255,255));
        g2d.setPaint(gp);
        //g2d.fill (new Rectangle(0, 0, width, height));   
        
        
        gp = new GradientPaint(width - 600,0,getBackground(),width, height, Color.RED.darker());
        g2d.setPaint(gp);
        p = new Polygon(xPoly, yPoly, xPoly.length);
        g2d.fillPolygon(p);
        
        g2d.setColor(Color.RED.darker());
        for (int i = 0; i < xPoints.length - 1; i++) {
            g2d.draw(new Line2D.Float(xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1]));
        }
        //g2d.drawPolyline(xPoints, yPoints, xPoints.length);
        g2d.setColor(Color.DARK_GRAY);
        
        int y =  (int) map(0, min_temp, max_temp, getHeight(), 0);
        int y_max =  (int) map(30, min_temp, max_temp, getHeight(), 0);
        int y_min =  (int) map(-5, min_temp, max_temp, getHeight(), 0);
        gp = new GradientPaint(0,0,new Color(230,230,230, 0x0F),width * 2, 0, new Color(255,255,255));
        g2d.setPaint(gp);
        //g2d.fillRect(1, 1, 33, 120);
        //g2d.fillRect(width - 40, 1, 40, 120);
        g2d.setColor(new Color(230,230,230, 0xFF));
        g2d.drawLine(width - 60, 0, width - 60, getHeight());
        //g2d.drawLine(33, 0, 33, 120);
        g2d.drawLine(width - 65, (int)yPoints[yPoints.length - 1], width - 60, (int)yPoints[yPoints.length - 1]);
        g2d.drawLine(width - 55, y_max, width - 60, y_max);
        g2d.drawLine(width - 55, y_min, width - 60, y_min);
        
        g2d.setColor(Color.DARK_GRAY);
        Font font = new Font(getFont().getFamily(), Font.PLAIN, 10);
        g2d.setFont(font);
        
        //g2d.drawString(Sensor.time, 50, 10);
        //g2d.drawString("REAL-TIME", 17, 103);
        
        ////
        //// TEMP
        ////
        if (name.contains("temp")) {
            
        }
        String s = array.get((arraySize - 1))[0];        
        g2d.drawString(s, width - 98, (int)yPoints[yPoints.length - 1] + 4);
        //g2d.setColor(new Color(230,230,230, 0xFF));
        String max = (name.contains("temp"))? Integer.toString(max_temp - 10) + "°C" : "Dark";
        String min = (name.contains("temp"))? Integer.toString(min_temp + 10) + "°C" : "Light";
        
        g2d.drawString(max, width - 48, y_max + 3);
        g2d.drawString(min, width - 50, y_min + 4);
        
        //System.out.println(arraySize - 240);
               
        rect = new Rectangle(0, 0, width - 100, height);
        g2d.setColor(Color.DARK_GRAY);
        if (rect.contains(mouse) && active) {
            g2d.drawString(array.get(mouse.x + (arraySize - yPoints.length))[0], mouse.x - 39, y_max - 2);       
            g2d.drawString(array.get(mouse.x + (arraySize - yPoints.length))[1].substring(11), mouse.x - 45, y_min + 10);
            g2d.setColor(Color.RED.darker()); 
            g2d.drawLine(mouse.x + 1, 0, mouse.x + 1, getHeight());
        }
        
        g2d.setColor(new Color(230,230,230, 0xFF));
        g2d.drawLine(0, getHeight() - 1, width, getHeight() - 1);
        
        BufferedImage img = null;
        //String name = getName();
        //System.out.println(name);
        try {
            img = ImageIO.read(new File((name.contains("temp"))? "temp.png" : "light.png"));
        } catch (IOException e) {

        }

        if (true) {
            g2d.drawImage(img, width - 17, getHeight() / 2 - 8, null);
        }
        
                
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
