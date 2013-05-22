
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author rndm
 */
public class MainPage extends javax.swing.JPanel {

    public MainPage(Welcome welcome) throws IOException {
        initComponents(); 
                
        statistics = new Statistics(welcome);
        
        JComboBox columnlist = (JComboBox)statistics.getComponent(0);
        columnlist.removeAllItems();
        for (String s: welcome.csv.getCsvData().get(0)) {
            columnlist.addItem(s.toUpperCase());
        }
        
        search = new Search();        
        graph = new Graph(welcome);
                
        jTabbedPane1.add(welcome.overview);
        jTabbedPane1.add(statistics);
        jTabbedPane1.add(search);
        jTabbedPane1.add(graph);
        
        jTabbedPane1.setTitleAt(0, "Overview"); 
        jTabbedPane1.setTitleAt(1, "Statistics"); 
        jTabbedPane1.setTitleAt(2, "Search");
        jTabbedPane1.setTitleAt(3, "Graph");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setPreferredSize(new java.awt.Dimension(100, 100));

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JPanel graph;
    private javax.swing.JPanel statistics;
    private javax.swing.JPanel search;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
