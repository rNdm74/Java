
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Table extends javax.swing.JPanel {

    public Table(Home home) {
                
        initComponents();
                              
        centre.setLayout(new BorderLayout());
                        
        Object[] columnNames = home.csvData.getData().get(0);
                        
        Object[][] data = new Object[home.csvData.getData().size()-1][columnNames.length];
        
        for (int row = 1; row < home.csvData.getData().size(); row++) {
           
            System.arraycopy(
                             home.csvData.getData().get(row), 
                             0, 
                             data[row-1], 
                             0, 
                             columnNames.length
                             );            
        }
                
        JTable table = new JTable(data, columnNames);
        
        JTableHeader th = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        
        table.setRowHeight(25);
        
        for (int column = 0; column < columnNames.length; column++) {
            String item = ((String)columnNames[column]).toUpperCase();
            TableColumn tc = tcm.getColumn(column);
            tc.setHeaderValue(item);
        }
        
        table.setBackground(getBackground());
        table.setGridColor(Color.WHITE);
                
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        centre.add(scrollPane);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centre;
    private javax.swing.JPanel east;
    private javax.swing.JPanel north;
    private javax.swing.JPanel south;
    private javax.swing.JPanel west;
    // End of variables declaration//GEN-END:variables
}
