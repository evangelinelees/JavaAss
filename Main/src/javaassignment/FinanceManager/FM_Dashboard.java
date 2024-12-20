
package javaassignment.FinanceManager;


import javaassignment.PurchaseManager.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javaassignment.Admin.AdminDAO;
import javaassignment.Admin.AdminDAOImpl;
import javaassignment.Admin.User;
import javaassignment.InventoryManager.Components.ItemInputPanel;
import javaassignment.InventoryManager.Components.SupplierInputPanel;
import javaassignment.InventoryManager.Controller.InventoryController;
import javaassignment.InventoryManager.Controller.SupplierController;
import javaassignment.InventoryManager.DAO.ItemDao;
import javaassignment.InventoryManager.DAO.ItemDaoImpl;
import javaassignment.InventoryManager.Models.Item;
import javaassignment.InventoryManager.Models.Supplier;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class FM_Dashboard extends javax.swing.JFrame {
    private final SupplierController supplierController;
    private final InventoryController inventoryController;
    private final RequisitionDAO requisitionDAO;
    private final PurchaseOrderDao purchaseOrderDao;
    private String loggedInUser;
    
    
    public FM_Dashboard(String loggedInUser,InventoryController inventoryController, ItemInputPanel itemInputPanel,SupplierInputPanel supplierInputPanel, 
            SupplierController supplierController, RequisitionDAO requisitionDAO, PurchaseOrderDao purchaseOrderDao) {
        this.loggedInUser = loggedInUser;
        this.requisitionDAO = requisitionDAO;
        this.purchaseOrderDao = purchaseOrderDao;
        this.supplierController = supplierController;
        this.inventoryController = inventoryController;
        this.itemInputPanel = itemInputPanel;
        this.supplierInputPanel = supplierInputPanel;
        
        
        initComponents();
        
        loadItems();
        loadSupplier();
        loadPO();
        loadApprovedPO();
    }
    
    
    public FM_Dashboard(InventoryController inventoryController, ItemInputPanel itemInputPanel,SupplierInputPanel supplierInputPanel, 
            SupplierController supplierController, RequisitionDAO requisitionDAO, PurchaseOrderDao purchaseOrderDao) {
        this.requisitionDAO = requisitionDAO;
        this.purchaseOrderDao = purchaseOrderDao;
        this.supplierController = supplierController;
        this.inventoryController = inventoryController;
        this.itemInputPanel = itemInputPanel;
        this.supplierInputPanel = supplierInputPanel;
        this.loggedInUser = loggedInUser;
        
        initComponents();
        
        loadItems();
        loadSupplier();
        loadPO();
        loadApprovedPO();
    }
    
    
    
    
    private void loadItems() {
        List<Item> items = inventoryController.getAllItems(); // Assuming this method exists
        if (itemInputPanel != null) {
            itemInputPanel.populateItems(items);
        }
    }
    
    private void loadSupplier() {
        List<Supplier> suppliers = supplierController.getAllSuppliers(); // Assuming this method exists
        if (supplierInputPanel != null) {
            supplierInputPanel.populateSupplier(suppliers);
        }
    }
    
    private void loadPO(){
        List<PurchaseOrder> purchaseOrder =purchaseOrderDao.getAllPurchaseOrders();
        purchaseOrderTablePanel1.populatePurchaseOrders(purchaseOrder);
    }
    
    private void loadApprovedPO(){
        List<PurchaseOrder> purchaseOrder =purchaseOrderDao.getAllPurchaseOrders();
        purchaseOrderTablePanel2.populateApprovedPurchaseOrders(purchaseOrder);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        MainTAB = new javax.swing.JTabbedPane();
        ItemSupplierTAB = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblItemTb = new javax.swing.JLabel();
        lblSupplierTb = new javax.swing.JLabel();
        itemInputPanel = new javaassignment.InventoryManager.Components.ItemInputPanel();
        supplierInputPanel = new javaassignment.InventoryManager.Components.SupplierInputPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        Approve = new javax.swing.JButton();
        Reject = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        purchaseOrderTablePanel1 = new javaassignment.PurchaseManager.PurchaseOrderTablePanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        paid = new javax.swing.JButton();
        purchaseOrderTablePanel2 = new javaassignment.PurchaseManager.PurchaseOrderTablePanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Save = new javax.swing.JMenuItem();
        LogOut = new javax.swing.JMenuItem();

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jButton1.setText("jButton1");

        jRadioButton1.setText("jRadioButton1");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton2)
                .addContainerGap(551, Short.MAX_VALUE))
        );

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Finance Manager Dashboard");

        lblItemTb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblItemTb.setText("Item Table");

        lblSupplierTb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSupplierTb.setText("Supplier Table");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(supplierInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblSupplierTb, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblItemTb, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(itemInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblItemTb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSupplierTb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        ItemSupplierTAB.addTab("Item & Supplier Table", jPanel2);

        MainTAB.addTab("View Items & Suppliers", ItemSupplierTAB);

        Approve.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Approve.setText("Approve");
        Approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveActionPerformed(evt);
            }
        });

        Reject.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Reject.setText("Reject");
        Reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejectActionPerformed(evt);
            }
        });

        Refresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(purchaseOrderTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 798, Short.MAX_VALUE)
                        .addComponent(Refresh)
                        .addGap(26, 26, 26)
                        .addComponent(Reject)
                        .addGap(18, 18, 18)
                        .addComponent(Approve)))
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(purchaseOrderTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reject)
                    .addComponent(Approve)
                    .addComponent(Refresh))
                .addGap(81, 81, 81))
        );

        jTabbedPane4.addTab("PO Table", jPanel4);

        MainTAB.addTab("Purchase Orders", jTabbedPane4);

        paid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        paid.setText("Pay");
        paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(purchaseOrderTablePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 1051, Short.MAX_VALUE)
                        .addComponent(paid)))
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(purchaseOrderTablePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(paid)
                .addGap(81, 81, 81))
        );

        jTabbedPane1.addTab("PO Pending Payment", jPanel5);

        MainTAB.addTab("Payment", jTabbedPane1);

        jMenu1.setText("File");

        Save.setText("Save Changes");
        jMenu1.add(Save);

        LogOut.setText("Log Out");
        jMenu1.add(LogOut);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(MainTAB, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainTAB)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveActionPerformed
        approvePurchaseOrder();
        loadPO();
    }//GEN-LAST:event_ApproveActionPerformed

    private void RejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RejectActionPerformed
        rejectPurchaseOrder();
        loadPO();
    }//GEN-LAST:event_RejectActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        loadPO();
    }//GEN-LAST:event_RefreshActionPerformed

    private void paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidActionPerformed
        payPurchaseOrder();
        loadApprovedPO();
    }//GEN-LAST:event_paidActionPerformed
     
    private void approvePurchaseOrder() {
        int selectedRow = purchaseOrderTablePanel1.getTable().getSelectedRow();
        if (selectedRow >= 0) {
            String poId = purchaseOrderTablePanel1.getTable().getValueAt(selectedRow, 0).toString(); // Get PO ID from the selected row
            boolean isApproved = purchaseOrderDao.updatePurchaseOrderStatus(poId, "Approved");
            if (isApproved) {
                JOptionPane.showMessageDialog(this, "Purchase Order approved successfully.");
                // Refresh the table
                loadPO();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to approve Purchase Order.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Purchase Order to approve.");
        }
    }
    private void rejectPurchaseOrder() {
        int selectedRow = purchaseOrderTablePanel1.getTable().getSelectedRow();
        if (selectedRow >= 0) {
            String poId = purchaseOrderTablePanel1.getTable().getValueAt(selectedRow, 0).toString(); // Get PO ID from the selected row
            boolean isRejected = purchaseOrderDao.updatePurchaseOrderStatus(poId, "Reject");
            if (isRejected) {
                JOptionPane.showMessageDialog(this, "Purchase Order rejected successfully.");
                // Refresh the table
                loadPO();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to reject Purchase Order.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Purchase Order to reject.");
        }
    }
    
    
    
    
        
    private void payPurchaseOrder() {
        int selectedRow = purchaseOrderTablePanel2.getTable().getSelectedRow();

        if (selectedRow >= 0) {
            // Get the PO ID from the selected row
            String poId = purchaseOrderTablePanel2.getTable().getValueAt(selectedRow, 0).toString();

            // Find the corresponding PurchaseOrder object from the list
            List<PurchaseOrder> purchaseOrders = purchaseOrderDao.getAllPurchaseOrders();
            PurchaseOrder selectedPO = null;

            // Find the selected PO from the list
            for (PurchaseOrder po : purchaseOrders) {
                if (po.getPoId().equals(poId)) {
                    selectedPO = po;
                    break;
                }
            }

            if (selectedPO != null) {
                // Change the status of the purchase order to "Paid"
                selectedPO.setStatus("Paid");

                // Update the status in the DAO (or save it in your data source)
                boolean isPaid = purchaseOrderDao.updatePurchaseOrderStatus(poId, "Paid");
                if (isPaid) {
                    JOptionPane.showMessageDialog(this, "Purchase Order marked as Paid successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to mark Purchase Order as Paid.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Purchase Order not found.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Purchase Order to mark as Paid.");
        }
    }
     
    

   

    
    
    
    
    
    
    
        
    
    public void writeToLog(String uniqueId, String description, String status) {
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
    
    
    
    

    
    

    public static void main(String args[]) {
        InventoryController inventoryController = new InventoryController();
        ItemInputPanel itemInputPanel = new ItemInputPanel();
        SupplierInputPanel supplierInputPanel = new SupplierInputPanel();
        SupplierController supplierController = new SupplierController();
        RequisitionDAO requisitionDAO = new RequisitionDAOImpl();
        PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDaoImpl();
        
        
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FM_Dashboard( inventoryController , itemInputPanel ,supplierInputPanel, 
                        supplierController, requisitionDAO, purchaseOrderDao ).setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Approve;
    private javax.swing.JTabbedPane ItemSupplierTAB;
    private javax.swing.JMenuItem LogOut;
    private javax.swing.JTabbedPane MainTAB;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Reject;
    private javax.swing.JMenuItem Save;
    private javaassignment.InventoryManager.Components.ItemInputPanel itemInputPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JLabel lblItemTb;
    private javax.swing.JLabel lblSupplierTb;
    private javax.swing.JButton paid;
    private javaassignment.PurchaseManager.PurchaseOrderTablePanel purchaseOrderTablePanel1;
    private javaassignment.PurchaseManager.PurchaseOrderTablePanel purchaseOrderTablePanel2;
    private javaassignment.InventoryManager.Components.SupplierInputPanel supplierInputPanel;
    // End of variables declaration//GEN-END:variables

}    
