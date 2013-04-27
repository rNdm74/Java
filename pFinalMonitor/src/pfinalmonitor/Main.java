
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
import java.awt.event.MouseEvent;
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
    private JButton refresh;
    private JButton pause;
    private JScrollPane jscrollpane;
    
    public static JButton button3;
    private boolean click = true;
    
    private int numberOfSensors;
    //private final ChangeListener sliderAction;
    //private final ChangeListener clicked;
        
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
                      
            sensors[i].setPreferredSize(new Dimension(400, 120)); 
            
            if (!"datetime".equals(sensors[i].name)) {
                jpanel.add(sensors[i]);
            }
            
            
        }
        
        
        //jpanel.setLayout(new GridLayout(numberOfSensors, 1));
        
        System.out.println(jpanel.getComponentCount());
        jpanel.remove(sensors[1]);
        //jpanel.add(sensors[1]);
        System.out.println(jpanel.getComponentCount());
        
        jpanel.setLayout(new GridLayout(jpanel.getComponentCount(), 0));
        
        
        jscrollpane = new JScrollPane(jpanel){
            @Override
            public void setHorizontalScrollBarPolicy(int policy) {
                super.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            }             
        };   
         
        
        //<editor-fold defaultstate="collapsed" desc=" Toolbar ">
        
        JToolBar bottomtoolbar = new JToolBar(); 
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 2, 0); 
        toptoolbar.setLayout(layout);
        //GridBagConstraints gbc = new GridBagConstraints();       
        
        toptoolbar.setRollover(true);
        toptoolbar.setFloatable(false);
        toptoolbar.setAutoscrolls(true);
        
        layout = new FlowLayout(FlowLayout.RIGHT, 2, 0);
        bottomtoolbar.setLayout(layout);
        bottomtoolbar.setRollover(true);
        bottomtoolbar.setFloatable(false);
        bottomtoolbar.setPreferredSize(new Dimension(getWidth(), 22));
        
        
        bottomtoolbar.addSeparator(new Dimension(5,20));
        bottomtoolbar.add(new JLabel("  " + xml.getnList() + "  "));
        bottomtoolbar.addSeparator(new Dimension(5,20));
        bottomtoolbar.add(new JLabel(" SENSORS "));
        
        JButton button = new JButton("Home");
        button.setPreferredSize(new Dimension(90, 30));   
        Image img = Toolkit.getDefaultToolkit().getImage("home.png");
        button.setIcon(new ImageIcon(img)); 
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    for(Sensor s: sensors){
                        s.leftPanel.setVisible(true);
                        s.rightPanel.setVisible(false);
                    }
                    //click = !click;
                }                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        toptoolbar.add(button);
        
        JButton button2 = new JButton("Activity");
        button2.setPreferredSize(new Dimension(90, 30));   
        img = Toolkit.getDefaultToolkit().getImage("activity.png");
        button2.setIcon(new ImageIcon(img)); 
        button2.setFocusPainted(false);
        button2.setFocusable(false);
        button2.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    for(Sensor s: sensors){
                        s.leftPanel.setVisible(false);
                        s.rightPanel.setVisible(true);
                        s.advancedSensorPanel.setVisible(true);
                    }
                    //click = !click;
                }                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        toptoolbar.add(button2);
                       
        //toptoolbar.addSeparator(new Dimension(20,20));
        
        button3 = new JButton("Graph");
        button3.setPreferredSize(new Dimension(90, 30));  
        img = Toolkit.getDefaultToolkit().getImage("graph.png");
        button3.setIcon(new ImageIcon(img)); 
        button3.setFocusPainted(false);
        button3.setFocusable(false);        
        button3.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    for(Sensor s: sensors){
                        s.leftPanel.setVisible(false);
                        s.rightPanel.setVisible(true);
                        s.advancedSensorPanel.setVisible(false);
                    }
                    //click = !click;
                }                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        toptoolbar.add(button3);
        
        //toptoolbar.addSeparator(new Dimension(10,0));
        
