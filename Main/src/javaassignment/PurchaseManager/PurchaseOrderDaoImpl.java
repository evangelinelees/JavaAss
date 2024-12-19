/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.PurchaseManager;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
    private final String purchaseOrderFilePath = "src/Databases/purchaseOrder.txt";

    @Override
    public boolean savePurchaseOrder(PurchaseOrder purchaseOrder) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(purchaseOrderFilePath, true))) {
            writer.write(purchaseOrder.toFileString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
    }
}

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(purchaseOrderFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 8) { // Ensure the data is complete
                    String poId = parts[0];
                    String itemName = parts[1];
                    String supplierName = parts[2];
                    LocalDate date = LocalDate.parse(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);
                    double price = Double.parseDouble(parts[5]);
                    double totalAmount = Double.parseDouble(parts[6]);
                    String status = parts[7];
                    purchaseOrders.add(new PurchaseOrder(poId, itemName, supplierName, date, quantity, price, totalAmount, status));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return purchaseOrders;
    }

    @Override
    public boolean updatePurchaseOrderStatus(String poId, String status) {
        List<PurchaseOrder> purchaseOrders = getAllPurchaseOrders();
        for (PurchaseOrder po : purchaseOrders) {
            if (po.getPoId().equals(poId)) {
                po.setStatus(status);
                // Save the updated list back to file
                return saveAllPurchaseOrders(purchaseOrders);
            }
        }
        return false;
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(String poId) {
        List<PurchaseOrder> purchaseOrders = getAllPurchaseOrders();
        for (PurchaseOrder po : purchaseOrders) {
            if (po.getPoId().equals(poId)) {
                return po;
            }
        }
        return null;
    }

    private boolean saveAllPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(purchaseOrderFilePath))) {
            for (PurchaseOrder po : purchaseOrders) {
                writer.write(po.toFileString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}