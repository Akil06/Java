/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabRole;

import Business.Enterprise.Enterprise;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DNARequest;
import Business.WorkQueue.LabFingerPrintRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aswat
 */
public class ManageDNAJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageDNAJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private LabOrganization labOrganization;
    private Enterprise enterprise;

    ManageDNAJPanel(JPanel userProcessContainer, Enterprise enterprise, LabOrganization labOrganization, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.labOrganization = labOrganization;
        this.enterprise = enterprise;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) DNATable.getModel();
        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equalsIgnoreCase(Organization.Type.Lab.getValue())) {

                for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                    if ((request.getName()).equals(WorkRequest.Type.DNA.getValue())) {

                        Object[] row = new Object[5];
                        row[0] = request;
                        int caseID = ((DNARequest) request).getCaseID();
                        row[1] = caseID;
                        row[2] = request.getSender();
                        row[3] = request.getStatus();
                        row[4] = request.getReceiver();
                        model.addRow(row);
                    }
                }

            }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        DNATable = new javax.swing.JTable();
        assignButton = new javax.swing.JButton();
        processButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        DNATable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Case ID", "Sender", "Status", "Reciever"
            }
        ));
        DNATable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(DNATable);

        assignButton.setText("Assign to me");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        processButton.setText("Process");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        backButton.setText("<<Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Manage DNA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(assignButton)
                        .addGap(224, 224, 224)
                        .addComponent(processButton)))
                .addContainerGap(368, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(199, 199, 199)
                    .addComponent(backButton)
                    .addContainerGap(712, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignButton)
                    .addComponent(processButton))
                .addContainerGap(328, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(472, 472, 472)
                    .addComponent(backButton)
                    .addContainerGap(199, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = DNATable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Select a row", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DNARequest dnaRequest = (DNARequest) DNATable.getValueAt(selectedRow, 0);
        if (dnaRequest.getStatus().equals("Sent")) {
            dnaRequest.setReceiver(account);
            dnaRequest.setStatus("Pending");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Already Assigned", "WARNING", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_assignButtonActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = DNATable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Select a row", "WARNING", JOptionPane.WARNING_MESSAGE);

            return;
        }

        DNARequest dnaRequest = (DNARequest) DNATable.getValueAt(selectedRow, 0);
        if (dnaRequest.getStatus().equals("Pending")) {

            dnaRequest.setStatus("Processing");

            ProcessDNAJPanel processDNAJPanel = new ProcessDNAJPanel(userProcessContainer, dnaRequest);
            userProcessContainer.add("ProcessDNAJPanel", processDNAJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(this, "Completed rows cannot be processed again", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_processButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DNATable;
    private javax.swing.JButton assignButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processButton;
    // End of variables declaration//GEN-END:variables
}
