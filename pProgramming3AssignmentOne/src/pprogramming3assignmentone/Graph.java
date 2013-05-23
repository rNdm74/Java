
package pprogramming3assignmentone;

import java.awt.BorderLayout;

/**
 *
 * @author rNdm
 */
public class Graph extends javax.swing.JPanel{
   
    public Graph(Welcome welcome) {
        initComponents();
        
        columnlist.removeAllItems();
        
        for (Object s: welcome.csvData.getData().get(0)) {
            columnlist.addItem(((String)s).toUpperCase());
        }
        
        //columnlist.addActionListener(this);
        
        activity.setLayout(new BorderLayout());
        drawGraph = new Activity(welcome);
        activity.add(drawGraph, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activity = new javax.swing.JPanel();
        columnlist = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(391, 291));

        javax.swing.GroupLayout activityLayout = new javax.swing.GroupLayout(activity);
        activity.setLayout(activityLayout);
        activityLayout.setHorizontalGroup(
            activityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        activityLayout.setVerticalGroup(
            activityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        columnlist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(activity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(columnlist, 0, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(columnlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel activity;
    private javax.swing.JComboBox columnlist;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel drawGraph;
}
