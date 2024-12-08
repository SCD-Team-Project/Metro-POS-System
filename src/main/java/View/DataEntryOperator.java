/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.DataEntryOperatorController;
import Model.Category;
import Model.DataEntryOperator.DataEntryOperatorService;
import Model.Product;
import Model.UserSession;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class DataEntryOperator extends javax.swing.JFrame 
{

    /**
     * Creates new form DataEntryOperator
     */
    DataEntryOperatorController deoController;
    private List<Product> productList = new ArrayList<>();
    private DefaultTableModel tableModel;
    public DataEntryOperator() 
    {
        initComponents();
        categoryLabel.setVisible(false);
        categoryField.setVisible(false);
        addVbtn.setEnabled(false);
        addProduct.setEnabled(false);
        vendorPanel.setVisible(false);
        salespricelabel.setVisible(false);
        salespricefield.setVisible(false);
        deoController=DataEntryOperatorController.getInstance(new DataEntryOperatorService());
        populateVendorDropdown();
        setupTable();
        toggleProductFields(false);
       populateCategoryDropdown();
    }
     private void populateCategoryDropdown() 
     {
        categoryField.removeAllItems(); // Clear existing items
        List<Category> categories = deoController.getAllCategories(); // Get categories from controller
        if (categories != null && !categories.isEmpty())
        {
            for (Category category : categories)
            {
                categoryField.addItem(category.getCategoryName()); // Add category names to the dropdown
            }
        }
    }
     private void toggleProductFields(boolean visible) 
     {
        categoryLabel.setVisible(visible);
        categoryField.setVisible(visible);
        salespricelabel.setVisible(visible);
        salespricefield.setVisible(visible);
        jScrollPane1.setVisible(visible);

        addressField.setEnabled(!visible);
        nameField.setEnabled(!visible);
        phonenpruchasepriceField2.setEnabled(!visible);
    }
    private void setupTable()
    {
        tableModel = new DefaultTableModel(new Object[]{"Product Name", "Quantity", "Category"}, 0);
        productTable.setModel(tableModel);

        // Add Action Button to Delete Product
        //productTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        //productTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), this));
    }
     private void addProductToTable(Product product) 
     {
        //JButton deleteButton = new JButton("Delete");
        tableModel.addRow(new Object[]{product.getProductName(), product.getStockQuantity(), product.getCategoryID()});
    }

    private void removeProductFromListAndTable(int rowIndex) 
    {
        productList.remove(rowIndex);
        tableModel.removeRow(rowIndex);
    }
    private void saveAllProducts() 
    {
        if (productList.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "No products to save!");
            return;
        }

        int branchID = UserSession.getBranchID();
        int vendorID = deoController.getVendorID((String) venderField.getSelectedItem());  //return -1 if vendorID not found
        boolean success = deoController.addProducts(branchID, vendorID, productList);

        if (success) {
            JOptionPane.showMessageDialog(this, "Products saved successfully!");
            productList.clear();
            tableModel.setRowCount(0); // Clear the table
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save products!");
        }
    }

    private void resetVendorFormFields() 
    {
    nameField.setText("");
    phonenpruchasepriceField2.setText("");
    emailnquantityField.setText("");
    addressField.setText("");
    venderField.setSelectedIndex(0); // Reset dropdown
}
    /*
     private void clearProductFields() {
    productNameField.setText("");
    productCategoryField.setSelectedIndex(0);
    productPriceField.setText("");
     }
    private void populateCategoryDropdown() {
    productCategoryField.removeAllItems();
    List<Category> categories = deoController.getAllCategories();
    if (categories != null && !categories.isEmpty()) {
        for (Category category : categories) {
            productCategoryField.addItem(category.getCategoryName());
        }
    }
}*/
   /* private void saveAllProducts() {
    if (productList.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No products to save!");
        return;
    }

    boolean success = deoController.addProducts(productList);
    if (success) {
        JOptionPane.showMessageDialog(this, "Products saved successfully!");
        productList.clear();
        updateProductTable();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to save products!");
    }
}*/
private void populateVendorDropdown() 
{
    venderField.removeAllItems(); // Clear existing items
    //venderField.addItem("Other"); // Add a blank option

    List<String> vendorNames = deoController.getAllVendorNames(); // Get vendor names from controller
    if (vendorNames != null&& !vendorNames.isEmpty()) 
    {
        for (String vendor : vendorNames) 
        {
            venderField.addItem(vendor); // Add each vendor to the dropdown
        }
    }
    venderField.addItem("Other");
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phoneField = new javax.swing.JTextField();
        bgPane = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        vendorLabel = new javax.swing.JLabel();
        venderField = new javax.swing.JComboBox<>();
        addVbtn = new javax.swing.JButton();
        vendorPanel = new javax.swing.JPanel();
        heading2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        emailnquantityLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        emailnquantityField = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        categoryLabel = new javax.swing.JLabel();
        categoryField = new javax.swing.JComboBox<>();
        addressField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        salespricelabel = new javax.swing.JLabel();
        salespricefield = new javax.swing.JTextField();
        phonenpurchasepricelabel = new javax.swing.JLabel();
        phonenpruchasepriceField2 = new javax.swing.JTextField();
        saveAllProducts = new javax.swing.JButton();
        addProduct = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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

        emailnquantityLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        emailnquantityLabel.setText("Email");
        vendorPanel.add(emailnquantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 173, -1, 20));

        addressLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        addressLabel.setText("Address");
        vendorPanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));
        vendorPanel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 172, -1));
        vendorPanel.add(emailnquantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 172, -1));

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
        vendorPanel.add(categoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        categoryField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryFieldActionPerformed(evt);
            }
        });
        vendorPanel.add(categoryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 170, 30));

        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });
        vendorPanel.add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 250, 70));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(productTable);

        vendorPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 230, 130));

        salespricelabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        salespricelabel.setText("Sales Price");
        vendorPanel.add(salespricelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));
        vendorPanel.add(salespricefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 172, -1));

        phonenpurchasepricelabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        phonenpurchasepricelabel.setText("Phone");
        vendorPanel.add(phonenpurchasepricelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        phonenpruchasepriceField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenpruchasepriceField2ActionPerformed(evt);
            }
        });
        vendorPanel.add(phonenpruchasepriceField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 172, -1));

        saveAllProducts.setText("SAVE ALL");
        saveAllProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAllProductsActionPerformed(evt);
            }
        });
        vendorPanel.add(saveAllProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

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
        bgPane.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(bgPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));
        getContentPane().add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        setSize(new java.awt.Dimension(1059, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void venderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderFieldActionPerformed
        // TODO add your handling code here:
        //also here the vendoxcombonox items will come from the getAllVendorNames() function in DEOControllerClass
        
          if ("Other".equals(venderField.getSelectedItem())) 
          {
            addVbtn.setEnabled(true);  // Enable "Add New Vendor" button
            addProduct.setEnabled(false);
          } 
          else
          {
            addVbtn.setEnabled(false); // Disable "Add New Vendor" button
            addProduct.setEnabled(true);
          }
    }//GEN-LAST:event_venderFieldActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
       //add the things to DB logic
       //the new vendor will be added to the db aka:
       //the controller of DEO will be called its function is this:
       //deoController.addNewVendor(vendorName, phoneNumber, email, address);
       if (heading2.getText().equals("Add New Vendor"))
       {
        String vendorName = nameField.getText();
        String phoneNumber = phonenpruchasepriceField2.getText();
        String email = emailnquantityField.getText();
        String address = addressField.getText();

        if (!vendorName.isEmpty() && !phoneNumber.isEmpty()&& !email.isEmpty()&&!address.isEmpty()) 
        {
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) 
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid email format!", "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!phoneNumber.matches("\\d{11}")) 
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Phone number must be exactly 11 digits!", "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean result=deoController.addNewVendor(vendorName, phoneNumber, email, address);
            if(result)
            {
                JOptionPane.showMessageDialog(this, "Vendor added successfully!");
                vendorPanel.setVisible(false);
                resetVendorFormFields();
                populateVendorDropdown(); // Refresh dropdown
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Failed to add vendor. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
        }
       //also the 
       
       }
       else
       {
            //here comes the product k liay add button click ho to uska wo code
           String productName=nameField.getText();
           int quantity=Integer.parseInt(emailnquantityField.getText());
           String category=(String)categoryField.getSelectedItem();
           int salesPrice=Integer.parseInt(salespricefield.getText());
           
           int purchasedPrice=Integer.parseInt(phonenpruchasepriceField2.getText());
           
           int categoryID=deoController.getCategoryID(category);
           Product product=new Product(productName,categoryID,purchasedPrice,salesPrice, quantity);
           productList.add(product);
           addProductToTable(product);
           
           nameField.setText("");
           emailnquantityField.setText("");
           salespricefield.setText("");
           phonenpruchasepriceField2.setText("");
       }
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
        emailnquantityLabel.setText("Email");
        phonenpurchasepricelabel.setText("Phone");
        
        categoryLabel.setVisible(false);
        categoryField.setVisible(false);
        
        addressLabel.setVisible(true);
        addressField.setVisible(true);
        
        vendorPanel.setVisible(true);
        
        salespricefield.setVisible(false);
        salespricelabel.setVisible(false);
        
        productTable.setVisible(false);
    }//GEN-LAST:event_addVbtnActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        // TODO add your handling code here:
         
        heading2.setText("Add New Product");
        emailnquantityLabel.setText("Quantity");
        phonenpurchasepricelabel.setText("Price Per Unit");
        addbtn.setText("Add");
        categoryLabel.setVisible(true);
        categoryField.setVisible(true);
        
        addressLabel.setVisible(false);
        addressField.setVisible(false);
        
        vendorPanel.setVisible(true);
        
        salespricefield.setVisible(true);
        salespricelabel.setVisible(true);
        
        productTable.setVisible(true);
    }//GEN-LAST:event_addProductActionPerformed

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressFieldActionPerformed

    private void categoryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryFieldActionPerformed

    private void phonenpruchasepriceField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenpruchasepriceField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonenpruchasepriceField2ActionPerformed

    private void saveAllProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAllProductsActionPerformed
        // TODO add your handling code here:
        saveAllProducts();
    }//GEN-LAST:event_saveAllProductsActionPerformed

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
    private javax.swing.JTextField emailnquantityField;
    private javax.swing.JLabel emailnquantityLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel heading2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JTextField phonenpruchasepriceField2;
    private javax.swing.JLabel phonenpurchasepricelabel;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField salespricefield;
    private javax.swing.JLabel salespricelabel;
    private javax.swing.JButton saveAllProducts;
    private javax.swing.JComboBox<String> venderField;
    private javax.swing.JLabel vendorLabel;
    private javax.swing.JPanel vendorPanel;
    // End of variables declaration//GEN-END:variables
}
