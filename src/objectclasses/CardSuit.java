package objectclasses;

/**
 * Enumeration class for use by the Card class and beyond, corresponding to a card's suit
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 05/07/2022
 */
public enum CardSuit
{
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String suitName;

    // Constructor
    CardSuit(String suitName)
    {
        this.suitName = suitName;
    }

    // Public method
    public String printSuit()
    {
        return suitName;
    }

}// end class CardSuit
