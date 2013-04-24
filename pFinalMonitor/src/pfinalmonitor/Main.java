
package pfinalmonitor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.util.Timer;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends javax.swing.JFrame {
    public static Dimension mainSize;
    
    protected static Sensor[] sensors;
    
    private XML xml;
    private Task[] tasks;
    
    private Timer timer;
    private JPanel jpanel;    
    private JScrollPane jscrollpane;
    
    private int numberOfSensors;
        
    public Main(Dimension size){ 
        try {            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (ClassNotFoundException | 
                 InstantiationException | 
                 IllegalAccessException | 
                 UnsupportedLookAndFeelException e) {
                System.out.println(e);
        }
        
        xml = new XML();        
        numberOfSensors = xml.getnList();        
        jpanel = new JPanel();  
        timer = new Timer();
        tasks = new Task[numberOfSensors];          
        sensors = new Sensor[numberOfSensors];       
           
        for (int i = 0; i < sensors.length; i++) {
            sensors[i] = new Sensor(Color.white, xml.getSensors().get(i));            
            tasks[i] = new Task(sensors[i]);             
            timer.schedule(tasks[i], 0, 1000);             
            sensors[i].setPreferredSize(new Dimension(640, 120));             
            jpanel.add(sensors[i]);
        }
        
        jpanel.setLayout(new GridLayout(numberOfSensors, 0));
        
        jscrollpane = new JScrollPane(jpanel){
            @Override
            public void setHorizontalScrollBarPolicy(int policy) {
                super.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            }             
        };   
        
        getContentPane().add(jscrollpane, BorderLayout.CENTER);
                
        setJMenuBar(new Menu());
        
        setMinimumSize(new Dimension(640, 120));
        
        setLocation(size.width / 2 - getWidth() / 2, 0);
        
        pack();
        
        setVisible(true); 
        
        //<editor-fold defaultstate="collapsed" desc=" Listeners ">
        // Variables declaration - do not modify
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) { 
                mainSize = getSize();
                for (int i = 0; i < sensors.length; i++) {
                    
                    sensors[i].getComponents()[1].setSize((sensors[i].leftPanel.button) ? 
                            new Dimension(getWidth(), Main.sensors[0].getHeight()) :
                            new Dimension(180, Main.sensors[0].getHeight()));
                                        
                    sensors[i].rightPanel.setSize(getWidth(), Main.sensors[0].getHeight());                    
                    sensors[i].advancedSensorPanel.setLocation(getWidth() - (FinalMonitorApp.size.width + 198), Main.sensors[0].getHeight() - 120);                    
                }
                super.componentResized(e);
            }
        });
        
        addWindowListener(new java.awt.event.WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        // End of variables declaration                   
        //</editor-fold>
    }
}
