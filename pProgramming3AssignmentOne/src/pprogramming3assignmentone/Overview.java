
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.*;

public class Overview extends javax.swing.JPanel {

    public Overview(Welcome welcome) {
        this.welcome = welcome;
        
        //welcome.panelTitle.setText("Overview");
        
        //setVisible(true);
        
        initComponents();
                            
        filepath.setText(welcome.csv.getFilename());
                
        overview.setLayout(new BorderLayout());
        
        String[] columnNames = welcome.csv.getCsvData().get(0);
        
        Object[][] data = new Object[welcome.csv.getCsvData().size()-1][columnNames.length];
        
        //System.out.println(csv.getCsvData().size());
        //System.out.println(columnNames.length);
        
        for (int row = 1; row < welcome.csv.getCsvData().size(); row++) {
            System.arraycopy(welcome.csv.getCsvData().get(row), 0, data[row-1], 0, columnNames.length);            
        }
        
        for (int i = 1; i < welcome.csv.getCsvData().size(); i++) {
            for (int j = 0; j < columnNames.length; j++) {
                //System.out.print(data[i][j] + " | ");
            }
            //System.out.println("");
        }
        //
        
        JTable jTable1 = new JTable(data, columnNames);
        jTable1.setBackground(getBackground());
        //jTable1.setPreferredScrollableViewportSize(new Dimension(getWidth() / 2, 70));
        jTable1.setAutoCreateRowSorter(true);
        
        TableRowSorter<TableModel> sorter 
        = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(sorter);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        for (int i = 0; i < 2; i++) {
            //jTable1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );            
        }
        
        //jTable1.getColumnModel().getColumn(1).setPreferredWidth(jTable1.getSize().width / 2);
        
        //jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        
        
        JScrollPane jScrollPane = new JScrollPane(jTable1);
        jTable1.setFillsViewportHeight(true);
        jScrollPane.setVisible(true);
        jScrollPane.setBorder(BorderFactory.createEtchedBorder());
        
        overview.add(jScrollPane, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        overview = new javax.swing.JPanel();
        filepath = new javax.swing.JFormattedTextField();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setPreferredSize(new java.awt.Dimension(100, 100));

        overview.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout overviewLayout = new javax.swing.GroupLayout(overview);
        overview.setLayout(overviewLayout);
        overviewLayout.setHorizontalGroup(
            overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );
        overviewLayout.setVerticalGroup(
            overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );

        filepath.setDisabledTextColor(java.awt.Color.darkGray);
        filepath.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(overview, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addComponent(filepath, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(overview, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(filepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private Welcome welcome;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField filepath;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel overview;
    // End of variables declaration//GEN-END:variables
}
