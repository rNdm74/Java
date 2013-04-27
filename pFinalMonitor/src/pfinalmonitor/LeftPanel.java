
package pfinalmonitor;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

/**
 *
 * @author rNdm
 */
public class LeftPanel extends JPanel {
    private AffineTransform affinetransform = new AffineTransform();     
    private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    
    public boolean button = true;
    public boolean hover;
    
    private RightPanel sensor;  
    
    
    private ArrayList<String[]> data = new ArrayList<>();
    private int width;
    private Point mouse = new Point();
    
    public LeftPanel(RightPanel sensor, ArrayList<String[]> data){
        this.sensor = sensor;
        this.data = data;
        
        setOpaque(true);
        //setSize(new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));//System.out.println(this.getParent().);
        setBackground(Color.white);
        //setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                   
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
            }
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
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
    
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) { 
        //setVisible(!button);
//        setSize((button) ? new Dimension(0, Main.sensors[0].getHeight()) : 
//                new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));
        //sensor.setLocation(getWidth(), 0);
        //sensor.setVisible(button);    
        
        
        String name = evt.getComponent().getName();
        
        
        name = "Monitor - " + (name.substring(0, 1).toUpperCase() + name.substring(1));
        
        FinalMonitorApp.monitor.setTitle(name);
        //Main.button3.setText(name);
        button = !button;
    }                                    
    
    @Override
    protected void paintComponent(Graphics g) {
        width = getWidth();

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
        
        


        //int sHeight = (int) font.getStringBounds(Sensor.time, frc).getHeight();

        Font font = new Font(getFont().getFamily(), Font.PLAIN, 12);
        g2d.setFont(font);

        if (data.size() > 2) {
            

            //g2d.drawString(data.get(data.size() - 1)[1], width - (sWidth + 20), getHeight() / 2 - sHeight / 2 + 30);
            font = new Font(getFont().getFamily(), Font.PLAIN, 30);
            g2d.setFont(font);

            String value = data.get(data.size() - 1)[0];

            int sWidth = (int) font.getStringBounds(value, frc).getWidth();
            int sHeight = (int) font.getStringBounds(value, frc).getHeight();
            
            //System.out.println(sHeight / 2);
            
            int valuePosition = (width > 300) ? width / 2 - sWidth / 2 : 100;
            
            g2d.drawString(value, valuePosition, getHeight()  / 2 + 8);
            
            
            Rectangle rect = new Rectangle(0, 0, width - 19, getHeight() - 1);
            
            
            
            
            g2d.setColor(new Color(230,230,230, 0xFF));
            //g2d.drawLine(width - 62, 0, width - 62, getHeight());
            //g2d.drawLine(70, 0, 70, getHeight());
            //g2d.setColor(Color.LIGHT_GRAY);
            //g2d.drawLine(71, 0, 71, getHeight());
            
            BufferedImage img = null;
            String name = getName();
            try {
                img = ImageIO.read(new File((name.contains("temp"))? "temp32.png" : "light32.png"));
            } catch (IOException e) {
                
            }
            
            if (button) {
                //g2d.setColor(new Color(230,230,230, 0xFF));
                //g2d.drawLine(width - 60, 0, width - 60, getHeight());
                //g2d.drawLine(70, 0, 70, getHeight());
                
            }
            g2d.drawImage(img, 18, getHeight() / 2 - 16, null);
                    
            if (hover) {
                gp = new GradientPaint(0,-10,new Color(135, 206, 250), 0, getHeight(), new Color(255, 255, 255));
                g2d.setPaint(gp);
                //g2d.drawLine(70, 0, 70, getHeight() - 2);
                
                gp = new GradientPaint(0,-10,new Color(255, 255, 255), 0, getHeight(), new Color(255, 255, 255));
                g2d.setPaint(gp);
                //g2d.drawLine(71, 1, 71, getHeight() - 2);
                
                //setSize(new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));
                gp = new GradientPaint(0, getHeight() / 2,new Color(135, 206, 250,0x30), 0, getHeight(), new Color(255, 255, 255, 0x2A));
                g2d.setPaint(gp);
                g2d.fillRoundRect(2, getHeight() / 2, width - 5, (getHeight() / 2) - 1, 5, 5);
                
                gp = new GradientPaint(0, getHeight(),new Color(135, 206, 250,0x2F), 0, 0, new Color(255, 255, 255, 0x2A));
                g2d.setPaint(gp);
                g2d.fillRoundRect(2, 0, width - 5, getHeight() / 2, 5, 5);
                
                gp = new GradientPaint(0,0,new Color(135, 206, 250),0, 0, new Color(135, 206, 250));
                g2d.setPaint(gp);
                g2d.drawRoundRect(2, 0, width - 5, getHeight() - 1, 5, 5);
                        
                font = new Font(getFont().getFamily(), Font.HANGING_BASELINE, 12);        
                int rWidth = (int) font.getStringBounds(getName().toUpperCase(), frc).getWidth(); 
                
                sWidth = (int) font.getStringBounds(data.get(data.size() - 1)[1], frc).getWidth(); 
                sHeight = (int) font.getStringBounds(data.get(data.size() - 1)[1], frc).getHeight();
                int rHeight = (int) font.getStringBounds(getName().toUpperCase(), frc).getHeight();

                g2d.setFont(font);
                g2d.drawString(getName().toUpperCase(), 15, getHeight() / 2 - rHeight / 2 - 25);
                g2d.drawString(data.get(data.size() - 1)[1], width - (sWidth + 20), getHeight() / 2 - sHeight / 2 + 45);
                
                
            }
            
            
                
            
        }
        super.repaint();
    }
}
