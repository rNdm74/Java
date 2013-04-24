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
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
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
        setSize((button) ? new Dimension(180, Main.sensors[0].getHeight()) : 
                new Dimension(Main.mainSize.width, Main.sensors[0].getHeight()));
                
        sensor.setVisible(button);        
        button = !button;
    }                                    
    
    @Override
    protected void paintComponent(Graphics g) {
        width = getWidth();

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
        
        

        g2d.setColor(new Color(230,230,230, 0xFF));
        //g2d.drawLine(width - 1, 0, width - 1, getHeight() - 1);
        g2d.drawLine(0, getHeight() - 1, width, getHeight() - 1);

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
            int sHeight = (int) font.getStringBounds(data.get(data.size() - 1)[1], frc).getHeight();

            g2d.drawString(data.get(data.size() - 1)[1], width / 2 - sWidth / 2, getHeight() / 2 - sHeight / 2 + 40);
            font = new Font(getFont().getFamily(), Font.PLAIN, 30);
            g2d.setFont(font);

            String s = data.get(data.size() - 1)[0] + "°C";

            sWidth = (int) font.getStringBounds(s, frc).getWidth();


            g2d.drawString(s, width / 2 - sWidth / 2, getHeight() / 2 - sHeight / 2 + 10);
            
            Rectangle rect = new Rectangle(0, 0, width - 19, getHeight() - 1);
            
            if (hover) {
                gp = new GradientPaint(0,0,new Color(230,230,230, 0x0F), width * 4, width * 4, Color.CYAN.brighter());
                g2d.setPaint(gp);
                g2d.fillRoundRect(0, 0, width - 19, getHeight() - 1, 10, 10);
                gp = new GradientPaint(0,0,Color.CYAN.darker(),width, width, Color.CYAN.darker());
                g2d.setPaint(gp);
                g2d.drawRoundRect(0, 0, width - 19, getHeight() - 1, 10, 10);
            }
        }
        super.repaint();
    }
}
