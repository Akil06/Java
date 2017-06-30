/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InvestigatorRole;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.AnalystOrganization;
import Business.Organization.InvestigatorOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AlarmWorkRequest;
import Business.WorkQueue.DispatchArrivalWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aswat
 */
public class ManageAnalystJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageAnalystJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private InvestigatorOrganization investigatorOrganization;
    private Enterprise enterprise;

    public ManageAnalystJPanel(JPanel userProcessContainer, Enterprise enterprise, InvestigatorOrganization investigatorOrganization, UserAccount account) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        initComponents();
        this.enterprise = enterprise;
        this.account = account;
        this.investigatorOrganization = investigatorOrganization;
        this.userProcessContainer = userProcessContainer;
        populateTable();
        dispathRequestPopulateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) analystTable.getModel();

        model.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equalsIgnoreCase(Organization.Type.Analyst.getValue())) {
                for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                    Object[] row = new Object[4];
                    row[0] = userAccount;

                    row[1] = userAccount.getEmployee().getName();
                    row[2] = userAccount.getEmployee().getId();
                    model.addRow(row);
                }
            }
        }
    }

    public void dispathRequestPopulateTable() {
        DefaultTableModel model = (DefaultTableModel) statusTable.getModel();
        model.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equalsIgnoreCase(Organization.Type.Analyst.getValue())) {
                for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                    if ((request.getName()).equals(WorkRequest.Type.Dispatch.getValue())) {
                        DispatchArrivalWorkRequest dispatch = (DispatchArrivalWorkRequest) request;
                        Object[] row = new Object[6];
                        //row[0] = dispatch;
                        row[0] = dispatch.getMessage();
                        row[1] = dispatch.getSender();
                        row[2] = dispatch.getReceiver();
                        row[3] = dispatch.getStatus();
                        row[4] = dispatch.getStreetline1() + "," + dispatch.getCity() + "," + dispatch.getZipCode() + "," + dispatch.getZipCode();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        analystTable = new javax.swing.JTable();
        requestButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        statusTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Analyst Request");

        analystTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "AnalystName", "Analyst ID"
            }
        ));
        jScrollPane1.setViewportView(analystTable);

        requestButton.setText("Send Request");
        requestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestButtonActionPerformed(evt);
            }
        });

        statusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Location"
            }
        ));
        statusTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(statusTable);

        backButton.setText("<<BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(requestButton)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(requestButton)
                .addGap(76, 76, 76)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = analystTable.getSelectedRow();

        if (selectedRow >= 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to select the Analyst", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                UserAccount userAccount = (UserAccount) analystTable.getValueAt(selectedRow, 0);

                for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                    if (request.getName().equals(WorkRequest.Type.Alarm.getValue())) {
                        AlarmWorkRequest Aw = (AlarmWorkRequest) request;
                        DispatchArrivalWorkRequest daWorkRequest = new DispatchArrivalWorkRequest();
                        daWorkRequest.setMessage("Arrive at the Location");
                        daWorkRequest.setSender(account);
                        // daWorkRequest.setReceiver(userAccount);
                        daWorkRequest.setStreetline1(Aw.getStreetline1());
                        daWorkRequest.setCity(Aw.getCity());
                        daWorkRequest.setState(Aw.getState());
                        daWorkRequest.setCountry(Aw.getCountry());
                        daWorkRequest.setZipCode(Aw.getZipCode());

                        Organization org = null;
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof AnalystOrganization) {
                                org = organization;
                                break;
                            }
                        }
                        if (org != null) {
                            org.getWorkQueue().getWorkRequestList().add(daWorkRequest);
                            userAccount.getWorkQueue().getWorkRequestList().add(daWorkRequest);
                            populateTable();
                            dispathRequestPopulateTable();
                            JOptionPane.showMessageDialog(null, "Request Sent Succesfully to Analyst Team");
                            break;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Valid Analyst", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_requestButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable analystTable;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton requestButton;
    private javax.swing.JTable statusTable;
    // End of variables declaration//GEN-END:variables
}