/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Chart;

import Business.Enterprise.Enterprise;
import Business.Organization.CommissionerOrganization;
import Business.Organization.Organization;
import Business.WorkQueue.AlarmWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author PeaceFull
 */
public class Pie_Chart extends JPanel {

   // private static final long serialVersionUID = 4400735172378226919L;
private Enterprise enterprise;

 private CommissionerOrganization commissionerOrganization;
String city="";
int count=0;
      List<String> list = new ArrayList<String>();
     
          
 String  cityArray[]=new String[10];

 int countArray[]=new int[10];

   public Pie_Chart( String title,Enterprise enterprise,CommissionerOrganization organization) 
   {
       this.enterprise=enterprise;
      this.commissionerOrganization=organization;
         createDemoPanel();
         DefaultPieDataset dataset = new DefaultPieDataset();
          for(int index=0;index<count;index++){
           dataset.setValue( cityArray[index] , (countArray[index]));  
     
      }
      
      /*  dataset.setValue("California", new Double(10.0));
        dataset.setValue("Arizona", new Double(8.0));
        dataset.setValue("New Mexico", new Double(8.0));
        dataset.setValue("Texas", new Double(40.0));
        dataset.setValue("Louisiana", new Double(8.0));
        dataset.setValue("Mississippi", new Double(4.0));
        dataset.setValue("Alabama", new Double(2.0));
        dataset.setValue("Florida", new Double(20.0));
*/
        // Create the custom label generator
         PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {2}");

        // Create the charts
         JFreeChart chart1 = ChartFactory.createPieChart("Number of Crime in Massachusetts (Flat Pie Chart)", dataset, true, true, false);
         PiePlot plot1 = (PiePlot) chart1.getPlot();
        plot1.setLabelGenerator(labelGenerator);

        JFreeChart chart2 = ChartFactory.createPieChart("Number of Crime in Massachusetts(Exploded Pie Chart)", dataset, true, true, false);
         PiePlot plot2 = (PiePlot) chart2.getPlot();
        plot2.setExplodePercent("3", 0.25);
        plot2.setLabelGenerator(labelGenerator);

         JFreeChart chart3 = ChartFactory.createPieChart3D("Number of Crime in Massachusetts (3D Pie Chart)", dataset, true, true, false);
         PiePlot3D plot3 = (PiePlot3D) chart3.getPlot();
        plot3.setLabelGenerator(labelGenerator);

         JFreeChart chart4 = ChartFactory.createPieChart3D("Number of Crime in Massachusetts (3D with Transparency)", dataset, true, true, false);
         PiePlot3D plot4 = (PiePlot3D) chart4.getPlot();
        plot4.setForegroundAlpha(0.6f);
        plot4.setLabelGenerator(labelGenerator);

         // Create this panel
        this.setLayout(new GridLayout(2, 2));
       ChartPanel panel1 = new ChartPanel(chart1);
      ChartPanel panel2 = new ChartPanel(chart2);
       ChartPanel panel3 = new ChartPanel(chart3);
    ChartPanel panel4 = new ChartPanel(chart4);
        this.add(panel1);
    this.add(panel2);
    this.add(panel3);
       this.add(panel4);
    }

    public void main() {
         JFrame frame = new JFrame("Number of Crime in Massachusetts");
       
         Pie_Chart chart = new Pie_Chart("",enterprise,commissionerOrganization);
        frame.getContentPane().add(chart, BorderLayout.CENTER);
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    
    public  void createDemoPanel( )
   {
       for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

            if (organization instanceof CommissionerOrganization) {
             for (WorkRequest request : commissionerOrganization.getWorkQueue().getWorkRequestList()) {
                 
                 list.add(((AlarmWorkRequest) request).getCity());
    
            }
             
int index=0;

Set<String> unique = new HashSet<String>(list);
for (String city : unique) {
    System.out.println(city + ": " + Collections.frequency(list, city));
    cityArray[index]=city;
    countArray[index]=Collections.frequency(list, city);
    index++;
    count++;
}
    
       }
       }
    }
}