
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

/**
 *
 * @author rndm
 */
public final class Home extends javax.swing.JFrame {
    public boolean loadfileActive;
    public boolean overviewActive;
    public boolean mainpageActive;
    
    public Worker csvData;
    
    public Load load;
    public Table table;
    public Main main;
    
    public Home() throws FileNotFoundException, IOException {
        initComponents();
        
        //content.setLayout(new BorderLayout());
        csvData = new Worker(address.getText());
        
        load = new Load(this);        
        content.add(load); 
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new javax.swing.JToolBar();
        back = new javax.swing.JButton();
        forward = new javax.swing.JButton();
        home = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        address = new javax.swing.JFormattedTextField();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        content = new javax.swing.JPanel();
        bottomBar = new javax.swing.JToolBar();
        buttonPanel = new javax.swing.JPanel();
        next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - CSV Analyser 1.0");
        setMinimumSize(new java.awt.Dimension(400, 400));
        setName("CSVReader"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleBar.setFloatable(false);
        titleBar.setRollover(true);
        titleBar.setMinimumSize(new java.awt.Dimension(76, 40));
        titleBar.setPreferredSize(new java.awt.Dimension(100, 50));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/32x32/arrow-7-left.png"))); // NOI18N
        back.setEnabled(false);
        back.setFocusable(false);
        back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        back.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        titleBar.add(back);

        forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/32x32/arrow-7-right.png"))); // NOI18N
        forward.setEnabled(false);
        forward.setFocusable(false);
        forward.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        forward.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        titleBar.add(forward);

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/32x32/home.png"))); // NOI18N
        home.setFocusable(false);
        home.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        home.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        titleBar.add(home);
        titleBar.add(filler4);

        address.setText("E:\\Share\\Documents\\sensor.csv");
        address.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        address.setFont(address.getFont());
        address.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        address.setMinimumSize(new java.awt.Dimension(6, 30));
        address.setPreferredSize(new java.awt.Dimension(6, 30));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        titleBar.add(address);
        titleBar.add(filler3);

        getContentPane().add(titleBar, java.awt.BorderLayout.NORTH);

        content.setLayout(new java.awt.BorderLayout());
        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        bottomBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bottomBar.setFloatable(false);
        bottomBar.setBorderPainted(false);
        bottomBar.setMinimumSize(new java.awt.Dimension(22, 40));
        bottomBar.setPreferredSize(new java.awt.Dimension(22, 40));
        bottomBar.setRequestFocusEnabled(false);

        buttonPanel.setOpaque(false);
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT);
        flowLayout1.setAlignOnBaseline(true);
        buttonPanel.setLayout(flowLayout1);

        next.setText("Next");
        next.setMaximumSize(new java.awt.Dimension(96, 23));
        next.setMinimumSize(new java.awt.Dimension(96, 23));
        next.setPreferredSize(new java.awt.Dimension(96, 23));
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        buttonPanel.add(next);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0,2));
        bottomBar.add(buttonPanel);

        getContentPane().add(bottomBar, java.awt.BorderLayout.SOUTH);

        getAccessibleContext().setAccessibleName("CSVReader");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if(!overviewActive){
            back.setEnabled(true);
            
            try {
            if (csvData.load()) {
                table = new Table(this);
                display("Data Overview", load, table);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        pack();   
            
            
            table.setVisible(true);
            
            address.setText(csvData.getFilename());
            
            overviewActive = true;
        }
        else{            
            next.setText("Close");
            try {
                table.setBorder(null);
                main = new Main(this);
                display("Main", table, main);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }                
    }//GEN-LAST:event_nextActionPerformed
    
    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        
    }//GEN-LAST:event_addressActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        display("Home", table, load);
        overviewActive = false;
    }//GEN-LAST:event_backActionPerformed
    
    private void display(String name, Component remove, Component add){
        setTitle(name);
        content.remove(remove);        
        content.add(add); 
        content.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JFormattedTextField address;
    private javax.swing.JButton back;
    private javax.swing.JToolBar bottomBar;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel content;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JButton forward;
    private javax.swing.JButton home;
    public javax.swing.JButton next;
    private javax.swing.JToolBar titleBar;
    // End of variables declaration//GEN-END:variables
}
