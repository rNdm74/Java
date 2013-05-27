
package pprogramming3assignmentone;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author rndm
 */
public final class Home extends javax.swing.JFrame {
    public boolean loadfile;
    public boolean overviewActive;
    public boolean mainpageActive;
    
    public Worker csvData;
    
    public Load load;
    public Table table;
    public Main main;
    
    public Home() throws FileNotFoundException, IOException {
        initComponents();
        
        csvData = new Worker(address.getText());
        
        //load = new Load(this);        
        //content.add(load); 
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
        jPanel1 = new javax.swing.JPanel();
        next = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

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

        address.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        address.setFont(address.getFont());
        address.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        address.setMinimumSize(new java.awt.Dimension(6, 30));
        address.setPreferredSize(new java.awt.Dimension(250, 30));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        titleBar.add(address);

        getContentPane().add(titleBar, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(437, 50));

        next.setText("Open");
        next.setMaximumSize(new java.awt.Dimension(96, 23));
        next.setMinimumSize(new java.awt.Dimension(96, 23));
        next.setPreferredSize(new java.awt.Dimension(96, 23));
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(20, 32767));
        jPanel2.setPreferredSize(new java.awt.Dimension(20, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(20, 32767));
        jPanel3.setPreferredSize(new java.awt.Dimension(20, 100));
        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setPreferredSize(new java.awt.Dimension(397, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        content.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("CSVReader");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        
    }//GEN-LAST:event_addressActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        display("Home", table, load);
        overviewActive = false;
    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if (!loadfile) {
            JFileChooser fc = new JFileChooser();
            
            fc.showDialog(this, "Attach");

            String file = fc.getSelectedFile().getAbsolutePath();

            address.setText(file);
            address.setToolTipText(file);         
            csvData.setFilename(file);

            next.setText("Next");
            
            loadfile = true;
        }
        else{
            if(!overviewActive){
                back.setEnabled(true);

                if (csvData.load()) {
                    table = new Table(this);
                    
                    //load = new Load(this);        
                    content.add(table);
                    
                    //display("Data Overview", load, table);                    
                }

                pack();

                overviewActive = true;
            }
            else{
                next.setText("Close");

                main = new Main(this);

                display("Main", table, main);
            }
        }
    }//GEN-LAST:event_nextActionPerformed
    
    public void display(String name, Component remove, Component add){
        setTitle(name);
        content.remove(remove);        
        content.add(add); 
        content.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JFormattedTextField address;
    public javax.swing.JButton back;
    private javax.swing.JPanel content;
    private javax.swing.Box.Filler filler4;
    public javax.swing.JButton forward;
    public javax.swing.JButton home;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JButton next;
    private javax.swing.JToolBar titleBar;
    // End of variables declaration//GEN-END:variables
}
