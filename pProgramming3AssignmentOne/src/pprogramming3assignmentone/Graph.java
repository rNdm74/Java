
package pprogramming3assignmentone;

import java.awt.BorderLayout;

/**
 *
 * @author rNdm
 */
public class Graph extends javax.swing.JPanel{
   
    public Graph(Home welcome) {
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

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(391, 291));

        activity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout activityLayout = new javax.swing.GroupLayout(activity);
        activity.setLayout(activityLayout);
        activityLayout.setHorizontalGroup(
            activityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        activityLayout.setVerticalGroup(
            activityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        columnlist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item" }));
        columnlist.setPreferredSize(new java.awt.Dimension(47, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(activity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(columnlist, 0, 371, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(columnlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(activity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel activity;
    private javax.swing.JComboBox columnlist;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel drawGraph;
}
