
package pfinalmonitor;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Home extends JPanel {
    private AffineTransform affinetransform = new AffineTransform();     
    private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    
    public boolean button = true;
    public boolean selected;
    public boolean hover;
    
    private JPanel sensorpanel;  
        
    private ArrayList<String[]> data = new ArrayList<>();
    
    private int width;
    private int height;
    
    public int count = 0;
    private int sensorID;
    
    private int mouse;
    private boolean mouseclicked;
    private Color backgroundColor = getBackground();
    private Color borderColor = Color.white;
    private Color textColor = Color.DARK_GRAY;
    private Color hoverColor = new Color(100,149,237, 0x2F);
    
    private GradientPaint gp;
        
    public Home(final JPanel sensorpanel, ArrayList<String[]> data, int sensorID){
        this.sensorpanel = sensorpanel;
        this.data = data;
        this.sensorID = sensorID;
        
        
        setOpaque(true);
        //setSize(new Dimension(Main.mainSize.width - 18, Main.sensors[0].getHeight()));//System.out.println(this.getParent().);
        
        //setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                //System.out.println(e.getWheelRotation());
                count += e.getWheelRotation();
                
                if(count >= Main.csv.getCsvData().size() - 1){
                            count = 0;
                }

                if (count < 0) {
                    count = Main.csv.getCsvData().size() - 1;
                }
            }
        });
        
        addMouseListener(new java.awt.event.MouseAdapter() {            
            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                //Main.selectedSensor.setText(" ");
            }
            @Override
            public void mouseEntered(MouseEvent evt) {                
                hover = true;
                
                for (Sensor s: Main.sensors) {
                    if (s.name.equals(evt.getComponent().getName())) {
                        
                    }
                }
                
                //Main.selectedSensor.setPreferredSize(new Dimension(getWidth() - 100,20));                
                //Main.selectedSensor.setText(getName().toUpperCase());
            }
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {                
                for (Sensor s: Main.sensors) {
                    if (s.name.equals(evt.getComponent().getName())) { 
                        if (Main.label.getText().matches(evt.getComponent().getName().toUpperCase())) {
                            Main.righttoolbar.setVisible(selected);
                            
                            selected = !selected;
                        }
                        else{
                            CSV csv = Main.csv;

                            for (int i = 0; i < csv.getCsvData().size(); i++) {                                
                                Main.table.setValueAt(csv.getCsvData().get(i)[0], i, 0);
                                Main.table.setValueAt(csv.getCsvData().get(i)[s.sensorID], i, 1);
                            }
                            Main.label.setText(evt.getComponent().getName().toUpperCase());
                        }                        
                        
                    }
                }
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouseclicked = true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseclicked = false;
            }
            
        });        
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                leftPanelMouseMoved(evt);
            }
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
            }
        });
    } 
    
    private void leftPanelMouseMoved(MouseEvent evt) {
        //mouse = evt.getPoint();
    }  
    
    @Override
    protected void paintComponent(Graphics g) {
        width = sensorpanel.getWidth() - 5;
        height = sensorpanel.getHeight();
                
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        // for antialiasing geometric shapes
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON );

        // for antialiasing text
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

        // to go for quality over speed
        g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY );
                
        g2d.setColor(backgroundColor);        
        g2d.fillRect(0, 0, width, getHeight());

        //g2d.setColor(new Color(230,230,230, 0xFF));
        //g2d.drawLine(width - 1, 0, width - 1, getHeight() - 1);
        if (hover) {mouseOver(g2d);}
        g2d.setColor(textColor);

        Font font = new Font(getFont().getFamily(), Font.PLAIN, 12);
        g2d.setFont(font);
        
        if (data.size() > 2) {
            
            font = new Font(getFont().getFamily(), Font.PLAIN, getHeight() / 4);
            g2d.setFont(font);

            String value = getName().toUpperCase();

            int sWidth = (int) font.getStringBounds(value, frc).getWidth();
            //int sHeight = (int) font.getStringBounds(value, frc).getHeight();            
            //int valuePosition = (width > 300) ? width / 2 - sWidth / 2 : 100;
            
            g2d.drawString(value, ((width / 2)) -  (sWidth / 2), getHeight() / 2 + 6); // SENSOR NAME
            //sWidth = (int) font.getStringBounds(csv.getCsvData().get(count)[sensorID], frc).getWidth();
            //g2d.drawString(csv.getCsvData().get(count)[sensorID], (width / 2) - (sWidth / 2), getHeight() / 2 + 8); // DATA
            //sWidth = (int) font.getStringBounds(csv.getCsvData().get(count)[0], frc).getWidth();
            //g2d.drawString(csv.getCsvData().get(count)[0], ((width - (width / 6)) - (sWidth / 2)), getHeight() / 2 + 8); // DATE

            
            
            //g2d.setPaint(borderColor);
            //g2d.drawRect(width / 3, 2, width / 3, getHeight() - 4);
            //g2d.drawRoundRect(3, 2, width - 7, getHeight() - 4, 5, 5);
            
            
        }
        
        super.repaint();
    }

    private void mouseOver(Graphics2D g2d) {        
        Font font;        
        int sWidth;
        int sHeight;
        
        gp = new GradientPaint(0, getHeight(),new Color(135, 206, 250,0x2F).darker(), 0, 0, new Color(255, 255, 255, 0x2A));
        
        g2d.setPaint((mouseclicked) ? new Color(100,149,237, 0x7F) : new Color(100,149,237, 0x2F));
        g2d.fillRect(3, 2, width, getHeight() -4);

        g2d.setColor(new Color(30,144,255, 0xAF));
        g2d.drawRect(2,1, width, getHeight()-3);

        //font = new Font(getFont().getFamily(), Font.PLAIN, getHeight() / 10);
        //g2d.setFont(font);

        //gp = new GradientPaint(0,0,new Color(255, 255, 255), 0, getHeight(), new Color(255, 255, 255));
        //g2d.setPaint(gp);
        //g2d.setColor(Color.white);
        //g2d.fillRect(width - 31, 10, 13, 4);
        //g2d.setColor(new Color(135, 206, 250));
        //g2d.drawRect(width - 31, 10, 13, 4);
        
    }
}
