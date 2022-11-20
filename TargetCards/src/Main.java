import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Class containing display methods to navigate a menu and a switch to make a selection
 * to navigate to another function of the application.
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 21/07/2022
 */
public class Main
{
    private static int gameMode = 1;
    public static void main(String[] args) throws InterruptedException
    {
        // Instantiate classes to be used within main method
        Game run = new Game();
        FileIO files = new FileIO();
        boolean userActive = true;
        while(userActive) // Menu will continue to be re-displayed and user prompted for selection until !userActive.
        {
            displayMenu();
            int userChoice = UserInput.enterInt(1, 6);
            try
            {
                switch (userChoice) {
                    case 1 -> run.game(1, 1, gameMode);
                    case 2 -> run.game(2, 1, gameMode);
                    case 3 -> run.game(2, 4, gameMode);
                    case 4 ->
                    {
                        System.out.println("\nSelect Game Mode");
                        for (int i = 0; i < 45; i++) System.out.print("-");
                        System.out.println("\n1 - Aces High\nIn this game mode an ace's value must always count as 11");
                        System.out.println("2 - Aces Low\nIn this mode an ace's value may be swapped when beneficial, with all ace values being changed to 1");
                        System.out.println("3 - Aces High (and Low!)\nIn this mode an ace's value may be 11 or 1 depending on when it is beneficial");
                        gameMode = UserInput.enterInt(1, 3); // Fix this
                        System.out.println("You Have Selected Mode " + gameMode + "\n");
                    }
                    case 5 -> files.displayHighScores(gameMode);
                    case 6 ->
                    {
                        System.out.println("Do You Really Wish to Exit? \nEnter Y for Yes, No = Anything Else \n");
                        String exitChoice = UserInput.enterString();
                        if (exitChoice.equals("Y")) {
                            System.out.println("\nThank You for Playing!\n");
                            userActive = false;
                        } else {
                            System.out.println("\nWelcome Back!\n");
                        }
                    }
                    default -> System.out.println("Invalid Choice, Please Try Again");
                }// End switch for menu selection
            }
            catch (InputMismatchException ex) {
                System.out.println("Please Enter a Number!");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }// End while(userActive)

    }// End method main

        /**
         * Simple method that prints menu options to the user.
         *
         */
    static void displayMenu() {
        String formatString = "-";

        System.out.println("\n" +"\u2665 \u2664 \u2666 \u2667" + " " + "\u2665 \u2664 \u2666 \u2667" + " ");
        System.out.println("\u2666 TARGET CARDS \u2667");
        System.out.println("\u2665 \u2664 \u2666 \u2667" + " " + "\u2665 \u2664 \u2666 \u2667" + " ");
        System.out.println("\nWelcome Player! - Please Enter Your Selection:");
        for (int i = 0; i < 45; i++) System.out.print(formatString);
        System.out.println();

        System.out.println();
        System.out.println("1. Single Player Game");
        System.out.println("2. Two Player Game");
        System.out.println("3. Two Player 4-Game Series");
        System.out.println("4. Select Game Mode");
        System.out.println("5. High Scores");
        System.out.println("6. Exit");
        System.out.println(modeSelected(gameMode));
        for (int i = 0; i < 45; i++) System.out.print(formatString);
        System.out.println();
    }//End method displayMenu

    static String modeSelected (int gameMode)
    {
        String modeSelected ="";
        if (gameMode == 1) {
            modeSelected = "\nCurrent Mode Selected: 1 - Aces High\nIn this game mode an ace's value must always count as 11";
        }
        if (gameMode == 2) {
            modeSelected = "\nCurrent Mode Selected: 2 - Aces Low\nIn this mode an ace's value may be swapped when beneficial, with all ace values being changed to 1";
        }
        if (gameMode == 3) {
            modeSelected = "\nCurrent Mode Selected: 3 - Aces High (and Low!)\nIn this mode an ace's value may be 11 or 1 depending on when it is beneficial";
        }
        return modeSelected;
    }



}// End class Main
