/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CommissionerRole;

import Business.Chart.BarChartDemo;
import Business.Enterprise.Enterprise;
import Business.Organization.CommissionerOrganization;
import Business.UserAccount.UserAccount;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author PeaceFull
 */


public class ManageReport {
     private BarChartDemo demo;

   public ManageReport (BarChartDemo demo){
        this.demo=demo;
        
        JPanel jPanel1 = new JPanel();
jPanel1.setLayout(new java.awt.BorderLayout());

jPanel1.add(demo,BorderLayout.CENTER);
jPanel1.validate();
   }
    
}


