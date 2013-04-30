
package pfinalmonitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author rNdm
 */
public class RightPanel extends JPanel{    
    //private AffineTransform affinetransform = new AffineTransform();     
    //private FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    
    private Color color = Color.WHITE;
    private Dimension size;
    private int width;
    
    public RightPanel(Dimension size){        
        setSize(size);
        
        setOpaque(false);
        
        setLayout(null);
        
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //int width = getWidth();      

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        
        //float[] scales = { 1f, 1f, 1f, 0.5f };
        //float[] offsets = new float[4];
        //RescaleOp rop = new RescaleOp(scales, offsets, null);
        //System.out.println(img.getHeight());
        //g2d.drawImage(bi, rop, 0, 0);
        //g2d.finalize();

        // for antialiasing text
        //g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
        //    RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

        // to go for quality over speed
        //g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
        //    RenderingHints.VALUE_RENDER_QUALITY );

        GradientPaint gp = new GradientPaint(0,0, Color.GRAY.brighter(), width, 0, new Color(230,230,230, 0xA0));
        g2d.setPaint(gp);
//
        //g2d.fill (new Rectangle(0, 0, getWidth(), getHeight()));
//
//        gp = new GradientPaint(0,0,new Color(255,255,255, 0xB0),width * 2, 0, new Color(230,230,230));
//        g2d.setPaint(gp);
//        g2d.fillRect(1, 30, width, 120);
//        //g2d.fillRect(width - 33, 1, 33, 120);
//
        //gp = new GradientPaint(0,0,color.brighter(),width, 0, new Color(230,230,230, 0xA0));
        //g2d.setColor(Color.BLACK);
        //.drawLine(33, 30, getWidth() - 260, 30);
        
//        g2d.drawLine(33, 60, width, 60);
//        g2d.drawLine(33, 90, width, 90);
//
//        //g2d.drawLine(33, 52, width, 52);
//
//        g2d.setColor(getBackground().brighter());
//        g2d.drawLine(34, 30, 34, 120);
//
//
//        g2d.setColor(getBackground().darker());
//        //g2d.draw3DRect(1, 0, width - 2, 29, true);
//        //g2d.draw3DRect(1, 91, width - 2, 29, false);
//        g2d.drawLine(0, 29, width, 29);
//        g2d.drawLine(33, 59, width, 59);
//        g2d.drawLine(33, 89, width, 89);
//
//
//        g2d.setColor(color.brighter());
//        g2d.drawLine(1, 30, width, 30);
//
//
//        g2d.setColor(Color.DARK_GRAY);
//        Font font = new Font(getFont().getFamily(), Font.PLAIN, 12);
//        g2d.setFont(font);
//        g2d.drawString("Settings", 20, 20);
//
//        font = new Font(getFont().getFamily(), Font.PLAIN, 12);
//        g2d.setFont(font);
//        String user = "Username";
//        //t uWidth = (int) font.getStringBounds(user, frc).getWidth();
//       // int uHeight = (int) font.getStringBounds(user, frc).getHeight();
//        //int pWidth = (int) font.getStringBounds("PASSWORD", frc).getWidth();
//       // int aWidth = (int) font.getStringBounds("URL", frc).getWidth();
//
//
//
//
////        g2d.drawString(user, 40, (28 + (28/2)) + (uHeight / 2));
////        g2d.drawString(userName.toUpperCase(), 120, (28 + (28/2)) + (uHeight / 2));
////
////        g2d.drawString("Device", 40, (58 + (28/2)) + (uHeight / 2));
////        g2d.drawString(device.toUpperCase(), 120, (58 + (28/2)) + (uHeight / 2));
////
////        g2d.drawString("Filename ", 40, (88 + (28/2)) + (uHeight / 2));
////        g2d.drawString(url, 120, (88 + (28/2)) + (uHeight / 2));
//
//        font = new Font(getFont().getFamily(), Font.PLAIN, 10);
//        g2d.setFont(font);
//        //g2d.drawString("REAL-TIME", 17, 103);
//
//
//        g2d.setColor(new Color(230,230,230, 0xFF));
        
        //System.out.println(getSize());
       // g2d.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
        
        
        
        super.repaint();
    } 
}

