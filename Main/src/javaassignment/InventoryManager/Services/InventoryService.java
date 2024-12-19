package javaassignment.InventoryManager.Services;


import java.util.List;
import javaassignment.InventoryManager.DAO.ItemDao;
import javaassignment.InventoryManager.DAO.ItemDaoImpl;
import javaassignment.InventoryManager.Models.Item;
import javax.swing.JOptionPane;


public class InventoryService {
    private final ItemDao itemDao = new ItemDaoImpl();
    
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }
    
    public void deductItemQuantity(String itemId, int losses, int sold) {
        // Validate inputs
        if (losses < 0 || sold < 0) {
            throw new IllegalArgumentException("Losses and sold values must be non-negative.");
        }

        // Delegate to DAO
        itemDao.deductItemQuantity(itemId, losses, sold);
    }
    
    public void updateItemQuantity(String itemName, int purchasedQuantity) {
        // Delegate the task to the controller (controller already has the logic for item update)
        Item item = itemDao.findByItemName(itemName);
        
        if (item != null) {
            // Update the quantity
            int newQuantity = item.getQuantity() + purchasedQuantity;
            item.setQuantity(newQuantity);

            // Save the updated item back to the DAO
            itemDao.updateItemQuantity(item);
            System.out.println("Item quantity updated: " + itemName + " new quantity: " + newQuantity);
        } else {
            throw new IllegalArgumentException("Item not found: " + itemName);
        }
    }

    
    public void saveItem(Item item) {
        if (item.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        
        Item existingItem = itemDao.findById(item.getItemId());
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            existingItem.setPrice(item.getPrice()); // Update price if necessary
            itemDao.updateItem(existingItem); // Update the existing item
        } else {
            itemDao.saveItem(item); // Save the new item
        }
    }
    
    public void updateItem(String itemId, String itemName, String description, int quantity, double price, String name) {
        Item item = new Item(itemId, itemName, description, quantity, price, name); // Create new Item object
        itemDao.updateItem(item); // Delegate to DAO
    }
    
    public void deleteItem(String itemId) {
        itemDao.deleteItem(itemId);
    }
    
    public Item getItemById(String itemId) {
        return itemDao.findById(itemId);
    }

    public Item getItemsByName(String itemName) {
        return itemDao.findByItemName(itemName);
    }
    
 
    
}