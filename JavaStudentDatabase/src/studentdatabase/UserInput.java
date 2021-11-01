package studentdatabase;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Class containing methods to take user keyboard input and return for
 * other methods in other classes to take and subsequently use and manipulate.
 * 
 * @author Stewart Millar
 * @version 1.0
 * @since 17/06/2021
 */
public class UserInput {
    
     
    /**
     * Take String input from keyboard and return, removing potential leading or
     * trailing whitespace.
     *  
     * @return String for Student name. 
     */
    public String enterName()
    {
        Scanner inputName = new Scanner(System.in);
        
        System.out.println("Please Enter Full Name of Student; ");
        String outputName = inputName.nextLine();
        outputName = outputName.trim();
        
        return outputName;
    }// End method enterName
    
    
    /**
     * Take 3 validated integer keyboard inputs in sequence and return them as a
     * String via casting and concatenating. Combination of while loop(s) with boolean
     * condition/iterating counter serves to repeat inputs until valid input entered.
     * 
     *  @return String for Student date of birth in xx/xx/xxxx format
     */
    public String enterDoB() 
    {
        int birthDay = 0; int birthMonth = 0; int birthYear = 0;
        int count = 0;
        boolean validInput = false; // Acts as a boolean flag to keep loop(s) repeating until valid input received
        
        System.out.println("\nPlease Enter Student Date of Birth by Following the Instructions - \nEnter Numerical Values Only!\n");
        while(!validInput && count < 10) 
        {
            try {
                Scanner inputDate = new Scanner(System.in);
                System.out.print("Input Day of Birth: ");
                birthDay = inputDate.nextInt();
                
                if (birthDay <= 31 && birthDay > 0){
                    validInput = true;
                    break;
                }
            } catch (InputMismatchException ex) {}
        System.out.println("Please Input a Valid Numerical Value - Between 1 and 31");
        count ++; System.out.println("You have " + (10-count)+ " more attempt(s) remaining!\n");    
        }
        validInput = false; // Reset to false for next while loop
        count = 0; // Reset counter
        
        while(!validInput && count < 10) 
        {
            try {
                Scanner inputDate = new Scanner(System.in);
                System.out.print("Input Month of Birth: ");
                birthMonth = inputDate.nextInt();
                
                if (birthMonth <= 12 && birthMonth > 0) {
                    validInput = true;
                    break;
                }
            } catch (InputMismatchException ex) {}
        System.out.println("Please Input a Valid Numerical Value - Between 1 and 12");
        count ++; System.out.println("You have " + (10-count)+ " more attempt(s) remaining!\n");    
        }
        validInput = false; // Reset to false for next while loop
        count = 0; // Reset counter
        
        while(!validInput && count < 10) 
        {
            try {
                Scanner inputDate = new Scanner(System.in);
                System.out.print("Input Year of Birth: ");
                birthYear = inputDate.nextInt();
                
                if (birthYear < 2006 && birthYear > 1900){
                    validInput = true;
                    break;
                }
            } catch (InputMismatchException ex) {}
        System.out.println("Please Input a Valid Numerical Value - Between 1900 and 2006");
        count ++; System.out.println("You have " + (10-count)+ " more attempt(s) remaining!");    
        }
        
        String bd = Integer.toString(birthDay);
        String bm = Integer.toString(birthMonth);
        String by = Integer.toString(birthYear);
        String outputDoB = (bd + "/" + bm + "/" + by);
        
        return outputDoB;
    }// End method enterDoB 
    
    
    /**
     * Takes 3 String keyboard inputs in sequence, removing leading and trailing 
     * whitespace. Concatenate trimmed Strings, add additional formatting and
     * return that String.
     * 
     * @return String for Student address with address lines separated by comma
     */
    public String enterAddress() 
    {
        Scanner inputAddress = new Scanner(System.in);
        
        System.out.println("\nPlease Enter Address by Following the Instructions - ");
        System.out.print("Input First Line of Address: ");
        String addFirstLine = inputAddress.nextLine();
        addFirstLine = addFirstLine.trim();
        System.out.print("Input Town/City: ");
        String addCity = inputAddress.nextLine();     
        addCity = addCity.trim();
        System.out.print("Input Post Code: ");
        String addPostCode = inputAddress.nextLine(); 
        addPostCode = addPostCode.trim();
        
        String outputAddress = (addFirstLine+ ", " +(addCity)+ ", " +(addPostCode));
        
        return outputAddress;
    }// End method enterAddress
    
    
    /** 
     *  Takes input from keyboard with user instruction provided and compares to 
     *  two predefined Strings that are the only desired inputs for this method 
     *  and subsequent program functionality. User input is taken within a while
     *  loop that will iterate until a valid input is entered.
     * 
     *  @return String for Student gender, can only be "M" or "F".
     */
    public String enterGender()
    {
        Scanner inputGender = new Scanner(System.in);
        
        String validMale = "M"; String validFemale = "F";
        int count = 0;
        String outputGender = "";
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.println("\nPlease Enter Gender - M for Male, F for Female; ");
                outputGender = inputGender.next();
                outputGender = outputGender.toUpperCase();
                outputGender = outputGender.trim();
                if (outputGender.equals(validMale) || outputGender.equals(validFemale)){
                    validInput = true;
                    break;
                }
                
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("Please Input a Valid Value: ");
            }
        count++;
        System.out.println("You have Entered Incorrectly " + count + " time(s)");
        System.out.println("Please Try to Get it Right Next Time");
        } 
        
        return (outputGender);
    }// End method enterGender
        
}// End class UserInput