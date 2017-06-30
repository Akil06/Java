/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Criminal.Criminal;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import Business.Enterprise.Enterprise;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.time.LocalDate;

/**
 *
 * @author AkilP
 */
public class Initialization {

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // ArrayList<Integer> arraylist = new ArrayList<Integer>();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
     
        int num = 0;
        int randomNum=0;
        // for (int j = 1; j < arraylist.size(); j++) {
           
            while ((num < min) || (num > max)){
            num = rand.nextInt(max);
            if ((num > min) || (num < max)){
                randomNum=num;
               break;
            }
        }
        
        
        return randomNum;
    }

    public static float randfloat(double min, double max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        ArrayList<Double> arraylist = new ArrayList<Double>();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        for (double i = min; i < max; i++) {
            arraylist.add(i);
        }
        float randomNum = 0;
        for (double j = min; j < arraylist.size(); j++) {
            randomNum = rand.nextFloat();
        }
        return randomNum;
    }

    public static void initializeCriminal(OrganizationDirectory orgDir) {
        Random random = new Random();
        String[] arrayOfHelicalRotation = {"Left", "Right"};

        for (Organization organization : orgDir.getOrganizationList()) {
             if (organization.getName().equalsIgnoreCase(Organization.Type.Admin.getValue())) {
            AdminOrganization admin = (AdminOrganization) organization;
            for (int i = 1; i < 100; i++) {
               
                    int no = random.nextInt(20);
                    String myCharacters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
                    String[] booleanArray = {"True", "False"};
                    String[] helicalArray = {"Right", "Left"};
                    String SA = booleanArray[random.nextInt(booleanArray.length)];
                    String robbery = booleanArray[random.nextInt(booleanArray.length)];
                    String murder = booleanArray[random.nextInt(booleanArray.length)];

                    int minDay = (int) LocalDate.of(1960, 3, 4).toEpochDay();
                    int maxDay = (int) LocalDate.of(2016, 1, 3).toEpochDay();
                    long randomDay = minDay + random.nextInt(maxDay - minDay);
                    String firstName = generateString(random, myCharacters, 5);
                    String lastName = generateString(random, myCharacters, 6);
                    LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

                    admin.getCriminalDirectory().addCriminal(firstName, lastName, randomBirthDate, no, SA, robbery, murder);
                }
                for (Criminal criminal : admin.getCriminalDirectory().getCriminalList()) {
                    String[] helicalArray = {"Right", "Left"};
                    String helicalRotation = helicalArray[random.nextInt(helicalArray.length)];
                    int diameter = randInt(18, 23);
                    int helicalTurn = randInt(28, 44);
                    int rotationPerBase = randInt(32, 36);
                    int meanPropellerTwist = randInt(16, 20);
                    float distanceBWAdjPh = randfloat(4.3, 8.0);
                    criminal.setIdentificationSigns(criminal.addIdentificationSigns(helicalRotation, diameter, helicalTurn, rotationPerBase, meanPropellerTwist, distanceBWAdjPh));
                }
            }

        }
//return enterprise;
    }

}
