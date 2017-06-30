/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InvestigatorRole;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Location.AddressConverter;
import Business.Organization.InvestigatorOrganization;
import Business.Organization.Organization;
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
 * @author raunak
 */
public class ManagePublicLocationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Ecosystem business;
    private UserAccount userAccount;
    private InvestigatorOrganization investigatorOrganization;

    private static String[] streetArray = {"tremont street"};
    String streetName = streetArray[(int) (Math.random() * streetArray.length)];
    private static String[] cityArray = {"Boston"};
    String cityName = cityArray[(int) (Math.random() * cityArray.length)];
    private static String[] stateArray = {"Mass"};
    String stateName = stateArray[(int) (Math.random() * stateArray.length)];
    private static String[] countryArray = {"USA"};
    String countryName = countryArray[(int) (Math.random() * countryArray.length)];
    private static String[] zipCodeArray = {"02120"};
    String zipCode = zipCodeArray[(int) (Math.random() * zipCodeArray.length)];
    String location="";
    String latLong="";
  
    String locationArray[]=new String[10];
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
  public  ManagePublicLocationJPanel(JPanel userProcessContainer, Enterprise enterprise, InvestigatorOrganization investigatorOrganization, UserAccount account) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    //public ManagePublicLocationJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        //this.business = business;
        this.investigatorOrganization = investigatorOrganization;
        investigatorNameTextField.setText(account.getUsername());
        if (userAccount.getEmployee().getCurrentStreetName() == null) {
            userAccount.getEmployee().setCurrentStreetName(streetName);
            userAccount.getEmployee().setCurrentCity(cityName);
            userAccount.getEmployee().setCurrentState(stateName);
            userAccount.getEmployee().setCurrentCountry(countryName);
            userAccount.getEmployee().setCurrentZipCode(zipCode);
            location = streetName + ',' + cityName + ',' + stateName + ',' + countryName;
            AddressConverter addressConverter = new AddressConverter();
            latLong = addressConverter.getLocation(location);
            locationArray= latLong.split(",");
            latitudeTextField.setText(locationArray[0]);
            longitudeTextField.setText(locationArray[1]);
       
            userAccount.getEmployee().setLatitude(locationArray[0]);
            userAccount.getEmployee().setLongitude(locationArray[1]);
        
        }
        streetNameTextField.setText(userAccount.getEmployee().getCurrentStreetName());
        cityTextField.setText(userAccount.getEmployee().getCurrentCity());
        stateTextField.setText(userAccount.getEmployee().getCurrentState());
        countryTextField.setText(userAccount.getEmployee().getCurrentCountry());
        zipCodeTextField.setText(userAccount.getEmployee().getCurrentZipCode());
           
        latitudeTextField.setText(userAccount.getEmployee().getLatitude());
        longitudeTextField.setText(userAccount.getEmployee().getLongitude());
       
        
        populateTable();
    }

    

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {

            //    for(WorkRequest request : investigatorOrganization.getWorkQueue().getWorkRequestList()){
            if ((request.getName()).equals(WorkRequest.Type.Alarm.getValue())) {
                        AlarmWorkRequest alarmRequest = (AlarmWorkRequest) request;
            Object[] row = new Object[7];
            row[0] = alarmRequest;
            row[1] = alarmRequest.getSender().getEmployee().getName();
            row[2] = alarmRequest.getReceiver() == null ? null : alarmRequest.getReceiver().getEmployee().getName();
            row[3] = alarmRequest.getStreetline1();
            row[4] = alarmRequest.getCity();
            row[5] = alarmRequest.getZipCode();
 
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        cityTextField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        streetNameTextField = new javax.swing.JTextField();
        streetNameLabel = new javax.swing.JLabel();
        zipCodeTextField = new javax.swing.JTextField();
        zipCodeLabel = new javax.swing.JLabel();
        stateTextField = new javax.swing.JTextField();
        stateLabel = new javax.swing.JLabel();
        countryTextField = new javax.swing.JTextField();
        stateLabel1 = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        investigatorNameTextField = new javax.swing.JTextField();
        investigatorNameLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        latitudeTextField = new javax.swing.JTextField();
        latitudeLabel = new javax.swing.JLabel();
        longitudeTextField = new javax.swing.JTextField();
        longitudeLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Street", "City", "Zip Code", "country"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(4).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(5).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(6).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 660, 160));

        processJButton.setText("View Details");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, -1, -1));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));
        add(cityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 140, -1));

        cityLabel.setText("City");
        add(cityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 60, -1));
        add(streetNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 140, -1));

        streetNameLabel.setText("Street Name");
        add(streetNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));
        add(zipCodeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 140, -1));

        zipCodeLabel.setText("Zip Code");
        add(zipCodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 80, -1));
        add(stateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 140, -1));

        stateLabel.setText("State");
        add(stateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 40, -1));
        add(countryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 140, -1));

        stateLabel1.setText("Country");
        add(stateLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 80, -1));

        locationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        locationLabel.setText("Your Current Location:");
        add(locationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 160, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Public Emergengy Request ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 200, 20));
        add(investigatorNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 100, -1));

        investigatorNameLabel.setText("Investigator Name");
        add(investigatorNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 110, -1));
        add(latitudeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 140, -1));

        latitudeLabel.setText("Latitude");
        add(latitudeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 474, 80, 20));
        add(longitudeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 140, -1));

        longitudeLabel.setText("Longitude");
        add(longitudeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 90, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select Atleast one Row to View Details", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        
        AlarmWorkRequest alarmWorkRequest = (AlarmWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);

       // alarmWorkRequest.setStatus("Processing");

        ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, alarmWorkRequest);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JLabel investigatorNameLabel;
    private javax.swing.JTextField investigatorNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel latitudeLabel;
    private javax.swing.JTextField latitudeTextField;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel longitudeLabel;
    private javax.swing.JTextField longitudeTextField;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JLabel stateLabel1;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JLabel streetNameLabel;
    private javax.swing.JTextField streetNameTextField;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JLabel zipCodeLabel;
    private javax.swing.JTextField zipCodeTextField;
    // End of variables declaration//GEN-END:variables
}
