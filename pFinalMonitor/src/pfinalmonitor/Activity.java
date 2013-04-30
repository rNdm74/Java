
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
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
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
class Activity extends JPanel {    
    private AffineTransform affinetransform = new AffineTransform();     
    private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    
    private static Polygon p;
    
    private static boolean active;
    
    private static Point mouse = new Point(0,0);
    
    public int mouseDragged = 1;
    
    public Point point = new Point(0,0);
    	
    public float[] xPoints;
    public float[] yPoints;
    public float[] get;
    //private static int[] xPoly;
    //private static int[] yPoly;
    
    private int width;
    private int height;
    
    public int min_temp = -15;
    public int max_temp = 40;
    
    public int min_light = 0;
    public int max_light = 1023;
    
    public int arraySize;
    
    private int x;
    
    public static String v;
	
    public ArrayList<String[]> data;	
    
    //private Color color;
    private JPanel sensorpanel;
    
    
    //private Dimension size;
    
    Rectangle rect;
    private boolean hover;

    public Activity(JPanel sensorpanel, ArrayList<String[]> data) throws IOException {
        this.sensorpanel = sensorpanel;        
        this.data = data; 
        
        setVisible(false);
                
        xPoints = new float[600];    
        
        yPoints = new float[xPoints.length];
        
        get = new float[xPoints.length];
        
        for (int i = 0; i < yPoints.length; i++) {
            String[] s = {"0000", new GregorianCalendar().getTime().toString().substring(0,20)};
            data.add(s);
            yPoints[i] = Float.parseFloat(data.get(i)[0]);
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
                hover = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                active = false;
                hover=false;
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
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;  
        
        width = sensorpanel.getWidth();
        height = getHeight();
        
        // for antialiasing geometric shapes
        //g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
        //                      RenderingHints.VALUE_ANTIALIAS_ON );
        
        // for antialiasing text
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                              RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

//        // to go for quality over speed
//        g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
//                              RenderingHints.VALUE_RENDER_QUALITY );
        

        GradientPaint gp = new GradientPaint((width - Main.mainSize.width) + 85, 0, Color.WHITE , width, 0, Color.RED.darker());
        g2d.setPaint(gp);
        
        for (int i = 0; i < xPoints.length - 1; i++) {
            g2d.draw(new Line2D.Float(xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1]));
        }
        
        g2d.setColor(Color.DARK_GRAY);
        
//        int y =  (int) map(0, min_temp, max_temp, getHeight(), 0);
//        int y_max =  (int) map(30, min_temp, max_temp, getHeight(), 0);
//        int y_min =  (int) map(-5, min_temp, max_temp, getHeight(), 0);
        //gp = new GradientPaint(0,0,new Color(230,230,230, 0x0F),width * 2, 0, new Color(255,255,255));
        //g2d.setPaint(gp);
        
        g2d.setColor(new Color(230,230,230, 0xFF));
        g2d.drawLine(width - 60, 0, width - 60, getHeight());
                
        g2d.setColor(Color.DARK_GRAY);
        Font font = new Font(getFont().getFamily(), Font.PLAIN, 10);
        g2d.setFont(font);
                
        ////
        //// TEMP
        ////        
        //String s = data.get((arraySize - 1))[0];        
        //g2d.drawString(s, width - 98, (int)yPoints[yPoints.length - 1] + 4);
        //g2d.setColor(new Color(230,230,230, 0xFF));
        String max = (getName().contains("temp"))? Integer.toString(max_temp - 10) + "°C" : "Dark";
        String min = (getName().contains("temp"))? Integer.toString(min_temp + 10) + "°C" : "Light";
        
        //g2d.drawString(max, width - 48, y_max + 3);
        //g2d.drawString(min, width - 50, y_min + 4);
              
        rect = new Rectangle(0, 0, width, height);
        
        g2d.setColor(Color.DARK_GRAY);
        if (rect.contains(mouse) && active) {
            //g2d.drawString(data.get(mouse.x + (arraySize - yPoints.length))[0], mouse.x - 39, 20 - 2);       
            //g2d.drawString(data.get(mouse.x + (arraySize - yPoints.length))[1].substring(11), mouse.x - 45, 100 + 10);
            g2d.setColor(Color.RED.darker()); 
            g2d.drawLine(mouse.x + 1, 0, mouse.x + 1, getHeight());
        }
        
        //g2d.setColor(new Color(230,230,230, 0xFF));
        //g2d.drawLine(0, getHeight() - 1, width - 60, getHeight() - 1);
                       
        //System.out.println(Main.mainSize.width);
        
        //g2d.setColor(Color.WHITE);
        //g2d.fillRect(0, 0, width - (Main.mainSize.width - 92), height);
        //g2d.setColor(new Color(230,230,230, 0xFF));
        //g2d.drawLine(width - (Main.mainSize.width - 90), 0,width - (Main.mainSize.width - 90),height);
        mouseOver(g2d);  
        super.repaint();
    }     

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        Activity.active = active;
    }    
    private void mouseOver(Graphics2D g2d) {
        GradientPaint gp;
        Font font;        
        if (hover) {
            gp = new GradientPaint(0,-10,new Color(135, 206, 250), 0, getHeight(), new Color(255, 255, 255));
            g2d.setPaint(gp);
            g2d.drawLine(70, 0, 70, getHeight() - 2);

            gp = new GradientPaint(0,-10,new Color(255, 255, 255), 0, getHeight(), new Color(255, 255, 255));
            g2d.setPaint(gp);


            //setSize(new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));
            gp = new GradientPaint(0, getHeight() / 2,new Color(135, 206, 250,0x30), 0, getHeight(), new Color(255, 255, 255, 0x2A));
            g2d.setPaint(gp);
            g2d.fillRect(2, getHeight() / 2, width - 5, (getHeight() / 2) - 1);

            gp = new GradientPaint(0, getHeight(),new Color(135, 206, 250,0x2F), 0, 0, new Color(255, 255, 255, 0x2A));
            g2d.setPaint(gp);
            g2d.fillRect(2, 0, width - 5, getHeight() / 2);

            gp = new GradientPaint(0,0,new Color(135, 206, 250),0, 0, new Color(135, 206, 250));
            g2d.setPaint(gp);
            g2d.drawRect(2, 0, width - 5, getHeight() - 1);

            font = new Font(getFont().getFamily(), Font.HANGING_BASELINE, getHeight() / 10);

            int rWidth = (int) font.getStringBounds(getName().toUpperCase().trim(), frc).getWidth(); 
            int rHeight = (int) font.getStringBounds(getName().toUpperCase(), frc).getHeight();
            g2d.setFont(font);
            //g2d.drawString(getName().toUpperCase(), 100, rHeight / 2);

            int sWidth = (int) font.getStringBounds(data.get(data.size() - 1)[1], frc).getWidth(); 
            int sHeight = (int) font.getStringBounds(data.get(data.size() - 1)[1], frc).getHeight();
            //g2d.drawString(data.get(data.size() - 1)[1], 15, getHeight() / 2 - sHeight / 2 + 45);
            //System.out.println(sHeight);
            g2d.drawString(data.get(data.size() - 1)[1], (width - sWidth) - 90, (getHeight() - sHeight));

            gp = new GradientPaint(0,0,new Color(135, 206, 250), 0, getHeight(), new Color(255, 255, 255));
            g2d.setPaint(gp);
            g2d.drawLine(width - 60, 0, width - 60, getHeight() - 2);
            //g2d.drawLine(width - (Main.mainSize.width - 90), 0, width - (Main.mainSize.width - 90), getHeight() - 2);

            gp = new GradientPaint(0,0,new Color(255, 255, 255), 0, getHeight(), new Color(255, 255, 255));
            g2d.setPaint(gp);
            g2d.drawLine(width - 61, 1, width - 61, getHeight() - 2);
            //g2d.drawLine(width - (Main.mainSize.width - 91), 1, width - (Main.mainSize.width - 91), getHeight() - 2);
            g2d.drawLine(71, 1, 71, getHeight() - 2);


            BufferedImage img = null;
            //String name = getName();
            try {                    
                img = ImageIO.read(new File("MD-eject.png"));
            } catch (IOException e) {}            
            g2d.drawImage(img, 18, getHeight() / 2 - 16, null);

            try {
                img = ImageIO.read(new File((getName().contains("temp"))? "temp32.png" : "light32.png"));
            } catch (IOException e) {}  
            g2d.drawImage(img, width - 50, getHeight() / 2 - 16, null);                
        }
    }
}
