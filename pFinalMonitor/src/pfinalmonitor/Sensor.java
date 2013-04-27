
package pfinalmonitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;

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
    
    public Sensor(Color color, String name) throws IOException {
        this.color = color;
        this.name = name;
        //setDoubleBuffered(true);
        setLayout(null);
        initComponents();        
    }

    // <editor-fold defaultstate="collapsed" desc="initComponents()">                          
    private void initComponents() throws IOException {
        Dimension size = new Dimension(FinalMonitorApp.size.width, 120);
        
        advancedSensorPanel = new EmbeddedSensor(color, size, data); 
        advancedSensorPanel.setName(name);
        
        rightPanel = new RightPanel(size);        
        rightPanel.add(advancedSensorPanel);
        
        leftPanel = new LeftPanel(rightPanel, data);
        leftPanel.setName(name);
        
        //leftPanel.setSize(new Dimension(400, 120));
        
        rightPanel.setBackground(color);
        leftPanel.setBackground(color);
        
        add(rightPanel);        
        add(leftPanel); 
    }// </editor-fold>                       
    
    public LeftPanel leftPanel;
    public RightPanel rightPanel;
    public EmbeddedSensor advancedSensorPanel;
    // End of variables declaration                   
//</editor-fold>
}

