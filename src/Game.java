import interfaces_adts.TSStack;
import objectclasses.Card;
import objectclasses.CardDeck;
import objectclasses.CardHand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Class containing game logic and instantiation of other classes as to play a game of Target Cards
 * Entrance point to class is contained in Main, and dictates what mode of the game is played
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 12/08/2022
 * /
 */public class Game
{
    private final int targetValue = 51;

    /**
     * Executes a variant of a game run of Target Cards depending on parameters passed
     *
     * @param numPlayers Dictates number of players playing game
     * @param numRounds Dictates number of rounds played
     * @param gameMode Dictates game mode game is executed in, 1 of 3 options.
     * @throws InterruptedException to enable pauses for readability of output
     * @throws IOException prevents crashes
     * @throws ClassNotFoundException prevents crashes
     */
    public void game (int numPlayers, int numRounds, int gameMode) throws InterruptedException, IOException, ClassNotFoundException {
        // Instantiating relevant classes
        CardDeck deck = new CardDeck();
        CardHand hand = new CardHand();

        printFormat(3); printFormat(3);
        if(gameMode == 1) { System.out.println("\nMode Selected - Aces High!"); }
        if(gameMode == 2) { System.out.println("\nMode Selected - Aces Low"); }
        if(gameMode == 3) { System.out.println("\nMode Selected - Aces High (or Low)!"); }
        printFormat(3); printFormat(3); System.out.println();
        boolean gameActive = true;

        if (numPlayers == 1)
        {
            Player player1 = new Player();
            printFormat(1); player1.setName( UserInput.enterString());
            while (gameActive)
            {   System.out.println("\nTrazyn the Swift is Shuffling the Deck...");
                for (int i = 0; i < 9; i++)
                {
                    System.out.println("...");
                    TimeUnit.MILLISECONDS.sleep(25);
                }
                System.out.println("\nHe has Finished...\n\n");
                TSStack<Card> gameDeck = deck.shuffledDeck();
                System.out.println(printStatements(player1, 3));
                int player1Bet = UserInput.enterInt(1, 15); // check this
                Card [] player1Hand = hand.playerDraw(player1Bet, gameDeck);

                System.out.println("You Have Bet " + player1Bet + " cards:\n");
                System.out.println("Your Drawn Hand - " + hand.showCards(player1Hand));
                System.out.println("Your Hand Value - " + hand.handValue(player1Hand));
                System.out.println("Your Hand Score - " + hand.handScore(targetValue, player1Hand, gameMode));

                System.out.println("\nDo You Wish to Play Again? \nEnter Y for Yes, No = Anything Else \n");
                String contPlay = UserInput.enterString();
                if (! contPlay.equals("Y")) {
                    gameActive = false;
                }
            }
        }
        else
        {
            Player player1 = new Player(); Player player2 = new Player(); // This needs to be here, or it will reset every time
            printFormat(1); player1.setName( UserInput.enterString()); player1.setPlayerMode(gameMode);
            printFormat(2); player2.setName( UserInput.enterString()); player2.setPlayerMode(gameMode);

            while (gameActive)
            {
            System.out.println("\n"+player1.getName() + " and " + player2.getName() + " are facing off in mortal combat!"); TimeUnit.MILLISECONDS.sleep(1500);
            int roundTracker = 0;
            if (player1.getPlayerWins() > 0 || player2.getPlayerWins() > 0){
                System.out.println("\nCurrent Match Score\n------------------------");
                System.out.println(player1.getPlayerWins() + " - " +player1.getName());
                System.out.println(player2.getPlayerWins() + " - " +player2.getName());
            }
                for (int r = 1; r <= numRounds; r++)
                {
                    System.out.println("\nTrazyn the Slovenly is Shuffling the Deck...");
                    for (int i = 0; i < 11; i++)
                    {
                        System.out.println("...");
                        TimeUnit.MILLISECONDS.sleep(125);
                    }
                    System.out.println("\nHe has Finished...\n");
                    TSStack<Card> gameDeck = deck.shuffledDeck();

                    if (r % 2 > 0)
                    {                    System.out.println("(Aces Found " + aceCount + ", Ace Swapped " + swappedAces + ")");

                        System.out.print(printStatements(player1, 3));
                        int player1Bet = UserInput.enterInt(1, 15);
                        System.out.print("\n" + printStatements(player2, 3));
                        int player2Bet = UserInput.enterInt(1, 15);

                        System.out.println("\n" + player1.getName() + " has bet " + player1Bet + " Cards!");
                        System.out.println(player2.getName() + " has bet " + player2Bet + " Cards!");

                        Card[] player1Hand = hand.playerDraw(player1Bet, gameDeck);
                        Card[] player2Hand = hand.playerDraw(player2Bet, gameDeck);
                        TimeUnit.MILLISECONDS.sleep(1500);

                        roundSummary(player1, hand, player1Hand, gameMode);
                        TimeUnit.MILLISECONDS.sleep(1500);
                        roundSummary(player2, hand, player2Hand, gameMode);

                        int player1RoundScore = hand.handScore(targetValue, player1Hand, gameMode);
                        int player2RoundScore = hand.handScore(targetValue, player2Hand, gameMode);
                        updateScore(player1, player1.getPlayerScore(), player1RoundScore);
                        updateScore(player2, player2.getPlayerScore(), player2RoundScore);
                        TimeUnit.MILLISECONDS.sleep(1500);

                        System.out.println();
                        displayWinner(findWinner (player1RoundScore, player2RoundScore),
                                player1, player1RoundScore, player2, player2RoundScore);
                        System.out.print("(This hand)\n");
                        TimeUnit.MILLISECONDS.sleep(1500);

                        System.out.println("\n" + printStatements(player1, 4) + player1.getPlayerScore());
                        System.out.println(       printStatements(player2, 4) + player2.getPlayerScore());
                        TimeUnit.MILLISECONDS.sleep(1750);
                    }
                    else
                    {
                        System.out.print("\n" + printStatements(player2, 3));
                        int player2Bet = UserInput.enterInt(1, 15);
                        System.out.print("\n" + printStatements(player1, 3));
                        int player1Bet = UserInput.enterInt(1, 15);

                        System.out.println("\n" + player2.getName() + " has bet " + player2Bet + " Cards!");
                        System.out.println(player1.getName() + " has bet " + player1Bet + " Cards!");
                        TimeUnit.MILLISECONDS.sleep(1500);

                        Card[] player1Hand = hand.playerDraw(player1Bet, gameDeck);
                        Card[] player2Hand = hand.playerDraw(player2Bet, gameDeck);

                        roundSummary(player2, hand, player2Hand, gameMode);
                        TimeUnit.MILLISECONDS.sleep(1500);
                        roundSummary(player1, hand, player1Hand, gameMode);

                        int player1RoundScore = hand.handScore(targetValue, player1Hand, gameMode);
                        int player2RoundScore = hand.handScore(targetValue, player2Hand, gameMode);
                        updateScore(player1, player1.getPlayerScore(), player1RoundScore);
                        updateScore(player2, player2.getPlayerScore(), player2RoundScore);
                        TimeUnit.MILLISECONDS.sleep(1500);

                        System.out.println();
                        displayWinner (findWinner(player1RoundScore, player2RoundScore),
                                player1, player1RoundScore, player2, player2RoundScore);
                        System.out.print("(This hand)\n");
                        TimeUnit.MILLISECONDS.sleep(1500);
                        System.out.println("\n" + printStatements(player1, 4) + player1.getPlayerScore());
                        System.out.println(       printStatements(player2, 4) + player2.getPlayerScore());
                        TimeUnit.MILLISECONDS.sleep(1750);

                    }// end if/else
                    roundTracker ++;
                } // end for loop for number of rounds

                // Update scores/display winner of a series only applicable (only for a 4 round game, incrementing roundTracker handles this)
                if (roundTracker == 4)
                {   System.out.println();
                    displayWinner(findWinner(player1.getPlayerScore(), player2.getPlayerScore()),
                            player1, player1.getPlayerScore(), player2, player2.getPlayerScore());
                    updateWins(findWinner(player1.getPlayerScore(), player2.getPlayerScore()), player1, player2);
                    TimeUnit.SECONDS.sleep(2);

                    System.out.println();
                    if (player1.getPlayerScore() < player1.getPlayerHighScore()) {
                        player1.setPlayerHighScore(player1.getPlayerScore());
                        System.out.println("Congratulations " + player1.getName() + "! You have set a new personal high score of " + player1.getPlayerHighScore() +" ^_^ \n");
                    }
                    if (player2.getPlayerScore() < player2.getPlayerHighScore()) {
                        player2.setPlayerHighScore(player2.getPlayerScore());
                        System.out.println("Congratulations " + player2.getName() + "! You have set a new personal high score of " + player2.getPlayerHighScore()+" ^-^ \n");
                    }
                }

                System.out.println("\nDo You Wish to Play Again? \nEnter Y for Yes, No = Anything Else");
                String contPlay = UserInput.enterString();
                if (! contPlay.equals("Y")) {
                    gameActive = false;
                }
                // Reset and update scores and bets for next 4 round game
                player1.setPlayerScore(0);
                player2.setPlayerScore(0);

                //updateHighScores(gameMode, player1, player2);
                // TODO Not currently functional (Concurrent Modification Exception) (Seemingly fixed)
                //TODO Exception in thread "main" java.lang.OutOfMemoryError: Java heap space (New errors after fixing the aforementioned, crash program)
                //	at java.base/java.util.LinkedList.linkBefore(LinkedList.java:162)
                //	at java.base/java.util.LinkedList.add(LinkedList.java:516)
            }// End while userActive

        }// End else

    }// End method game

    /**
     * Find the winner (or draw) via a comparison of player scores
     * @param player1score Player 1's score
     * @param player2score Player 2's score
     *
     * @return an integer value where 1 denotes a player 1 win, 2 for player 2 and 3 for a draw
     */
    private int findWinner (int player1score, int player2score)
    {
        int player1 = 1; int player2 = 2; int draw = 3;

        if (player1score < player2score) {
            return player1;
        }
        if (player2score < player1score) {
            return player2;
        }
        else {
            return draw;
        }
    }// end method findWinner

    /**
     * Void method to display the winner of a hand/match and details of the game
     *
     * @param resultCheck Integer corresponding to winners (or tie), calls the findWinner method
     * @param player1 Player 1 for retrieval/printing of details
     * @param player1Score Player 1's score
     * @param player2 Player 2 for retrieval/printing of details
     * @param player2Score Player 2's score
     */
    // Display the winner (or draw) via a comparison of player scores
    private void displayWinner (int resultCheck, Player player1, int player1Score, Player player2, int player2Score)
    {
        String resultMessage = "";

        if (resultCheck == 1) {
            resultMessage += player1.getName() + " is the winner! With a score of... " + player1Score;
        }
        if (resultCheck == 2) {
            resultMessage += player2.getName() + " is the winner! With a score of... " + player2Score;
        }
        if (resultCheck == 3) {
            resultMessage += "It is a draw, you must do battle again!";
        }
        System.out.println(resultMessage);
    }


    /**
     * Void method to output the cards of a player's hand, their value and their score as per the game rules
     *
     * @param player Player whose hand we want details of
     * @param hand Instance of the hand class for use of methods
     * @param playerHand A player's current hand as an array
     * @param gameMode Integer value corresponding to 1 of 3 rulesets
     */
    private void roundSummary (Player player, CardHand hand, Card[] playerHand, int gameMode)
    {
        System.out.println("\n" + player.getName() + "'s Hand - " + (hand.showCards(playerHand)));
        System.out.println(player.getName() + "'s Hand Value - " + (hand.handValue(playerHand)));
        System.out.println(player.getName() + "'s Hand Score - " + (hand.handScore(targetValue, playerHand, gameMode)));
        hand.swapReport(targetValue, playerHand, gameMode);
    }

    /**
     * Void method for updating a player's score as a match progresses, using setPlayerScore method of Player class
     *
     * @param player Player whose score needs updating
     * @param existingScore Integer value for a player's current cumulative score
     * @param roundScore Integer value for a player's score that particular hand
     */
    private void updateScore (Player player, int existingScore, int roundScore)
    {
        int newScore = existingScore + roundScore;
        player.setPlayerScore(newScore);
    }

    /**
     * Void method for updating a player's score as a match progresses, using setPlayerScore method of Player class
     *
     * @param resultCheck Integer corresponding to winners (or tie), calls the findWinner method
     * @param player1 Player 1, if they satisfy the result check, win count will be incremented
     * @param player2 Player 2, if they satisfy the result check, win count will be incremented
     */
    private void updateWins (int resultCheck, Player player1, Player player2) //
    {
        int player1CurrentWins = player1.getPlayerWins();
        int player2CurrentWins = player2.getPlayerWins();

        if (resultCheck == 1) {
            player1CurrentWins = player1CurrentWins + 1;
            player1.setPlayerWins(player1CurrentWins);
        }
        if (resultCheck == 2) {
            player2CurrentWins = player2CurrentWins + 1;
            player2.setPlayerWins(player2CurrentWins);
        }
    }

    /**
     * Currently non-functional method to read from existing file of high scores, pass Player objects to, compare
     * their highscores to those in file and update and re-write the file if they are eligible to be entered.
     *
     * @param gameMode Integer value corresponding to particular file we're reading/potentially writing to
     * @param player1 Player 1 passed to see if eligible to be added to high score list
     * @param player2 Player 2 passed to see if eligible to be added to high score list
     * @throws IOException Various I/O Issues thrown
     * @throws ClassNotFoundException Class conversion issues thrown
     * @throws InterruptedException Can be called by a class that is using interrupts
     * @throws FileNotFoundException Already handled by general IO Exception, somewhat redundant
     */
    public void updateHighScores(int gameMode, Player player1, Player player2) throws IOException, ClassNotFoundException, InterruptedException, FileNotFoundException
        {
            FileIO files = new FileIO();
            try {
                LinkedList<Player> scores = files.fileRead(gameMode);

                int updates = 0; boolean player1scoreEntry = false; boolean player2scoreEntry = false;

                if (player1.getPlayerHighScore() <= player2.getPlayerHighScore())
                {   int start = 0; // Initialise variable for second pass to start from
                    for (int i = 0; i < scores.size(); i++)
                    {
                        if (player1.getPlayerHighScore() < scores.get(i).getPlayerHighScore()); {
                        scores.add(i, player1);
                        updates++;
                        player1scoreEntry = true;
                        }
                        start++;
                    }
                    if (updates > 0) { // No point trying to insert if the better candidate score hasn't entered high score
                        for (int j = start ; j < scores.size() ; j++)
                        {
                            if (player2.getPlayerHighScore() < scores.get(j).getPlayerHighScore()); {
                            scores.add(j, player1);
                            updates++;
                            player2scoreEntry = true;
                            }
                        }
                    }
                } // End If player1HighScore < player2HighScore

                // Swap the order around, as player 2 more likely to be inserted
                else
                {
                    int start = 0; // Initialise variable for (potential )second pass to start from
                    for (int i = 0; i < scores.size(); i++)
                    {
                        if (player2.getPlayerHighScore() < scores.get(i).getPlayerHighScore()); {
                        scores.add(i, player2);
                        updates++;
                        player2scoreEntry = true;
                        }
                        start++;
                    }
                    if (updates > 0) { // No point trying to insert if the better candidate score hasn't entered high score
                        for (int j = start ; j < scores.size() ; j++)
                        {
                            if (player2.getPlayerHighScore() < scores.get(j).getPlayerHighScore()); {
                            scores.add(j, player1);
                            updates++;
                            player1scoreEntry = true;
                            }
                        }
                    }
                } // End else

                if (player1scoreEntry) {
                    System.out.println("Congratulations" + player1.getName() + "!");
                    System.out.println("Your Score of " + player1.getPlayerHighScore() + " has seen you entered the hall of fame at position " + (1 + scores.indexOf(player1)));
                }
                if (player2scoreEntry) {
                    System.out.println("Congratulations" + player2.getName() + "!");
                    System.out.println("Your Score of " + player2.getPlayerHighScore() + " has seen you entered the hall of fame at position " + (1 + scores.indexOf(player2)));
                }

                // Trim the list back down to 10 items
                for (int i = 0; i < updates; i++) {
                    scores.removeLast();
                }
                // Write trimmed file
                files.fileWrite(scores, gameMode);
            }
            catch (FileNotFoundException exF) {
                System.out.println(exF);
            }
            //TODO Add an initial check where if player 1 < 2 they check first, or the other way around. If 1 is lower than 2 and isn't eligible for the list, 2 won't be by default
            //TODO fix this and get a functional swap going. Find location, swap nodes and chop off the tail before writing to file.
            //TODO Tried and failed to implement this functionality.

        }// End method updateHighScores


    /**
     * Simple void method for printing tailored information
     *
     * @param player Player for whom we want to tailor output to
     * @param requestedOutput Specific type of output string desired
     * @return outputString, information that we wish printed
     */
    private String printStatements(Player player, int requestedOutput)
    {
        String outputString = "";

        // Player prompts
        if (requestedOutput == 1) {
            outputString = "\nPlayer 1, Please Enter Your Name: ";
        }
        if (requestedOutput == 2) {
            outputString = "\nPlayer 2, Please Enter Your Name: ";
        }
        if (requestedOutput == 3) {
            outputString = player.getName() + ", Place Your Bet!";
        }

        if (requestedOutput == 4) {
            outputString = player.getName() + "'s Match Score - ";
        }

        return outputString;
    }


    /**
     * Simple void method for printing tailored information

     * @param requestedOutput Specific type of output print desired
     */
    private void printFormat(int requestedOutput) {
        // Player prompts, need these as placeholders until the player object has their name attribute set
        if (requestedOutput == 1) {
            System.out.println("\nPlayer 1, Please Enter Your Name: ");
        }
        if (requestedOutput == 2) {
            System.out.println("\nPlayer 2, Please Enter Your Name: ");
        }
        if (requestedOutput == 3) {
            // Formatting
            System.out.print("\u2665 \u2664 \u2666 \u2667" + " ");
            System.out.print("\u2665 \u2664 \u2666 \u2667" + " ");
        }
    }

}// end class Game
