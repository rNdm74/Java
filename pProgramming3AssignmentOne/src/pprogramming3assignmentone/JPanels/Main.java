
package pprogramming3assignmentone.JPanels;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

/**
 *
 * @author rndm
 */
public class Main extends javax.swing.JPanel {

    /**
     *
     * @param home initializes the main window JPanel
     */
    public Main(Home home){
        initComponents(); 
        initTabComponents(home);
        setTabLookAndFeel(home);
    }

    private void initTabComponents(Home home) {
        statistics = new Statistics(home);
        sorting = new Sorting(home);
        search = new Search(home);        
        graph1 = new Graph(home);
        graph2 = new Graph(home);
                        
        mainpagetabs.add(home.table);
        mainpagetabs.add(sorting);               
        mainpagetabs.add(search);
        mainpagetabs.add(statistics); 
        mainpagetabs.add(splitPane(home));
    }
    
    private JSplitPane splitPane(Home home) {
        JSplitPane splitPane = new JSplitPane();
        splitPane.setBorder(null);
        splitPane.setLeftComponent(graph1);
        splitPane.setRightComponent(graph2);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(home.getWidth());
        return splitPane;
    }
    
    private void setTabLookAndFeel(Home home) {
        String[] names = {"Overview", "Sorting", "Search", "Statistics", "Graph"};     
        
        JLabel[] labels = new JLabel[names.length]; 
        
        int height = (home.table.getHeight() / (labels.length)) - 5;
        
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(names[i]);
            labels[i].setPreferredSize(new Dimension(50, height));
            
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
        mainpagetabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        mainpagetabs.setToolTipText("");
        mainpagetabs.setOpaque(true);
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
