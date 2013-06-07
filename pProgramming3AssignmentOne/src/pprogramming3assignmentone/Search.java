
package pprogramming3assignmentone;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adam Charlton
 */
public class Search extends javax.swing.JPanel {
    Home home;
    
    /**
     *
     * @param home constructor receives the home class to access its variables
     */
    public Search(Home home) {
        this.home = home;
        
        initComponents();
        
        initComboBox(home); 
        
        populateTable();  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list = new javax.swing.JComboBox();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        examples = new javax.swing.JComboBox();
        advancedSearch = new javax.swing.JFormattedTextField();
        search = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(391, 291));

        list.setMaximumRowCount(100);
        list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item", " " }));
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

        tableScrollPane.setBorder(null);

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

        examples.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        examples.setPreferredSize(new java.awt.Dimension(56, 25));

        advancedSearch.setForeground(java.awt.SystemColor.textInactiveText);
        advancedSearch.setText("  Advanced Search");
        advancedSearch.setEnabled(false);
        advancedSearch.setFont(advancedSearch.getFont().deriveFont((float)12));
        advancedSearch.setPreferredSize(new java.awt.Dimension(44, 26));
        advancedSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                advancedSearchMouseClicked(evt);
            }
        });
        advancedSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedSearchActionPerformed(evt);
            }
        });
        advancedSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                advancedSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                advancedSearchFocusLost(evt);
            }
        });
        advancedSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                advancedSearchKeyPressed(evt);
            }
        });

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/icons/search16.png"))); // NOI18N
        search.setBorderPainted(false);
        search.setFocusPainted(false);
        search.setRequestFocusEnabled(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(examples, 0, 173, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search))
                    .addComponent(advancedSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(advancedSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(examples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
        try{
            populateTable();
            populateSearchExamples();
        }
        catch(Exception e){
            System.out.println(e);
        }    
    }//GEN-LAST:event_listActionPerformed

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setColumnCount(0);
        
        for (int column = 0; column < list.getItemCount(); column++) {
            model.addColumn(list.getItemAt(column));
        }
    }
    
    private void populateTable(ArrayList<String[]> data) {
        int pos = list.getSelectedIndex();
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        model.setNumRows(0);

        for (int row = 0; row < data.get(pos).length; row++) {
            if (examples.getSelectedItem().equals(data.get(pos)[row])) {                    
                model.addRow(home.csvData.getData().get(row));
            }
        }
    }
        
    private void populateData(ArrayList<String[]> data) {
        int length = home.csvData.getData().get(0).length;

        for (int column = 0; column < length; column++) {
            String[] objects = new String[home.csvData.getData().size()];

            for (int row = 0; row < home.csvData.getData().size(); row++) {
                objects[row] = (String) home.csvData.getData().get(row)[column];
            }

            data.add(objects);
        }
    }
        
    private void populateSearchExamples() {
        examples.removeAllItems();
                        
        for (int i = 1; i < home.csvData.getData().size(); i++) {
           int pos = list.getSelectedIndex();
           String s = String.valueOf(home.csvData.getData().get(i)[pos]);
           examples.addItem(((String)s).toUpperCase());
        }
    }
    
    private void initComboBox(Home home) {
        list.removeAllItems();
        
        for (Object s: home.csvData.getData().get(0)) {
            list.addItem(((String)s).toUpperCase());
        }
    }

    private void listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listItemStateChanged
         
    }//GEN-LAST:event_listItemStateChanged

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        ArrayList<String[]> data = new ArrayList<>();
        populateData(data);
        populateTable(data);
    }//GEN-LAST:event_searchActionPerformed

    private void advancedSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_advancedSearchKeyPressed

        // CODE NOT WORKING WILL IMPLEMENT AT A LATER DATE //
        if (evt.getKeyCode() == 10) {

            
            //            for (Object o: ) {
                //                ((String)o).
                //            }

            //            for (int row = 0; row < data.get(pos).length; row++) {
                //
                //            }
            //
            //            int resultPos = Arrays.binarySearch(data.get(pos), searchField.getText(), new CompareString());
            //
            //
            //
            //            if (resultPos > 0) {
                //                ArrayList<String> rowData = new ArrayList<>();
                //
                //                for (int column = 0; column < data.size(); column++) {
                    //                    String search = searchField.getText();
                    //                    String result = (String) data.get(column)[resultPos];
                    //
                    //                    if (!search.matches(result)) {
                        //                        rowData.add(result);
                        //                    }
                    //                }
                //
                //                DefaultTableModel model = (DefaultTableModel)table.getModel();
                //                model.addRow(rowData.toArray());
                //            }
        }
    }//GEN-LAST:event_advancedSearchKeyPressed

    private void advancedSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_advancedSearchFocusLost
        advancedSearch.setText("Search");
    }//GEN-LAST:event_advancedSearchFocusLost

    private void advancedSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_advancedSearchFocusGained
        advancedSearch.setText("");
    }//GEN-LAST:event_advancedSearchFocusGained

    private void advancedSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedSearchActionPerformed

    }//GEN-LAST:event_advancedSearchActionPerformed

    private void advancedSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advancedSearchMouseClicked

    }//GEN-LAST:event_advancedSearchMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField advancedSearch;
    private javax.swing.JComboBox examples;
    private javax.swing.JComboBox list;
    private javax.swing.JButton search;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
