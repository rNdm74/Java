
package pprogramming3assignmentone;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rNdm
 */
public class Search extends javax.swing.JPanel {
    Home home;
    
    public Search(Home home) {
        this.home = home;
        
        initComponents();
        
        list.removeAllItems();
        
        for (Object s: home.csvData.getData().get(0)) {
            list.addItem(((String)s).toUpperCase());
        }
           
        populateTable();  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list = new javax.swing.JComboBox();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        examples = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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

        table.setBorder(null);
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
        tableScrollPane.setViewportView(table);

        examples.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Basic");

        searchField.setBorder(null);
        searchField.setForeground(java.awt.SystemColor.textInactiveText);
        searchField.setText("  Search");
        searchField.setFont(searchField.getFont().deriveFont((float)12));
        searchField.setPreferredSize(new java.awt.Dimension(44, 26));
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFieldMouseClicked(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/16x16/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Advanced");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(examples, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
       
    }//GEN-LAST:event_searchFieldMouseClicked

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        searchField.setText("");
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        searchField.setText("Search");
    }//GEN-LAST:event_searchFieldFocusLost

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
                       
        if (evt.getKeyCode() == 10) { 
            
      
            /*8*/
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
    }//GEN-LAST:event_searchFieldKeyPressed

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
        
        try{
            populateTable();
            populateSearchExamples((String)list.getSelectedItem());
        }
        catch(Exception e){
            
        }
    }                                    

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setColumnCount(0);
        
        for (int column = 0; column < list.getItemCount(); column++) {
            model.addColumn(list.getItemAt(column));
//            if (list.getItemAt(i) != list.getSelectedItem()) {
//                model.addColumn(list.getItemAt(i));
//            }            
        }
    }//GEN-LAST:event_listActionPerformed

    private void listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listItemStateChanged
         
    }//GEN-LAST:event_listItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<String[]> data = new ArrayList<>();
        
        int length = home.csvData.getData().get(0).length;

        for (int column = 0; column < length; column++) {
            String[] objects = new String[home.csvData.getData().size()];

            for (int row = 0; row < home.csvData.getData().size(); row++) {
                objects[row] = (String) home.csvData.getData().get(row)[column];
            }

            data.add(objects);
        }

        int pos = list.getSelectedIndex();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setNumRows(0);

        for (int row = 0; row < data.get(pos).length; row++) {
            if (examples.getSelectedItem().equals(data.get(pos)[row])) {                    
                model.addRow(home.csvData.getData().get(row));
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox examples;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox list;
    private javax.swing.JFormattedTextField searchField;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

    private void populateSearchExamples(String item) {
        examples.removeAllItems();
                        
        for (int i = 1; i < home.csvData.getData().size(); i++) {
           int pos = list.getSelectedIndex();
           String s = String.valueOf(home.csvData.getData().get(i)[pos]);
           examples.addItem(((String)s).toUpperCase());
        }
    }

    private void search(Home home) {
//        ArrayList<Object[]> data = new ArrayList<>();
//        
//        int length = home.csvData.getData().get(0).length;
//        
//        for (int column = 0; column < length; column++) {
//            Object[] objects = new Object[home.csvData.getData().size()];
//            
//            for (int row = 0; row < home.csvData.getData().size(); row++) {
//                objects[row] = home.csvData.getData().get(row)[column];
//            }
//            data.add(objects);
//        }
//        
//        Arrays.sort(data.get(0));
//        
//        for (int i = 0; i < data.get(0).length; i++) {
//            //System.out.println(data.get(0)[i]);
//        }
 
            
       
        
//        String[] stringData = new String[home.csvData.getData().size()];
//        Double[] doubleData = new Double[home.csvData.getData().size()];
//        
//        for(int i = 1; i < home.csvData.getData().size(); i++){
//            Object o = home.csvData.getData().get(i)[list.getSelectedIndex()];
//            
//            if(isDouble(o)){
//                doubleData[i - 1] = Double.parseDouble((String)o);
//            }
//            else{
//                stringData[i - 1] = (String)o;
//            }
//        }
//                
//        Arrays.sort(stringData, new CompareString());
//        Arrays.sort(doubleData, new CompareDouble());
//                
//        if (stringData[0] != null) {
//            return new Binary().binarySearch(stringData, searchField.getText());
//        }
//        else{
//            
//            return Arrays.binarySearch(doubleData, Double.parseDouble(searchField.getText()));
//        }
        
    }    
    private boolean isDouble(Object o){
        try{
            Double.parseDouble((String)o);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
