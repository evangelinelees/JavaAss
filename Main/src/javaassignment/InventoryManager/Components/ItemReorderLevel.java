/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.InventoryManager.Components;



import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import javaassignment.InventoryManager.Models.Item;


public class ItemReorderLevel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private List<Item> originalItems = new ArrayList<>();
    
    public ItemReorderLevel() {
        tableModel = new DefaultTableModel(new Object[]{"Item ID", "Item Name", "Description", "Quantity", "Price","Supplier Name","Reorder Level"}, 0);
        table = new JTable(tableModel);
        initComponents();
    }

    private void initComponents() {
        String[] columnNames = {"Item ID", "Item Name", "Description", "Quantity", "Price","Supplier Name","Reorder Level"};

        // Create the table model and JTable
        tableModel = new DefaultTableModel(columnNames, 0); // Initialize with no rows
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true); // Ensure the table fills the viewport height

        // Add JScrollPane for the JTable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 200)); // Set preferred size for the table

        // Set custom scrollbar UI
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarWin11UI());
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarWin11UI());

        // Set the layout and add the scroll pane to the panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    
    }

    
    public void addItem(String itemId, String itemName, String description, String quantity, String price, String name) {
        
        // Add the row with the calculated reorder level
        tableModel.addRow(new Object[]{itemId, itemName, description, quantity, price, name});    }

    public void clearItems() {
        int selectedRow = table.getSelectedRow(); 
        
        if (selectedRow != -1) { 
            tableModel.removeRow(selectedRow); 
        }
    }

    public void populateItems(List<Item> items) {
         if (originalItems.isEmpty()) {
            originalItems.addAll(items); // Save all items for later refresh
        }

        tableModel.setRowCount(0); // Clear the existing rows
        for (Item item : items) {
            // Convert item quantity from String to int


            boolean isReorderNeeded = item.isReorderNeeded();
            String reorderLevel = isReorderNeeded ? "Yes" : "No";

            // Add row with the item data and reorder level
            tableModel.addRow(new Object[]{
                item.getItemId(),
                item.getItemName(),
                item.getDescription(),
                item.getQuantity(), // Add the original quantity as a string
                item.getPrice(),
                item.getName(),
                reorderLevel // Add dynamic reorder level as "Yes" or "No"
            });
        }
        
    }      

    private boolean calculateReorderLevel(int quantity) {
        int threshold = 10; // Reorder threshold
        return quantity < threshold; // If quantity is less than threshold, reorder is needed
    }

    public void showReorderItems(int threshold) {
        
        List <Item> reorderItems = new ArrayList<>();
        for (Item item : originalItems) { // Use the original list for filtering
            if (item.getQuantity() < threshold) {
                reorderItems.add(item);
            }
        }

        // Populate the table with the filtered list
        populateItems(reorderItems);
    }
    
    public void refreshAllItems() {
        // Populate the table with the original list
        populateItems(originalItems);
    }
    
    public JTable getTable() {
        return table;
    }
    
    
   
}