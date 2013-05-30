
package pprogramming3assignmentone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rNdm
 */
public class Statistics extends javax.swing.JPanel implements ActionListener {

    public Statistics(Home home) {
        this.home = home;
        
        initComponents();
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
            
        model.setColumnCount(0);
        model.setRowCount(0);
        
        String[] names = {"", "Max", "Min", "Mean", "Mode", "Medium", "Range"};
        
        for (int column = 0; column < names.length; column++) {
            model.addColumn(names[column]);
        }
        
        for (int row = 0; row < home.csvData.getData().get(0).length; row++) {
            Object[] items = {
                ((String)home.csvData.getData().get(0)[row]).toUpperCase(),
                findMax(row, home.csvData),
                findMin(row, home.csvData),
                findMean(row, home.csvData),
                findMedian(row, home.csvData),
                findMode(row, home.csvData),
                findRange(findMax(row, home.csvData), findMin(row, home.csvData))
            };

            model.addRow(items);    
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(391, 291));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setRowHeight(25);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private Home home;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {                
//        int pos = ((JComboBox)e.getSource()).getSelectedIndex();
//        
//        maxoutput.setText((findMax(pos, home.csvData)));
//        minoutput.setText((findMin(pos, home.csvData)));
//        meanoutput.setText(findMean(pos, home.csvData));
//        medianoutput.setText(findMedian(pos, home.csvData));
//        modeoutput.setText(findMode(pos, home.csvData));
//        rangeoutput.setText(findRange());
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
    
    public String findMax(int column, Worker file){
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
                return "Item cannot be calculated";
            }
        }
      
        return Double.toString(maxValue);
    }
    private String findMin(int column, Worker file){
        double minValue;
        
        Object item = file.getData().get(1)[column];
        
        if (isValid(item)) {
            minValue = Double.parseDouble((String)item);
        
            for (int row = 1; row < file.getData().size(); row++) {
                item = (String)file.getData().get(row)[column];

                double temp = Double.parseDouble((String)item);
                
                if (temp < minValue) {
                    minValue = temp;
                }            
            }
        } 
        else{
            return "Item cannot be calculated";
        }
      
        return Double.toString(minValue);
    }    
    private String findMean(int column, Worker file){
        double sum = 0;
    
        Object item = file.getData().get(1)[column];
        
        if (isValid(item)) {
            for (int row = 1; row < file.getData().size(); row++) {
                sum += Double.parseDouble((String)item);
            }        
        }
        else{
            return "Item cannot be calculated";
        }
        
        return Double.toString(sum / file.getData().size());
    }    
    private String findMedian(int column, Worker file){       
        double[] temp = new double[file.getData().size()];
        
        Object item = file.getData().get(1)[column];
        
        if (isValid(item)) {
            for (int i = 1; i < temp.length-1; i++) {
                temp[i-1] = Double.parseDouble((String)file.getData().get(i)[column]);
            }
        }
        else{
            return "Item cannot be calculated";
        }
        
        Selection s = new Selection(temp);
        
        s.selectionSortVersion1();
        
        int middle = temp.length/2;
                
        if (temp.length%2 == 1) {
            return Double.toString(temp[middle]);
        } else {
            return Double.toString((temp[middle-1] + temp[middle]) / 2.0);
        }        
    }    
    private String findMode(int column, Worker file){
        double maxValue = 0, maxCount = 0;
        
        Object item = file.getData().get(1)[column];
        
        if (isValid(item)) {
            for (int i = 1; i < file.getData().size(); ++i) {                
                double count = 0;
                
                for (int j = 1; j < file.getData().size(); ++j) {
                    String s1 = (String)file.getData().get(j)[column];
                    String s2 = (String)file.getData().get(i)[column];
                    
                    if (s1.equals(s2)){
                        ++count;
                    }
                }
                
                if (count > maxCount) {
                    maxCount = count;
                    maxValue = Double.parseDouble((String)file.getData().get(i)[column]);
                }
            }
        }
        else{
            return "Item cannot be calculated";
        }

        return Double.toString(maxValue);
    }
    private String findRange(String max, String min){
        if (isValid(max)){
            double maximum = Double.parseDouble(max);
            double minimum = Double.parseDouble(min);
            return Double.toString(maximum - minimum);
        }    
        else{
            return "Item cannot be calculated";
        }        
    }
}
