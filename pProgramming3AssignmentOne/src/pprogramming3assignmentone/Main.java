
package pprogramming3assignmentone;

import java.io.IOException;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author rndm
 */
public class Main extends javax.swing.JPanel {

    public Main(Home welcome) throws IOException {
        initComponents(); 
                                
        statistics = new Statistics(welcome);        
        search = new Search(welcome);        
        graph = new Graph(welcome);
                
        mainpagetabs.add(welcome.table);
        mainpagetabs.add(statistics);
        mainpagetabs.add(search);
        mainpagetabs.add(graph);
        
        mainpagetabs.setTitleAt(0, "Overview"); 
        mainpagetabs.setTitleAt(1, "Statistics"); 
        mainpagetabs.setTitleAt(2, "Search");
        mainpagetabs.setTitleAt(3, "Graph");
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpagetabs = new javax.swing.JTabbedPane();

        setPreferredSize(new java.awt.Dimension(391, 291));
        setLayout(new java.awt.BorderLayout());

        mainpagetabs.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mainpagetabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainpagetabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        mainpagetabs.setToolTipText("");
        mainpagetabs.setOpaque(true);
        add(mainpagetabs, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JPanel graph;
    private javax.swing.JPanel statistics;
    private javax.swing.JPanel search;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainpagetabs;
    // End of variables declaration//GEN-END:variables
}