//        ComboBox sensorsList = new ComboBox(xml);
//        sensorsList.setPreferredSize(new Dimension(115, 27));
//        //sensorsList.addPopupMenuListener(PopupMenuListener);
//        sensorsList.setFocusable(false);
//        toptoolbar.add(sensorsList);
        
        pause = new JButton("Pause"); 
        pause.setPreferredSize(new Dimension(90, 30));
        img = Toolkit.getDefaultToolkit().getImage("pause.png");
        pause.setIcon(new ImageIcon(img));    
        pause.setFocusPainted(false);
        pause.setFocusable(false);
        pause.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String string = (!click) ? "Pause" : "Play";
                Task.pause = click;
                
                Image img = Toolkit.getDefaultToolkit().getImage(string + ".png");
                pause.setText(string);
                pause.setIcon(new ImageIcon(img));
                click = !click;
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        toptoolbar.add(pause);
        
        //toptoolbar.addSeparator(new Dimension(20,20));
        JButton plus = new JButton();
        plus.setPreferredSize(new Dimension(30, 30));
        img = Toolkit.getDefaultToolkit().getImage("arrow-7-up.png");
        plus.setIcon(new ImageIcon(img));
        plus.setFocusPainted(true);
        plus.setFocusable(false);
        plus.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Task.delay += 100;
                refresh.setText(Long.toString(Task.delay) + " ms");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        toptoolbar.add(plus);
        
        
        refresh = new JButton(Long.toString(Task.delay) + " ms");
        refresh.setPreferredSize(new Dimension(90, 30));
        refresh.setFocusable(false);
        img = Toolkit.getDefaultToolkit().getImage("time.png");
        refresh.setIcon(new ImageIcon(img));
        toptoolbar.add(refresh);
        
        
        
        
        
        //toptoolbar.addSeparator(new Dimension(20,20));
        
        JButton minus = new JButton();
        minus.setPreferredSize(new Dimension(30, 30));
        img = Toolkit.getDefaultToolkit().getImage("arrow-7-down.png");
        minus.setIcon(new ImageIcon(img));
        minus.setFocusPainted(false);
        minus.setFocusable(false);
        minus.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Task.delay -= 100;
                refresh.setText(Long.toString(Task.delay) + " ms");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
                System.out.println(e.getButton());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        toptoolbar.add(minus);
        
        //toptoolbar.addSeparator(new Dimension(20,20));
        
        
        
        JButton settings = new JButton("Settings"); 
        settings.setPreferredSize(new Dimension(90, 30));
        img = Toolkit.getDefaultToolkit().getImage("settings.png");
        settings.setIcon(new ImageIcon(img));    
        settings.setFocusPainted(false);
        settings.setFocusable(false);
        settings.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
              jpanel.remove(sensors[0]);
              jpanel.add(sensors[1]); 
              System.out.println(jpanel.getComponentCount());
              
        
              jpanel.setLayout(new GridLayout(jpanel.getComponentCount(), 0));
              
              jpanel.revalidate();
              pack();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        toptoolbar.add(settings);
        
        //toptoolbar.addSeparator(new Dimension(20,20));
        
//        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 1000, 1000);        
//        slider.setFocusable(false);
//        slider.setSnapToTicks(true);
//        slider.setPreferredSize(new Dimension(80,40));
//        
//        slider.setInverted(true);   
//        slider.setPaintLabels(true);
//        slider.setIgnoreRepaint(true);        
//        sliderAction=new ChangeListener() {
//            @Override
//            public void stateChanged (ChangeEvent event)
//            {
//                JSlider jslider=(JSlider)event.getSource();
//                int delay = jslider.getValue();
//                time.setText((delay == 1000) ? "1 sec" : delay + " ms");
//                Task.delay = delay;                
//            }
//        };        
//        slider.addChangeListener(sliderAction);          
//        time.setPreferredSize(new Dimension(50,40));
//        toptoolbar.add(slider);  
//        toptoolbar.add(time);
        //</editor-fold>        
        
        getContentPane().add(toptoolbar, BorderLayout.PAGE_START);
        getContentPane().add(bottomtoolbar, BorderLayout.PAGE_END);
        getContentPane().add(jscrollpane, BorderLayout.CENTER);
        
        menu = new Menu();
        
        setJMenuBar(menu);
        
        //setMinimumSize(new Dimension(700, 120));
        
        setLocation(size.width / 2 - getWidth() / 2, 0);
        
        pack();
        
        setVisible(true); 
        
        //<editor-fold defaultstate="collapsed" desc=" Listeners ">
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //System.out.println(
                mainSize = getSize();
                
                
                for (int i = 0; i < sensors.length; i++) {
                    
                    sensors[i].getComponents()[1].setSize(new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));
//                            (sensors[i].leftPanel.button) ? 
//                            ) :
//                            new Dimension(0, Main.sensors[0].getHeight()));
                    
                    if(sensors[i].leftPanel.button){
                      sensors[i].leftPanel.setSize(new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));  
                    }
                     
                    sensors[i].rightPanel.setSize(getWidth(), Main.sensors[0].getHeight()); 
                    
                    sensors[i].advancedSensorPanel.setSize(FinalMonitorApp.size.width, Main.sensors[0].getHeight());
                    sensors[i].advancedSensorPanel.setLocation(getWidth() - (FinalMonitorApp.size.width +20), 0);  
                    
                    //toptoolbar.setVisible(!(mainSize.width < 180));
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