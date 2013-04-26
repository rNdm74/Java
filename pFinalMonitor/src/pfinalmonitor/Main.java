
package pfinalmonitor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends javax.swing.JFrame {
    public static Dimension mainSize;
    public static int delay = 1000;
    
    protected static Sensor[] sensors;
    
    private XML xml;
    private Task[] tasks;
    
    private ScheduledExecutorService service;
    private Menu menu;
    private JPanel jpanel;
    private JToolBar toptoolbar;
    private JLabel time;
    private JScrollPane jscrollpane;
    
    private int numberOfSensors;
    private final ChangeListener sizeAction;
        
    public Main(Dimension size) throws IOException{ 
        try {            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (ClassNotFoundException | 
                 InstantiationException | 
                 IllegalAccessException | 
                 UnsupportedLookAndFeelException e) {
                System.out.println(e);
        }
        
        xml = new XML();  
        mainSize = new Dimension(getWidth(), getHeight());
        numberOfSensors = xml.getnList();        
        jpanel = new JPanel();  
        toptoolbar = new JToolBar();
        time = new JLabel("1 sec");
        service = Executors.newSingleThreadScheduledExecutor();
        tasks = new Task[numberOfSensors];          
        sensors = new Sensor[numberOfSensors];       
           
        for (int i = 0; i < sensors.length; i++) {
            sensors[i] = new Sensor(Color.white, xml.getSensors().get(i)); 
            
            tasks[i] = new Task(sensors[i]);             
            
            service.scheduleAtFixedRate(tasks[i],0, 1, TimeUnit.MILLISECONDS);
                      
            sensors[i].setPreferredSize(new Dimension(600, 120)); 
            
            jpanel.add(sensors[i]);
        }
        
        jpanel.setLayout(new GridLayout(numberOfSensors, 1));
        
        jscrollpane = new JScrollPane(jpanel){
            @Override
            public void setHorizontalScrollBarPolicy(int policy) {
                super.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            }             
        };   
                
        JToolBar bottomtoolbar = new JToolBar(); 
         
        toptoolbar.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();       
        
        toptoolbar.setRollover(true);
        toptoolbar.setFloatable(false);
        toptoolbar.setAutoscrolls(true);
        
        FlowLayout layout = new FlowLayout(FlowLayout.RIGHT, 2, 0);
        bottomtoolbar.setLayout(layout);
        bottomtoolbar.setRollover(true);
        bottomtoolbar.setFloatable(false);
        bottomtoolbar.setPreferredSize(new Dimension(getWidth(), 22));
        
        
        bottomtoolbar.addSeparator(new Dimension(5,20));
        bottomtoolbar.add(new JLabel("  " + xml.getnList() + "  "));
        bottomtoolbar.addSeparator(new Dimension(5,20));
        bottomtoolbar.add(new JLabel(" SENSORS "));
        
        JButton button = new JButton("Pause");        
        //button.setBounds(10, 0, 90, 31);
        button.setPreferredSize(new Dimension(80, 31));
        Image img = Toolkit.getDefaultToolkit().getImage("pause.png");
        button.setIcon(new ImageIcon(img));    
        button.setFocusPainted(false);
        button.setFocusable(false);
        toptoolbar.add(button, gbc);
        
        toptoolbar.addSeparator(new Dimension(20,20));
        
        button = new JButton("Realtime");
        button.setPreferredSize(new Dimension(80, 31));   
        img = Toolkit.getDefaultToolkit().getImage("time.png");
        button.setIcon(new ImageIcon(img)); 
        button.setFocusPainted(false);
        button.setFocusable(false);
        toptoolbar.add(button, gbc);
                       
        toptoolbar.addSeparator(new Dimension(20,20));
        
        button = new JButton("Graph");
        button.setPreferredSize(new Dimension(80, 31));  
        img = Toolkit.getDefaultToolkit().getImage("graph.png");
        button.setIcon(new ImageIcon(img)); 
        button.setFocusPainted(false);
        button.setFocusable(false);
        toptoolbar.add(button);
        
        toptoolbar.addSeparator(new Dimension(10,0));
        
        ComboBox sensorsList = new ComboBox(xml);
        sensorsList.setPreferredSize(new Dimension(115, 27));
        //sensorsList.addPopupMenuListener(PopupMenuListener);
        sensorsList.setFocusable(false);
        toptoolbar.add(sensorsList, gbc);
        
        toptoolbar.addSeparator(new Dimension(20,20));
        
        JLabel refresh = new JLabel(" Refresh ");
        img = Toolkit.getDefaultToolkit().getImage("refresh.png");
        refresh.setIcon(new ImageIcon(img));
        toptoolbar.add(refresh,gbc);
        
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 1000, 1000);        
        slider.setFocusable(false);
        slider.setSnapToTicks(true);
        slider.setPreferredSize(new Dimension(80,30));
        slider.setInverted(true);   
        //slider.setExtent(50);
        //slider.setMinorTickSpacing(50);
        //slider.setMajorTickSpacing(500);
        //slider.setPaintTicks(true);
        sizeAction=new ChangeListener() {
            @Override
            public void stateChanged (ChangeEvent event)
            {
                JSlider jslider=(JSlider)event.getSource();
                int delay = jslider.getValue();
                time.setText((delay == 1000) ? "1 sec" : delay + " ms");
                Task.delay = delay;                
            }
        };
        
        slider.addChangeListener(sizeAction);  
        
        time.setPreferredSize(new Dimension(40,30));
        toptoolbar.add(slider, gbc);  
        toptoolbar.add(time);
                
        
        getContentPane().add(toptoolbar, BorderLayout.PAGE_START);
        getContentPane().add(bottomtoolbar, BorderLayout.PAGE_END);
        getContentPane().add(jscrollpane, BorderLayout.CENTER);
        
        menu = new Menu();
        setJMenuBar(menu);
        
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
                            new Dimension(105, Main.sensors[0].getHeight()));
                    
                    if(sensors[i].leftPanel.button){
                      sensors[i].leftPanel.setSize(new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));  
                    }
                     
                    sensors[i].rightPanel.setSize(getWidth(), Main.sensors[0].getHeight());                    
                    sensors[i].advancedSensorPanel.setSize(FinalMonitorApp.size.width, Main.sensors[0].getHeight());
                    sensors[i].advancedSensorPanel.setLocation(getWidth() - (FinalMonitorApp.size.width + 163), 0);  
                    
                    toptoolbar.setVisible(!(mainSize.width < 180));
                }
                super.componentResized(e);
            }
        });
        
        addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 18){
                    menu.setVisible(true);
                };                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == 18){                    
                };
            }
        });
        
        addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                menu.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
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