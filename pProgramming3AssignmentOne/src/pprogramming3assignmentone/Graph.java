
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;

/**
 *
 * @author rNdm
 */
public class Graph extends javax.swing.JPanel{
   
    public Graph(Home home) {
        this.home = home;
        initComponents();
        
        list.removeAllItems();
        
        for (Object s: home.csvData.getData().get(0)) {
            list.addItem(((String)s).toUpperCase());
        }
                
        activity.setLayout(new BorderLayout());
        
        drawGraph = new Activity(home);
        
        drawGraph.getData().clear();
        
        int pos = list.getSelectedIndex();
        
        for (int i = 1; i < home.csvData.getData().size(); i++) {            
            if (isGraphable((String)home.csvData.getData().get(i)[pos])) {
                String value = (String)home.csvData.getData().get(i)[pos];
            
                drawGraph.getData().add(Integer.parseInt(value));
            }            
        }
        
        drawGraph.setBackground(Color.WHITE);
        
        activity.add(drawGraph, BorderLayout.CENTER);
    }
    
    private boolean isGraphable(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activity = new javax.swing.JPanel();
        list = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(391, 291));

        activity.setBackground(java.awt.Color.white);
        activity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        activity.setOpaque(false);

        javax.swing.GroupLayout activityLayout = new javax.swing.GroupLayout(activity);
        activity.setLayout(activityLayout);
        activityLayout.setHorizontalGroup(
            activityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );
        activityLayout.setVerticalGroup(
            activityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item" }));
        list.setPreferredSize(new java.awt.Dimension(47, 25));
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(list, 0, 371, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
        if (drawGraph != null) {
            drawGraph.getData().clear();
            
            int pos = ((JComboBox)evt.getSource()).getSelectedIndex();
            
            double max = findMax(pos, home.csvData);
            
            drawGraph.setMaxValue((int)Math.round(max));
            
            if (isValid((String)home.csvData.getData().get(1)[pos])) {
                
                for (int i = 1; i < home.csvData.getData().size(); i++) { 
                        Double value = Double.parseDouble((String)home.csvData.getData().get(i)[pos]);                        
                        int newValue = (int)Math.round(value);
                        System.out.println(newValue);
                        drawGraph.getData().add(newValue);                           
                }
            }
            
            repaint(); 
        }
        
    }//GEN-LAST:event_listActionPerformed

    private double findMax(int column, Worker file){
        double maxValue = 0;
        
        for (int row = 1; row < file.getData().size(); row++) {
            Object item = file.getData().get(row)[column];
            
            if (isValid(item)) {
                double temp = Double.parseDouble((String)item);
                if (temp > maxValue) {
                    maxValue = temp;
                }
            } 
            else{
                return 0;
            }
        }
      
        return maxValue;
    }
    
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
    
    private Home home;
    private Activity drawGraph;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel activity;
    private javax.swing.JComboBox list;
    // End of variables declaration//GEN-END:variables
    
}
