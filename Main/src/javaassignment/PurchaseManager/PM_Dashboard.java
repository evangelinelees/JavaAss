/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaassignment.PurchaseManager;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class PM_Dashboard extends javax.swing.JFrame {
    private final SupplierController supplierController;
    private final InventoryController inventoryController;
    private final RequisitionDAO requisitionDAO;
    private final PurchaseOrderDao purchaseOrderDao;
    private String loggedInUser;    
    
    public PM_Dashboard(InventoryController inventoryController, ItemInputPanel itemInputPanel, SupplierInputPanel supplierInputPanel, SupplierController supplierController, RequisitionDAO requisitionDAO, PurchaseOrderDao purchaseOrderDao) {
        this.loggedInUser = loggedInUser;
        this.requisitionDAO = requisitionDAO;
        this.purchaseOrderDao = purchaseOrderDao;
        this.supplierController = supplierController;
        this.inventoryController = inventoryController;
        this.itemInputPanel = itemInputPanel;
        this.supplierInputPanel = supplierInputPanel;
        
        
        initComponents();
        setupTableSelectionListener();
        loadItemsToTable();
        loadItems();
        loadSupplier();
        loadRequisition();
        loadPO();        
    }
    private void loadItemsToTable() {
        List<Item> items = inventoryController.getAllItems();
        if (itemReorderLevel1 != null) {
            itemReorderLevel1.populateItems(items);
        }
        // Check if inventoryController is initialized
        if (inventoryController != null) {
            // Now it's safe to call methods on inventoryController
            System.out.println("Fetching all items...");
           
            
            System.out.println("Items fetched: " + items.size());
        } else {
            System.out.println("InventoryController is null!");
            System.out.println("inventoryController: " + inventoryController);
        }
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
    
    private void loadRequisition(){
        List<Requisition> requisition = requisitionDAO.getAllRequisitions();
       if (requisitionTablePanel1 != null) {
           requisitionTablePanel1.populateRequisitions(requisition);
        } 
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
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ItemCodeField = new javax.swing.JTextField();
        ItemNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CurrentQuantityField = new javax.swing.JTextField();
        ProposedQuantityField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        UserIDField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SubmitRequisition = new javax.swing.JButton();
        lblSupplierTb1 = new javax.swing.JLabel();
        itemReorderLevel1 = new javaassignment.InventoryManager.Components.ItemReorderLevel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        requisitionTablePanel1 = new javaassignment.PurchaseManager.RequisitionTablePanel();
        GeneratePO = new javax.swing.JButton();
        purchaseOrderTablePanel1 = new javaassignment.PurchaseManager.PurchaseOrderTablePanel();
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
        jLabel1.setText("Purchase Manager Dashboard");

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
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addContainerGap(21, Short.MAX_VALUE))
        );

        ItemSupplierTAB.addTab("Item & Supplier Table", jPanel2);

        MainTAB.addTab("View Items & Suppliers", ItemSupplierTAB);

        jLabel5.setText("Item Code");

        ItemCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCodeFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Item Name");

        jLabel9.setText("Current Quantity");

        jLabel7.setText("Proposed Quantity");

        UserIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIDFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("UserID");

        SubmitRequisition.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SubmitRequisition.setText("Submit Requisition");
        SubmitRequisition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitRequisitionActionPerformed(evt);
            }
        });

        lblSupplierTb1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSupplierTb1.setText("Item Table");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ItemCodeField))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ItemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(SubmitRequisition))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(UserIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CurrentQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ProposedQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemReorderLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplierTb1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSupplierTb1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemReorderLevel1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProposedQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CurrentQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(SubmitRequisition)
                .addGap(40, 40, 40))
        );

        jTabbedPane3.addTab("Requisition Table", jPanel3);

        MainTAB.addTab("Requisitions", jTabbedPane3);

        GeneratePO.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        GeneratePO.setText("Generate Purchase Order");
        GeneratePO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneratePOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(purchaseOrderTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(GeneratePO))
                    .addComponent(requisitionTablePanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(requisitionTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(purchaseOrderTablePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GeneratePO)
                .addGap(93, 93, 93))
        );

        jTabbedPane4.addTab("PO Table", jPanel4);

        MainTAB.addTab("Purchase Orders", jTabbedPane4);

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
                .addGap(235, 235, 235)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainTAB)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainTAB, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemCodeFieldActionPerformed

    private void UserIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserIDFieldActionPerformed

    private void SubmitRequisitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitRequisitionActionPerformed
        String itemCode = ItemCodeField.getText();
        String itemName = ItemNameField.getText();
        String currentQuantity = CurrentQuantityField.getText();
        String proposedQuantity = ProposedQuantityField.getText();
        String userId = UserIDField.getText();

        if (itemCode.isEmpty() || itemName.isEmpty() || currentQuantity.isEmpty() || proposedQuantity.isEmpty() || userId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            AdminDAO adminDAO = new AdminDAOImpl();
            if ("admin".equalsIgnoreCase(userId)) {
                // You can create a default "admin" user object if needed
                User user = new User(); // Assuming a User constructor exists
                user.setUserId("admin");
            
            } else {
            User user = adminDAO.getUserById(userId);
            if (user == null) {
                JOptionPane.showMessageDialog(this, "Invalid UserID. Please enter a valid UserID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

            // Create a Requisition object
            Requisition requisition = new Requisition(itemCode, itemName, currentQuantity, proposedQuantity, userId, loggedInUser);

            // Save requisition using DAO
            RequisitionDAOImpl requisitionDAO = new RequisitionDAOImpl();
            boolean success = requisitionDAO.saveRequisition(itemCode, itemName, currentQuantity, proposedQuantity, userId);
            if (success) {
                JOptionPane.showMessageDialog(this, "Requisition submitted successfully.");
                writeToLog(loggedInUser," | Requisition created | ","SUCCESS");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadRequisition();
        clearFields();
    }//GEN-LAST:event_SubmitRequisitionActionPerformed

    private void GeneratePOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneratePOActionPerformed
        setupGeneratePurchaseOrderButton();
        loadRequisition();
    }//GEN-LAST:event_GeneratePOActionPerformed
    
    public void writeToLog(String uniqueId, String description, String status) {
        try {
                File logFilePath = new File("log.txt");
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
    
    private void clearFields(){ 
       ProposedQuantityField.setText("");
       UserIDField.setText(""); 
    }
    
    public void setupTableSelectionListener() {
        itemReorderLevel1.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // React only when selection is final
                    int selectedRow = itemReorderLevel1.getTable().getSelectedRow();
                    if (selectedRow >= 0) { // Ensure a row is selected
                        // Fetch data from the selected row
                        String itemId = itemReorderLevel1.getTable().getValueAt(selectedRow, 0).toString(); // Column 0: Item ID
                        String itemName = itemReorderLevel1.getTable().getValueAt(selectedRow, 1).toString(); // Column 1: Item Name
                        String quantity = itemReorderLevel1.getTable().getValueAt(selectedRow, 3).toString(); // Column 3: Quantity
                        
                        // Populate the text fields
                        ItemCodeField.setText(itemId);
                        ItemNameField.setText(itemName); 
                        CurrentQuantityField.setText(quantity);

                    }
                }
            }
        });
    }
    
    public void setupGeneratePurchaseOrderButton() {
    GeneratePO.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ItemDao itemDao= new ItemDaoImpl();
            PurchaseOrderDao purchaseOrderDao= new PurchaseOrderDaoImpl();
            // Get selected row in requisition table
            int selectedRow = requisitionTablePanel1.getTable().getSelectedRow();
            if (selectedRow >= 0) { // Ensure a requisition is selected
                String itemCode = requisitionTablePanel1.getTable().getValueAt(selectedRow, 0).toString();
                String itemName = requisitionTablePanel1.getTable().getValueAt(selectedRow, 1).toString(); // Column 1: Item Name
                String proposedQuantityStr = requisitionTablePanel1.getTable().getValueAt(selectedRow, 3).toString(); // Column 3: Proposed Quantity
                int proposedQuantity = Integer.parseInt(proposedQuantityStr);

                // Fetch item price and supplier name from inventory using itemDAO
                Item item = itemDao.findByItemName(itemName); // Fetch item by name
                if (item != null) { 
                    double price = item.getPrice();
                    String supplierName = item.getName();
                    // Step 3: Calculate the total amount
                    double totalAmount = price * proposedQuantity;

                    // Generate a unique PO ID (e.g., based on current time)
                    String poId = "PO" + System.currentTimeMillis(); // Simple example
                    
                    LocalDate currentDate = LocalDate.now();
                    
                    // Create the purchase order
                    PurchaseOrder purchaseOrder = new PurchaseOrder(poId, itemName, supplierName, currentDate, 
                                                                    proposedQuantity, price, totalAmount,"Pending");
                    purchaseOrder.setSupplierName(supplierName); // Set the supplier name
                    purchaseOrder.setStatus("Pending"); // Set default status as "Pending"

                    // Save the purchase order
                    boolean isSaved = purchaseOrderDao.savePurchaseOrder(purchaseOrder);

                    // If purchase order is saved successfully
                    if (isSaved) {
                        // Refresh the purchase order table to display the new purchase order
                        loadPO();

                        // Remove the requisition from the requisition table (assuming you want to delete it)
                        requisitionDAO.deleteRequisition(itemCode);

                        // Optionally show a confirmation message
                        JOptionPane.showMessageDialog(null, "Purchase Order generated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to generate Purchase Order.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Item not found in inventory.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a requisition to generate a purchase order.");
            }
        }
    });
}


    
    
    
    
    private void loadPO(){
        List<PurchaseOrder> purchaseOrder =purchaseOrderDao.getAllPurchaseOrders();
        purchaseOrderTablePanel1.populatePurchaseOrders(purchaseOrder);
    }
    
     
    
    
    public double getPriceFromInventory(String itemName) {
    // Call InventoryDAO or equivalent method to retrieve the price for the given item name
    ItemDao itemDao = new ItemDaoImpl();
    Item item = itemDao.findByItemName(itemName);  // Assuming you have this method

    if (item != null) {
        return item.getPrice(); // Return the price if the item is found
    } else {
        return -1;  // Return -1 if the item is not found
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
                new PM_Dashboard( inventoryController , itemInputPanel ,supplierInputPanel, 
                        supplierController, requisitionDAO, purchaseOrderDao ).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CurrentQuantityField;
    private javax.swing.JButton GeneratePO;
    private javax.swing.JTextField ItemCodeField;
    private javax.swing.JTextField ItemNameField;
    private javax.swing.JTabbedPane ItemSupplierTAB;
    private javax.swing.JMenuItem LogOut;
    private javax.swing.JTabbedPane MainTAB;
    private javax.swing.JTextField ProposedQuantityField;
    private javax.swing.JMenuItem Save;
    private javax.swing.JButton SubmitRequisition;
    private javax.swing.JTextField UserIDField;
    private javaassignment.InventoryManager.Components.ItemInputPanel itemInputPanel;
    private javaassignment.InventoryManager.Components.ItemReorderLevel itemReorderLevel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JLabel lblItemTb;
    private javax.swing.JLabel lblSupplierTb;
    private javax.swing.JLabel lblSupplierTb1;
    private javaassignment.PurchaseManager.PurchaseOrderTablePanel purchaseOrderTablePanel1;
    private javaassignment.PurchaseManager.RequisitionTablePanel requisitionTablePanel1;
    private javaassignment.InventoryManager.Components.SupplierInputPanel supplierInputPanel;
    // End of variables declaration//GEN-END:variables

    
}
