
package pprogramming3assignmentone;

import java.awt.BorderLayout;
import java.awt.Component;
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
    
    public Worker csv;
    
    public LoadFile loadfile;
    public Overview overview;
    public MainPage mainpage;
    
    public Welcome() throws FileNotFoundException, IOException {
        initComponents();
        next.setVisible(false);
        back.setVisible(false);
        content.setLayout(new BorderLayout());
        loadfile = new LoadFile(this);
        content.add(loadfile, BorderLayout.CENTER); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0));
        panelTitle = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        bottomBar = new javax.swing.JToolBar();
        ButtonPanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        content.setPreferredSize(new java.awt.Dimension(391, 291));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        bottomBar.setFloatable(false);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout ButtonPanelLayout = new javax.swing.GroupLayout(ButtonPanel);
        ButtonPanel.setLayout(ButtonPanelLayout);
        ButtonPanelLayout.setHorizontalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ButtonPanelLayout.setVerticalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(next)
                    .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bottomBar.add(ButtonPanel);

        getContentPane().add(bottomBar, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        if(!overviewActive){
            back.setVisible(true);
            overview = new Overview(this); 
            
            display("Overview", loadfile, overview);
            overviewActive = true;
            //pack();
        }
        else{
            ok.setVisible(false);
            ok.setText("Close");
            back.setVisible(false);
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

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        
        
                
    }//GEN-LAST:event_nextActionPerformed
    
    private void display(String name, Component remove, Component add){
        panelTitle.setText(name);
        content.remove(remove);        
        content.add(add); 
        content.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton back;
    private javax.swing.JToolBar bottomBar;
    private javax.swing.JPanel content;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton next;
    public javax.swing.JButton ok;
    public javax.swing.JLabel panelTitle;
    private javax.swing.JToolBar titleBar;
    // End of variables declaration//GEN-END:variables
}
