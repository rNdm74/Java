
package pprogramming3assignmentone;

import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author Adam Charlton
 */
public class Sorting extends javax.swing.JPanel implements Comparable<Object>{

    /**
     *
     * @param home initializes the sorting JPanel
     */
    public Sorting(Home home) {
        //this.home = home;
        
        initComponents();
        
        initComboBox(home);
        
        populateData(home);
        
        // Sort data on first column
        Arrays.sort(data.get(0));
        
        populateTable();
    }
    
    private void initComboBox(Home home) {
        list.removeAllItems();
        
        for (Object s: home.csvData.getData().get(0)) {
            list.addItem(((String)s).toUpperCase());
        }
    }

    private void populateData(Home home) {
        data = new ArrayList<>();
        
        int length = home.csvData.getData().get(0).length;

        for (int column = 0; column < length; column++) {
            String[] objects = new String[home.csvData.getData().size()];

            for (int row = 0; row < home.csvData.getData().size(); row++) {
                objects[row] = (String) home.csvData.getData().get(row)[column];
            }

            data.add(objects);
        }
    }

    private void populateColumnData(DefaultTableModel model) throws NumberFormatException {
        for (int column = 0; column < list.getItemCount(); column++) {

            int pos = list.getSelectedIndex();

            ArrayList<Object> columnData = new ArrayList<>();

            for (int row = 1; row < data.get(pos).length; row++) {

                Object item = data.get(column)[row];

                if (isValid(item)) {
                    columnData.add(Double.parseDouble((String)item));
                }
                else{
                    columnData.add((String)item);
                }
            }

            model.addColumn(list.getItemAt(column),columnData.toArray());
        }
    }

    private void setComparator(TableRowSorter sorter) {
        for (int column = 0; column < list.getItemCount(); column++) {
            if (isValid(data.get(column)[1])) {
                sorter.setComparator(column, new CompareDouble());
            }
            else{
                sorter.setComparator(column, new CompareString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        list = new javax.swing.JComboBox();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        sort = new javax.swing.JButton();
        overview = new javax.swing.JRadioButton();
        single = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(254, 254, 254));

        list.setMaximumRowCount(100);
        list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item", " " }));
        list.setEnabled(false);
        list.setName("list"); // NOI18N
        list.setPreferredSize(new java.awt.Dimension(47, 25));
        list.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listItemStateChanged(evt);
            }
        });
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });

        tableScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        tableScrollPane.setBorder(null);

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        table.setGridColor(java.awt.Color.white);
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table.setRowHeight(25);
        tableScrollPane.setViewportView(table);

        sort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/icons/filter.png"))); // NOI18N
        sort.setEnabled(false);
        sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortActionPerformed(evt);
            }
        });

        buttonGroup1.add(overview);
        overview.setSelected(true);
        overview.setText("Overview");

        buttonGroup1.add(single);
        single.setText("Single Item");
        single.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(overview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(single)
                        .addGap(12, 12, 12)
                        .addComponent(list, 0, 163, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sort)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(single)
                        .addComponent(overview))
                    .addComponent(sort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortActionPerformed
        populateTable();
    }//GEN-LAST:event_sortActionPerformed

    private void listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listItemStateChanged

    }//GEN-LAST:event_listItemStateChanged

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
        
    }//GEN-LAST:event_listActionPerformed

    private void populateTable() {
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setColumnCount(0);
            model.setRowCount(0);

            TableRowSorter sorter = new TableRowSorter();
            table.setRowSorter(sorter);
            sorter.setModel(table.getModel());
            
            populateColumnData(model);
            
            setComparator(sorter);
    }

    /**
     *
     * @param input object to determine its variable type
     * @return boolean true false
     */
    public boolean isValid(Object input){ 
       try  
       {  
          Double.parseDouble((String) input);  
          return true;  
       }  
       catch( Exception e)  
       {  
          return false;  
       }  
    }
       
    //private Home home;
    private ArrayList<String[]> data;  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox list;
    private javax.swing.JRadioButton overview;
    private javax.swing.JRadioButton single;
    private javax.swing.JButton sort;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param o sets the default sort
     * @return object that is to be the default sort
     */
    @Override
    public int compareTo(Object o) {
        return Integer.parseInt(data.get(0)[0]);
    }
}
