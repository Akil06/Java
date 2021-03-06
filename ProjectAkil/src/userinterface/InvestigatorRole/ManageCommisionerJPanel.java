/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InvestigatorRole;

import Business.Enterprise.Enterprise;
import Business.Organization.InvestigatorOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Aswat
 */
public class ManageCommisionerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCommisionerJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private InvestigatorOrganization investigatorOrganization;
    private Enterprise enterprise;

   public ManageCommisionerJPanel(JPanel userProcessContainer, Enterprise enterprise, InvestigatorOrganization investigatorOrganization, UserAccount account) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   initComponents(); 
   this.enterprise = enterprise;
        this.account = account;
        this.investigatorOrganization = investigatorOrganization;
        this.userProcessContainer = userProcessContainer;
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
        manageFIRButton = new javax.swing.JButton();
        caseStatusButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        jLabel1.setText("Manage Commisioner");

        manageFIRButton.setText("Manage FIR");
        manageFIRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageFIRButtonActionPerformed(evt);
            }
        });

        caseStatusButton.setText("Case Status");
        caseStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseStatusButtonActionPerformed(evt);
            }
        });

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
                        .addGap(377, 377, 377)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(caseStatusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageFIRButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(backButton)))
                .addContainerGap(470, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(94, 94, 94)
                .addComponent(manageFIRButton)
                .addGap(49, 49, 49)
                .addComponent(caseStatusButton)
                .addGap(131, 131, 131)
                .addComponent(backButton)
                .addContainerGap(268, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void caseStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseStatusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caseStatusButtonActionPerformed

    private void manageFIRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageFIRButtonActionPerformed
        // TODO add your handling code here:
        ManageFIRJPanel manageFIRJPanel = new ManageFIRJPanel(userProcessContainer, enterprise ,investigatorOrganization,account);
        userProcessContainer.add("manageFIRJPanel", manageFIRJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageFIRButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton caseStatusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageFIRButton;
    // End of variables declaration//GEN-END:variables
}
