/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.PurchaseManager;

import java.util.List;

/**
 *
 * @author vroom
 */
public interface RequisitionDAO {
    boolean saveRequisition(String itemCode, String itemName, String currentQuantity, String proposedQuantity, String userId);
    List<Requisition> getAllRequisitions();
    boolean deleteRequisition(String itemCode);
}
