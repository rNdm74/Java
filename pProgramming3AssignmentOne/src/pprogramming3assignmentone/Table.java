
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import java.awt.Cursor;
import javax.swing.*;

public class Table extends javax.swing.JPanel {

    public Table(Home home) {
        this.home = home;
                
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
        table.setBackground(getBackground());
        table.setAutoCreateRowSorter(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        //scrollPane.setVisible(true);
        //scrollPane.setBorder(BorderFactory.createEtchedBorder());
        
        centre.add(scrollPane);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centre = new javax.swing.JPanel();
        north = new javax.swing.JPanel();
        south = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        east = new javax.swing.JPanel();
        west = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        setPreferredSize(new java.awt.Dimension(391, 291));
        setLayout(new java.awt.BorderLayout());

        centre.setPreferredSize(new java.awt.Dimension(100, 100));
        centre.setLayout(new java.awt.BorderLayout());
        add(centre, java.awt.BorderLayout.CENTER);

        north.setBackground(new java.awt.Color(255, 255, 255));
        north.setPreferredSize(new java.awt.Dimension(400, 20));

        javax.swing.GroupLayout northLayout = new javax.swing.GroupLayout(north);
        north.setLayout(northLayout);
        northLayout.setHorizontalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );
        northLayout.setVerticalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(north, java.awt.BorderLayout.NORTH);

        south.setBackground(new java.awt.Color(255, 255, 255));
        south.setPreferredSize(new java.awt.Dimension(400, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jFormattedTextField1.setBorder(null);
        jFormattedTextField1.setForeground(new java.awt.Color(109, 109, 109));
        jFormattedTextField1.setText("Filter data");
        jFormattedTextField1.setFont(jFormattedTextField1.getFont().deriveFont(jFormattedTextField1.getFont().getSize()+1f));
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(109, 25));
        jFormattedTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jFormattedTextField1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jFormattedTextField1MouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/16x16/filter.png"))); // NOI18N
        jLabel1.setEnabled(false);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout southLayout = new javax.swing.GroupLayout(south);
        south.setLayout(southLayout);
        southLayout.setHorizontalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        southLayout.setVerticalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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
            .addGap(0, 209, Short.MAX_VALUE)
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
            .addGap(0, 209, Short.MAX_VALUE)
        );

        add(west, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }//GEN-LAST:event_jFormattedTextField1MouseEntered

    private void jFormattedTextField1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jFormattedTextField1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        
    }//GEN-LAST:event_jLabel1MouseExited

    private Home home;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centre;
    private javax.swing.JPanel east;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel north;
    private javax.swing.JPanel south;
    private javax.swing.JPanel west;
    // End of variables declaration//GEN-END:variables
}
