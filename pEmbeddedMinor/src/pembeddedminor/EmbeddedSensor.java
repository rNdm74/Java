/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pembeddedminor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author rndm
 */
class EmbeddedSensor extends JPanel {
    public EmbeddedSensor(){
        //this.setBounds(p.getBounds());
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        //super.paintComponent( g2d );
        
        g2d.drawString("255", 20, 20);
        
        repaint();
    }    
}
