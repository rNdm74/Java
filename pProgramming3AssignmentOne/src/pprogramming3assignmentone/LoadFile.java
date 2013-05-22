
package pprogramming3assignmentone;

import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author rNdm
 */
public class LoadFile extends javax.swing.JPanel implements MouseListener{
    private Welcome welcome;
    
    public LoadFile(Welcome welcome) {
        this.welcome = welcome;
        initComponents();
        filePath.addMouseListener(this);
        open.transferFocus();          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseCsvFile = new javax.swing.JLabel();
        open = new javax.swing.JButton();
        filePath = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(100, 100));

        chooseCsvFile.setText(" Import csv file");

        open.setText("Open");
        open.setNextFocusableComponent(filePath);
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        filePath.setText("/home/rndm/Work/Pi_Bak/thunderhead/sensor.csv");
        filePath.setToolTipText("");
        filePath.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        filePath.setDisabledTextColor(java.awt.Color.darkGray);
        filePath.setFocusTraversalPolicy(open.getFocusTraversalPolicy());
        filePath.setFocusable(false);
        filePath.setHighlighter(null);
        filePath.setPreferredSize(new java.awt.Dimension(250, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooseCsvFile, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filePath, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(chooseCsvFile, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(open))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        try{
            JFileChooser fc = new JFileChooser();
            fc.showDialog(this, "Attach");

            String file = fc.getSelectedFile().getAbsolutePath();
            
            welcome.csv = new Worker(file);

            filePath.setText(file);
            filePath.setToolTipText(file);
            
            welcome.ok.setEnabled(true);
        }
        catch(HeadlessException | IOException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_openActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chooseCsvFile;
    private javax.swing.JFormattedTextField filePath;
    private javax.swing.JButton open;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        filePath.setFocusable(true);
        filePath.requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
