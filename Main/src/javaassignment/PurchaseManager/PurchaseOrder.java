/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.PurchaseManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */
public class PurchaseOrder {
    private String poId;
    private String itemName;
    private String supplierName;
    private int quantity;
    private double price;
    private double totalAmount;
    private String status; // Default status: Pending
    private LocalDate date;
    
    // Constructor
    public PurchaseOrder(String poId, String itemName, String supplierName, LocalDate date, int quantity, 
                            double price, double totalAmount, String status) {
        this.poId = poId;
        this.itemName = itemName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
        this.status = (status == null || status.isEmpty()) ? "Pending" : status;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getters and Setters
    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    // Convert to file string format for storage
    public String toFileString() {
        return String.format("%s|%s|%s|%s|%d|%.2f|%.2f|%s", poId, itemName, supplierName, date, quantity, price, totalAmount, status);
    }
}