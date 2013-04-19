
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
import java.util.ArrayList;

/**
 *
 * @author rndm
 */
public class Sensor extends javax.swing.JWindow {
    
    public ArrayList<Integer> y1 = new ArrayList<>();
    
    int xPos=0;
    int posX=0,posY=0;
    
    private boolean button = true;
    private boolean button1 = true;
    private boolean button2 = true;
    private boolean button3 = true;
    
    public static String userName = "charlal1";
    public static String ipAddress = "172.12.73.0";
    public static String port = "45733";
    
    private Color color;
    
    public Sensor(Color color) { 
        this.color = color;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="initComponents()">                          
    private void initComponents() {

        sensorFrame = new javax.swing.JFrame();
        basicSensorPanel = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                                
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

                // for antialiasing text
                g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

                // to go for quality over speed
                g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY );

                GradientPaint w2w = new GradientPaint(0,0,leftPanel.getBackground(),getWidth(), 0, new Color(230,230,230, 0xA0));
                g2d.setPaint(w2w);
                
                g2d.fill (new Rectangle(0, 0, getWidth(), getHeight()));

                w2w = new GradientPaint(0,0,leftPanel.getBackground().brighter(),getWidth(), 0, new Color(230,230,230, 0xA0));
                g2d.setPaint(w2w);
                
                g2d.drawLine(50, 30, 50, 90);
                g2d.drawLine(0, 30, getWidth(), 30);
                g2d.drawLine(0, 50, getWidth(), 50);
                g2d.drawLine(0, 70, getWidth(), 70);
                g2d.drawLine(0, 90, getWidth(), 90);
                
                g2d.setColor(getBackground());
                
                g2d.draw3DRect(1, 0, getWidth() - 2, 29, true);
                g2d.draw3DRect(1, 91, getWidth() - 2, 29, false);
                
                g2d.setColor(Color.DARK_GRAY);
                Font font = new Font(getFont().getFamily(), Font.PLAIN, 10);
                g2d.setFont(font);
                
                
                g2d.drawString("CONNECTION DETAILS", 25, 20);
                
                g2d.drawString("LOGIN", 10, 44);
                
                g2d.drawString("IP", 10, 64);
                
                g2d.drawString("PORT", 10, 84);
                
                font = new Font(getFont().getFamily(), Font.PLAIN, 10);
                g2d.setFont(font);
                //g2d.drawString("REAL-TIME", 17, 103);
                super.repaint();
            }
        };
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
                g2d.setPaint(gp);
                g2d.fill (new Rectangle(0, 0, getWidth(), getHeight()));

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
                Font font = new Font(getFont().getFamily(), Font.BOLD, 10);
                g2d.setFont(font);

