/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.PurchaseManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class RequisitionDAOImpl implements RequisitionDAO {
    private final String requisitionFilePath = "src/Databases/REQUISITION.txt";
    

    public boolean saveRequisition(String itemCode, String itemName, String currentQuantity, 
            String proposedQuantity, String userId) {
        String reqDetails = itemCode + "|" + itemName + "|" + currentQuantity + "|" + proposedQuantity + "|" + userId;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(requisitionFilePath, true))) {
            writer.write(reqDetails);
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public List<Requisition> getAllRequisitions() {
        List<Requisition> requisitions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(requisitionFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) { // Ensure the data is correct
                    requisitions.add(new Requisition(parts));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requisitions;
    }
    
    public boolean deleteRequisition(String itemCode) {
        List<Requisition> requisitions = getAllRequisitions();
        boolean isDeleted = false;
        try {
            // Create a temporary list to hold all the requisitions except the one to delete
            List<Requisition> updatedRequisitions = new ArrayList<>();

            for (Requisition requisition : requisitions) {
                // If the requisition doesn't match the itemCode to delete, keep it in the list
                if (!requisition.getItemCode().equals(itemCode)) {
                    updatedRequisitions.add(requisition);
                } else {
                    isDeleted = true;
                }
            }

            // If the requisition was found and deleted, rewrite the file with the updated list
            if (isDeleted) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(requisitionFilePath))) {
                    for (Requisition req : updatedRequisitions) {
                        writer.write(req.toFileString());
                        writer.newLine();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return isDeleted;
    }
    
}

    

