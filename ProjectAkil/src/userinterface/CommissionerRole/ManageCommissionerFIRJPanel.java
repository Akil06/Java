/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CommissionerRole;

import Business.Enterprise.Enterprise;
import Business.Organization.CommissionerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EnquiryReportRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aswat
 */
public class ManageCommissionerFIRJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageFIRJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private CommissionerOrganization commissionerOrganization;
    private Enterprise enterprise;

    ManageCommissionerFIRJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount userAccount, CommissionerOrganization commissionerOrganization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = userAccount;
        this.commissionerOrganization = commissionerOrganization;
        this.enterprise = enterprise;

        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) firTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : commissionerOrganization.getWorkQueue().getWorkRequestList()) {

            Object[] row = new Object[4];
            row[0] = request;
            String victim = ((EnquiryReportRequest) request).getVictimName();
            row[1] = victim;
            row[2] = request.getSender();
            String result = ((EnquiryReportRequest) request).getResult();

            row[3] = result == null ? "Not Reviewed" : result;

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        processButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        firTable = new javax.swing.JTable();

        processButton.setText("Process");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        backButton.setText("<<BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Manage FIR");

        firTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Enquiry ID", "Victim Name", "Sender", "Status"
            }
        ));
        jScrollPane1.setViewportView(firTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(284, 284, 284)
                                .addComponent(processButton)))))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(processButton))
                .addContainerGap(284, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        // TODO add your handling code here:
        int row = firTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        EnquiryReportRequest enquiryReportRequest = (EnquiryReportRequest) firTable.getValueAt(row, 0);
        
        ViewCommisionerEnquiryJPanel viewCommisionerEnquiryJPanel = new ViewCommisionerEnquiryJPanel(userProcessContainer,enquiryReportRequest);
                    
        userProcessContainer.add("viewCommisionerEnquiryJPanel", viewCommisionerEnquiryJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);


    }//GEN-LAST:event_processButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable firTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processButton;
    // End of variables declaration//GEN-END:variables

    

}