
package pprogramming3assignmentone;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author rndm
 */
public class Programming3AssignmentOneApp {

    private static final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static final int desktopWidth = gd.getDisplayMode().getWidth();
    private static final int desktopHeight = gd.getDisplayMode().getHeight();
        
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());            
            Welcome gui = new Welcome();
            gui.setVisible(true); 
//            if (gui.filePath().getText().contains("csv")) {
//                gui.getOk().setEnabled(true);
//            }
            
            gui.setLocation(desktopWidth / 2 - gui.getWidth() / 2, desktopHeight / 2 - gui.getHeight() / 2);
            
        } catch (ClassNotFoundException | 
                 InstantiationException | 
                 IllegalAccessException | 
                 UnsupportedLookAndFeelException e) {
                System.out.println(e);
        } 
    }
}
