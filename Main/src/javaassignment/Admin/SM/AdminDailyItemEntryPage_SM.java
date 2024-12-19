
package javaassignment.Admin.SM;

import javaassignment.SalesManager.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import javaassignment.InventoryManager.Controller.InventoryController;

import javaassignment.InventoryManager.Models.Item;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author vroom
 */
public class AdminDailyItemEntryPage_SM extends javax.swing.JFrame {
    private final InventoryController inventoryController;
    public String loggedInUser;
    

    /**
     * Creates new form DailyItemEntryPage
     * @param loggedInUser
     * @param inventoryController
     */
    public AdminDailyItemEntryPage_SM(String loggedInUser, InventoryController inventoryController) {
        initComponents();
        this.inventoryController = inventoryController;
        this.loggedInUser = loggedInUser;

        // Set the current date in the dateField
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateField.setText(today.format(formatter));
        dateField.setEnabled(false);

        // Set fields to be non-editable by default
        itemName.setEnabled(false);
        itemCode.setEnabled(false);
        initialQuantity.setEnabled(false);
        grossProfit.setEnabled(false);
        price.setEnabled(false);

        // Add listeners to calculate grossProfit
        setupListeners();

        // Load items into the table
        loadItems();       
        
    }
    
    public AdminDailyItemEntryPage_SM(InventoryController inventoryController){
       initComponents();
        this.inventoryController = inventoryController;
        

        // Set the current date in the dateField
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateField.setText(today.format(formatter));
        dateField.setEnabled(false);

        // Set fields to be non-editable by default
        itemName.setEnabled(false);
        itemCode.setEnabled(false);
        initialQuantity.setEnabled(false);
        grossProfit.setEnabled(false);
        price.setEnabled(false);

        // Add listeners to calculate grossProfit
        setupListeners();

        // Load items into the table
        loadItems();       
        
    }
     
    private void loadItems() {
        List<Item> items = inventoryController.getAllItems(); // Assuming this method exists
        if (itemInputPanel1 != null) {
            itemInputPanel1.populateItems(items);
        }
    }

