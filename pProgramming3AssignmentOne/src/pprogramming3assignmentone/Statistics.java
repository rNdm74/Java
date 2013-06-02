
package pprogramming3assignmentone;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adam Charlton
 */
public class Statistics extends javax.swing.JPanel {

    /**
     *
     * @param home constructor that accesses variables from the home class
     */
    public Statistics(Home home) {
        initComponents();
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
            
        model.setColumnCount(0);
        model.setRowCount(0);
        
        String[] names = {"", "Max", "Min", "Mean", "Mode", "Medium", "Range"};
        
        for (int column = 0; column < names.length; column++) {
            model.addColumn(names[column].toUpperCase());
        }
        
        for (int row = 0; row < home.csvData.getData().get(0).length; row++) {            
            model.addRow(new Find(home).returnStats(row));    
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(391, 291));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table.setRowHeight(25);
        tableScrollPane.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
