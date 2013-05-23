
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Overview extends javax.swing.JPanel {

    public Overview(Welcome welcome) {
        this.welcome = welcome;
        
        //welcome.panelTitle.setText("Overview");
        
        //setVisible(true);
        
        initComponents();
                            
        //filepath.setText(welcome.csv.getFilename());
                
        overview.setLayout(new BorderLayout());
        
        Object[] columnNames = welcome.csvData.getData().get(0);
        
        Object[][] data = new Object[welcome.csvData.getData().size()-1][columnNames.length];
        
        for (int row = 1; row < welcome.csvData.getData().size(); row++) {
            
            
            System.arraycopy(
                             welcome.csvData.getData().get(row), 
                             0, 
                             data[row-1], 
                             0, 
                             columnNames.length
                             );            
        }
                
        JTable table = new JTable(data, columnNames);
        table.setBackground(getBackground());
//        table.setAutoCreateRowSorter(true);
//        
//        TableRowSorter<TableModel> sorter 
//        = new TableRowSorter<>(table.getModel());
//        
//        List <RowSorter.SortKey> sortKeys = new ArrayList<>();
//        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
//        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//        sorter.setSortKeys(sortKeys); 
//        
//        table.setRowSorter(sorter);
        
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        for (int i = 0; i < 2; i++) {
            //jTable1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );            
        }
        
        //jTable1.getColumnModel().getColumn(1).setPreferredWidth(jTable1.getSize().width / 2);
        
        //able.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        //table.setDefaultRenderer(String.class, centerRenderer);
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        scrollPane.setVisible(true);
        scrollPane.setBorder(BorderFactory.createEtchedBorder());
        
        overview.add(scrollPane, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        overview = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(391, 291));
        setLayout(new java.awt.BorderLayout());

        overview.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout overviewLayout = new javax.swing.GroupLayout(overview);
        overview.setLayout(overviewLayout);
        overviewLayout.setHorizontalGroup(
            overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        overviewLayout.setVerticalGroup(
            overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        add(overview, java.awt.BorderLayout.CENTER);

        jFormattedTextField1.setText("jFormattedTextField1");
        add(jFormattedTextField1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private Welcome welcome;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel overview;
    // End of variables declaration//GEN-END:variables
}
