
package pprogramming3assignmentone;

/**
 *
 * @author rndm
 */
public class Main extends javax.swing.JPanel {

    public Main(Home home){
        initComponents(); 
                                
        statistics = new Statistics(home);        
        search = new Search(home);        
        graph = new Graph(home);
        sorting = new Sorting(home);
                
        mainpagetabs.add(home.table);
        mainpagetabs.add(statistics);        
        mainpagetabs.add(search);
        mainpagetabs.add(graph);
        mainpagetabs.add(sorting);
        
        mainpagetabs.setTitleAt(0, "Overview"); 
        mainpagetabs.setTitleAt(1, "Statistics"); 
        mainpagetabs.setTitleAt(2, "Search");
        mainpagetabs.setTitleAt(3, "Graph");
        mainpagetabs.setTitleAt(4, "Sorting");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpagetabs = new javax.swing.JTabbedPane();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(391, 291));
        setLayout(new java.awt.BorderLayout());

        mainpagetabs.setBackground(java.awt.Color.white);
        mainpagetabs.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mainpagetabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainpagetabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        mainpagetabs.setToolTipText("");
        mainpagetabs.setOpaque(true);
        add(mainpagetabs, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JPanel graph;
    public javax.swing.JPanel statistics;
    private javax.swing.JPanel search;
    private javax.swing.JPanel sorting;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainpagetabs;
    // End of variables declaration//GEN-END:variables
}
