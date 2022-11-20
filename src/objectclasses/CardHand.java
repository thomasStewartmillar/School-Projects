package objectclasses;

import interfaces_adts.TSStack;

/**
 * Class containing methods pertaining to the creation of a hand of cards, drawing from a deck
 * and obtaining information and calculations for the purpose of playing a game
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 04/07/2022
 */
public class CardHand
{
    private final int MAX_HAND = 15; // No longer used, input validation cuts the array to the size of the bet
    private int handSize;

    // Default/No parameter constructor
    public CardHand()
    {

    }

    /**
     * Initialises empty array of size equal to the player bet that is then populated with cards from the deck Stack
     * @param playerBet Integer value specifying the size of the hand the player will draw
     * @param deck TSStack of shuffled cards from which hand is drawn
     *
     * @return playerHand An array of card objects that serves as the player's hand in-game
     */
    // Initialises empty array of size equal to the player bet that can be populated with cards from the deck Stack
    public Card[] playerDraw (int playerBet, TSStack<Card> deck)
    {
        handSize = playerBet;
        Card[] playerHand = new Card[handSize];

        for(int i = 0; i < playerBet; i++)
        {
            CardSuit suit = deck.peek().getCardSuit();
            CardValue value = deck.peek().getCardValue();
            playerHand[i] = new Card(suit, value);
            deck.pop();
        }
        return playerHand;
    }

    /**
     *  Iterate through an array of card objects, get their details using the Card class' cardDetails method and
     *  generate a summary string that is output
     *
     * @param cards Array of cards to iterate through
     * @return outputString A string containing all the details of the cards passed, separated by a comma
     */
    public String showCards (Card[] cards)
    {
       String outputString = "";
       for (Card c: cards)
       {
           outputString += c.cardDetails() + ", ";
       }
       StringBuffer buffer = new StringBuffer(outputString); // Remove final ", " from concatenation in the loop
       buffer.deleteCharAt(buffer.length()-1);
       outputString = String.valueOf(buffer.deleteCharAt(buffer.length()-1));
       return outputString;
    }


    /**
     * Method to iterate through an array of card objects, total their value and return it.
     *
     * @param cardHand An array of card objects corresponding to a hand of cards
     * @return handValue integer value corresponding to the cumulative points total of the cards in hand
     */
    public int handValue (Card[] cardHand)
    {
        int handValue = 0;

        for (Card card: cardHand)
        {
            handValue += card.getValue();
        }
        return handValue;
    }

    /**
     * Method to iterate through an array of card objects, check if cards are aces and increment a total if so
     *
     * @param hand An array of card objects corresponding to a hand of cards
     * @return aceNum
     */
    private int aceCheck (Card[] hand){
        int aceNum = 0 ;

        for(Card card: hand)
        {
            if (card.getCardValue() == CardValue.ACE ){
                aceNum++;
            }
        }
        return aceNum;
    }

    /**
     * Method to adjust a hand's value if aces are present and the game mode allows them to be swapped.
     *
     * @param existingHand Integer corresponding to a hand's value without changing any values.
     * @param numberAceSwaps The number of aces eligible to be swapped.
     * @return adjustedScore An integer value corresponding to the existing score minus deductions from swapping aces.
     */
    private int adjustedHand (int existingHand, int numberAceSwaps)
    {
        int adjustedScore = existingHand - (10 * numberAceSwaps);
        return adjustedScore;
    }


    /**
     * Method to determine the score of a hand and returns it. Contains branching logic to deal with differing scenarios,
     * such as game mode/ruleset being employed. Calls the handValue, aceCheck and adjustedHand methods to accomplish this.
     *
     * @param targetVal The target value from which the score is calculated along with the hand value
     * @param cardHand An array of card objects corresponding to a hand of cards.
     * @param gameMode Integer value that corresponds to the game mode and determines if, and how aces can be
     *                 swapped to adjust the ultimate score.
     *
     * @return handScore The ultimate score that the passed hand earns within the game rules.
     */
    public int handScore (int targetVal, Card[] cardHand, int gameMode)
    {
        int handValue = handValue(cardHand);
        int handScore = 0;
        int aceCount = aceCheck(cardHand);

        if (gameMode == 1)
        {
            if (handValue <= targetVal) {
                handScore = targetVal - handValue;
            }
            else {
                handScore = targetVal;
            }
        }

        if (gameMode == 2)
        {
            int maxPossibleSwap = aceCount * 10;
            int swappedAces = aceCount; // Either swapping all aces or none in this method

            // Swap all 4 aces in hand
            if (handValue > 81 && handValue <= 91 && maxPossibleSwap == 40)
            {
                handScore = targetVal - adjustedHand(handValue, swappedAces);
            }
            // Swap all 3 aces in hand
            if (handValue > 71 && handValue <= 81 && maxPossibleSwap == 30)
            {
                handScore = targetVal - adjustedHand(handValue, swappedAces);
            }
            // Swap 2 aces in hand
            if (handValue > 61 && handValue <= 71 && maxPossibleSwap == 20)
            {
                handScore = targetVal - adjustedHand(handValue, swappedAces);
            }
            // Swap 1 ace held
            if (handValue > 51 && handValue <= 61 && maxPossibleSwap == 10)
            {
                handScore = targetVal - adjustedHand(handValue, swappedAces);
            }
            // Always disadvantageous to swap
            if (handValue < 51)
            {
                swappedAces = 0;
                handScore = targetVal - handValue;
            }
            // Even with a swap will still exceed target score, score = 51
            if (handValue - maxPossibleSwap > 51)
            {
                handScore = targetVal;
            }
        }// end if (gameMode == 2)

        if (gameMode == 3)
        {
            if (aceCount >= 1)
            {
                int swappedAces = 0;
                int maxPossibleSwap = aceCount * 10;

                // Swap all 4 aces in hand
                if (handValue > 81 && handValue <= 91 && aceCount == 4) {
                    swappedAces = 4;
                    handScore = targetVal - adjustedHand(handValue, swappedAces);
                }
                // Swap all 3 aces if 3 held, or 3/4 if beneficial to player
                if (handValue > 71 && handValue <= 81 && aceCount >= 3) {
                    swappedAces = 3;
                    handScore = targetVal - adjustedHand(handValue, swappedAces);
                }
                // Swap both if 2 held, or 2 out of total aces in hand
                if (handValue > 61 && handValue <= 71 && aceCount >= 2) {
                    swappedAces = 2;
                    handScore = targetVal - adjustedHand(handValue, swappedAces);
                }
                // Swap single ace if 1 held, or 1 out of total aces in hand
                if (handValue > 51 && handValue <= 61 && aceCount >= 1) {
                    swappedAces = 1;
                    handScore = targetVal - adjustedHand(handValue, swappedAces);
                }
                // Always disadvantageous to swap
                if (handValue < 51) {
                    handScore = targetVal - handValue;
                }
                // Even with a swap will still exceed target score, score = 51
                if (handValue - maxPossibleSwap > 51)
                {
                    handScore = targetVal;
                }
            } // End if aceCount >= 1
            else
                if (handValue < 51) {
                    handScore = targetVal - handValue;
                }
                else {
                    handScore = targetVal;
                }

        }// end if (gameMode == 3)

        return handScore;
    }// End method handScore


