/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Public;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Location.AddressConverter;
import Business.Organization.CommissionerOrganization;
import Business.Organization.InvestigatorOrganization;
import Business.Organization.Organization;
import Business.Organization.PublicOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AlarmWorkRequest;
import Business.WorkQueue.WorkRequest;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class PublicWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PublicLogin
     */
    private double dist;
    private JPanel userProcessContainer;
    private PublicOrganization publicOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private UserAccount currentUserAccount;
    String latLong = "";
    String location = "";
    // private static String[] streetArray = {"100 Institute Rd"};
    private static String[] streetArray = {"Smith street"};
    String streetName = streetArray[(int) (Math.random() * streetArray.length)];
    private static String[] cityArray = {"Worcester"};
    String cityName = cityArray[(int) (Math.random() * cityArray.length)];
    private static String[] stateArray = {"Mass"};
    String stateName = stateArray[(int) (Math.random() * stateArray.length)];
    private static String[] countryArray = {"USA"};
    String countryName = countryArray[(int) (Math.random() * countryArray.length)];
    private static String[] zipCodeArray = {"02120"};
    String zipCode = zipCodeArray[(int) (Math.random() * zipCodeArray.length)];

    int flag = 1;
   String locationArray[]=new String[10];
    public PublicWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PublicOrganization organization, Ecosystem business, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.publicOrganization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        currentUserAccount = account;
        publicNameTextField.setText(userAccount.getUsername());
        if (userAccount.getEmployee().getCurrentStreetName() == null) {
            streetTextField.setText(streetName);
            cityTextField.setText(cityName);
            stateTextField.setText(stateName);
            countryTextField.setText(countryName);
            zipCodeTextField.setText(zipCode);
            userAccount.getEmployee().setCurrentStreetName(streetName);
            userAccount.getEmployee().setCurrentCity(cityName);
            userAccount.getEmployee().setCurrentState(stateName);
            userAccount.getEmployee().setCurrentCountry(countryName);
            userAccount.getEmployee().setCurrentZipCode(zipCode);

            location = streetName + ',' + cityName + ',' + stateName + ',' + countryName;
            AddressConverter addressConverter = new AddressConverter();
            latLong = addressConverter.getLocation(location);
            locationArray = latLong.split(",");
            latitudeTextField.setText(locationArray[0]);
            longitudeTextField.setText(locationArray[1]);
            userAccount.getEmployee().setLatitude(locationArray[0]);
            userAccount.getEmployee().setLongitude(locationArray[1]);

        }
        else if(userAccount.getEmployee().getCurrentStreetName() != null) {

            streetTextField.setText(userAccount.getEmployee().getCurrentStreetName());
            cityTextField.setText(userAccount.getEmployee().getCurrentCity());

            stateTextField.setText(userAccount.getEmployee().getCurrentState());

            countryTextField.setText(userAccount.getEmployee().getCurrentCountry());
            zipCodeTextField.setText(userAccount.getEmployee().getCurrentZipCode());
            // locationTextField.setText(location);

            latitudeTextField.setText(userAccount.getEmployee().getLatitude());
            longitudeTextField.setText(userAccount.getEmployee().getLongitude());
        
        populateTable();
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
        publicTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        zipCodeLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        publicNameLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        streetTextField = new javax.swing.JTextField();
        cityTextField = new javax.swing.JTextField();
        zipCodeTextField = new javax.swing.JTextField();
        countryTextField = new javax.swing.JTextField();
        alarmButton = new javax.swing.JButton();
        stateTextField = new javax.swing.JTextField();
        stateLabel = new javax.swing.JLabel();
        publicNameTextField = new javax.swing.JTextField();
        latitudeTextField = new javax.swing.JTextField();
        latitudeLabel = new javax.swing.JLabel();
        longitudeLabel = new javax.swing.JLabel();
        longitudeTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        locationDirectedTextArea = new javax.swing.JTextArea();
        investigatorLocationCheck = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Public Emergengy Request ");

        publicTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Request ID", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(publicTable);
        if (publicTable.getColumnModel().getColumnCount() > 0) {
            publicTable.getColumnModel().getColumn(0).setResizable(false);
            publicTable.getColumnModel().getColumn(1).setResizable(false);
            publicTable.getColumnModel().getColumn(2).setResizable(false);
            publicTable.getColumnModel().getColumn(3).setResizable(false);
            publicTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Current Location :");

        streetLabel.setText("Street");

        zipCodeLabel.setText("Zip Code");

        cityLabel.setText("City");

        publicNameLabel.setText("Name");

        countryLabel.setText("Country");

        streetTextField.setEnabled(false);
        streetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetTextFieldActionPerformed(evt);
            }
        });

        cityTextField.setEnabled(false);

        zipCodeTextField.setEnabled(false);

        countryTextField.setEnabled(false);

        alarmButton.setText("Request Alarm");
        alarmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alarmButtonActionPerformed(evt);
            }
        });

        stateTextField.setEnabled(false);

        stateLabel.setText("State");

        publicNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicNameTextFieldActionPerformed(evt);
            }
        });

        latitudeTextField.setEnabled(false);

        latitudeLabel.setText("Latitude");

        longitudeLabel.setText("Longitude");

        longitudeTextField.setEnabled(false);

        locationDirectedTextArea.setColumns(20);
        locationDirectedTextArea.setRows(5);
        jScrollPane2.setViewportView(locationDirectedTextArea);

        investigatorLocationCheck.setText("Investigator Location Check");
        investigatorLocationCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                investigatorLocationCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(longitudeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(longitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(latitudeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(latitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(zipCodeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(cityLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(streetLabel)
                                        .addGap(54, 54, 54)
                                        .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(stateLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(countryLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(alarmButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(publicNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(publicNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(investigatorLocationCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publicNameLabel)
                    .addComponent(publicNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(investigatorLocationCheck))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(streetLabel)
                    .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateLabel)
                    .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipCodeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countryLabel))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(latitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(latitudeLabel))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(longitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(longitudeLabel)
                    .addComponent(alarmButton))
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void alarmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alarmButtonActionPerformed
        // TODO add your handling code here:

        String message = "Emergency";

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

            for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                if (organization instanceof InvestigatorOrganization) {

                    for (WorkRequest requestCheck : userAccount.getWorkQueue().getWorkRequestList()) {

                        if (requestCheck.getSender().equals(currentUserAccount)) {

                            JOptionPane.showMessageDialog(null, "Request Sent already");
                            flag = 0;

                        }
                    }

                }
            }
        }

        /* else{

        JOptionPane.showMessageDialog(null, "Alarm Request Already Sent");

       }
         */
        Organization org = null;
        UserAccount checkUserAcc = null;

        /*    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

            if (organization instanceof InvestigatorOrganization) {
                org = organization;
                for (UserAccount userAccountReceiver : organization.getUserAccountDirectory().getUserAccountList()) {
                    if (null != userAccountReceiver.getEmployee().getCurrentStreetName()) {
                        if (userAccountReceiver.getEmployee().getCurrentStreetName().equalsIgnoreCase(userAccount.getEmployee().getCurrentStreetName()) && userAccountReceiver.getEmployee().getCurrentZipCode().equalsIgnoreCase(userAccount.getEmployee().getCurrentZipCode()) && flag == 1) {

                            checkUserAcc = userAccountReceiver;

                            AlarmWorkRequest request = new AlarmWorkRequest();

                            request.setMessage(message);
                            request.setSender(userAccount);
                            request.setStatus("Sent");
                            request.setStreet(userAccount.getEmployee().getCurrentStreetName());
                            request.setCity(cityName);
                            request.setState(message);
                            request.setCountry(countryName);
                            request.setZipCode(userAccount.getEmployee().getCurrentZipCode());
                            request.setReceiver(userAccountReceiver);
                            userAccountReceiver.getWorkQueue().getWorkRequestList().add(request);
                            userAccount.getWorkQueue().getWorkRequestList().add(request);
                            populateTable();

                            break;

                        }
                        
         */
        double[] distanceArray = new double[100];
        int i = 0;
        int count = 0;

        if (flag == 1) {
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

                if (organization instanceof InvestigatorOrganization) {
                    org = organization;
                    for (UserAccount userAccountReceiver : organization.getUserAccountDirectory().getUserAccountList()) {

                        //dist=   distance(Double.parseDouble(userAccountReceiver.getEmployee().getLatitude()),Double.parseDouble(userAccount.getEmployee().getLatitude()),Double.parseDouble(userAccountReceiver.getEmployee().getLongitude()),Double.parseDouble(userAccount.getEmployee().getLongitude()),0,0);
                        if ((null != userAccountReceiver.getEmployee().getCurrentStreetName() && (null !=userAccountReceiver.getEmployee().getLatitude()))) {
                            dist = distanceGet(Double.parseDouble(userAccountReceiver.getEmployee().getLatitude()), Double.parseDouble(userAccountReceiver.getEmployee().getLongitude()), Double.parseDouble(userAccount.getEmployee().getLatitude()), Double.parseDouble(userAccount.getEmployee().getLongitude()), 'K');

                            userAccountReceiver.getEmployee().setTempDistance(dist);
                            distanceArray[i] = dist;
                            i++;
                            checkUserAcc = userAccountReceiver;

                            count++;

                            /* AlarmWorkRequest request = new AlarmWorkRequest();

                            request.setMessage(message);
                            request.setSender(userAccount);
                            request.setStatus("Sent");
                            request.setStreet(userAccount.getEmployee().getCurrentStreetName());
                            request.setCity(cityName);
                            request.setState(message);
                            request.setCountry(countryName);
                            request.setZipCode(userAccount.getEmployee().getCurrentZipCode());
                            request.setReceiver(userAccountReceiver);
                            userAccountReceiver.getWorkQueue().getWorkRequestList().add(request);
                            userAccount.getWorkQueue().getWorkRequestList().add(request);
                             */
                            populateTable();

                        }
                    }
                }
            }
        }

        double minimum = distanceArray[0];

        for (int k = 1; k < count; k++) {
            if (distanceArray[k] < minimum) {
                minimum = distanceArray[k];

            }
        }

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

            if (organization instanceof InvestigatorOrganization) {
                org = organization;
                for (UserAccount userAccountReceiver : organization.getUserAccountDirectory().getUserAccountList()) {
                    // if (0 != userAccountReceiver.getEmployee().getTempDistance()) {
                    if ((userAccountReceiver.getEmployee().getTempDistance() == minimum) && (flag == 1)) {

                        checkUserAcc = userAccountReceiver;

                        AlarmWorkRequest alarmWorkRequest = new AlarmWorkRequest();

                        alarmWorkRequest.setMessage(message);
                        alarmWorkRequest.setSender(userAccount);
                        alarmWorkRequest.setStatus("Sent");
                        alarmWorkRequest.setStreetline1(userAccount.getEmployee().getCurrentStreetName());
                        alarmWorkRequest.setCity(cityName);
                        alarmWorkRequest.setState(stateName);
                        alarmWorkRequest.setCountry(countryName);
                        alarmWorkRequest.setZipCode(userAccount.getEmployee().getCurrentZipCode());
                        alarmWorkRequest.setReceiver(userAccountReceiver);
                        userAccountReceiver.getWorkQueue().getWorkRequestList().add(alarmWorkRequest);
                        userAccount.getWorkQueue().getWorkRequestList().add(alarmWorkRequest);
                        organization.getWorkQueue().getWorkRequestList().add(alarmWorkRequest);
                        Organization orgCommissoner = null;
                        for (Organization commissionerOrganization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            if (commissionerOrganization instanceof CommissionerOrganization) {
                                orgCommissoner = commissionerOrganization;
                                break;
                            }
                        }
                        if (orgCommissoner != null) {
                            orgCommissoner.getWorkQueue().getWorkRequestList().add(alarmWorkRequest);
                        }
                        populateTable();
                        JOptionPane.showMessageDialog(null, "Request Sent Successfully,Investigator will reach your location shortly");
                        break;

                    }
                }
            }
        }

        if (checkUserAcc != null && flag == 1) {

            for (int j = 0; j < count; j++) {
                // System.out.println("Distance " + distanceArray[j] + '\n');
            }
            // System.out.println("Minimum Distance " + minimum + '\n');

            // JOptionPane.showMessageDialog(null, "Request message sent");
        } else if (checkUserAcc == null && flag == 1) {

            JOptionPane.showMessageDialog(null, "No Police In Paticular Location");

        }

    }//GEN-LAST:event_alarmButtonActionPerformed

    private void streetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetTextFieldActionPerformed


    }//GEN-LAST:event_streetTextFieldActionPerformed

    private void publicNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publicNameTextFieldActionPerformed

    private void investigatorLocationCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_investigatorLocationCheckActionPerformed
        // TODO add your handling code here:
        String investigatorsLocation = "";
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

            if (organization instanceof InvestigatorOrganization) {

                for (UserAccount userAccountReceiver : organization.getUserAccountDirectory().getUserAccountList()) {

                    //dist=   distance(Double.parseDouble(userAccountReceiver.getEmployee().getLatitude()),Double.parseDouble(userAccount.getEmployee().getLatitude()),Double.parseDouble(userAccountReceiver.getEmployee().getLongitude()),Double.parseDouble(userAccount.getEmployee().getLongitude()),0,0);
                    if (null != userAccountReceiver.getEmployee().getCurrentStreetName()) {
                        dist = distanceGet(Double.parseDouble(userAccountReceiver.getEmployee().getLatitude()), Double.parseDouble(userAccountReceiver.getEmployee().getLongitude()), Double.parseDouble(userAccount.getEmployee().getLatitude()), Double.parseDouble(userAccount.getEmployee().getLongitude()), 'K');

                        userAccountReceiver.getEmployee().setTempDistance(dist);
                        investigatorsLocation += '\n' + "Investigator Name = " + userAccountReceiver.getUsername() + '\n' + "Investigator Location = " + userAccountReceiver.getEmployee().getCurrentStreetName() + "," + userAccountReceiver.getEmployee().getCurrentCity() + ',' + userAccountReceiver.getEmployee().getCurrentState() + ',' + userAccountReceiver.getEmployee().getCurrentZipCode() + ',' + userAccountReceiver.getEmployee().getCurrentCountry() + '\n' + "Investigator Latitude = " + userAccountReceiver.getEmployee().getLatitude() + '\n' + "Investigator Longitude = " + userAccountReceiver.getEmployee().getLongitude() + '\n' + "Proximity Distance from User = " + userAccountReceiver.getEmployee().getTempDistance() + '\n';

                    }
                }
            }
        }

        locationDirectedTextArea.setText(investigatorsLocation);

        /*     String investigatorsLocation="";
   for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

            if (organization instanceof InvestigatorOrganization) {
              
                for (UserAccount userAccountReceiver : organization.getUserAccountDirectory().getUserAccountList()) {
                        
                  if(userAccountReceiver.getEmployee().getLatitude()!=null){
                 investigatorsLocation+='\n'+"Investigator Name = "+userAccountReceiver.getUsername()+'\n'+"Investigator Location = "+userAccountReceiver.getEmployee().getCurrentStreetName()+","+userAccountReceiver.getEmployee().getCurrentCity()+','+userAccountReceiver.getEmployee().getCurrentState()+','+userAccountReceiver.getEmployee().getCurrentZipCode()+','+userAccountReceiver.getEmployee().getCurrentCountry()+'\n'+"Investigator Latitude = "+userAccountReceiver.getEmployee().getLatitude()+'\n'+"Investigator Longitude = "+userAccountReceiver.getEmployee().getLongitude()+'\n'+"Proximity Distance from User = "+userAccountReceiver.getEmployee().getTempDistance()+'\n';
                }
                }
            }
    }
   locationDirectedTextArea.setText(investigatorsLocation);
         */

    }//GEN-LAST:event_investigatorLocationCheckActionPerformed

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) publicTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {

            Object[] row = new Object[6];
            row[0] = request;

            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver().getEmployee().getName();
            row[3] = ((AlarmWorkRequest) request).getRequestId();
            String result = ((AlarmWorkRequest) request).getStatus();
            row[4] = result == null ? "Waiting" : result;

            model.addRow(row);
        }

    }

    public double distance(double lat1, double lat2, double lon1,
            double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    private double distanceGet(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
 /*::  This function converts decimal degrees to radians             :*/
 /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
 /*::  This function converts radians to decimal degrees             :*/
 /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alarmButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JButton investigatorLocationCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel latitudeLabel;
    private javax.swing.JTextField latitudeTextField;
    private javax.swing.JTextArea locationDirectedTextArea;
    private javax.swing.JLabel longitudeLabel;
    private javax.swing.JTextField longitudeTextField;
    private javax.swing.JLabel publicNameLabel;
    private javax.swing.JTextField publicNameTextField;
    private javax.swing.JTable publicTable;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel zipCodeLabel;
    private javax.swing.JTextField zipCodeTextField;
    // End of variables declaration//GEN-END:variables
}
