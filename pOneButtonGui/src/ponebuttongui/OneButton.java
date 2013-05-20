
package ponebuttongui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author rndm
 */
public class OneButton extends JFrame implements ActionListener{
    
    private JButton yes;
    private JButton no;
    private JLabel label;
    private JPanel back;    
    private JTextArea text;
    
    // Constructor
    public OneButton(){
        // Name form
        super("2 Button gui"); 
        
        // Initialize variables
        yes = new JButton("Yes");
        no = new JButton("No");
        label = new JLabel("Click for yes or no");
        back = new JPanel();
        text = new JTextArea(10,10);
        
        // Give contentpane a layout
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        
        // Add buttons to panel        
        back.add(yes);
        back.add(no);
        
        // Add components to contentpane
        cp.add(text);
        cp.add(label);
        cp.add(back);        
        
        // Add Listeners to buttons
        no.addActionListener(this);
        yes.addActionListener(this);
        
        // Set options on forms
        setSize(400, 400); 
        setVisible(true);
        setResizable(false);                                 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();
        
        if (buttonPressed == yes) {
            text.append("Yes button has been pressed\n");
        }
        else{
            text.append("No button has been pressed\n");
        }        
    }
}
