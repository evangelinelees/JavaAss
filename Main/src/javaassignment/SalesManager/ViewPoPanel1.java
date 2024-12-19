/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.SalesManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javaassignment.InventoryManager.Components.ScrollBarWin11UI;
import javaassignment.PurchaseManager.PurchaseOrder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jchok
 */
public class ViewPoPanel1 {
    private JTable table;
    private DefaultTableModel tableModel;

    public ViewPoPanel1() {
        tableModel = new DefaultTableModel(new Object[]{
                "PO ID", "Item Name", "Supplier Name", "Date", "Quantity", "Price", "Total Amount","Status"}, 0);
        table = new JTable(tableModel);
        initComponents();
    }


private void initComponents() {
        // Column names
        String[] columnNames = {"PO ID", "Item Name", "Supplier Name", "Date", "Quantity", "Price", "Total Amount","Status"};

        // Create table model and JTable
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        // JScrollPane for table with custom scrollbars
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 150));
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarWin11UI());
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarWin11UI());

        
    }
    
    

    public void populatePurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        tableModel.setRowCount(0); // Clear existing rows
        for (PurchaseOrder po : purchaseOrders) {
            tableModel.addRow(new Object[]{
                    po.getPoId(),
                    po.getItemName(),
                    po.getSupplierName(),
                    po.getDate(),
                    po.getQuantity(),
                    po.getPrice(),
                    po.getTotalAmount(),
                    po.getStatus()     
            });
        }
    }
    
    public JTable getTable() {
        return table;
    }
}