
package pprogramming3assignmentone;

import java.io.IOException;
import javax.swing.JComboBox;

/**
 *
 * @author rndm
 */
public class MainPage extends javax.swing.JPanel {

    public MainPage(Welcome welcome) throws IOException {
        initComponents(); 
                                
        statistics = new Statistics(welcome);        
        search = new Search(welcome);        
        graph = new Graph(welcome);
                
        mainpagetabs.add(welcome.overview);
        mainpagetabs.add(statistics);
        mainpagetabs.add(search);
        mainpagetabs.add(graph);
        
        mainpagetabs.setTitleAt(0, "Overview"); 
        mainpagetabs.setTitleAt(1, "Statistics"); 
        mainpagetabs.setTitleAt(2, "Search");
        mainpagetabs.setTitleAt(3, "Graph");
        
        //mainpagetabs.setSize(welcome.overview.getSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpagetabs = new javax.swing.JTabbedPane();

        setPreferredSize(new java.awt.Dimension(391, 291));
        setLayout(new java.awt.BorderLayout());

        mainpagetabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainpagetabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        mainpagetabs.setToolTipText("");
        add(mainpagetabs, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JPanel graph;
    private javax.swing.JPanel statistics;
    private javax.swing.JPanel search;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainpagetabs;
    // End of variables declaration//GEN-END:variables
}
