/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinalmonitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author rNdm
 */
public class LeftPanel extends JPanel {
    private BasicSensorPanel basicSensorPanel;
    
    private AffineTransform affinetransform = new AffineTransform();     
    private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    
    private ArrayList<String[]> data = new ArrayList<>();
    public boolean button = true;
    int y;
    
    public LeftPanel(BasicSensorPanel basicSensorPanel, ArrayList<String[]> data){
        this.basicSensorPanel = basicSensorPanel;
        this.data = data;
        grabFocus();
        //setBackground(color);
        //leftPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setSize(new java.awt.Dimension(360, 120));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setDoubleBuffered(true);
        //leftPanel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
//        setName(name);
//        setPreferredSize(new java.awt.Dimension(360, 120));
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                
                jPanel1MousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                
                //jPanel1MouseDragged(evt);
            }
        });
    }  
    
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) { 
        setSize((button) ? new Dimension(120, 120) : new Dimension(360, 120));
        
        Point p1 = new Point(getLocation().x + 120, getLocation().y);
        Point p2 = new Point(getLocation().x + 360, getLocation().y);
        
        basicSensorPanel.setLocation((button) ?  p1 : p2);
        
        basicSensorPanel.setVisible(button);
        
        button = !button;
    }                                    

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {                                     
        //sensorFrame.requestFocus();
        
        //posX=evt.getX();
        //posY=evt.getY();
    }                                    

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {
        System.out.println("saf");
        y += 1;
        
        setLocation (0, y);
        //menuFrame.setLocation(evt.getXOnScreen()-posX + this.getWidth() * 3,evt.getYOnScreen()-posY);
        //sensorFrame.setLocation(evt.getXOnScreen()-posX + this.getWidth(),evt.getYOnScreen()-posY);
    }                                    

    
    @Override
            protected void paintComponent(Graphics g) {
                int width = getWidth();
                
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

                GradientPaint gp = new GradientPaint(0, 0, new Color(230,230,230, 0xA0),width, 0, getBackground());
                g2d.setPaint(gp);
                //g2d.fill (new Rectangle(0, 0, width, getHeight()));
                //        g2d.setColor(getBackground().darker());
                //        g2d.drawLine(0, 70, getWidth(), 70);
                //        g2d.setColor(getBackground().brighter());
                //        g2d.drawLine(0, 71, getWidth(), 71);
                //        g2d.draw3DRect(1, 71, getWidth() - 1, 46, sensor1Show);
                //
                
                gp = new GradientPaint(0,0,new Color(230,230,230, 0x0F),width * 2, width, new Color(255,255,255));
                g2d.setPaint(gp);
                //g2d.fillRect(1, 1, 33, 120);
                //g2d.fillRect(1, 31, width - 1, 59);
                
                
                
                g2d.setColor(Color.DARK_GRAY);
                Font font = new Font(getFont().getFamily(), Font.PLAIN, 12);
                g2d.setFont(font);
                //g2d.drawString(name.toUpperCase(), 20, 20);
                
                
                //int sHeight = (int) font.getStringBounds(Sensor.time, frc).getHeight();
                
                font = new Font(getFont().getFamily(), Font.PLAIN, 10);
                g2d.setFont(font);
                                
                if (data.size() > 2) {
                    int sWidth = (int) font.getStringBounds(data.get(data.size() - 1)[1], frc).getWidth();                
                
                    g2d.drawString(data.get(data.size() - 1)[1], width / 2 - sWidth / 2, 107);
                    
                    //        font = new Font(getFont().getFamily(), Font.PLAIN, 10);
                //        g2d.setFont(font);
                //
//                if(button3){
                font = new Font(getFont().getFamily(), Font.PLAIN, 30);
                g2d.setFont(font);
                
                
                
                String s = data.get(data.size() - 1)[0] + "°C";
                
                sWidth = (int) font.getStringBounds(s, frc).getWidth();
                
                
                g2d.drawString(s, width / 2 - sWidth / 2, getHeight() / 2 + 10);
                
                //g2d.setColor(color.darker().darker());
                //g2d.drawLine(1, 29, width, 29);
                //g2d.drawLine(1, 91, width, 91);
                //g2d.setColor(color.brighter());
                //g2d.drawLine(1, 30, width, 30);
                //g2d.drawLine(1, 90, width, 90);
//                }
//                else{
//                    g2d.drawString("ADVANCED", 25, 98);
//                }
                }
                
                

                
                
                super.repaint();
                    
                
            
                                
            }
}
