package objectclasses;

import interfaces_adts.TSStack;
import java.util.Random;

/**
 * Class containing a method for populating a full deck of cards, and a method for shuffling and returning
 * a shuffled deck of cards
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 010/07/2022
 */

public class CardDeck extends CardHand // Allows reuse of methods
{
    private final int deckSize = 52;

    private Card[] fillDeck()
    {
        Card[] fullDeck = new Card[deckSize];
        int i = 0;

        for(CardSuit suit: CardSuit.values())
        {
            for(CardValue card: CardValue.values())
            {
                fullDeck[i] = new Card(suit, card);
                i++;
             }
        }
        return fullDeck;
    }

    /**
     * Method calls the fillDeck method to populate an array containing all 52 cards of a standard playing deck.
     * This array is then shuffled and pushed into a stack, which is returned by the method.
     *
     * @return shufDeck, a stack of shuffled cards
     */
    public TSStack<Card> shuffledDeck()
    {
        Card[] deck = fillDeck();
        TSStack<Card>  shufDeck = new TSStack<>();

        // Creating object for Random class
        Random rand = new Random();

        // Starting from the last element and swapping one by one.
        for (int i = deckSize-1; i > 0; i--)
        {
            // Pick a random index from 0 to i
            int j = rand.nextInt(i+1);

            // Swap array contents with the element at random index
            Card temp = new Card(); // Initialise temporary card to swap
            CardSuit suit = deck[i].getCardSuit(); // Get card suit and value from index location
            CardValue value = deck[i].getCardValue();
            deck[i] = deck[j]; // choose random location (j)
            deck[j] = temp.setCard (suit, value); // set Card values to overwrite those in J
        }
        for (Card card : deck) {
            shufDeck.push(card);
        }

        return shufDeck;
    } // End method shuffleDeck

}//End class CardDeck
