
package pprogramming3assignmentone.JPanels;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import pprogramming3assignmentone.Classes.Worker;

/**
 *
 * @author rndm
 */
public final class Home extends javax.swing.JFrame {
    /**
     *
     */
    public boolean loadfile;
    /**
     *
     */
    public boolean overviewActive;
    /**
     *
     */
    public boolean mainpageActive;
    
    /**
     *
     */
    public Worker csvData;
    
    /**
     *
     */
    public Load load;
    /**
     *
     */
    public Table table;
    /**
     *
     */
    public Main main;

    private void HomeScreen() throws HeadlessException {
        JFileChooser fc = new JFileChooser();
        
        fc.showDialog(this, "Attach");

        String file = fc.getSelectedFile().getAbsolutePath();

        address.setText(file);
        address.setToolTipText(file);         
        csvData.setFilename(file);

        attach.setText("Next");
        
        loadfile = true;
    }

    private void OverviewScreen() {
        back.setEnabled(true);

        if (csvData.load()) {
            table = new Table(this);      
            content.add(table);                   
        }

        revalidate();

        overviewActive = true;
    }

    private void MainScreen() {
        attach.setText("Close");

        main = new Main(this);

        display("Main", table, main);
    }
    
    /**
     *
     * @throws FileNotFoundException file is not found
     * @throws IOException 
     */
    public enum Display{
        HOME,
        OVERVIEW,
        MAIN
    }
    
    public Home() throws FileNotFoundException, IOException {
        initComponents();
        
        csvData = new Worker(address.getText());
        
        content.add(new Welcome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new javax.swing.JToolBar();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        back = new javax.swing.JButton();
        home = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        address = new javax.swing.JFormattedTextField();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        south = new javax.swing.JPanel();
        attach = new javax.swing.JButton();
        west = new javax.swing.JPanel();
        east = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        north = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - CSV Analyser 1.0");
        setMinimumSize(new java.awt.Dimension(400, 400));
        setName("CSVReader"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleBar.setBackground(new java.awt.Color(255, 255, 255));
        titleBar.setFloatable(false);
        titleBar.setRollover(true);
        titleBar.setMargin(new java.awt.Insets(0, 0, 0, -1));
        titleBar.setMinimumSize(new java.awt.Dimension(76, 40));
        titleBar.setPreferredSize(new java.awt.Dimension(100, 50));
        titleBar.add(filler6);

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

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/32x32/home.png"))); // NOI18N
        home.setEnabled(false);
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
        titleBar.add(filler5);

        getContentPane().add(titleBar, java.awt.BorderLayout.NORTH);

        south.setBackground(new java.awt.Color(255, 255, 255));
        south.setPreferredSize(new java.awt.Dimension(437, 50));

        attach.setText("Attach");
        attach.setMaximumSize(new java.awt.Dimension(96, 23));
        attach.setMinimumSize(new java.awt.Dimension(96, 23));
        attach.setPreferredSize(new java.awt.Dimension(96, 25));
        attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout southLayout = new javax.swing.GroupLayout(south);
        south.setLayout(southLayout);
        southLayout.setHorizontalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southLayout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addComponent(attach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        southLayout.setVerticalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(attach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(south, java.awt.BorderLayout.PAGE_END);

        west.setBackground(new java.awt.Color(255, 255, 255));
        west.setMaximumSize(new java.awt.Dimension(20, 32767));
        west.setPreferredSize(new java.awt.Dimension(20, 50));

        javax.swing.GroupLayout westLayout = new javax.swing.GroupLayout(west);
        west.setLayout(westLayout);
        westLayout.setHorizontalGroup(
            westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        westLayout.setVerticalGroup(
            westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        getContentPane().add(west, java.awt.BorderLayout.WEST);

        east.setBackground(new java.awt.Color(255, 255, 255));
        east.setMaximumSize(new java.awt.Dimension(20, 32767));
        east.setPreferredSize(new java.awt.Dimension(20, 100));

        javax.swing.GroupLayout eastLayout = new javax.swing.GroupLayout(east);
        east.setLayout(eastLayout);
        eastLayout.setHorizontalGroup(
            eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        eastLayout.setVerticalGroup(
            eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        getContentPane().add(east, java.awt.BorderLayout.EAST);

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setLayout(new java.awt.BorderLayout());

        north.setBackground(java.awt.Color.white);
        north.setPreferredSize(new java.awt.Dimension(397, 20));

        javax.swing.GroupLayout northLayout = new javax.swing.GroupLayout(north);
        north.setLayout(northLayout);
        northLayout.setHorizontalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        northLayout.setVerticalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        content.add(north, java.awt.BorderLayout.PAGE_START);

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

    private void attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachActionPerformed
        if (!loadfile) {
            
            HomeScreen();
        }
        else{
            if(!overviewActive){

                OverviewScreen();
            }
            else{

                MainScreen();
            }
        }
    }//GEN-LAST:event_attachActionPerformed
    
    /**
     *
     * @param name sets the title on the JFrame
     * @param remove component from JFrame
     * @param add component from JFrame
     */
    public void display(String name, Component remove, Component add){
        setTitle(name);
        content.remove(remove);        
        content.add(add); 
        content.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JFormattedTextField address;
    public javax.swing.JButton attach;
    public javax.swing.JButton back;
    private javax.swing.JPanel content;
    private javax.swing.JPanel east;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    public javax.swing.JButton home;
    private javax.swing.JPanel north;
    private javax.swing.JPanel south;
    private javax.swing.JToolBar titleBar;
    private javax.swing.JPanel west;
    // End of variables declaration//GEN-END:variables
}
