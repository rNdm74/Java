
package pprogramming3assignmentone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author rNdm
 */
public class Statistics extends javax.swing.JPanel implements ActionListener {

    public Statistics(Welcome welcome) {
        this.welcome = welcome;
        
        initComponents();
        
//        for (int i = 0; i < statistics.getComponentCount(); i++) {
//            if (statistics.getComponent(i).getName() != null) {
//                JComboBox columnlist = (JComboBox)statistics.getComponent(i);
//                
//            }
//        }
        
        columnlist.removeAllItems();
        
        for (Object s: welcome.csvData.getData().get(0)) {
            columnlist.addItem(((String)s).toUpperCase());
        }
        
        columnlist.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        columnlist = new javax.swing.JComboBox();
        max = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        mean = new javax.swing.JLabel();
        median = new javax.swing.JLabel();
        mode = new javax.swing.JLabel();
        range = new javax.swing.JLabel();
        maxoutput = new javax.swing.JFormattedTextField();
        minoutput = new javax.swing.JFormattedTextField();
        meanoutput = new javax.swing.JFormattedTextField();
        medianoutput = new javax.swing.JFormattedTextField();
        modeoutput = new javax.swing.JFormattedTextField();
        rangeoutput = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(391, 291));

        columnlist.setMaximumRowCount(100);
        columnlist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item", " " }));
        columnlist.setName("columnlist"); // NOI18N

        max.setText("Max");

        min.setText("Min");

        mean.setText("Mean");

        median.setText("Median");

        mode.setText("Mode");

        range.setText("Range");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(max, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mean, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(min, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mode, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(median, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(range, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minoutput, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(maxoutput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(medianoutput)
                            .addComponent(meanoutput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rangeoutput)
                            .addComponent(modeoutput, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(columnlist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(columnlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxoutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(max))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minoutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(min))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meanoutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mean))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medianoutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(median))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeoutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mode))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rangeoutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(range))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private Welcome welcome;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox columnlist;
    private javax.swing.JLabel max;
    private javax.swing.JFormattedTextField maxoutput;
    private javax.swing.JLabel mean;
    private javax.swing.JFormattedTextField meanoutput;
    private javax.swing.JLabel median;
    private javax.swing.JFormattedTextField medianoutput;
    private javax.swing.JLabel min;
    private javax.swing.JFormattedTextField minoutput;
    private javax.swing.JLabel mode;
    private javax.swing.JFormattedTextField modeoutput;
    private javax.swing.JLabel range;
    private javax.swing.JFormattedTextField rangeoutput;
    // End of variables declaration//GEN-END:variables


    @Override
    public void actionPerformed(ActionEvent e) {
        String item = (String) ((JComboBox)e.getSource()).getSelectedItem();
        
        int columnPosition = (column(item, welcome.csvData));
        
        maxoutput.setText((findMax(columnPosition, welcome.csvData)));
        minoutput.setText((findMin(columnPosition, welcome.csvData)));
        meanoutput.setText(findMean(columnPosition, welcome.csvData));
        medianoutput.setText(findMedian(columnPosition, welcome.csvData));
        modeoutput.setText(findMode(columnPosition, welcome.csvData));
        rangeoutput.setText(findRange());
    }
    
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
    
    private String findMax(int column, Worker file){
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
    private String findRange(){
        if (isValid(maxoutput.getText())){
            //new ItemCompare().compare(maxoutput, minoutput);
            double maximum = Double.parseDouble(maxoutput.getText());
            double minimum = Double.parseDouble(minoutput.getText());
            return Double.toString(maximum - minimum);
        }    
        else{
            return "Item cannot be calculated";
        }        
    }
}
