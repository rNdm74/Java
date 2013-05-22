
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author rndm
 */
public class MainPage extends javax.swing.JPanel {

    public MainPage(Welcome welcome) {
        this.welcome = welcome;
        initComponents(); 
        
        overview = new JPanel();
        overview.setLayout(new BorderLayout());
        overview.add(welcome.overview, BorderLayout.CENTER);
        
        statistics = new Statistics(welcome);
        //System.out.println(statistics.);
        JComboBox columnlist = (JComboBox)statistics.getComponent(0);
        columnlist.removeAllItems();
        for (String s: welcome.csv.getCsvData().get(0)) {
            columnlist.addItem(s.toUpperCase());
        }
                
        jTabbedPane1.add(overview);
        jTabbedPane1.add(statistics);
        
        jTabbedPane1.setTitleAt(0, "Overview"); 
        jTabbedPane1.setTitleAt(1, "Statistics"); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        jTabbedPane1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private Welcome welcome;
    private javax.swing.JPanel overview;
    private javax.swing.JPanel statistics;
    private javax.swing.JPanel search;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
