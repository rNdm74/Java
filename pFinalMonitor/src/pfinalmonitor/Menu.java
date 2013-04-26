/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinalmonitor;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 *
 * @author rNdm
 */
public class Menu extends JMenuBar{
    JMenu menu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
        
    public Menu(){  
        
        UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(Color.GRAY, 1));
        
        setPreferredSize(new Dimension(getWidth(), 24));
        
        setVisible(false);
        
        menu = new JMenu("Sensors"); 
        
        add(menu);
        
        submenu = new JMenu("Temp 1             ");
        
        submenu.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        
        menuItem = new JMenuItem("Pause             ",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        submenu.add(menuItem);
        
        menu.add(submenu);
        
        submenu = new JMenu("Temp 2             ");
        submenu.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuItem = new JMenuItem("      Pause             ",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        submenu.add(menuItem);
        
        menu.add(submenu);
        
        submenu = new JMenu("Temp 3             ");
        
        submenu.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuItem = new JMenuItem("Pause             ",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        submenu.add(menuItem);
        menu.add(submenu);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem("Light 1             ",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Light 2             ",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Light 3             ",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
//        
//        
//        menuItem = new JMenuItem("Save");
//        menu.add(menuItem);
//        menu.addSeparator();
//        menuItem = new JMenuItem("Exit");
//        menu.add(menuItem);
        //menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        //menuItem.setMnemonic(KeyEvent.VK_D);
        //menu.add(menuItem);

        //a group of radio button menu items
        
//        ButtonGroup group = new ButtonGroup();
//        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
//        rbMenuItem.setSelected(true);
//        rbMenuItem.setMnemonic(KeyEvent.VK_R);
//        group.add(rbMenuItem);
//        menu.add(rbMenuItem);
//
//        rbMenuItem = new JRadioButtonMenuItem("Another one");
//        rbMenuItem.setMnemonic(KeyEvent.VK_O);
//        group.add(rbMenuItem);
//        menu.add(rbMenuItem);

        menu = new JMenu("Edit");
        menu.setMnemonic(KeyEvent.VK_S);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menu.add(new JMenuItem("Preferences"));
        add(menu);
//        
//        //a group of check box menu items
//        menu.addSeparator();
//        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
//        cbMenuItem.setMnemonic(KeyEvent.VK_C);
//        menu.add(cbMenuItem);
//
//        cbMenuItem = new JCheckBoxMenuItem("Another one");
//        cbMenuItem.setMnemonic(KeyEvent.VK_H);
//        menu.add(cbMenuItem);

        //a submenu
        //menu.addSeparator();
//        
//        
//        submenu = new JMenu("Temp 2");
//        submenu.setMnemonic(KeyEvent.VK_S);
//
//        menuItem = new JMenuItem("An item in the submenu");
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(
//                KeyEvent.VK_2, ActionEvent.ALT_MASK));
//        submenu.add(menuItem);
//
//        menuItem = new JMenuItem("Another item");
//        submenu.add(menuItem);
//        menu.add(submenu);
//
//        //Build second menu in the menu bar.
//        menu = new JMenu("My Sensors");
//        menu.setMnemonic(KeyEvent.VK_S);
//        menu.getAccessibleContext().setAccessibleDescription(
//                "This menu does nothing");
//        menu.add(submenu);
//         
//        
//        submenu = new JMenu("Temp 1");
//        submenu.setMnemonic(KeyEvent.VK_S);
//
//        menuItem = new JMenuItem("An item in the submenu");
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(
//                KeyEvent.VK_2, ActionEvent.ALT_MASK));
//        submenu.add(menuItem);
//
//        menuItem = new JMenuItem("Another item");
//        submenu.add(menuItem);
//        menu.add(submenu);
//        add(menu);
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_S);
        menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
        
        add(menu);
        
        
        addFocusListener(new java.awt.event.FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void focusLost(FocusEvent e) {
                setVisible(false);
            }
        });
    }
}
