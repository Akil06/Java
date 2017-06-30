/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Criminal;

//import Business.Criminal.Criminal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author AkilP
 */
public class CriminalDirectory {
    
     private ArrayList<Criminal> criminalList;

    public CriminalDirectory() {
        criminalList = new ArrayList();
    }

    public ArrayList<Criminal> getCriminalList() {
        return criminalList;
    }
     
     public Criminal addCriminal (String firstName,String lastName,LocalDate dob,int noOfCases,String SA,String robbery,String murder){
         Criminal criminal = new Criminal();
         criminal.setFirstName(firstName);
         criminal.setLastName(lastName);
         criminal.setDob(dob);
         criminal.setNumberOfCasesConvicted(noOfCases);
         criminal.setMurder(murder);
         criminal.setRobbery(robbery);
         criminal.setSexualAssault(SA);
         criminalList.add(criminal);
         return criminal;
     }
    
}
