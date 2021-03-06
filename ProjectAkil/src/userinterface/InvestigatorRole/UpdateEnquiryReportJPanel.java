/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InvestigatorRole;

import Business.WorkQueue.EnquiryReportRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Aswat
 */
public class UpdateEnquiryReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateEnquiryReportJPanel
     */
    private JPanel userProcessContainer;
    private EnquiryReportRequest enquiryReportRequest;

   public UpdateEnquiryReportJPanel(JPanel userProcessContainer, EnquiryReportRequest enquiryReportRequest) {
            initComponents();
            this.userProcessContainer=userProcessContainer;
            this.enquiryReportRequest=this.enquiryReportRequest;
            enquiryIDTextField.setText(String.valueOf(enquiryReportRequest.getEnquiryID()));
            enquiryDescriptionTextField.setText(enquiryReportRequest.getEnquiryDescription());
            victimIDTextField.setText(String.valueOf(enquiryReportRequest.getVictimID()));
            victimNameTextField.setText(enquiryReportRequest.getVictimName());
            suspectPersonIDTextField.setText(String.valueOf(enquiryReportRequest.getSuspectPersonID()));
            suspectPersonNameTextField.setText(enquiryReportRequest.getSuspectName());
            motiveTextArea.setText(enquiryReportRequest.getMotive());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        suspectPersonIDTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        victimIDTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        victimNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        motiveTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        enquiryIDTextField = new javax.swing.JTextField();
        enquiryDescriptionTextField = new javax.swing.JTextField();
        suspectPersonNameTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        suspectPersonIDTextField.setEnabled(false);

        jLabel1.setText("Enquiry ID");

        victimIDTextField.setEnabled(false);

        jLabel2.setText("Enquiry Description");

        victimNameTextField.setEnabled(false);

        jLabel3.setText("Suspect Person ID");

        jScrollPane1.setEnabled(false);

        motiveTextArea.setColumns(20);
        motiveTextArea.setRows(5);
        jScrollPane1.setViewportView(motiveTextArea);

        jLabel4.setText("Suspect Person Name");

        jLabel5.setText("Victim Person ID");

        jLabel8.setText("Enquiry Report");

        jLabel6.setText("Victim Person Name");

        jLabel7.setText("Motive");

        enquiryIDTextField.setEnabled(false);

        enquiryDescriptionTextField.setEnabled(false);

        suspectPersonNameTextField.setEnabled(false);

        backButton.setText("<<BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(backButton))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addGap(60, 60, 60)
                                .addComponent(updateButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(victimNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(victimIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(suspectPersonNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(enquiryDescriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(enquiryIDTextField)
                                .addComponent(suspectPersonIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)))))
                .addContainerGap(458, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(enquiryIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(enquiryDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(suspectPersonIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(suspectPersonNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(victimIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(victimNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(updateButton)
                    .addComponent(saveButton))
                .addContainerGap(126, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        enquiryDescriptionTextField.setEnabled(true);
        suspectPersonNameTextField.setEnabled(true);
        victimNameTextField.setEnabled(true);
        motiveTextArea.setEnabled(true);
        updateButton.setEnabled(false);
        saveButton.setEnabled(true);
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        enquiryReportRequest.setEnquiryDescription(enquiryDescriptionTextField.getText());
        enquiryReportRequest.setVictimName(victimNameTextField.getText());
        enquiryReportRequest.setMotive(motiveTextArea.getText());
        enquiryReportRequest.setSuspectName(suspectPersonNameTextField.getText());
        
        enquiryDescriptionTextField.setEnabled(false);
        suspectPersonNameTextField.setEnabled(false);
        victimNameTextField.setEnabled(false);
        motiveTextArea.setEnabled(false);
        updateButton.setEnabled(true);
        saveButton.setEnabled(false);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField enquiryDescriptionTextField;
    private javax.swing.JTextField enquiryIDTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea motiveTextArea;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField suspectPersonIDTextField;
    private javax.swing.JTextField suspectPersonNameTextField;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField victimIDTextField;
    private javax.swing.JTextField victimNameTextField;
    // End of variables declaration//GEN-END:variables
}
