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
public class ManageCriminalInvestigationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCriminalInvestigation
     */
    // public ManageCriminalInvestigationJPanel() {
    private JPanel userProcessContainer;
    private UserAccount account;
    private InvestigatorOrganization investigatorOrganization;
    private Enterprise enterprise;

    public ManageCriminalInvestigationJPanel(JPanel userProcessContainer, Enterprise enterprise, InvestigatorOrganization investigatorOrganization, UserAccount account) {
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
        enquiryReportButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        jLabel1.setText("Manage Criminal Invetigation");

        enquiryReportButton.setText("Enquiry Report");
        enquiryReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enquiryReportButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Smart Search");

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
                        .addGap(353, 353, 353)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(enquiryReportButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(backButton)))
                .addContainerGap(440, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(86, 86, 86)
                .addComponent(enquiryReportButton)
                .addGap(67, 67, 67)
                .addComponent(jButton2)
                .addGap(136, 136, 136)
                .addComponent(backButton)
                .addContainerGap(276, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enquiryReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enquiryReportButtonActionPerformed
        // TODO add your handling code here:
        EnquiryReportJPanel enquiryReportJPanel = new EnquiryReportJPanel(userProcessContainer, enterprise,investigatorOrganization,account);
        userProcessContainer.add("enquiryReportJPanel", enquiryReportJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_enquiryReportButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton enquiryReportButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
