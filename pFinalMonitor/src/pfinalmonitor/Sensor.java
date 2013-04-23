
package pfinalmonitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JScrollPane;

/**
 *
 * @author rndm
 */
public class Sensor extends javax.swing.JPanel {
    public ArrayList<String[]> data = new ArrayList<>();
    
    AffineTransform affinetransform = new AffineTransform();     
    FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    
    private int xPos=0;
    private int posX=0,posY=0;
    
    public String time = "";
    
    private boolean button = true;
    public boolean button1 = true;
    public boolean button2 = true;
    public boolean button3 = true;
    
    public static String userName = "charlal1";
    public static String device = "temperature";
    public static String url = "sensor.xml";
    
    private Color color;
    public String name = "";
    
    public Sensor(Color color, String name) {
        //setPreferredSize(new Dimension(100, 110));
        //setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //add(vertical);
        //setAlwaysOnTop(true);
        this.color = color;
        this.name = name;
        setLayout(null);
        initComponents();        
    }

    // <editor-fold defaultstate="collapsed" desc="initComponents()">                          
    private void initComponents() {
        basicSensorPanel = new BasicSensorPanel(color);
        rightPanel = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
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
        
                GradientPaint gp;
                gp = new GradientPaint(0,0,
                    new Color(230,230,230, 0xA0), getWidth(), 0, getBackground());
                //g2d.setPaint(gp);
                //g2d.fill (new Rectangle(0, 0, getWidth(), getHeight()));

                //g2d.drawString("MAX", getWidth() - 27, 12);
                //g2d.drawString("MIN", getWidth() - 27, 117);
                int h = getHeight() / 3;

                g2d.setColor(getBackground().brighter());
                //g2d.drawLine(29, 1, 29, getHeight());

                g2d.draw3DRect(1, 0, getWidth() - 2, h, button1);
                button1Bounds = new Rectangle(1, 0, getWidth() - 2, h);
                g2d.draw3DRect(1, h+1, getWidth() - 2, h, button2);
                button2Bounds = new Rectangle(1, h+1, getWidth() - 2, h);
                g2d.draw3DRect(1, h*2+1, getWidth() - 2, h, button3);
                button3Bounds = new Rectangle(1, h*2+1, getWidth() - 2, h);
                
                g2d.setColor(getBackground().darker());
                //g2d.drawLine(30, 2, getWidth(), 2);
                g2d.drawLine(1, h, getWidth(), h);
                g2d.drawLine(1, h*2, getWidth(), h*2);
                g2d.drawLine(1, 0, 1, getHeight());

                g2d.setColor(Color.DARK_GRAY);

                //g2d.drawString(getName().toUpperCase(), 25, 40);
//                Font font = new Font(getFont().getFamily(), Font.BOLD, 10);
//                g2d.setFont(font);

//                if(!sensor1Show){
//                    g2d.drawString(jLabel1A.getText(), 5,
//                        Integer.parseInt( jLabel1A.getText()) -
//                        jLabel1A.getHeight() / 2 );
//                }

                Font font = new Font(getFont().getFamily(), Font.PLAIN, 12);
                g2d.setFont(font);
                
                
                
                g2d.drawString("Hide menu", 34, button1Bounds.y + 23);
                g2d.drawString("Settings", 34, button2Bounds.y + 23);
                g2d.drawString("Pause", 34, button3Bounds.y + 23);
                
//                if(!button2){
//                    g2d.setColor(color.brighter());
//                    g2d.fillOval(15, button2Bounds.y + 14, 10, 10);
//                    g2d.setColor(color.darker().darker());
//                    g2d.drawOval(15, button2Bounds.y + 14, 10, 10);
//                }
//                else{
//                    g2d.setColor(color.darker());
//                    g2d.fillOval(15, button2Bounds.y + 14, 10, 10);
//                    g2d.setColor(color.darker().darker());                    
//                    g2d.drawOval(15, button2Bounds.y + 14, 10, 10);
//                }
                
                if(!button3){
                    g2d.setColor(color.brighter());
                    g2d.fillOval(15, button3Bounds.y + 14, 10, 10);
                    g2d.setColor(color.darker().darker());
                    g2d.drawOval(15, button3Bounds.y + 14, 10, 10);
                }
                else{
                    g2d.setColor(color.darker());
                    g2d.fillOval(15, button3Bounds.y + 14, 10, 10);
                    g2d.setColor(color.darker().darker());                    
                    g2d.drawOval(15, button3Bounds.y + 14, 10, 10);
                }

                
                
                super.repaint();
            }
        };         
        leftPanel = new LeftPanel(basicSensorPanel, data);
        rightPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());        
        rightPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rightPanelMouseMoved(evt);
            }
        });        
        advancedSensorPanel = new EmbeddedSensor(data);        
        basicSensorPanel.add(advancedSensorPanel);        
        add(basicSensorPanel);
        add(leftPanel);        
        formWindowOpened();
        
        
    }// </editor-fold>                        
           
    
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {        
        leftPanel.setSize((button) ? new java.awt.Dimension(120, 120):new java.awt.Dimension(360, 120));
        sensorFrame.setVisible(button);
        menuFrame.setVisible(button);
        button = !button;
    }  
    public void formWindowOpened() {        
        int w = 120;
        int h = 120;
        
        Dimension d;
        
        d = new Dimension(w + w, h);
        
        rightPanel.setSize(w, h);
        
        basicSensorPanel.setSize(d);
        
        advancedSensorPanel.setSize(d);
        
        basicSensorPanel.setLocation(new Point(360, 0));
        
        advancedSensorPanel.point = new Point(0, 0);           
    }    
    private void rightPanelMouseClicked(java.awt.event.MouseEvent evt) {
        Point p = evt.getPoint();
        
        if (button1Bounds.contains(p)) {
            menuFrame.setVisible(false);
            //sensorFrame.dispose();
            //dispose();
            //System.exit(0); 
            
            button = !button;
        }
        
        if (button2Bounds.contains(p)) {
            advancedSensorPanel.setVisible(!button2);         
            advancedSensorPanel.setActive(button2);        
            button2 = !button2;
        }
        
        if (button3Bounds.contains(p)) {
            //rightPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    
            button3 = !button3;
        } 
        else{
            //rightPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
    } 
    private void rightPanelMouseMoved(java.awt.event.MouseEvent evt) {                                     
        Point p = evt.getPoint();
        
        if (button3Bounds.contains(p)) {
            rightPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));            
        }
        else{
            rightPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }        
    }
    // </editor-fold>
     
    //<editor-fold defaultstate="collapsed" desc=" Variables ">
    // Variables declaration - do not modify  
    private Rectangle button1Bounds;
    private Rectangle button2Bounds;
    private Rectangle button3Bounds;
    
    public javax.swing.JWindow sensorFrame;
    public javax.swing.JWindow menuFrame;
    
    private LeftPanel leftPanel;
    private BasicSensorPanel basicSensorPanel;
    private EmbeddedSensor advancedSensorPanel;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration                   
//</editor-fold>
}