//                if(!sensor1Show){
//                    g2d.drawString(jLabel1A.getText(), 5,
//                        Integer.parseInt( jLabel1A.getText()) -
//                        jLabel1A.getHeight() / 2 );
//                }

                font = new Font(getFont().getFamily(), Font.PLAIN, 10);
                g2d.setFont(font);
                //g2d.drawString("CHANGE VIEW", getWidth() / 2 - 35, 103);

                g2d.drawString("REAL-TIME", 34, 103);
                
                if(!button3){
                    g2d.setColor(color.brighter());
                    g2d.fillOval(15, 94, 10, 10);
                    g2d.setColor(color.darker().darker());
                    g2d.drawOval(15, 94, 10, 10);
                }
                else{
                    g2d.setColor(color.darker());
                    g2d.fillOval(15, 94, 10, 10);
                    g2d.setColor(color.darker().darker());                    
                    g2d.drawOval(15, 94, 10, 10);
                }

                
                
                super.repaint();
            }
        };               
        leftPanel = new javax.swing.JPanel(){
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

                GradientPaint w2w = new GradientPaint(0, 0, new Color(230,230,230, 0xA0),getWidth(), 0, getBackground());
                g2d.setPaint(w2w);
                g2d.fill (new Rectangle(0, 0, getWidth(), getHeight()));
                //        g2d.setColor(getBackground().darker());
                //        g2d.drawLine(0, 70, getWidth(), 70);
                //        g2d.setColor(getBackground().brighter());
                //        g2d.drawLine(0, 71, getWidth(), 71);
                //        g2d.draw3DRect(1, 71, getWidth() - 1, 46, sensor1Show);
                //
                g2d.setColor(Color.DARK_GRAY);
                Font font = new Font(getFont().getFamily(), Font.PLAIN, 10);
                g2d.setFont(font);
                g2d.drawString(getName().toUpperCase(), 25, 20);
                //        font = new Font(getFont().getFamily(), Font.PLAIN, 10);
                //        g2d.setFont(font);
                //
//                if(button3){
                font = new Font(getFont().getFamily(), Font.BOLD, 30);
                g2d.setFont(font);
                g2d.drawString(y1.get(y1.size() - 1).toString(), getWidth() / 2 - 30, getHeight() / 2 + 10);
                
                g2d.setColor(color.darker().darker());
                g2d.drawLine(1, 29, getWidth(), 29);
                //g2d.drawLine(1, 91, getWidth(), 91);
                g2d.setColor(color.brighter());
                g2d.drawLine(1, 30, getWidth(), 30);
                //g2d.drawLine(1, 90, getWidth(), 90);
//                }
//                else{
//                    g2d.drawString("ADVANCED", 25, 98);
//                }

                super.repaint();
            }
        };
       
        sensorFrame.isAlwaysOnTop();
        sensorFrame.setBounds(new java.awt.Rectangle(1, 1, 150, 120));
        sensorFrame.setIconImages(null);
        sensorFrame.setUndecorated(true);
        sensorFrame.setResizable(false);
        sensorFrame.setType(java.awt.Window.Type.UTILITY);
        sensorFrame.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            @Override
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jFrame1AMouseWheelMoved(evt);
            }
        });
        sensorFrame.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jFrame1AMouseDragged(evt);
            }
        });
        sensorFrame.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            @Override
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                //jFrame1AAncestorMoved(evt);
            }
            @Override
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        sensorFrame.getContentPane().setLayout(null);

        basicSensorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        basicSensorPanel.setAlignmentX(1.0F);
        basicSensorPanel.setAlignmentY(1.0F);
        basicSensorPanel.setFont(basicSensorPanel.getFont());

        sensorFrame.getContentPane().add(basicSensorPanel);
        basicSensorPanel.setBounds(0, 0, 0, 0);
        basicSensorPanel.setLayout(null);
        
        
        rightPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rightPanel.setAlignmentX(1.0F);
        rightPanel.setAlignmentY(1.0F);
        rightPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rightPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rightPanelMouseExited(evt);
            }
        });
        rightPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rightPanelMouseMoved(evt);
            }
        });

        sensorFrame.getContentPane().add(rightPanel);
        rightPanel.setBounds(0, 0, 0, 0);
        
        advancedSensorPanel = new EmbeddedSensor(y1);        
        basicSensorPanel.add(advancedSensorPanel);

        sensorFrame.getAccessibleContext().setAccessibleParent(this);
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setTitle("Embedded Systems");
        //setName("");
        //setUndecorated(true);
        //setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });                
        //getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        
        leftPanel.setBackground(color);
        leftPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        leftPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        leftPanel.setDoubleBuffered(true);
        //leftPanel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        leftPanel.setName("Sensor 1");
        leftPanel.setPreferredSize(new java.awt.Dimension(110, 120));
        leftPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        leftPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        getContentPane().add(leftPanel);
           
        pack();
    }// </editor-fold>                        
           
    
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        sensorFrame.setVisible(button);
        button = !button;
    }                                    

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {                                     
        sensorFrame.requestFocus();
        
        posX=evt.getX();
        posY=evt.getY();
    }                                    

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {                                     
        setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
        
        sensorFrame.setLocation(evt.getXOnScreen()-posX + this.getWidth(),evt.getYOnScreen()-posY);
    }                                    

    private void jFrame1AMouseDragged(java.awt.event.MouseEvent evt) {                                      
//        int x = (sensor1.getLocation().x);
//        int y = (sensor1.getLocation().y);
//        int speed;
//        
//        speed = ((x < 0 && evt.getX() > xPos) ? 1 : -1);
//        
//        x+=speed;
//                
//        sensor1.setLocation(x, y);
//        
//        xPos = evt.getX();
    }                                     

    private void jFrame1AMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                         
        //sensor1.setLocation(sensor1.getLocation().x + evt.getWheelRotation(), sensor1.getLocation().y);
    }                                        

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        leftPanel.setBackground(leftPanel.getBackground().darker());
        
        sensorFrame.setBackground(leftPanel.getBackground());
        
        basicSensorPanel.setBackground(sensorFrame.getBackground());   
        
        rightPanel.setBackground(sensorFrame.getBackground());
        
        advancedSensorPanel.setBackground(basicSensorPanel.getBackground());
        
        int w = leftPanel.getWidth();
        int h = leftPanel.getHeight();
        
        Dimension d = new Dimension(w + (w / 2) + w, h);
                
        sensorFrame.setSize(d);
        
        d = new Dimension(w + (w / 2), h);
        
        rightPanel.setSize(w, h);
        
        basicSensorPanel.setSize(d);
        
        advancedSensorPanel.setSize(d);
        
        Point p1 = leftPanel.getLocationOnScreen();
        
        sensorFrame.setLocation(p1.x + leftPanel.getWidth(), p1.y);
        
        rightPanel.setLocation(sensorFrame.getWidth() - rightPanel.getWidth(), 0);
        
        int n = -d.width;
        advancedSensorPanel.point = new Point(++n, 0);
                
        sensorFrame.setVisible(false);
    }                                 

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {                                     
        //evt.getComponent().setFont(evt.getComponent().getFont().deriveFont(60.0f));
    }                                    

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {                                    
        //evt.getComponent().setFont(evt.getComponent().getFont().deriveFont(30.0f));
    }                                   

    private void rightPanelMouseClicked(java.awt.event.MouseEvent evt) {
        Point p = evt.getPoint();
        
        if (button1Bounds.contains(p)) {
            System.exit(0);        
            //button1 = !button1;
        }
        
        if (button2Bounds.contains(p)) {
//            advancedSensorPanel.setVisible(true);         
//            advancedSensorPanel.setActive(button3);        
            button2 = !button2;
        }
        
        if (button3Bounds.contains(p)) {
            //rightPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            advancedSensorPanel.setVisible(true);         
            advancedSensorPanel.setActive(button3);        
            button3 = !button3;
        } 
        else{
            //rightPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
    }                                      

    private void rightPanelMouseEntered(java.awt.event.MouseEvent evt) {                                       
        
    }                                      

    private void rightPanelMouseExited(java.awt.event.MouseEvent evt) {                                      
        //System.out.println(evt.getPoint());
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
    private javax.swing.JFrame sensorFrame;
    public javax.swing.JPanel leftPanel;
    private javax.swing.JPanel basicSensorPanel;
    private EmbeddedSensor advancedSensorPanel;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration                   
//</editor-fold>
}

