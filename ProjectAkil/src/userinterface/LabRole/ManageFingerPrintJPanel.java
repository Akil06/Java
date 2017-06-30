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
import Business.WorkQueue.LabFingerPrintRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aswat
 */
public class ManageFingerPrintJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageFingerPrintJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private LabOrganization labOrganization;
        private Enterprise enterprise;

    ManageFingerPrintJPanel(JPanel userProcessContainer, Enterprise enterprise, LabOrganization labOrganization, UserAccount account) {
            initComponents();
            this.userProcessContainer= userProcessContainer;
            this.account=account;
            this.labOrganization=labOrganization;
            this.enterprise=enterprise;
            populateTable();
                 
}
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) fingerTable.getModel();
        model.setRowCount(0);
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equalsIgnoreCase(Organization.Type.Lab.getValue())) {

                for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                    if ((request.getName()).equals(WorkRequest.Type.FingerPrint.getValue())) {

                        Object[] row = new Object[5];
                        row[0] = request;
                        int caseID = ((LabFingerPrintRequest) request).getCaseID();
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
        fingerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        processButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        assignButton = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();
        displayButton = new javax.swing.JButton();
        asTextField = new javax.swing.JTextField();

        fingerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        fingerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(fingerTable);

        jLabel1.setText("Manage Finger Print ");

        processButton.setText("Process");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        backButton.setText("<<Back");

        assignButton.setText("Assign to me");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        imgLabel.setText("jLabel2");

        displayButton.setText("Display");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(121, 121, 121)
                                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(asTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(assignButton)
                                .addGap(117, 117, 117)
                                .addComponent(displayButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(processButton)
                                .addGap(23, 23, 23)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processButton)
                    .addComponent(assignButton)
                    .addComponent(displayButton))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(asTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        // TODO add your handling code here:
         int selectedRow = fingerTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this,"Select a row","WARNING",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        LabFingerPrintRequest labFingerPrintRequest = (LabFingerPrintRequest) fingerTable.getValueAt(selectedRow, 0);
        labFingerPrintRequest.setReceiver(account);
        labFingerPrintRequest.setStatus("Pending");
        populateTable();
    }//GEN-LAST:event_assignButtonActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        // TODO add your handling code here:
         int selectedRow = fingerTable.getSelectedRow();
        
        if (selectedRow < 0){
                        JOptionPane.showMessageDialog(this,"Select a row","WARNING",JOptionPane.WARNING_MESSAGE);

            return;
        }
        
        LabFingerPrintRequest labFingerPrintRequest = (LabFingerPrintRequest)fingerTable.getValueAt(selectedRow, 0);
     
        labFingerPrintRequest.setStatus("Processing");
        
        
        ProcessFingerPrintJPanel processFingerPrintJPanel = new ProcessFingerPrintJPanel(userProcessContainer,labFingerPrintRequest );
        userProcessContainer.add("ProcessFingerPrintJPanel", processFingerPrintJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_processButtonActionPerformed

    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = fingerTable.getSelectedRow();
        
        if (selectedRow < 0){
                        JOptionPane.showMessageDialog(this,"Select a row","WARNING",JOptionPane.WARNING_MESSAGE);

            return;
        }
        
        LabFingerPrintRequest labFingerPrintRequest = (LabFingerPrintRequest)fingerTable.getValueAt(selectedRow, 0);
        imgLabel.setIcon(labFingerPrintRequest.getImage());
        asTextField.setText(String.valueOf(labFingerPrintRequest.getCaseID()));
    }//GEN-LAST:event_displayButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asTextField;
    private javax.swing.JButton assignButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton displayButton;
    private javax.swing.JTable fingerTable;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processButton;
    // End of variables declaration//GEN-END:variables
}