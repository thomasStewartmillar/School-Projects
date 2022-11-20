import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Class containing methods for user to enter integer/string values where required in the rest of the application
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 15/07/2022
 */
public class UserInput
{
    /**
     * Take String input from keyboard and return, removing potential leading or
     * trailing whitespace.
     *
     * @return String for Player name or to make yes/no choices in menus via if statement/toUpperCase method.
     */
    public static String enterString()
    {
        Scanner input = new Scanner(System.in);

        String outputString = input.nextLine();
        outputString = outputString.trim();

        if(outputString.equals("y")) // Reuse in multiple places
        {
            outputString = outputString.toUpperCase();
        }
        input.close();

        return outputString;
    }// End method enterString

    /**
     * Take integer input from keyboard and return it, validating for range of allowable input
     *
     * @param lowest  Lower bound of acceptable input
     * @param highest Upper bound of acceptable input
     * @return Select integer value.
     */
    public static int enterInt(int lowest, int highest)
    {
        int lowestVal = lowest; int highestVal = highest;
        Scanner userInput = new Scanner(System.in);
        boolean inputError = true;
        int outputVal = 0;
        System.out.println("\nPlease enter a number between " + lowestVal +" and " + highestVal+ "");

        do {
            try
            {
                System.out.print("Enter valid value: ");
                outputVal = userInput.nextInt();
                if (lowestVal <= outputVal && outputVal <= highestVal)
                {
                    inputError = false;
                }
            } catch (InputMismatchException ex)
            {
                System.out.println("Error! Please Enter a Numerical Value");
            }
            userInput.nextLine();// Resets userInput Scanner to prevent infinite loop
        } while (inputError);
        userInput.close();

        return outputVal;
    }// End method enterInt


}// End class UserInput
