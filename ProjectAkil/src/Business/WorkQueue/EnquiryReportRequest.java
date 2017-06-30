/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Aswat
 */
public class EnquiryReportRequest extends WorkRequest{
    
    private int enquiryID;
    private String enquiryDescription;
    private int suspectPersonID;
    private String suspectName;
    private int victimID;
    private String victimName;
    private String motive;
    private static int count1=1000;
    private static int count2=3200;
    private static int count3=0;
    private String result;

    public EnquiryReportRequest() {
        super(WorkRequest.Type.Enquiry.getValue());
        count1++;
        count2++;
        count3++;
        suspectPersonID=count1;
        victimID=count2;
        enquiryID=count3;
    }

    public int getEnquiryID() {
        return enquiryID;
    }

    public void setEnquiryID(int enquiryID) {
        this.enquiryID = enquiryID;
    }

    
    
    public String getEnquiryDescription() {
        return enquiryDescription;
    }

    public void setEnquiryDescription(String enquiryDescription) {
        this.enquiryDescription = enquiryDescription;
    }

    public int getSuspectPersonID() {
        return suspectPersonID;
    }

    public void setSuspectPersonID(int suspectPersonID) {
        this.suspectPersonID = suspectPersonID;
    }

    public String getSuspectName() {
        return suspectName;
    }

    public void setSuspectName(String suspectName) {
        this.suspectName = suspectName;
    }

    public int getVictimID() {
        return victimID;
    }

    public void setVictimID(int victimID) {
        this.victimID = victimID;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
    @Override
    public String toString() {
        return enquiryDescription;
    }
    

    
}
