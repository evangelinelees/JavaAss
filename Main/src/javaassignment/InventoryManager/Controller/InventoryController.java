/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.InventoryManager.Controller;


import java.util.List;
import javaassignment.InventoryManager.Models.Item;
import javaassignment.InventoryManager.Services.InventoryService;

public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController() {
        this.inventoryService = new InventoryService();
    }
    
    
    public void saveItem(String itemId, String itemName, String description, int quantity, double price, String name) {
        Item newItem = new Item(itemId, itemName, description, quantity, price,name);
        inventoryService.addItem(newItem);
    }

    public List<Item> getAllItems() {
        return inventoryService.getAllItems();
    }
    
    public void updateItem(String itemId, String itemName, String description, int quantity, double price, String name) {
        inventoryService.updateItem(itemId, itemName, description, quantity, price, name);
    }
    
    public void deleteItem(String itemId) {
        inventoryService.deleteItem(itemId);
    }
    
    public Item getItemById(String itemId) {
        return inventoryService.getItemById(itemId);
    }

    public Item getItemsByName(String itemName) {
        return inventoryService.getItemsByName(itemName);
    }
    
    public void deductItemQuantity(String itemId, String lossesText, String soldText) {
        try {
            int losses = Integer.parseInt(lossesText.trim());
            int sold = Integer.parseInt(soldText.trim());

            inventoryService.deductItemQuantity(itemId, losses, sold); // Call the service layer

            System.out.println("Quantity successfully updated for item ID: " + itemId);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format for losses or sold: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }  
    
    public void updateItemQuantity(String itemName, int purchasedQuantity) {
        try {
            inventoryService.updateItemQuantity(itemName, purchasedQuantity);
            System.out.println("Controller: Item quantity updated successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println("Controller: " + e.getMessage());
        }
    }
}