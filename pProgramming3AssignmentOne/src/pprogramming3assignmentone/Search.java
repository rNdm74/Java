
package pprogramming3assignmentone;

/**
 *
 * @author rNdm
 */
public class Search extends javax.swing.JPanel {
    Home home;
    public Search(Home home) {
        this.home = home;
        
        initComponents();
        
        columnlist.removeAllItems();
        
        for (Object s: home.csvData.getData().get(0)) {
            columnlist.addItem(((String)s).toUpperCase());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        columnlist = new javax.swing.JComboBox();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JFormattedTextField();
        searchLabel = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(391, 291));

        columnlist.setMaximumRowCount(100);
        columnlist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item", " " }));
        columnlist.setName("columnlist"); // NOI18N
        columnlist.setPreferredSize(new java.awt.Dimension(47, 25));

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        searchField.setBorder(null);
        searchField.setForeground(java.awt.SystemColor.textInactiveText);
        searchField.setText("  Search");
        searchField.setFont(searchField.getFont().deriveFont((float)12));
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

        searchLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/16x16/search.png"))); // NOI18N
        searchLabel.setEnabled(false);
        searchLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField)
                .addGap(18, 18, 18)
                .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(searchField))
                .addGap(15, 15, 15))
        );

        scroll.setBorder(null);

        result.setColumns(20);
        result.setFont(result.getFont());
        result.setRows(5);
        result.setBorder(null);
        scroll.setViewportView(result);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(columnlist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(columnlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchLabelMouseClicked
        
        
    }//GEN-LAST:event_searchLabelMouseClicked

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
       //System.out.println("doo");
    }//GEN-LAST:event_searchFieldMouseClicked

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        searchField.setText("");
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        searchField.setText("Search");
    }//GEN-LAST:event_searchFieldFocusLost

    private int column(String item, Worker file){
        int column = 0;
        
        int length = file.getData().get(0).length;
                
        for (int i = 0; i < length; i++) {
            String s = ((String)file.getData().get(0)[i]).toUpperCase();
                        
            if (s == null ? item == null : s.equals(item)) {
                column = i;
            }            
        }  
        
        return column;
    }
    
    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        String item = (String)columnlist.getSelectedItem();
        result.removeAll();
        
        if (evt.getKeyCode() == 10) {
            
            for (int i = 1; i < home.csvData.getData().size(); i++) {
               String s = String.valueOf(home.csvData.getData().get(i)[column(item, home.csvData)]);
               result.append(s + "\n"); 
               
//                if (s.(searchField.getText())) {
//                    
//                }                
            }
        }
        
    }//GEN-LAST:event_searchFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox columnlist;
    private javax.swing.JTextArea result;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JFormattedTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    // End of variables declaration//GEN-END:variables
}
