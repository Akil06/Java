
package Business.Chart;

import Business.Enterprise.Enterprise;
import Business.Organization.CommissionerOrganization;
import Business.Organization.Organization;
import Business.WorkQueue.AlarmWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a bar chart.
 *
 */
public class BarChartDemo extends ApplicationFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    
    
private Enterprise enterprise;

 private CommissionerOrganization commissionerOrganization;
 
    int countCity=0;
    int countState=0;
    int countCityNY=0;
    int countStateNY=0;
      List<String> listCity = new ArrayList<String>();
      List<String> listState = new ArrayList<String>();
       List<String> listCityNY = new ArrayList<String>();
      List<String> listStateNY = new ArrayList<String>();
     
          
 String  cityArray[]=new String[10];

 int countCityArray[]=new int[10];  
          
 String  stateArray[]=new String[10];

 int countStateArray[]=new int[10];  
 
 
 String  cityArrayNY[]=new String[10];

 int countCityArrayNY[]=new int[10];  
          
 String  stateArrayNY[]=new String[10];

 int countStateArrayNY[]=new int[10];  
    public BarChartDemo(final String title,Enterprise enterprise,CommissionerOrganization organization) {

        super(title);
    this.enterprise=enterprise;
      this.commissionerOrganization=organization;
       createDemoPanel( );
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);

    }
    
    
    public  void createDemoPanel( )
   {
       
       for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

            if (organization instanceof CommissionerOrganization) {
             for (WorkRequest request : commissionerOrganization.getWorkQueue().getWorkRequestList()) {
                 if(((AlarmWorkRequest) request).getState().equals("Mass")){
                 listState.add(((AlarmWorkRequest) request).getState());
                 listCity.add(((AlarmWorkRequest) request).getCity());
                 }
                 else if(((AlarmWorkRequest) request).getState().equals("NY")){
                  listStateNY.add(((AlarmWorkRequest) request).getState());
                 listCityNY.add(((AlarmWorkRequest) request).getCity());
                  
                 }
    
            }
             
int index=0;

Set<String> uniqueCity = new HashSet<String>(listCity);
for (String city : uniqueCity) {
    //System.out.println(city + ": " + Collections.frequency(listCity, city));
    cityArray[index]=city;
    countCityArray[index]=Collections.frequency(listCity, city);
    index++;
    countCity++;
}
int index1=0;
Set<String> uniqueState = new HashSet<String>(listState);
for (String city : uniqueState) {
    //System.out.println(city + ": " + Collections.frequency(listState, city));
    stateArray[index1]=city;
    countStateArray[index1]=Collections.frequency(listState, city);
    index1++;
    countState++;
}



int index2=0;

Set<String> uniqueCityNY = new HashSet<String>(listCityNY);
for (String city : uniqueCityNY) {
    //System.out.println(city + ": " + Collections.frequency(listCity, city));
    cityArrayNY[index]=city;
    countCityArrayNY[index]=Collections.frequency(listCityNY, city);
    index2++;
    countCityNY++;
}
int index3=0;

Set<String> uniqueStateNY = new HashSet<String>(listStateNY);
for (String city : uniqueStateNY) {
    //System.out.println(city + ": " + Collections.frequency(listState, city));
    stateArrayNY[index1]=city;
    countStateArrayNY[index1]=Collections.frequency(listStateNY, city);
    index3++;
    countStateNY++;
}




            }
       }
   }
   

    /**
     * Returns a sample dataset.
     * 
     * @return The dataset.
     */
    private CategoryDataset createDataset() {
       
        // row keys...
      /*  final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";

        // column keys...
        final String category1 = "Category 1";
        final String category2 = "Category 2";
        final String category3 = "Category 3";
        final String category4 = "Category 4";
        final String category5 = "Category 5";
        // create the dataset...
        */DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        
        
        
      for(int index=0;index<countState;index++){
          
          for(int index1=0;index1<countCity;index1++)
           dataset.addValue( countCityArray[index1] , stateArray[index],cityArray[index1] );  
     
        }
      
  /*     dataset.addValue(1.0, series1, category1);
        dataset.addValue(7.0, series2, category2);
       
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5.0, series1, category5);

        dataset.addValue(5.0, series2, category1);
        dataset.addValue(6.0, series2, category3);
        dataset.addValue(8.0, series2, category4);
        dataset.addValue(4.0, series2, category5);

        dataset.addValue(4.0, series3, category1);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);
     */  
        return dataset;
        
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Bar Chart Demo",         // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public void main(final String[] args) {

        final BarChartDemo demo = new BarChartDemo("Bar Chart Demo",enterprise,commissionerOrganization);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}

