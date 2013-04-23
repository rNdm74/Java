
package pfinalmonitor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.util.Timer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Main extends javax.swing.JFrame {
    private Timer timer = new Timer();
    private Point pos;
    private int size = new XML().getnList();
    private Sensor[] sensors = new Sensor[6];
    int y = 0;
    int mouse = 0;
    JScrollPane vertical;
    
    public Main(int width, int height){
        JPanel p = new JPanel();
        p.setSize(600, 400);
        p.setLayout(new GridLayout(13, 6, 10, 0));
    
        setUIFont (new javax.swing.plaf.FontUIResource("Dialog",Font.PLAIN,12));
        
        setSize(400, 400);
        
        //JTextArea console;

        
        //console = new JTextArea(15, 15);

        
        
        setLocation(width / 2 - getWidth() / 2, 0);
                                
        sensors[0] = new Sensor(Color.white, "temp1");
        sensors[1] = new Sensor(Color.white, "temp2");
        sensors[2] = new Sensor(Color.white, "temp3");
        sensors[3] = new Sensor(Color.white, "light");
        sensors[4] = new Sensor(Color.white, "light");
        sensors[5] = new Sensor(Color.white, "light");
        
        Task t1 = new Task(sensors[0]);
        Task t2 = new Task(sensors[1]);
        Task t3 = new Task(sensors[2]);
        Task t4 = new Task(sensors[3]);
        Task t5 = new Task(sensors[4]);
        Task t6 = new Task(sensors[5]);
        
        timer.schedule(t1, 0, 1000);
        timer.schedule(t2, 0, 1000);
        timer.schedule(t3, 0, 1000);
        timer.schedule(t4, 0, 1000);
        timer.schedule(t5, 0, 1000);
        timer.schedule(t6, 0, 1000);
        
        //getContentPane().setLayout(null); 
        
        
        
        
        //vertical.setSize(new Dimension(this.getWidth(), this.getHeight()));
        //vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //vertical.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
             
        p.add(sensors[0]);
            
            sensors[0].setPreferredSize(new Dimension(360, 120));
            sensors[0].setSize(new Dimension(360, 120));
            sensors[0].setLocation(getWidth() / 2 - 360 / 2, 20);
        
        
        for (int i = 1; i < sensors.length; i++) {
            p.add(sensors[i]);
            
           // sensors[i].setPreferredSize(new Dimension(360, 120));
            sensors[i].setSize(new Dimension(360, 120));
            sensors[i].setLocation(getWidth() / 2 - 360 / 2, sensors[0].getY() + 140 * i);
        }
        
        //System.out.println(sensors[sensors.length - 1].getY());
        //setSize(400, sensors[sensors.length - 1].getY() + 185);
        //pack();
        vertical = new JScrollPane(p);
        getContentPane().add(vertical, BorderLayout.CENTER);
        setVisible(true);        
        
        addWindowListener(new java.awt.event.WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        addMouseWheelListener( new MouseWheelListener() {
            @Override
            public void mouseWheelMoved( MouseWheelEvent e ) {
                y -= e.getWheelRotation() * 2;
                
                for (int i = 0; i < sensors.length; i++) {
                    sensors[i].setLocation(getWidth() / 2 - 360 / 2, y + 120 * i);
                }
            }
        });         
    }
    
    public static void setUIFont (javax.swing.plaf.FontUIResource f){
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get (key);
      if (value != null && value instanceof javax.swing.plaf.FontUIResource)
        UIManager.put (key, f);
      }
    }
}
