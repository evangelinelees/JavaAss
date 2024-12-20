/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaassignment.InventoryManager.Forms;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javaassignment.InventoryManager.Components.ItemInputPanel;
import javaassignment.InventoryManager.Components.SupplierSelection;
import javaassignment.InventoryManager.Controller.InventoryController;
import javaassignment.InventoryManager.Controller.SupplierController;
import javaassignment.InventoryManager.DAO.ItemDao;
import javaassignment.InventoryManager.DAO.ItemDaoImpl;
import javaassignment.InventoryManager.Models.Item;
import javaassignment.InventoryManager.Utilities.DataHandling;
import javaassignment.PurchaseManager.PurchaseOrder;
import javaassignment.PurchaseManager.PurchaseOrderDao;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public final class PaymentOrder extends JPanel {
    
    private final InventoryController inventoryController;
    private final PurchaseOrderDao purchaseOrderDao;
    public String loggedInUser;
    
    
   
    
    public void ItemInputForm(){
        initComponents();
        
    }

    public PaymentOrder(InventoryController inventoryController, ItemInputPanel itemInputPanel1,
        ItemDao itemDao,String loggedInUser,PurchaseOrderDao purchaseOrderDao ) {
        this.purchaseOrderDao = purchaseOrderDao;
        this.loggedInUser = loggedInUser;
        this.inventoryController = inventoryController;
        System.out.println(loggedInUser);
        initComponents();
        loadItems();
        customizeAcceptButton("Update");
        loadPO();
        
    }
    
    
    private void loadItems() {
        List<Item> items = inventoryController.getAllItems(); // Assuming this method exists
        if (itemInputPanel1 != null) {
            itemInputPanel1.populateItems(items);
        }
    }
    
    private void loadPO(){
        List<PurchaseOrder> purchaseOrder = purchaseOrderDao.getAllPurchaseOrders();
        purchaseOrderTablePanel1.populatepPaidPurchaseOrders(purchaseOrder);
    }

   
    
    public void writeToLog(String loggedInUser, String description, String status) {
        try {
                File logFilePath = new File("src/Databases/Log.txt");
                int counter = 1;

                // Create log.txt if it doesn't exist
                if (!logFilePath.exists()) {
                    logFilePath.createNewFile();
            }

            // Read existing log entries and calculate the counter
            try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    counter++;  // Increment the counter for each existing line
                }
            } catch (IOException e) {
                System.err.println("Error reading log file: " + e.getMessage());
            }

            // Prepare the log entry with the counter
            String logEntry = counter + " | "+ loggedInUser + description + status;

            // Append log entry
            try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFilePath, true))) {
                logWriter.write(logEntry);
                logWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemInputPanel1 = new javaassignment.InventoryManager.Components.ItemInputPanel();
        universalButton1 = new javaassignment.InventoryManager.Components.UniversalButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        purchaseOrderTablePanel1 = new javaassignment.PurchaseManager.PurchaseOrderTablePanel();

        setMaximumSize(new java.awt.Dimension(900, 680));
        setMinimumSize(new java.awt.Dimension(900, 680));

        universalButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                universalButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Item Table");

        jLabel8.setText("Paid Purchase Order");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(815, Short.MAX_VALUE)
                .addComponent(universalButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemInputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseOrderTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchaseOrderTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(universalButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        
    }//GEN-LAST:event_saveButton1ActionPerformed

    private void universalButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_universalButton1ActionPerformed
        setupUpdateInventoryButton();
        loadItems();
        loadPO();
    }//GEN-LAST:event_universalButton1ActionPerformed
   
    public void setupUpdateInventoryButton() {
        universalButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Get the selected row from the table
                int selectedRow = purchaseOrderTablePanel1.getTable().getSelectedRow();
                if (selectedRow >= 0) {
                    String itemName = purchaseOrderTablePanel1.getTable().getValueAt(selectedRow, 1).toString();
                    String quantityStr = purchaseOrderTablePanel1.getTable().getValueAt(selectedRow, 4).toString();

                    if (isNumeric(quantityStr)) {
                        int purchasedQuantity = Integer.parseInt(quantityStr);

                        // Call the controller to update the item quantity
                        inventoryController.updateItemQuantity(itemName, purchasedQuantity);

                        // Optionally, refresh the inventory display or give feedback
                        loadPO();  // Reload the table or display a success message
                        JOptionPane.showMessageDialog(null, "Inventory updated successfully.");
                        writeToLog(loggedInUser," | Inventory updated | ","SUCCESS");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid quantity. Please enter a valid number.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a purchase order to update inventory.");
                }
                
            }
        });
        rejectClosedOrder();
    }
    
    private void rejectClosedOrder() {
        int selectedRow = purchaseOrderTablePanel1.getTable().getSelectedRow();
        if (selectedRow >= 0) {
            String poId = purchaseOrderTablePanel1.getTable().getValueAt(selectedRow, 0).toString(); // Get PO ID from the selected row
            boolean isRejected = purchaseOrderDao.updatePurchaseOrderStatus(poId, "Closed");
            if (isRejected) {
                JOptionPane.showMessageDialog(this, "Purchase Order added successfully.");
                // Refresh the table
                loadPO();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to reject Purchase Order.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Purchase Order to reject.");
        }
    }
    
    public boolean isNumeric(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
    
    private void customizeAcceptButton(String text) {
        universalButton1.setText(text);
        System.out.println(loggedInUser);
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaassignment.InventoryManager.Components.ItemInputPanel itemInputPanel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javaassignment.PurchaseManager.PurchaseOrderTablePanel purchaseOrderTablePanel1;
    private javaassignment.InventoryManager.Components.UniversalButton universalButton1;
    // End of variables declaration//GEN-END:variables

    

   
}
