/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.PurchaseManager;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author User
 */

import java.util.List;

public interface PurchaseOrderDao {
    boolean savePurchaseOrder(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> getAllPurchaseOrders();
    boolean updatePurchaseOrderStatus(String poId, String status);
    PurchaseOrder getPurchaseOrderById(String poId);
   
}