package objectclasses;

/**
 * Class defining card attributes, behaviours and default values as well as accessor/mutator
 * methods, for future use by other classes
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 08/07/2022
 */
public class Card
{
    private CardSuit suit;
    private CardValue value;

    // Default/no parameter constructor
    public Card ()
    {

    }

    // Two parameter constructor
    public Card (CardSuit suit, CardValue value)
    {
        this.suit = suit;
        this.value = value;
    }

    public Card getCard(CardSuit suit, CardValue value)
    {
        Card card = new Card (suit, value);
        return card;
    }

    public Card setCard(CardSuit suit, CardValue value)
    {
        Card card = new Card (suit, value);
        return card;
    }

    public String getSuit()
    {
        return suit.printSuit(); // Returns the suit as a String for methods that require that functionality
    }

    public CardSuit getCardSuit() // Returns the CardSuit enum of the targeted card, used primarily for constructing new Cards
    {
        return suit;
    }
    public CardValue getCardValue() // Returns the CardValue enum of the targeted card, used primarily for constructing new Cards
    {
        return value;
    }


    public int getValue() // Useful for game logic, so integer values are compared rather than CardValue enum
    {
        return value.getCardValue();
    }


    public String cardDetails()
    {
        String cardDetails = "";
        cardDetails += value.getCardValueName() + " of " + getSuit();
        return cardDetails;
    }

}// End class Card
