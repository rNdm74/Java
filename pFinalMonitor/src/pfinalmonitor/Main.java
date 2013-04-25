
package pfinalmonitor;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ListCellRenderer;
import javax.swing.Renderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

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
        
        JToolBar jtoolbar = new JToolBar(); 
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 2, -1);
        jtoolbar.setLayout(layout);
        jtoolbar.setRollover(true);
        //jtoolbar.setLayout(null);
        jtoolbar.setFloatable(false);
        jtoolbar.setPreferredSize(new Dimension(getWidth(), 32));
        
        //jtoolbar.addSeparator(new Dimension(5,20));
        
        JButton button = new JButton("Pause");        
        //button.setBounds(10, 0, 90, 31);
        button.setPreferredSize(new Dimension(90, 31));
        Image img = Toolkit.getDefaultToolkit().getImage("pause.png");
        button.setIcon(new ImageIcon(img));    
        button.setFocusPainted(false);
        button.setFocusable(false);
        jtoolbar.add(button);
        
        jtoolbar.addSeparator(new Dimension(20,20));
        
        button = new JButton("Realtime");
        button.setPreferredSize(new Dimension(100, 31));   
        img = Toolkit.getDefaultToolkit().getImage("time.png");
        button.setIcon(new ImageIcon(img)); 
        button.setFocusPainted(false);
        button.setFocusable(false);
        jtoolbar.add(button);
        
        jtoolbar.addSeparator(new Dimension(20,20));
        
        button = new JButton("Graph");
        button.setPreferredSize(new Dimension(80, 31));  
        img = Toolkit.getDefaultToolkit().getImage("graph.png");
        button.setIcon(new ImageIcon(img)); 
        button.setFocusPainted(false);
        button.setFocusable(false);
        jtoolbar.add(button);
        
        
        ComboBox sensorsList = new ComboBox(xml);
        sensorsList.setPreferredSize(new Dimension(80, 29));
        //sensorsList.addPopupMenuListener(PopupMenuListener);
        sensorsList.setFocusable(false);
        jtoolbar.add(sensorsList);
        
        getContentPane().add(jtoolbar, BorderLayout.PAGE_START);
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
