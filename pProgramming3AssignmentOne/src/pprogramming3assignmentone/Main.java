
package pprogramming3assignmentone;

import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

/**
 *
 * @author Adam Charlton
 */
public class Main extends javax.swing.JPanel {

    /**
     *
     * @param home initializes the main window JPanel
     */
    public Main(Home home){
        initComponents(); 
        initTabComponents(home);
        setTabLookAndFeel();
    }

    private void initTabComponents(Home home) {
        initComponents(home);
        addComponents(home);
    }
    
    private void addComponents(Home home) {
        mainpagetabs.add(home.table);
        mainpagetabs.add(sorting);               
        mainpagetabs.add(search);
        mainpagetabs.add(statistics); 
        mainpagetabs.add(splitPane(home));
    }

    private void initComponents(Home home) {
        statistics = new Statistics(home);
        sorting = new Sorting(home);
        search = new Search(home);        
        graph1 = new Graph(home);
        graph2 = new Graph(home);
    }
    
    private JSplitPane splitPane(Home home) {
        JSplitPane splitPane = new JSplitPane();
        splitPane.setBorder(null);
        splitPane.setLeftComponent(graph1);
        splitPane.setRightComponent(graph2);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(10);
        splitPane.setDividerLocation(home.getWidth());
        return splitPane;
    }
    
    private void setTabLookAndFeel() {
        String[] names = {"Overview", "Sorting", "Search", "Statistics", "Graph"};  
        String[] iconNames = {"bookmark.png", "list-ordered.png", "search.png", "report.png", "statistics-pie-chart.png"};
        
        JLabel[] labels = new JLabel[names.length]; 
        
        for (int i = 0; i < labels.length; i++) {
            URL url = getClass().getResource("/pprogramming3assignmentone/icons/"+ iconNames[i]);
                        
            labels[i] = new JLabel(names[i]);
            labels[i].setIcon(new ImageIcon(url));
            labels[i].setPreferredSize(new Dimension(100, 40));
            
            mainpagetabs.setTabComponentAt(i, labels[i]);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpagetabs = new javax.swing.JTabbedPane();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(391, 291));
        setLayout(new java.awt.BorderLayout());

        mainpagetabs.setBackground(java.awt.Color.white);
        mainpagetabs.setToolTipText("");
        mainpagetabs.setDoubleBuffered(true);
        mainpagetabs.setOpaque(true);
        mainpagetabs.setPreferredSize(new java.awt.Dimension(50, 50));
        add(mainpagetabs, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JPanel sorting;
    private javax.swing.JPanel search;
    private javax.swing.JPanel statistics;
    private javax.swing.JPanel graph1;
    private javax.swing.JPanel graph2;    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainpagetabs;
    // End of variables declaration//GEN-END:variables
}
