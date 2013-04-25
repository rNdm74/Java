
package pfinalmonitor;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author rNdm
 */
public class ComboBox extends JComboBox{
    private ImageIcon TEMP_ICON;
    private ImageIcon LIGHT_ICON;
    
    public final String TEMP_STR = "temp";
    public final String LIGHT_STR = "light";
    
    public ComboBox(XML xml){
        Image img = Toolkit.getDefaultToolkit().getImage("temp.png");
        TEMP_ICON = new ImageIcon(img);
        
        img = Toolkit.getDefaultToolkit().getImage("light.png");
        LIGHT_ICON = new ImageIcon(img);
        
        Map<Object, Icon> icons = new HashMap<>(); 

        icons.put(TEMP_STR, TEMP_ICON); 
        icons.put(LIGHT_STR, LIGHT_ICON); 

        setRenderer(new IconListRenderer(icons));

        for(String val : xml.getSensors()){
            addItem(val);
        }
    }    
}

class IconListRenderer extends DefaultListCellRenderer{ 
    private static final long serialVersionUID = 1L;
    private Map<Object, Icon> icons = null; 
    
    public final String TEMP_STR = "temp";
    public final String LIGHT_STR = "light";
    

    public IconListRenderer(Map<Object, Icon> icons){ 
        this.icons = icons; 
    } 

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 

        // Get icon to use for the list item value 
        Icon icon = icons.get(value); 

        if(value.toString().substring(0, 4).equals(TEMP_STR)){
            icon = icons.get(TEMP_STR);
        }
        else if(value.toString().substring(0, 5).equals(LIGHT_STR)){
            icon = icons.get(LIGHT_STR);
        }

        
        // Set icon to display for value 
        label.setIcon(icon); 
        
        return label;  
    }
}
