
package pfinalmonitor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
//import static pfinalmonitor.Main.sensorpanel;

public class Home extends JPanel {
    private AffineTransform affinetransform = new AffineTransform();     
    private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    
    public boolean button = true;
    public boolean hover;
    
    private JPanel sensorpanel;  
    
    
    private ArrayList<String[]> data = new ArrayList<>();
    private int width;
    private Point mouse = new Point();
    
    public Home(final JPanel sensorpanel, ArrayList<String[]> data){
        this.sensorpanel = sensorpanel;
        this.data = data;
        
        setOpaque(false);
        //setSize(new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));//System.out.println(this.getParent().);
        
        //setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                   
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                Main.selectedSensor.setText(" ");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                Main.selectedSensor.setPreferredSize(new Dimension(getWidth() - 100,20));                
                Main.selectedSensor.setText(getName().toUpperCase());
            }
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Dimension d = FinalMonitorApp.monitor.getSize();
                
                for (Sensor s: Main.sensors) {
                    if (s.name.equals(evt.getComponent().getName())) {
                        sensorpanel.remove(s);
                    }
                }
                
                sensorpanel.setLayout(new GridLayout(sensorpanel.getComponentCount(), 1));
                
                FinalMonitorApp.monitor.getContentPane().add(new JPanel(), BorderLayout.EAST);
                
                FinalMonitorApp.monitor.pack();
                
                FinalMonitorApp.monitor.setSize(d);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
            }
        });        
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                leftPanelMouseMoved(evt);
            }
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
            }
        });
    } 
    
    private void leftPanelMouseMoved(MouseEvent evt) {
        mouse = evt.getPoint();
    }  
    
    @Override
    protected void paintComponent(Graphics g) {
        width = sensorpanel.getWidth();

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
//        // for antialiasing geometric shapes
//        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
//            RenderingHints.VALUE_ANTIALIAS_ON );

        // for antialiasing text
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

//        // to go for quality over speed
//        g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
//            RenderingHints.VALUE_RENDER_QUALITY );

        GradientPaint gp = new GradientPaint(0, 0, new Color(230,230,230, 0xA0),width, 0, getBackground());
        g2d.setPaint(gp);
        
        

        g2d.setColor(new Color(230,230,230, 0xFF));
        g2d.drawLine(width - 1, 0, width - 1, getHeight() - 1);
        //g2d.drawLine(70, getHeight() - 1, width - 62, getHeight() - 1);

        gp = new GradientPaint(0,0,new Color(230,230,230, 0x0F),width * 2, width, new Color(255,255,255));
        g2d.setPaint(gp);
        //g2d.fillRect(1, 1, 33, 120);
        //g2d.fillRect(1, 31, width - 1, 59);

        g2d.setColor(Color.DARK_GRAY);

        Font font = new Font(getFont().getFamily(), Font.PLAIN, 12);
        g2d.setFont(font);
        
        if (data.size() > 2) {
            //g2d.drawString(data.get(data.size() - 1)[1], width - (sWidth + 20), getHeight() / 2 - sHeight / 2 + 30);
            //System.out.println(getHeight() / 7);
            font = new Font(getFont().getFamily(), Font.PLAIN, getHeight() / 4);
            g2d.setFont(font);

            String value = data.get(data.size() - 1)[0];

            int sWidth = (int) font.getStringBounds(value, frc).getWidth();
            int sHeight = (int) font.getStringBounds(value, frc).getHeight();            
            int valuePosition = (width > 300) ? width / 2 - sWidth / 2 : 100;
            
            g2d.drawString(value, width / 2 - sWidth / 2, getHeight()  / 2 + 8);
                        
            Rectangle rect = new Rectangle(0, 0, width - 19, getHeight() - 1);
            
            g2d.setColor(new Color(230,230,230, 0xFF));

            g2d.setPaint(Color.LIGHT_GRAY);
            g2d.drawRoundRect(3, 2, width - 6, getHeight() - 4, 5, 5);
            
            mouseOver(g2d);
        }
        
        super.repaint();
    }

    private void mouseOver(Graphics2D g2d) {
        GradientPaint gp;
        Font font;
        int sWidth;
        int sHeight;
        
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
            g2d.drawRoundRect(3, 2, width-6, getHeight()-4, 5, 5);

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
