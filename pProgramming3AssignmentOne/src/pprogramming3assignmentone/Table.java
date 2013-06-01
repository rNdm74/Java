
package pprogramming3assignmentone.JPanels;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Adam Charlton
 */
public class Table extends javax.swing.JPanel {

    /**
     *
     * @param home JTable that displays overview of CSV data
     */
    public Table(Home home) {
        initComponents();
        
        csvData = home.csvData.getData();
                              
        centre.setLayout(new BorderLayout());
        centre.add(new JScrollPane(initTable()));
    }

    private JTable initTable() {
        Object[] columnNames = csvData.get(0);        
        setupTable(returnData(columnNames), columnNames);        
        populateHeader(columnNames);        
        return table;
    }
    
    private void setupTable(Object[][] data, Object[] columnNames) {
        table = new JTable(data, columnNames);
        table.setRowHeight(25);
        table.setBackground(getBackground());
        table.setGridColor(getBackground());
        table.setFillsViewportHeight(true);
        table.setFocusable(false);
    }
    
    private Object[][] returnData(Object[] columnNames) {
        Object[][] data = new Object[csvData.size()-1][columnNames.length];
        
        for (int row = 1; row < csvData.size(); row++) {
            System.arraycopy(csvData.get(row), 0, data[row-1], 0, columnNames.length);            
        }
        
        return data;
    }

    private void populateHeader(Object[] columnNames) {
        JTableHeader header = table.getTableHeader();
        TableColumnModel model = header.getColumnModel();
                
        for (int column = 0; column < columnNames.length; column++) {
            String item = ((String)columnNames[column]).toUpperCase();            
            TableColumn tablecolumn = model.getColumn(column);            
            tablecolumn.setHeaderValue(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centre = new javax.swing.JPanel();
        north = new javax.swing.JPanel();
        south = new javax.swing.JPanel();
        east = new javax.swing.JPanel();
        west = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(391, 291));
        setLayout(new java.awt.BorderLayout());

        centre.setPreferredSize(new java.awt.Dimension(100, 100));
        centre.setLayout(new java.awt.BorderLayout());
        add(centre, java.awt.BorderLayout.CENTER);

        north.setBackground(new java.awt.Color(255, 255, 255));
        north.setPreferredSize(new java.awt.Dimension(400, 11));

        javax.swing.GroupLayout northLayout = new javax.swing.GroupLayout(north);
        north.setLayout(northLayout);
        northLayout.setHorizontalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        northLayout.setVerticalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        add(north, java.awt.BorderLayout.NORTH);

        south.setBackground(new java.awt.Color(255, 255, 255));
        south.setPreferredSize(new java.awt.Dimension(400, 20));

        javax.swing.GroupLayout southLayout = new javax.swing.GroupLayout(south);
        south.setLayout(southLayout);
        southLayout.setHorizontalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        southLayout.setVerticalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(south, java.awt.BorderLayout.PAGE_END);

        east.setBackground(new java.awt.Color(255, 255, 255));
        east.setPreferredSize(new java.awt.Dimension(10, 260));

        javax.swing.GroupLayout eastLayout = new javax.swing.GroupLayout(east);
        east.setLayout(eastLayout);
        eastLayout.setHorizontalGroup(
            eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        eastLayout.setVerticalGroup(
            eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        add(east, java.awt.BorderLayout.EAST);

        west.setBackground(new java.awt.Color(255, 255, 255));
        west.setPreferredSize(new java.awt.Dimension(10, 260));

        javax.swing.GroupLayout westLayout = new javax.swing.GroupLayout(west);
        west.setLayout(westLayout);
        westLayout.setHorizontalGroup(
            westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        westLayout.setVerticalGroup(
            westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        add(west, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private java.util.ArrayList<Object[]> csvData;
    private javax.swing.JTable table;    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centre;
    private javax.swing.JPanel east;
    private javax.swing.JPanel north;
    private javax.swing.JPanel south;
    private javax.swing.JPanel west;
    // End of variables declaration//GEN-END:variables
}
