
package pfinalmonitor;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Sensor extends javax.swing.JPanel {   
    
    public Sensor(JPanel sensorpanel, String name) throws IOException {
        this.sensorpanel = sensorpanel;
        this.name = name;
        
        setLayout(null);
        
        setBackground(Color.white);
        
        setPreferredSize(new Dimension(120, 120));
        
        setSize(new Dimension(120, 120));               
        
        initComponents();
        
        setOpaque(false);
    }
       

    // <editor-fold defaultstate="collapsed" desc="initComponents()">                          
    private void initComponents() throws IOException {        
        size = new Dimension(getWidth(), getHeight());        
        data = new ArrayList<>();
        
        home = new Home(sensorpanel, data);
        home.setName(name);
        
        activity = new Activity(sensorpanel, data); 
        activity.setName(name);
        
        //graph = new Graph(sensorpanel);   
        //graph.setName(name);
        
        home.setBackground(getBackground());
        activity.setBackground(getBackground());        
        //graph.setBackground(getBackground());        
        
        add(home); 
        add(activity);
        //add(graph);        
        
    }// </editor-fold>                       
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    public JPanel sensorpanel;
    
    public Home home;
    public Graph graph;
    public Activity activity;
    
    public Dimension size;
    
    public String name;
    public ArrayList<String[]> data;                     
    //</editor-fold>
}

