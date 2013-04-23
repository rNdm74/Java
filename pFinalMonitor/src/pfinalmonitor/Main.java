
package pfinalmonitor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.util.Timer;
import javax.swing.UIManager;

public class Main extends javax.swing.JFrame {
    private Timer timer = new Timer();
    private Point pos;
    private int size = new XML().getnList();
    private Sensor[] sensors = new Sensor[6];
    int y = 0;
    int mouse = 0;
    
    public Main(int width, int height){        
        setUIFont (new javax.swing.plaf.FontUIResource("Dialog",Font.PLAIN,12));
        
        setJMenuBar(new Menu());
        
        setLocation(width / 2 - getWidth() / 2, height / 2 - getHeight() / 2);
                                
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
        
        getContentPane().setLayout(null); 
                
        for (int i = 0; i < sensors.length; i++) {
            getContentPane().add(sensors[i]);
            sensors[i].setLocation(0, 0 + 120 * i);
            sensors[i].setSize(360, 120);
        }
        
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
                    sensors[i].setLocation(0, y + 120 * i);
                }
            }
        });  
        
        setSize(380, 60 + 120 * 3);
        setVisible(true);
        
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
