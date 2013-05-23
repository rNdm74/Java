
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rndm
 */
public final class Welcome extends javax.swing.JFrame {
    public boolean loadfileActive;
    public boolean overviewActive;
    public boolean mainpageActive;
    
    public Worker csvData;
    
    public LoadFile loadfile;
    public Overview overview;
    public MainPage mainpage;
    
    public Welcome() throws FileNotFoundException, IOException {
        initComponents();
        //next.setVisible(false);
        back.setVisible(false);
        content.setLayout(new BorderLayout());
        loadfile = new LoadFile(this);
        content.add(loadfile, BorderLayout.CENTER); 
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0));
        panelTitle = new javax.swing.JLabel();
        bottomBar = new javax.swing.JToolBar();
        ButtonPanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        address = new javax.swing.JFormattedTextField();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("CSVReader"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleBar.setFloatable(false);
        titleBar.setRollover(true);
        titleBar.setMinimumSize(new java.awt.Dimension(76, 40));
        titleBar.setPreferredSize(new java.awt.Dimension(100, 50));
        titleBar.add(filler1);

        panelTitle.setFont(panelTitle.getFont().deriveFont(panelTitle.getFont().getStyle() | java.awt.Font.BOLD, 18));
        panelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelTitle.setText("Welcome");
        titleBar.add(panelTitle);

        getContentPane().add(titleBar, java.awt.BorderLayout.NORTH);

        bottomBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bottomBar.setFloatable(false);
        bottomBar.setBorderPainted(false);
        bottomBar.setMinimumSize(new java.awt.Dimension(22, 40));
        bottomBar.setPreferredSize(new java.awt.Dimension(22, 40));
        bottomBar.setRequestFocusEnabled(false);

        ButtonPanel.setOpaque(false);
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT);
        flowLayout1.setAlignOnBaseline(true);
        ButtonPanel.setLayout(flowLayout1);

        back.setText("Back");
        back.setPreferredSize(new java.awt.Dimension(96, 23));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        ButtonPanel.add(back);

        ok.setText("Next");
        ok.setEnabled(false);
        ok.setMaximumSize(new java.awt.Dimension(96, 23));
        ok.setMinimumSize(new java.awt.Dimension(96, 23));
        ok.setPreferredSize(new java.awt.Dimension(96, 23));
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        ButtonPanel.add(ok);

        ButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0,2));
        bottomBar.add(ButtonPanel);

        getContentPane().add(bottomBar, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        address.setEnabled(false);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        jPanel1.add(content, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        if(!overviewActive){
            back.setVisible(true);
            overview = new Overview(this); 
            
            display("Overview", loadfile, overview);
            overviewActive = true;
            address.setText(csvData.getFilename());
            //pack();
        }
        else{
            //ok.setVisible(false);
            ok.setText("Close");
            //back.setVisible(false);
            try {
                mainpage = new MainPage(this);
            } catch (IOException ex) {
                Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
            display("Mainpage", overview, mainpage);            
            //pack();
        }                
    }//GEN-LAST:event_okActionPerformed

    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        display("Welcome", overview, loadfile);
        overviewActive = false;
    }//GEN-LAST:event_backActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed
    
    private void display(String name, Component remove, Component add){
        panelTitle.setText(name);
        content.remove(remove);        
        content.add(add); 
        content.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JFormattedTextField address;
    private javax.swing.JButton back;
    private javax.swing.JToolBar bottomBar;
    private javax.swing.JPanel content;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton ok;
    public javax.swing.JLabel panelTitle;
    private javax.swing.JToolBar titleBar;
    // End of variables declaration//GEN-END:variables
}