    /**
     * Similar method to the handScore in terms of how it's structured, but this is for printing information rather than
     * returning it.
     *
     * @param targetVal The target value from which the score is calculated along with the hand value
     * @param cardHand An array of card objects corresponding to a hand of cards.
     * @param gameMode Integer value that corresponds to the game mode and determines if, and how aces can be
     *                 swapped to adjust the ultimate score.
     *
     */
    public void swapReport (int targetVal, Card[] cardHand, int gameMode)
    {
        int handValue = handValue(cardHand);

        if (gameMode == 2)
        {
            int aceCount = aceCheck(cardHand);
            int maxPossibleSwap = aceCount * 10;
            int swappedAces = aceCount; // Either swapping all aces or none in this method

            // Swap all 4 aces in hand
            if (handValue > 81 && handValue <= 91 && maxPossibleSwap == 40)
            {
                System.out.println("(Aces Found " + aceCount + ", Ace Swapped " + swappedAces + ")");
            }
            // Swap all 3 aces in hand
            if (handValue > 71 && handValue <= 81 && maxPossibleSwap == 30)
            {
                System.out.println("(Aces Found " + aceCount + ", Ace Swapped " + swappedAces + ")");
            }
            // Swap 2 aces in hand
            if (handValue > 61 && handValue <= 71 && maxPossibleSwap == 20)
            {
                System.out.println("(Aces Found " + aceCount + ", Ace Swapped " + swappedAces + ")");

            }
            // Swap 1 ace held
            if (handValue > 51 && handValue <= 61 && maxPossibleSwap == 10)
            {
                System.out.println("(Aces Found " + aceCount + ", Ace Swapped " + swappedAces + ")");
            }
        }// end if (gameMode == 2)

        if (gameMode == 3)
        {
            int aceCount = aceCheck(cardHand);
            int maxPossibleSwap = aceCount * 10;
            int swappedAces = 0;
            if (aceCount >= 1)
            {
                // Swap all 4 aces in hand
                if (handValue > 81 && handValue <= 91 && aceCount == 4)
                {
                    swappedAces = 4;
                    System.out.println("(Aces Found " + aceCount + ", Ace Swapped " + swappedAces + ")");
                }
                // Swap all 3 aces if 3 held, or 3/4 if beneficial to player
                if (handValue > 71 && handValue <= 81 && aceCount >= 3)
                {
                    swappedAces = 3;
                    System.out.println("(Aces Found " + aceCount + ", Ace Swapped " + swappedAces + ")");
                }
                // Swap both if 2 held, or 2 out of total aces in hand
                if (handValue > 61 && handValue <= 71 && aceCount >= 2)
                {
                    swappedAces = 2;
                }
                // Swap single ace if 1 held, or 1 out of total aces in hand
                if (handValue > 51 && handValue <= 61 && aceCount >= 1)
                {
                    swappedAces = 1;
                    System.out.println("(Aces Found " + aceCount + ", Ace Swapped " + swappedAces + ")");
                }
                // Always disadvantageous to swap
                if (handValue < 51) {

                }
                // Even with a swap will still exceed target score, score = 51
                if (handValue - maxPossibleSwap > 51)
                {
                    System.out.println("(Despite the Option to Swap)");
                }
            }// End if (aceCount >= 1)           @param newEntry The new item to be added at aforementioned position


        }// end if (gameMode == 3)

    }// End method swapReport

}// End class CardHand
