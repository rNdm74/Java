
package pprogramming3assignmentone;

import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 *
 * @author Adam Charlton
 */
public class Programming3AssignmentOneApp {

    private static final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static final int desktopWidth = gd.getDisplayMode().getWidth();
    private static final int desktopHeight = gd.getDisplayMode().getHeight();    
    private static final Dimension desktop = new Dimension(desktopWidth, desktopHeight);
        
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
            
            Home home = new Home(desktop);
            
            home.setVisible(true); 
            
        } catch (ClassNotFoundException | 
                 InstantiationException | 
                 IllegalAccessException | 
                 UnsupportedLookAndFeelException e) {
                 System.out.println(e);
        } 
    }
}
