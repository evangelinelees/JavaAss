/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.PurchaseManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javaassignment.InventoryManager.Components.ScrollBarWin11UI;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class RequisitionTablePanel extends JPanel {
    private final JTable table;
    private final DefaultTableModel tableModel;

    public RequisitionTablePanel() {
        // Initialize the table model with column names
        String[] columnNames = {"Item Code", "Item Name", "Current Quantity", "Proposed Quantity", "User ID"};
        tableModel = new DefaultTableModel(columnNames, 0); // Start with no rows
        table = new JTable(tableModel);
        initComponents();
    }

    private void initComponents() {
        // Set the table properties
        table.setFillsViewportHeight(true);

        // Add JScrollPane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 200)); // Set table size

        // Optional: Custom scrollbar UI
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarWin11UI());
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarWin11UI());

        // Set panel layout and add the scroll pane
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to add a single requisition entry to the table
    public void addRequisition(String itemCode, String itemName, String currentQuantity, String proposedQuantity, String userId) {
        tableModel.addRow(new Object[]{itemCode, itemName, currentQuantity, proposedQuantity, userId});
    }

    // Method to clear all rows from the table
    public void clearTable() {
        tableModel.setRowCount(0); // Clear all rows
    }

    // Method to populate the table with a list of requisitions
    public void populateRequisitions(List<Requisition> requisitions) {
        tableModel.setRowCount(0); // Clear existing rows
        for (Requisition req : requisitions) {
            tableModel.addRow(new Object[]{
                req.getItemCode(),
                req.getItemName(),
                req.getCurrentQuantity(),
                req.getProposedQuantity(),
                req.getUserId()   
            });
        }
    }
    
   

    // Method to get the JTable if needed
    public JTable getTable() {
        return table;
    }
}
