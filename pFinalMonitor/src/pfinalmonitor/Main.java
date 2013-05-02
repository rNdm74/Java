
package pfinalmonitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Main extends javax.swing.JFrame {
    public Main() throws IOException{ 
        try {            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            getContentPane().add(topToolBar(), BorderLayout.PAGE_START);
            getContentPane().add(new JPanel(), BorderLayout.WEST);
            getContentPane().add(jscrollPane(), BorderLayout.CENTER);
            getContentPane().add(new JPanel(), BorderLayout.EAST);
            getContentPane().add(bottomToolBar(), BorderLayout.PAGE_END);

            setLocation(FinalMonitorApp.size.width / 2 - getWidth() / 2, 0);

            pack();

            setVisible(true);        
            
        } catch (ClassNotFoundException | 
                 InstantiationException | 
                 IllegalAccessException | 
                 UnsupportedLookAndFeelException e) {
                System.out.println(e);
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Listeners ">         
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //System.out.println(getSize());
                //System.out.println(sizeChanged);

                mainSize = getSize();

                for (Sensor s: sensors) { 
                    s.home.setSize(frameSize());
                    s.activity.setSize(frameSize());
                }
                
                super.componentResized(e);
            }
            
            private Dimension frameSize() {
                return new Dimension(width(), height());
            }
            private boolean isWindows() {
                return System.getProperty("os.name").contains("Windows");
            }
            private int height() {
                return sensorpanel.getComponents()[0].getHeight();
            }
            private int width() {
                return (isWindows()) ? getWidth() - 18 :  getWidth();
            }                        
        });        
        addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 18){
                    //menu.setVisible(true);
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
                //menu.setVisible(false);
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
        //</editor-fold>
    } 
    
    //<editor-fold defaultstate="collapsed" desc=" Methods ">
    private JButton settings() {
        Image img;
        JButton settings = new JButton("Settings");
        settings.setPreferredSize(new Dimension(90, 30));
        img = Toolkit.getDefaultToolkit().getImage("settings.png");
        settings.setIcon(new ImageIcon(img));
        settings.setFocusPainted(false);
        settings.setFocusable(false);
        settings.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
              //sensorpanel.removeAll();
              
              //sensorpanel.add(sensors.get(3));
              //jpanel.remove(sensors.get(6));
              
              //sensorpanel.setLayout(new GridLayout(sensorpanel.getComponentCount(), 1));
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
        return settings; 
    } 
    private JButton refresh() {
        Image img;
        refresh = new JButton(Long.toString(Task.delay) + " ms");
        refresh.setPreferredSize(new Dimension(90, 30));
        refresh.setFocusable(false);
        img = Toolkit.getDefaultToolkit().getImage("time.png");
        refresh.setIcon(new ImageIcon(img));
        return refresh;
    }
    private JButton minus() {
        Image img;
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
                
                //System.out.println(e.getButton());
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
        return minus;
    }
    private JButton plus() {
        Image img;
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
                sizeChanged = false;
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
        return plus;
    }
    private JButton pause() {
        Image img;
        pause = new JButton("Pause");
        pause.setPreferredSize(new Dimension(90, 30));
        img = Toolkit.getDefaultToolkit().getImage("pause.png");
        pause.setIcon(new ImageIcon(img));
        pause.setFocusPainted(false);
        pause.setFocusable(false);
        pause.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String string = (click) ? "Pause" : "Play";
                Task.pause = !click;
                
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
        return pause;
    }
    private JButton graph() {
        Image img;
        graph = new JButton("Graph");
        graph.setPreferredSize(new Dimension(90, 30));
        img = Toolkit.getDefaultToolkit().getImage("graph.png");
        graph.setIcon(new ImageIcon(img));
        graph.setFocusPainted(false);
        graph.setFocusable(false);
        graph.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                jscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                click = true;
                
                if (e.getButton() == 1) {
                    for(Sensor s: sensors){
                        s.home.setVisible(false);
                        s.activity.setVisible(false);                    
                    }                    
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
        return graph;
    }
    private JButton activity() {
        Image img;
        JButton activity = new JButton("Activity");
        activity.setPreferredSize(new Dimension(90, 30));
        img = Toolkit.getDefaultToolkit().getImage("activity.png");
        activity.setIcon(new ImageIcon(img));
        activity.setFocusPainted(false);
        activity.setFocusable(false);
        activity.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                jscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                click = false;
                
                if (e.getButton() == 1) {
                    for(Sensor s: sensors){
                        s.home.setVisible(false);
                        s.activity.setVisible(true);
                    }                    
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
        return activity;
    }
    private JButton home() {
        
        JButton home = new JButton("Home");
        home.setPreferredSize(new Dimension(90, 30));   
        Image img = Toolkit.getDefaultToolkit().getImage("home.png");
        home.setIcon(new ImageIcon(img)); 
        home.setFocusPainted(false);
        home.setFocusable(false);
        home.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                jscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                click = false;
                if (e.getButton() == 1) {
                    for(Sensor s: sensors){
                        s.home.setVisible(true);
                        s.activity.setVisible(false);
                    }                    
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
        return home;
    }
    
    private JToolBar topToolBar() {
        buttons = new JButton[]
        {
            home(),
            activity(),
            graph(),
            pause(),            
            refresh(),
            plus(),
            minus(),
            settings()
        };
        
        toptoolbar = new JToolBar();
        
        toptoolbar.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));                       
        toptoolbar.setRollover(true);
        toptoolbar.setFloatable(false);
        toptoolbar.setAutoscrolls(true);
        
        for(JButton b: buttons){
            toptoolbar.add(b);
        }
        
        return toptoolbar;
    }
    private JToolBar bottomToolBar() { 
        selectedSensor = new JLabel();
        
        bottomtoolbar = new JToolBar();
        
        bottomtoolbar.setLayout(new FlowLayout(FlowLayout.RIGHT, 0,2));
        bottomtoolbar.setRollover(true);
        bottomtoolbar.setFloatable(false);
        bottomtoolbar.setPreferredSize(new Dimension(getWidth(), 22));
        
        bottomtoolbar.add(selectedSensor);
        
        bottomtoolbar.addSeparator(new Dimension(5,20));
        
        bottomtoolbar.add(new JLabel("  " + xml.getnList() + "  "));
        bottomtoolbar.addSeparator(new Dimension(5,20));
        bottomtoolbar.add(new JLabel(" SENSORS "));
        bottomtoolbar.addSeparator(new Dimension(5,20));
        
        
        return bottomtoolbar;
    }  
    
    private JPanel sensorPanel() throws IOException {
        sensorpanel = new JPanel(){            
            private AffineTransform affinetransform = new AffineTransform();     
            private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
            
            private String date = new GregorianCalendar().getTime().toString();
                               
            private void label_line(Graphics g, double x, double y, double theta, String label) {
                Graphics2D g2D = (Graphics2D)g;

               // Create a rotation transformation for the font.
               AffineTransform fontAT = new AffineTransform();

               // get the current font
               Font theFont = g2D.getFont();

               // Derive a new font using a rotatation transform
               fontAT.rotate(theta);
               Font theDerivedFont = theFont.deriveFont(fontAT);

               // set the derived font in the Graphics2D context
               g2D.setFont(theDerivedFont);
                              
               // Render a string using the derived font
               g2D.drawString(label, (int)x, (int)y);

               // put the original font back
               g2D.setFont(theFont);
           }
            
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D)g;
                
                if (click) {                    
                    int width = sensorpanel.getWidth();  
                    int height = FinalMonitorApp.monitor.getContentPane().getHeight();
                    
                    //System.out.println(sensorpanel.getWidth());

                    g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                              RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
                    
                    g2d.setColor(Color.DARK_GRAY);
                    Font font = new Font(getFont().getFamily(), Font.PLAIN, 12);
                    g2d.setFont(font);
                    
                    int fWidth = (int) font.getStringBounds(date, frc).getWidth() + 20; 
                    int fHeight = (int) font.getStringBounds(date, frc).getHeight();

                    g2d.drawString("0", 25, height - 40 - fWidth);
                    
                    for (int i = 0; i < 10; i++) {                        
                        label_line(g2d, 50 + (((width - 100) / 10) * i) , height - 20 - fWidth , Math.toRadians(50), date);
                    }
                    
                    GradientPaint gp = new GradientPaint(0,0, Color.GRAY.brighter(), width, 0, new Color(230,230,230, 0xA0));
                    g2d.setPaint(gp);
                    g2d.drawLine(50, 50, 50, height - 40 - fWidth);

                    gp = new GradientPaint(0,0, Color.GRAY.brighter(), 0, height, new Color(230,230,230, 0xA0));
                    g2d.setPaint(gp);
                    g2d.drawLine(50, height - 40 - fWidth, width - 100, height - 40 - fWidth);
                    
                    super.repaint();
                }                
            }
            @Override
            public void setBackground(Color bg) {
                super.setBackground(Color.LIGHT_GRAY.brighter()); 
            }
        };
        
        xml = new XML();

        service = Executors.newSingleThreadScheduledExecutor();

        tasks = new ArrayList<>();

        sensors = new ArrayList<>();
                
        for (int i = 0; i < xml.getnList(); i++) {
            // Creates Sensor
            sensors.add(new Sensor(sensorpanel, xml.getSensors().get(i)));

            // Creates a task for each sensor
            tasks.add(new Task(sensors.get(i)));

            // Adds tasks to schedule
            service.scheduleAtFixedRate(tasks.get(i), 
                                        0, 
                                        1,
                                        TimeUnit.MILLISECONDS);

            // Adds sensors to jpanel
            if (!"datetime".equals(sensors.get(i).name)) {
                sensorpanel.add(sensors.get(i));
            }
        }

        // Sets panel layout
        sensorpanel.setLayout(new GridLayout(sensorpanel.getComponentCount(), 
                                             1));
        
        return sensorpanel;
    }
    private JScrollPane jscrollPane() throws IOException {
        jscrollpane = new JScrollPane(sensorPanel()){ 
            @Override
            public void setHorizontalScrollBarPolicy(int policy) {
                    super.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            }             
        };
        return jscrollpane; 
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Variables ">
    public static Dimension mainSize;
    public static int delay = 1000;
    public static JButton graph;
    public static JLabel selectedSensor;
    public static JPanel sensorpanel;
    
    protected static ArrayList<Sensor> sensors;
    
    private ArrayList<Task> tasks;
    
    private ScheduledExecutorService service;
    private JToolBar bottomtoolbar;
    private JToolBar toptoolbar;
    private JScrollPane jscrollpane;
    private JButton[] buttons;    
    private JButton refresh;
    private JButton pause;
    private boolean click;
    public boolean sizeChanged;
    private XML xml;
    // </editor-fold>
}