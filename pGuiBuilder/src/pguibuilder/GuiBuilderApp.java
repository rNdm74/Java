
package pguibuilder;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author rndm
 */
public class GuiBuilderApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());            
            GUI gui = new GUI();
            gui.setVisible(true);        
            
        } catch (ClassNotFoundException | 
                 InstantiationException | 
                 IllegalAccessException | 
                 UnsupportedLookAndFeelException e) {
                System.out.println(e);
        }        
    }
}