/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaassignment.Admin.SM;

import javaassignment.Admin.AdminMainPage;
import javaassignment.InventoryManager.Controller.InventoryController;
import javaassignment.LoginPage;

/**
 *
 * @author vroom
 */
public class AdminSMPage extends javax.swing.JFrame {
    public String loggedInUser;

    /**
     * Creates new form SalesManagerMainPage
     * @param loggedInUser
     */
    public AdminSMPage(String loggedInUser) {
        initComponents();       
        this.loggedInUser = loggedInUser;
    }
    
    public AdminSMPage(){
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BackBTN = new javax.swing.JButton();
        sessionUser = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ViewSalesItemsBTN = new javax.swing.JButton();
        DailyItemSalesEntryBTN = new javax.swing.JButton();
        SalesReportBTN = new javax.swing.JButton();
        ViewPOBTN = new javax.swing.JButton();
        editDailyItems = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Sales Manager Main");

        BackBTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BackBTN.setText("Back");
        BackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBTNActionPerformed(evt);
            }
        });

        sessionUser.setBackground(new java.awt.Color(204, 255, 204));
        sessionUser.setForeground(new java.awt.Color(204, 255, 204));
        sessionUser.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(sessionUser, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(BackBTN)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sessionUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BackBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        ViewSalesItemsBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ViewSalesItemsBTN.setText("View Sales Items & Create Requisition");
        ViewSalesItemsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSalesItemsBTNActionPerformed(evt);
            }
        });

        DailyItemSalesEntryBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DailyItemSalesEntryBTN.setText("Daily Item-wise Sales Entry");
        DailyItemSalesEntryBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DailyItemSalesEntryBTNActionPerformed(evt);
            }
        });

        SalesReportBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SalesReportBTN.setText("Sales Report");
        SalesReportBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesReportBTNActionPerformed(evt);
            }
        });

        ViewPOBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ViewPOBTN.setText("View Purchaser Orders");

        editDailyItems.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editDailyItems.setText("Delete Daily Sales Entry");
        editDailyItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDailyItemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DailyItemSalesEntryBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SalesReportBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editDailyItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ViewPOBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(ViewSalesItemsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(ViewSalesItemsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DailyItemSalesEntryBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editDailyItems, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalesReportBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewPOBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 870, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
       AdminMainPage AMP = new AdminMainPage(loggedInUser);
       AMP.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_BackBTNActionPerformed

    private void ViewSalesItemsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewSalesItemsBTNActionPerformed
        InventoryController inventoryController = new InventoryController();
        AdminViewItemCreateReq_SM VSIT = new AdminViewItemCreateReq_SM(loggedInUser,inventoryController);
        VSIT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ViewSalesItemsBTNActionPerformed

    private void DailyItemSalesEntryBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DailyItemSalesEntryBTNActionPerformed
        InventoryController inventoryController = new InventoryController();
        AdminDailyItemEntryPage_SM DIE = new AdminDailyItemEntryPage_SM(loggedInUser,inventoryController);
        DIE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DailyItemSalesEntryBTNActionPerformed

    private void SalesReportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesReportBTNActionPerformed
        AdminSalesReportPage SR = new AdminSalesReportPage(loggedInUser);
        SR.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SalesReportBTNActionPerformed

    private void editDailyItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDailyItemsActionPerformed
        AdminViewDeleteSalesEntry EDSE = new AdminViewDeleteSalesEntry(loggedInUser);
        EDSE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editDailyItemsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminSMPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminSMPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminSMPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminSMPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminSMPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JButton DailyItemSalesEntryBTN;
    private javax.swing.JButton SalesReportBTN;
    private javax.swing.JButton ViewPOBTN;
    private javax.swing.JButton ViewSalesItemsBTN;
    private javax.swing.JButton editDailyItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField sessionUser;
    // End of variables declaration//GEN-END:variables
}
