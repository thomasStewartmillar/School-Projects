package objectclasses;

/**
 * Enumeration class for use by the Card class and beyond, corresponding to a card's rank/value
 *
 * @author Stewart Millar
 * @version 1.0
 * @since 05/07/2022
 */
public enum CardValue
{
    TWO(2,"Two"), THREE(3, "Three"), FOUR(4, "Four"),
    FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7, "Seven"),
    EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"),
    JACK(10, "Jack"), QUEEN(10, "Queen"),
    KING(10, "King"), ACE(11, "Ace");

    private final int cardValue;
    private final String cardValueName;

    // Constructor
    CardValue(int cardValue, String cardValueName)
    {
        this.cardValue = cardValue;
        this.cardValueName = cardValueName;
    }

    // Public Methods
    public int getCardValue()
    {
        return cardValue;
    }// End method getCardValue

    public String getCardValueName()
    {
        return cardValueName;
    }// End method getCardValue

} // End class CardValue

