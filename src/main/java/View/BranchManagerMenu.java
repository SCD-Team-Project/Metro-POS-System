/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author Dell
 */
public class BranchManagerMenu extends javax.swing.JFrame {

    /**
     * Creates new form BranchManagerMenu
     */
    public BranchManagerMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        addCashierbtn = new javax.swing.JButton();
        addDEObtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Branch Manager");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgPanel.setBackground(new java.awt.Color(255, 255, 255,200));
        bgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        heading.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        heading.setText("Branch Manager");

        addCashierbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addCashierbtn.setText("Add Cashier");
        addCashierbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addCashierbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCashierbtnActionPerformed(evt);
            }
        });

        addDEObtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addDEObtn.setText("Add Data-Entry Operator");
        addDEObtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addDEObtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDEObtnActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        updateBtn.setText("Update/Delete");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBtn.setMaximumSize(new java.awt.Dimension(48, 24));
        updateBtn.setPreferredSize(new java.awt.Dimension(48, 24));

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(heading))
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(addCashierbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addDEObtn)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(75, 75, 75))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(heading)
                .addGap(33, 33, 33)
                .addComponent(addCashierbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addDEObtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(bgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 410, 380));

        mainLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\Stores-Open-Graph-Image.jpg")); // NOI18N
        getContentPane().add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        setSize(new java.awt.Dimension(1059, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addCashierbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCashierbtnActionPerformed
        // TODO add your handling code here:
        AddCashier add=new AddCashier();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addCashierbtnActionPerformed

    private void addDEObtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDEObtnActionPerformed
        // TODO add your handling code here:
        AddDEO add=new AddDEO();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addDEObtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        //show the login SCreen
        Login l=new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BranchManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BranchManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BranchManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BranchManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BranchManagerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCashierbtn;
    private javax.swing.JButton addDEObtn;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel heading;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
