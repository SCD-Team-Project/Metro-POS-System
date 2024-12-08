/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author Dell
 */
public class DataEntryOperator extends javax.swing.JFrame {

    /**
     * Creates new form DataEntryOperator
     */
    public DataEntryOperator() {
        initComponents();
        categoryLabel.setVisible(false);
        categoryField.setVisible(false);
        addVbtn.setEnabled(false);
        addProduct.setEnabled(false);
        vendorPanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPane = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        vendorLabel = new javax.swing.JLabel();
        venderField = new javax.swing.JComboBox<>();
        addVbtn = new javax.swing.JButton();
        vendorPanel = new javax.swing.JPanel();
        heading2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        categoryLabel = new javax.swing.JLabel();
        categoryField = new javax.swing.JComboBox<>();
        addressField = new javax.swing.JTextField();
        addProduct = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataEntryOperator");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgPane.setBackground(new java.awt.Color(255, 255, 255,200));
        bgPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bgPane.setPreferredSize(new java.awt.Dimension(660, 460));
        bgPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        heading.setText("Data Entry Operator");
        bgPane.add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        vendorLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        vendorLabel.setText("Vendor");
        bgPane.add(vendorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 66, -1, -1));

        venderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "TestItem1", "TestItem2", "" }));
        venderField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        venderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderFieldActionPerformed(evt);
            }
        });
        bgPane.add(venderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 63, 288, 32));

        addVbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addVbtn.setText("Add New Vendor");
        addVbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addVbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVbtnActionPerformed(evt);
            }
        });
        bgPane.add(addVbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 63, -1, 33));

        vendorPanel.setBackground(new java.awt.Color(255, 255, 255));
        vendorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vendorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        heading2.setText("Add New Vendor");
        vendorPanel.add(heading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        nameLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        nameLabel.setText("Name");
        vendorPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        phoneLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        phoneLabel.setText("Phone");
        vendorPanel.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        emailLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        emailLabel.setText("Email");
        vendorPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        addressLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        addressLabel.setText("Address");
        vendorPanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));
        vendorPanel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 172, -1));
        vendorPanel.add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 172, -1));
        vendorPanel.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 172, -1));

        addbtn.setText("ADD");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        vendorPanel.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, -1));

        exitBtn.setText("CLOSE");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        vendorPanel.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        categoryLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        categoryLabel.setText("Category");
        vendorPanel.add(categoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        categoryField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vendorPanel.add(categoryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 170, -1));

        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });
        vendorPanel.add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 250, 70));

        bgPane.add(vendorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 114, 544, 328));

        addProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addProduct.setText("+");
        addProduct.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });
        bgPane.add(addProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(569, 63, 25, 33));

        getContentPane().add(bgPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        mainLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\Stores-Open-Graph-Image.jpg")); // NOI18N
        getContentPane().add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        setSize(new java.awt.Dimension(1059, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void venderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderFieldActionPerformed
        // TODO add your handling code here:
        if(venderField.getSelectedIndex()>0){
            addVbtn.setEnabled(false);
            addProduct.setEnabled(true);
        }
        else{
            addVbtn.setEnabled(true);
            addProduct.setEnabled(false);
        }
    }//GEN-LAST:event_venderFieldActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
       //add the things to DB logic
        
    }//GEN-LAST:event_addbtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        Login l=new Login();
        l.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_exitBtnActionPerformed

    private void addVbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVbtnActionPerformed
        // TODO add your handling code here:
        heading2.setText("Add New Vendor");
        emailLabel.setText("Email");
        phoneLabel.setText("Phone");
        categoryLabel.setVisible(false);
        categoryField.setVisible(false);
        addressLabel.setVisible(true);
        addressField.setVisible(true);
        vendorPanel.setVisible(true);
    }//GEN-LAST:event_addVbtnActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        // TODO add your handling code here:
         
        heading2.setText("Add New Product");
        emailLabel.setText("Quantity");
        phoneLabel.setText("Price");
        categoryLabel.setVisible(true);
        categoryField.setVisible(true);
        addressLabel.setVisible(false);
        addressField.setVisible(false);
        vendorPanel.setVisible(true);
    }//GEN-LAST:event_addProductActionPerformed

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressFieldActionPerformed

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
            java.util.logging.Logger.getLogger(DataEntryOperator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataEntryOperator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataEntryOperator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataEntryOperator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataEntryOperator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JButton addVbtn;
    private javax.swing.JButton addbtn;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JPanel bgPane;
    private javax.swing.JComboBox<String> categoryField;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel heading2;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JComboBox<String> venderField;
    private javax.swing.JLabel vendorLabel;
    private javax.swing.JPanel vendorPanel;
    // End of variables declaration//GEN-END:variables
}
