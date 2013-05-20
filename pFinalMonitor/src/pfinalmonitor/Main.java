
package pfinalmonitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Main extends JFrame {
    public Main() throws IOException{ 
        try {            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            getContentPane().add(topToolBar(), BorderLayout.PAGE_START);
            getContentPane().add(rightToolBar(), BorderLayout.EAST);            
            getContentPane().add(jscrollPane(), BorderLayout.CENTER);            
            getContentPane().add(leftToolBar(), BorderLayout.WEST);
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
    private JPanel startup() throws IOException {
        startup = new JPanel();
        //startup.setPreferredSize(new Dimension(90, 30));
        //startup.add();
        return startup; 
    }
    private JButton settings() {
        Image img;
        JButton settings = new JButton("Settings");
        settings.setPreferredSize(new Dimension(90, 30));
        img = Toolkit.getDefaultToolkit().getImage("settings.png");
        settings.setIcon(new ImageIcon(img));
        settings.setFocusPainted(false);
        settings.setFocusable(false);        
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
        final JButton minus = new JButton();
        minus.setPreferredSize(new Dimension(30, 30));
        img = Toolkit.getDefaultToolkit().getImage("arrow-7-down.png");
        minus.setIcon(new ImageIcon(img));
        minus.setFocusPainted(false);
        minus.setFocusable(false);
        minus.setEnabled(false);        
        minus.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (minus.isEnabled()) {
                  for(Sensor s: sensors){
                        s.home.count--;
                    }  
                }
            }
        });
        return minus;
    }
    private JButton plus() {
        Image img;
        final JButton plus = new JButton();
        plus.setPreferredSize(new Dimension(30, 30));
        img = Toolkit.getDefaultToolkit().getImage("arrow-7-up.png");
        plus.setIcon(new ImageIcon(img));
        plus.setFocusPainted(true);
        plus.setFocusable(false);
        plus.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (plus.isEnabled()) {
                    for(Sensor s: sensors){
                        s.home.count++;
                    }  
                }
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
                jscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
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
                
                righttoolbar.setVisible(false);
                lefttoolbar.setVisible(false);
                
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
        home.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //lefttoolbar.setVisible(true);
                //righttoolbar.setVisible(true);
                //scrollTablePane.setVisible(true);
                jscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                click = false;
                for(Sensor s: sensors){
                        //s.setPreferredSize(new Dimension(339,50));
                        s.home.setVisible(true);
                        s.activity.setVisible(false);
                }
                //pack();
            }
        });        
        return home;
    }
    
    private JButton file() {
        Image img;
        JButton file = new JButton("Add CSV");
        file.setPreferredSize(new Dimension(90, 30));
        img = Toolkit.getDefaultToolkit().getImage("pause.png");
        file.setIcon(new ImageIcon(img));
        file.setFocusPainted(false);
        file.setFocusable(false);
        file.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
//                int returnVal = fc.showDialog(Main.this, "Attach");
//                try {
//                    csv = new CSV(fc.getSelectedFile().getAbsolutePath());
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });
        return file;
    }
    
    private JButton left() {
        Image img;
        final JButton left = new JButton();
        left.setPreferredSize(new Dimension(22, 55));
        img = Toolkit.getDefaultToolkit().getImage("arrow-7-left.png");
        left.setIcon(new ImageIcon(img));
        //left.setSelected(true);
        
        left.setFocusPainted(false);
        left.setFocusable(false);
        left.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (left.isEnabled()) {
                    for(Sensor s: sensors){
                        s.home.count++;
                    }  
                }
            }
        });
        return left;
    }    
    private JButton right() {
        Image img;
        final JButton right = new JButton();
        right.setPreferredSize(new Dimension(30, 60));
        img = Toolkit.getDefaultToolkit().getImage("arrow-7-right.png");
        right.setIcon(new ImageIcon(img));
        right.setBorderPainted(true);
        right.setFocusPainted(true);
        right.setFocusable(false);
        right.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (right.isEnabled()) {
                    for(Sensor s: sensors){
                        s.home.count++;
                    }  
                }
            }
        });
        return right;
    }
    
    private JTextField textfield() {
        final JTextField textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(150, 22));        
        return textfield;
    }    
    private JTextArea textarea() {
        final JTextArea textarea = new JTextArea();
        textarea.setPreferredSize(new Dimension(5, 30));        
        return textarea;
    }
    
    
    
    private JToolBar topToolBar() {
        buttons = new JButton[]
        {
            home(),
            activity(),
            graph()
            //pause(),            
            //refresh(),
            //plus(),
            //minus()
            
        };
        
        toptoolbar = new JToolBar();
        
        toptoolbar.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));                       
        toptoolbar.setRollover(true);
        toptoolbar.setFloatable(false);
        toptoolbar.setAutoscrolls(true);
        
        for(JButton b: buttons){
            toptoolbar.add(b);
        }
        
        //toptoolbar.add(textfield());
        
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
        bottomtoolbar.addSeparator(new Dimension(5,0));        
        bottomtoolbar.add(new JLabel("  " + xml.getnList() + "  "));
        bottomtoolbar.addSeparator(new Dimension(5,0));
        bottomtoolbar.add(new JLabel(" SENSORS "));
        bottomtoolbar.addSeparator(new Dimension(5,0));       
        
        return bottomtoolbar;
    }  
    private JToolBar leftToolBar(){
        lefttoolbar = new JToolBar();
        
        lefttoolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lefttoolbar.setRollover(true);
        lefttoolbar.setFloatable(false);
        //lefttoolbar.setPreferredSize(new Dimension(22, getHeight()));
        for (int i = 0; i < 6; i++) {
            //lefttoolbar.add(new JButton("Add Flight"));
        }
        //lefttoolbar.add(text());
        lefttoolbar.setVisible(false);
        return lefttoolbar;
}
    private JToolBar rightToolBar() throws FileNotFoundException, IOException{
        righttoolbar = new JToolBar();
          
        righttoolbar.setLayout(new BorderLayout());
        
        righttoolbar.setFloatable(false);
        
        String[] columnNames = {"Timestamp", "Values"};
        JFileChooser fc = new JFileChooser();
                
        //int returnVal = fc.showDialog(this, "Attach");
        
        //fc.getSelectedFile().getAbsolutePath()
                
        csv = new CSV();
        
        Object[][] data = new Object[csv.getCsvData().size()][3];
        
        for (int i = 0; i < csv.getCsvData().size(); i++) {
//            for (int j = 0; j < 2; j++) {
//                data[i][j] = csv.getCsvData().get(i)[j];
//            } 
            data[i][0] = csv.getCsvData().get(i)[0];
            data[i][1] = csv.getCsvData().get(i)[2];
        }
        
        table = new JTable(data, columnNames);
        table.setBackground(getBackground());
        //table.setPreferredSize(new Dimension(200,200));
        table.setPreferredScrollableViewportSize(new Dimension(getWidth() / 2, 70));
        //table.setEnabled(false);
        //table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        
        TableRowSorter<TableModel> sorter 
        = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        //TableColumn column;
        
        for (int i = 0; i < 2; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
            
        }
        
        table.getColumnModel().getColumn(1).setPreferredWidth(table.getSize().width / 2);
        //column.setPreferredWidth(table.getPreferredScrollableViewportSize().width / 2);      //custom size
        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        table.setDefaultRenderer(String.class, centerRenderer);
        
//        ArrayList <RowSorter.SortKey> sortKeys = new ArrayList<>();
//        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
//        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//        sorter.setSortKeys(sortKeys);
                
        filter = new JPanel();
        filter.setLayout(new FlowLayout());
        
        filter.add(new JLabel(" Filter : "));
        filter.add(textfield());
                
        scrollTablePane = new JScrollPane(table);
        scrollTablePane.setBackground(getBackground());
        scrollTablePane.setBorder(null);
        //scrollTablePane.setPreferredSize(new Dimension(250,100));
        //scrollTablePane.setSize(new Dimension(250,100));
        
        JPanel panel = new JPanel();
        panel.add(label);
                        
        righttoolbar.add(panel, BorderLayout.NORTH);
        righttoolbar.add(new JPanel(), BorderLayout.WEST);
        righttoolbar.add(scrollTablePane, BorderLayout.CENTER);
        righttoolbar.add(new JPanel(), BorderLayout.EAST);
        righttoolbar.add(filter, BorderLayout.PAGE_END);
        righttoolbar.setBorderPainted(true);
        righttoolbar.setVisible(false);
        
        //scrollTablePane.setVisible(false);
        //filter.setVisible(false);
        return righttoolbar;
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

                // for antialiasing geometric shapes
                g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON );

                // for antialiasing text
                g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
                
                if (click) {                    
                    int width = sensorpanel.getWidth();  
                    int height = FinalMonitorApp.monitor.getContentPane().getHeight();

                    g2d.setColor(Color.DARK_GRAY);

                    Font font = new Font(getFont().getFamily(), Font.PLAIN, 12);
                    g2d.setFont(font);
                    
                    int fWidth = (int) font.getStringBounds(date, frc).getWidth() + 20; 
                    int fHeight = (int) font.getStringBounds(date, frc).getHeight();

                    label_line(
                            g2d,
                            25,                                     // X
                            (height / 2) - 15,                             // Y
                            Math.toRadians(360 - 90),               // ANGLE
                            "Sensor Data"                                  // TEXT
                    );

                    g2d.drawString("Time", 75 + (width - 150) / 2, height - fWidth + 60);



                    
                    for (int i = 0; i < 10; i++) {
                        g2d.setColor(Color.DARK_GRAY);

                        label_line(
                                   g2d,
                                   50 + (((width - 100) / 10) * i),               // X
                                   (height / 6) + height - 65 - fWidth,                          // Y
                                   Math.toRadians(angle),                            // ANGLE
                                   date.substring(0,20)                           // TEXT
                                   );

                        // X AXIS LINES
                        g2d.drawLine(
                                     50 + (((width - 100) / 10) * i),             // X
                                (height / 6) + height - 75 - fWidth,                        // Y
                                     50 + (((width - 100) / 10) * i),             // X
                                (height / 6) + height - 85 - fWidth                         // Y
                                     );

                        g2d.setPaint(Color.LIGHT_GRAY);

                        // Y AXIS LINES
                        g2d.drawLine(
                                     50,                                                // X
                                (height / 6) + (((height - 80 - (fWidth))/10) * i),    // Y
                                     50 + width - 100,                                  // X
                                (height / 6) + (((height - 80 - (fWidth))/10) * i)     // Y
                                     );
                    }

                    int w = width / 15;

                    //System.out.println(width);

                    if (width < 599){
                        angle = (45) + (45 -  w);
                    }



                    g2d.setColor(Color.DARK_GRAY);
                    g2d.setStroke(new BasicStroke(1.0f));
                    GradientPaint gp = new GradientPaint(0,0, Color.GRAY.brighter(), width, 0, new Color(230,230,230, 0xA0));
                    //g2d.setPaint(gp);
                    //g2d.drawLine(50, 50, 50, height - 40 - fWidth);
                    g2d.drawString("1023", 15, fWidth + 4);
                    g2d.drawLine(
                            45,      // X
                            fWidth,  // Y
                            55,      // X
                            fWidth   // Y
                    );

                    g2d.drawString("0", 25, (height - 80 - fWidth) + 4);
                    g2d.drawLine(
                            45,      // X
                            height - 80 - fWidth,  // Y
                            55,      // X
                            height - 80 - fWidth   // Y
                    );

                    // CHART RECTANGLE
                    g2d.drawRect(
                                 50,                         // X
                                 height / 6,                 // Y
                                 50 + width - 150,           //WIDTH
                                 height - 80 - (fWidth)  //HEIGHT
                                 );

                    gp = new GradientPaint(0,0, Color.GRAY.brighter(), 0, height, new Color(230,230,230, 0xA0));
                    //g2d.setPaint(gp);
                    //g2d.drawLine(50, height - 40 - fWidth, 50 + width - 100, height - 40 - fWidth);

                    g2d.setStroke(new BasicStroke(1.0f));
                    g2d.setPaint(Color.LIGHT_GRAY);
                    g2d.drawRoundRect(3, 2, width - 6, getHeight() - 5, 5, 5);
                    
                    super.repaint();
                }                
            }
            @Override
            public void setBackground(Color bg) {
                super.setBackground(null); 
            }
        };
        
        xml = new XML();

        service = Executors.newSingleThreadScheduledExecutor();

        tasks = new ArrayList<>();

        sensors = new ArrayList<>();
                
        for (int i = 0; i < xml.getnList(); i++) {
            // Creates Sensor
            sensors.add(new Sensor(sensorpanel, xml.getSensors().get(i), (i + 1)));
            // Creates a task for each sensor
            tasks.add(new Task(sensors.get(i)));

            // Adds tasks to schedule
            service.scheduleAtFixedRate(
                    tasks.get(i), 
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
        
        sensorpanel.setBorder(null);
        sensorpanel.setBackground(getBackground());
        return sensorpanel;
    }
    private JScrollPane jscrollPane() throws IOException {
        jscrollpane = new JScrollPane(sensorPanel()){ 

            @Override
            public void setBackground(Color bg) {
                super.setBackground(getBackground()); 
            }
            
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
    public static JPanel startup;
    public static JPanel sensorpanel;
    public static JLabel label = new JLabel(" LABEL ");
    public static JTable table;
    public static JScrollPane scrollTablePane;
    public static JPanel filter;
    
    protected static ArrayList<Sensor> sensors;
    
    private ArrayList<Task> tasks;
    
    private ScheduledExecutorService service;
    public static JToolBar lefttoolbar;
    public static JToolBar righttoolbar;
    public static JToolBar bottomtoolbar;
    public static JToolBar toptoolbar;
    public static CSV csv;
    private JScrollPane jscrollpane;
    private JButton[] buttons;    
    private JButton refresh;
    private JButton pause;
    private JTextArea text;
    private int angle = 45;
    private boolean click;
    public boolean sizeChanged;
    private XML xml;
    // </editor-fold>
}