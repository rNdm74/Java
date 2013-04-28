
package pfinalmonitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import static pfinalmonitor.Main.sensors;

/**
 *
 * @author rndm
 */
public class Sensor extends javax.swing.JPanel {   
       
    
    public Sensor(Color color, String name) throws IOException {
        this.color = color;
        this.name = name;
        
        setLayout(null);
        
        setPreferredSize(new Dimension(600, 120));
        
        setSize(new Dimension(600, 120));
        
        
        
        initComponents();
        
        setOpaque(false);
    }
       

    // <editor-fold defaultstate="collapsed" desc="initComponents()">                          
    private void initComponents() throws IOException {        
        size = new Dimension(FinalMonitorApp.size.width, getHeight());
        
        advancedSensorPanel = new EmbeddedSensor(color, size, data); 
        advancedSensorPanel.setName(name);
        
        rightPanel = new RightPanel(size);        
        rightPanel.add(advancedSensorPanel);
        rightPanel.setName(name);
        
        leftPanel = new LeftPanel(rightPanel, data);
        leftPanel.setName(name);
                
        rightPanel.setBackground(color);
        leftPanel.setBackground(color);
        
        add(rightPanel);        
        add(leftPanel); 
    }// </editor-fold>                       
    
    public LeftPanel leftPanel;
    public RightPanel rightPanel;
    public EmbeddedSensor advancedSensorPanel;
    public Dimension size;
    public String time = "";
    public String name = "";
    public ArrayList<String[]> data = new ArrayList<>();
    
    private Color color;
    private boolean button = true;
    private AffineTransform affinetransform = new AffineTransform();     
    private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    // End of variables declaration                   
//</editor-fold>
}

