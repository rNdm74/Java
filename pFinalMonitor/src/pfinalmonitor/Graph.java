
package pfinalmonitor;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Graph extends JPanel{    
    //private AffineTransform affinetransform = new AffineTransform();     
    //private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    
    JPanel sensorpanel;      
    
    public Graph(final JPanel sensorpanel){  
        this.sensorpanel = sensorpanel;
        
        //setSize(sensorpanel.getSize());
        
        setOpaque(true);
        
        //setLayout(null);        
        
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = sensorpanel.getWidth();  
        int height = sensorpanel.getHeight();
                
        for (int i = 1; i < sensorpanel.getComponentCount(); i++) {
            //sensorpanel.getComponent(i).setVisible(false);
        }
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
                
        GradientPaint gp = new GradientPaint(0,0, Color.GRAY.brighter(), width, 0, new Color(230,230,230, 0xA0));
        g2d.setPaint(gp);
        
        g2d.drawLine(33, 0, 33, height);
        g2d.drawLine(0, 200, width, 200);
        
        super.repaint();
    } 
}