     private void addListenerToField(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateGrossProfit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateGrossProfit();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateGrossProfit();
            }
        });
    }

    // Attach listeners to the relevant fields
    private void setupListeners() {
        addListenerToField(initialQuantity);
        addListenerToField(lossesField);
        addListenerToField(quantitySold);
    }
     
    private void updateGrossProfit() {
        try {
            // Get the values from the text fields
            String quantitySoldText = quantitySold.getText().trim();
            String lossesText = lossesField.getText().trim();
            String quantity = initialQuantity.getText().trim();
            String itemPrice = price.getText().trim();
            
            System.out.println("Quantity Sold: " + quantitySoldText);
            System.out.println("Losses: " + lossesText);
            System.out.println("Initial Quantity: " + quantity);
            System.out.println("Item Price: " + itemPrice);

            // Check if either field is empty
            if (quantitySoldText.isEmpty() || lossesText.isEmpty() || quantity.isEmpty() || itemPrice.isEmpty()) {
            grossProfit.setText(""); // Clear the gross profit field if any field is empty
            System.out.println("One or more fields are empty");
            return;
        }

            // Try to parse the values as integers and doubles
            int InitialQuantity = Integer.parseInt(quantity);
            int quantitySoldValue = Integer.parseInt(quantitySoldText);
            int lossesValue = Integer.parseInt(lossesText);
            double itemPriceValue = Double.parseDouble(itemPrice);

            // Ensure quantitySold is not greater than initial quantity
            if (quantitySoldValue + lossesValue > InitialQuantity) {
                grossProfit.setText("Error: Exceeds stock");
                return;
            }

            // Ensure losses do not exceed the remaining stock after sales
            int remainingStock = InitialQuantity - quantitySoldValue;
            if (lossesValue > remainingStock) {
                grossProfit.setText("Error: Losses exceed remaining stock");
                return;
            }

            // Calculate gross profit
            double grossProfitValue = (quantitySoldValue - lossesValue) * itemPriceValue;

            // Display the result in the grossProfit field
            grossProfit.setText(String.format("%.2f", grossProfitValue));

        } catch (NumberFormatException e) {
            System.out.println("Invalid input encountered: " + e.getMessage());
            // Handle invalid inputs gracefully
            grossProfit.setText("Invalid input");

        }
    }
     
    private boolean isValidDate(String date) {
    if (date == null || date.isEmpty()) {
        return false; // Empty or null is invalid
    }

    // Regex to match the YYYY-MM-DD format
    String datePattern = "\\d{4}-\\d{2}-\\d{2}";

    if (!date.matches(datePattern)) {
        return false; // Invalid format
    }

    // Additional validation using SimpleDateFormat to ensure it's a real date
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false); // Ensure strict validation
    try {
        dateFormat.parse(date); // Try parsing the date
        return true; // Valid date
    } catch (ParseException e) {
        return false; // Invalid date
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        itemCode = new javax.swing.JTextField();
        itemName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        initialQuantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        quantitySold = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        grossProfit = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lossesField = new javax.swing.JTextField();
        submitReportButton = new javax.swing.JButton();
        price = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        itemCodeSearch = new javax.swing.JTextField();
        itemNameSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        itemCodeSearchBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        refreshTableBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        customDate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        itemInputPanel1 = new javaassignment.InventoryManager.Components.ItemInputPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Daily Sales Item Report");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jLabel3.setText("Select Item you wish to create daily report for first.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 320, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Item List");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel6.setText("Date of Report:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, 20));

        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });
        jPanel1.add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 130, -1));

        jLabel7.setText("Item ID:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, 20));

        itemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCodeActionPerformed(evt);
            }
        });
        jPanel1.add(itemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 130, -1));

        itemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameActionPerformed(evt);
            }
        });
        jPanel1.add(itemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 130, -1));

        jLabel8.setText("Item Name:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, 20));

        initialQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initialQuantityActionPerformed(evt);
            }
        });
        jPanel1.add(initialQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 130, -1));

        jLabel9.setText("Quantity Sold:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, 20));

        jLabel10.setText("Initial Quantity:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, 20));

        quantitySold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitySoldActionPerformed(evt);
            }
        });
        jPanel1.add(quantitySold, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 80, -1));

        jLabel11.setText("Gross Profit:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, -1, 20));

        grossProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grossProfitActionPerformed(evt);
            }
        });
        jPanel1.add(grossProfit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 220, -1));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel12.setText("Losses:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, 20));

        lossesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lossesFieldActionPerformed(evt);
            }
        });
        jPanel1.add(lossesField, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 80, -1));

        submitReportButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        submitReportButton.setText("Submit Daily Report");
        submitReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitReportButtonActionPerformed(evt);
            }
        });
        jPanel1.add(submitReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 350, -1));

        price.setText("Price");
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 100, -1));

        jLabel1.setText("Price per Item");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, -1, -1));
        jPanel1.add(itemCodeSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 90, -1));
        jPanel1.add(itemNameSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 90, -1));

        jLabel4.setText("Search by Item Code");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel13.setText("Search by Item Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        itemCodeSearchBtn.setText("Search (Item Code)");
        itemCodeSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCodeSearchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(itemCodeSearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        jButton2.setText("Search (Item Name)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        refreshTableBtn.setText("Refresh Table");
        refreshTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTableBtnActionPerformed(evt);
            }
        });
        jPanel1.add(refreshTableBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        jLabel14.setText("Custom Date:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        customDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customDateActionPerformed(evt);
            }
        });
        jPanel1.add(customDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 130, -1));

        jLabel15.setText("YYYY-MM-DD");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, -1, 20));
        jPanel1.add(itemInputPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 470, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed

    }//GEN-LAST:event_dateFieldActionPerformed

    private void itemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCodeActionPerformed

    private void itemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameActionPerformed

    private void initialQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initialQuantityActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        AdminSMPage SMP = new AdminSMPage(loggedInUser);
        SMP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void quantitySoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitySoldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitySoldActionPerformed

    private void lossesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lossesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lossesFieldActionPerformed

    private void grossProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grossProfitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grossProfitActionPerformed

    private void submitReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitReportButtonActionPerformed
    try {
            // Step 1: Validate and determine the report date
            String customDateValue = customDate.getText().trim();
            String reportDate;

            if (isValidDate(customDateValue)) {
                reportDate = customDateValue; // Use customDate if valid
            } else {
                // Show an error if customDate contains invalid characters
                if (!customDateValue.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid date format in Custom Date. Use YYYY-MM-DD.", "Date Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop submission
                }
                reportDate = dateField.getText().trim(); // Fallback to default date
            }

            // Proceed with other steps...
            String Code = this.itemCode.getText();
            String Name = this.itemName.getText();
            Double Price = Double.valueOf(price.getText());
            int quantitySoldValue = Integer.parseInt(quantitySold.getText());
            int lossesValue = Integer.parseInt(lossesField.getText());

            // Step 2: Check for duplicates
            boolean isDuplicate = checkDuplicateInDailyFile(reportDate, Code, Name);
            if (isDuplicate) {
                grossProfit.setText("Error: Duplicate record");
                JOptionPane.showMessageDialog(null, "Duplicate record found. Report not saved.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Step 3: Calculate the gross profit
            double grossProfitValue = (quantitySoldValue - lossesValue) * Price;
            grossProfit.setText(String.format("%.2f", grossProfitValue));

            // Step 4: Update ITEM.txt
            updateItemQuantityInItemsFile();

            // Step 5: Write to DAILY.txt
            writeReportToDailyFile(reportDate, Code, Name, Price, quantitySoldValue, lossesValue, grossProfitValue);

            // Refresh table and success message
            loadItems();
            JOptionPane.showMessageDialog(null, "Report successfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
            writeToLog(loggedInUser," | Submitted daily report | ","SUCCESS");
            

        } catch (NumberFormatException e) {
            grossProfit.setText("Invalid input");
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for Price, Quantity Sold, and Losses.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            grossProfit.setText("Error processing files");
            JOptionPane.showMessageDialog(null, "An error occurred while processing files.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkDuplicateInDailyFile(String reportDate, String itemCode, String itemName) throws IOException {
        // Read the DAILY.txt file
        File dailyFile = new File("src/Databases/DAILY.txt");
        if (!dailyFile.exists()) {
            return false; // No file exists, no duplicates
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(dailyFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line by "|"
                String[] fields = line.split("\\|");

                // Ensure the line contains at least 3 fields
                if (fields.length >= 4) { // Updated to expect at least Price as the 4th field
                    String existingDate = fields[0].trim();
                    String existingItemCode = fields[1].trim();
                    String existingItemName = fields[2].trim();

                    // Check for duplicate record (same date, item code, and item name)
                    if (existingDate.equals(reportDate.trim()) && 
                        existingItemCode.equals(itemCode.trim()) && 
                        existingItemName.equals(itemName.trim())) {
                        return true; // Duplicate found
                    }
                } else {
                    System.out.println("Invalid line in DAILY.txt: " + line);
                }
            }
        }
        return false; // No duplicate found
    }


    private void writeReportToDailyFile(String reportDate, String Code, String Name, Double Price, int quantitySold, int losses, double grossProfit) throws IOException {
        File dailyFile = new File("src/Databases/DAILY.txt");
        List<String> lines = new ArrayList<>();

        // Read the existing lines from the file
        if (dailyFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(dailyFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        }

        // Create the new report line to be inserted
        String newReportLine = String.format("%s|%s|%s|%.2f|%d|%d|%.2f", reportDate, Code, Name, Price, quantitySold, losses, grossProfit);

        // Insert the new report line at the correct position
        boolean inserted = false;
        for (int i = 0; i < lines.size(); i++) {
            String existingLine = lines.get(i);
            String[] fields = existingLine.split("\\|");
            String existingDate = fields[0].trim();

            // Compare dates and insert the new record at the correct position
            if (reportDate.compareTo(existingDate) < 0) {
                lines.add(i, newReportLine);
                inserted = true;
                break;
            }
        }

        // If not inserted yet, it means it should be added at the end
        if (!inserted) {
            lines.add(newReportLine);
        }

        // Write the lines back to the DAILY.txt file with new lines between records
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dailyFile))) {
            for (String line : lines) {
                writer.write(line);  // Write each line
                writer.newLine();  // Add newline after each line
            }
        }
    }



    private void updateItemQuantityInItemsFile() throws IOException {
        String itemId = itemCode.getText().trim();
        String losses = lossesField.getText().trim();
        String sold = quantitySold.getText().trim();

        inventoryController.deductItemQuantity(itemId, losses, sold);
    }//GEN-LAST:event_submitReportButtonActionPerformed

    private void setupTableSelectionListener(){
    itemInputPanel1.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Only react when selection is final
                    int selectedRow = itemInputPanel1.getTable().getSelectedRow();
                    if (selectedRow >= 0) {
                        // Get values from the selected row and populate the fields
                        String itemId = itemInputPanel1.getTable().getValueAt(selectedRow, 0).toString(); // Assuming ID is in the first column
                        String name = itemInputPanel1.getTable().getValueAt(selectedRow, 1).toString();
                        String description = itemInputPanel1.getTable().getValueAt(selectedRow, 2).toString();
                        String quantity = itemInputPanel1.getTable().getValueAt(selectedRow, 3).toString();
                        String price1 = itemInputPanel1.getTable().getValueAt(selectedRow, 4).toString();

                        // Populate the fields for editing
                        itemCode.setText(itemId);
                        itemName.setText(name);
                        //descriptionField.setText(description);
                        initialQuantity.setText(quantity);
                        price.setText(price1);
                    }
                }
            }
        });
    }
    
    
    
    private void refreshTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTableBtnActionPerformed
        loadItems();
    }//GEN-LAST:event_refreshTableBtnActionPerformed

    private void customDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customDateActionPerformed

    private void itemCodeSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCodeSearchBtnActionPerformed
        String itemId = itemCodeSearch.getText().trim();

    if (itemId.isEmpty()) {
        try {
            List<Item> allItems = inventoryController.getAllItems(); // Get all items (no search filter)
            
            // Update the table with all items
            itemInputPanel1.populateItems(allItems); // Assuming this method accepts a list of items
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while loading all items.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }else{
        try {
            Item item = inventoryController.getItemById(itemId); // Now it returns a single item

            if (item == null) {
            JOptionPane.showMessageDialog(this, "No item found with this Item Code.", "No Results", JOptionPane.INFORMATION_MESSAGE);
            } else {
            // Update the itemReorderLevel1 table with the found item
                itemInputPanel1.populateItems(Collections.singletonList(item)); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while searching for the item.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            }
    }            
    }//GEN-LAST:event_itemCodeSearchBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String itemName = itemNameSearch.getText().trim(); // Get the item name from the search field

        if (itemName.isEmpty()) {
            List<Item> allItems = inventoryController.getAllItems(); // Get all items (no search filter)
            
            // Update the table with all items
            itemInputPanel1.populateItems(allItems);
            JOptionPane.showMessageDialog(this, "Please enter an Item Name to search.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Item item = inventoryController.getItemsByName(itemName); // Now it returns a list of items

            if (item == null) {
                JOptionPane.showMessageDialog(this, "No items found with this Item Name.", "No Results", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Update the itemReorderLevel1 table with the found items
                itemInputPanel1.populateItems(Collections.singletonList(item));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while searching for the item.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDailyItemEntryPage_SM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDailyItemEntryPage_SM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDailyItemEntryPage_SM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDailyItemEntryPage_SM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InventoryController inventoryController = new InventoryController();
                AdminDailyItemEntryPage_SM frame = new AdminDailyItemEntryPage_SM(inventoryController);
                frame.setVisible(true);
                frame.setupTableSelectionListener();
                frame.setupListeners();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField customDate;
    private javax.swing.JTextField dateField;
    private javax.swing.JTextField grossProfit;
    private javax.swing.JTextField initialQuantity;
    private javax.swing.JTextField itemCode;
    private javax.swing.JTextField itemCodeSearch;
    private javax.swing.JButton itemCodeSearchBtn;
    private javaassignment.InventoryManager.Components.ItemInputPanel itemInputPanel1;
    private javax.swing.JTextField itemName;
    private javax.swing.JTextField itemNameSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lossesField;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quantitySold;
    private javax.swing.JButton refreshTableBtn;
    private javax.swing.JButton submitReportButton;
    // End of variables declaration//GEN-END:variables
}