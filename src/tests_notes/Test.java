package tests_notes;

import objectclasses.Card;

public class Test extends Card
{
    /**
     *
     * Assorted Tests, kept for reference purposes
     */
    /*
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        objectclasses.CardDeck cd = new objectclasses.CardDeck();

        objectclasses.CardHand player1hand = new objectclasses.CardHand();
        FileIO testIO = new FileIO();
        LinkedList<Player> testList = new LinkedList<>();
        LinkedList<Player> testList2 = new LinkedList<>();
        LinkedList<Player> testList3 = new LinkedList<>();

        // Populating initial High Score List 1
        Player player1 = new Player();
        player1.setName("Claire A Voyant"); player1.setPlayerHighScore(194);
        Player player2 = new Player();
        player2.setName("Oswald the Sleek"); player2.setPlayerHighScore(195);
        Player player3 = new Player();
        player3.setName("Dave Davidson"); player3.setPlayerHighScore(196);
        Player player4 = new Player();
        player4.setName("Clarence Stranglethorn"); player4.setPlayerHighScore(197);
        Player player5 = new Player();
        player5.setName("Ignacious the Magnificent"); player5.setPlayerHighScore(198);
        Player player6 = new Player();
        player6.setName("Dirk Dirkenson"); player6.setPlayerHighScore(199);
        Player player7 = new Player();
        player7.setName("Marjorie the Unfriendly"); player7.setPlayerHighScore(200);
        Player player8 = new Player();
        player8.setName("Aaron A. Aardvark"); player8.setPlayerHighScore(201);
        Player player9 = new Player();
        player9.setName("Kirk van Houten"); player9.setPlayerHighScore(202);
        Player player10 = new Player();
        player10.setName("Stewart Meelor"); player10.setPlayerHighScore(203);

        testList.add(player1); testList.add(player2); testList.add(player3); testList.add(player4); testList.add(player5);
        testList.add(player6); testList.add(player7); testList.add(player8); testList.add(player9); testList.add(player10);

        // Populating initial High Score List 2
        Player player11 = new Player();
        player11.setName("Duke Nukem"); player11.setPlayerHighScore(194);
        Player player12 = new Player();
        player12.setName("Ubertron"); player12.setPlayerHighScore(195);
        Player player13 = new Player();
        player13.setName("Huey Lewis"); player13.setPlayerHighScore(196);
        Player player14 = new Player();
        player14.setName("Alasdair Millar"); player14.setPlayerHighScore(197);
        Player player15 = new Player();
        player15.setName("Kermit Erasmus"); player15.setPlayerHighScore(198);
        Player player16 = new Player();
        player16.setName("Leeroy Jenkins"); player16.setPlayerHighScore(199);
        Player player17 = new Player();
        player17.setName("Zdenek Z. Zeman"); player17.setPlayerHighScore(200);
        Player player18 = new Player();
        player18.setName("Juan Roman Riquelme"); player18.setPlayerHighScore(201);
        Player player19 = new Player();
        player19.setName("Stump Bee-fist"); player19.setPlayerHighScore(202);
        Player player20 = new Player();
        player20.setName("Blake Rakely"); player20.setPlayerHighScore(203);

        testList2.add(player11); testList2.add(player12); testList2.add(player13); testList2.add(player14); testList2.add(player15);
        testList2.add(player16); testList2.add(player17); testList2.add(player18); testList2.add(player19); testList2.add(player20);

        // Populating initial High Score List 3
        Player player21 = new Player();
        player21.setName("Malachy of Malta"); player21.setPlayerHighScore(194);
        Player player22 = new Player();
        player22.setName("Chesterfield Pennywhistle III"); player22.setPlayerHighScore(195);
        Player player23 = new Player();
        player23.setName("Spike Spiegel	"); player23.setPlayerHighScore(196);
        Player player24 = new Player();
        player24.setName("Rush Kendrar"); player24.setPlayerHighScore(197);
        Player player25 = new Player();
        player25.setName("Race Midnight"); player25.setPlayerHighScore(198);
        Player player26 = new Player();
        player26.setName("Leeroy Jenkins"); player26.setPlayerHighScore(199);
        Player player27 = new Player();
        player27.setName("Dutch Wagenbach"); player27.setPlayerHighScore(200);
        Player player28 = new Player();
        player28.setName("Sharon from Marketing"); player28.setPlayerHighScore(201);
        Player player29 = new Player();
        player29.setName("Shut Up Wesley"); player29.setPlayerHighScore(202);
        Player player30 = new Player();
        player30.setName("Dr. Colossus"); player30.setPlayerHighScore(203);

        testList3.add(player21); testList3.add(player22); testList3.add(player23); testList3.add(player24); testList3.add(player25);
        testList3.add(player26); testList3.add(player27); testList3.add(player28); testList3.add(player29); testList3.add(player30);

        testIO.fileWrite(testList, 1);
        testIO.fileWrite(testList2, 2);
        testIO.fileWrite(testList3, 3);

        //testIO.fileWrite(testList, 2);
        //testIO.fileRead(2);

        Stack<objectclasses.Card> testStack = cd.shuffledDeck();
        objectclasses.Card card1 = testStack.pop();
        System.out.println(card1.cardDetails());

        int i = 0;
        int j = 0;
        while(!testStack.isEmpty())
        {
            objectclasses.Card card = testStack.peek();
            System.out.println(card.cardDetails());
            j = j + card.getValue();
            testStack.pop();
            j++;
        }
        System.out.println(i);


        //aceSwapTestMode3();
        //stackTest();

        objectclasses.Card [] testHand = new objectclasses.Card[3];
        testHand[0] = new objectclasses.Card(objectclasses.CardSuit.CLUBS, objectclasses.CardValue.ACE);
        testHand[1] = new objectclasses.Card(objectclasses.CardSuit.CLUBS, objectclasses.CardValue.ACE);
        testHand[2] = new objectclasses.Card(objectclasses.CardSuit.CLUBS, objectclasses.CardValue.JACK);

        System.out.println(aceCheck(testHand));
    }

    public static int aceCheck (objectclasses.Card[] hand){
        int aceNum = 0 ;

        for(objectclasses.Card card: hand)
        {
            if (card.getCardValue() == objectclasses.CardValue.ACE ){
                aceNum++;
            }
        }
        return aceNum;
    }

    public static int aceTest (int targetVal, int handValue, int aceCount, int gameMode)
    {
        int handScore = 0;
        int swappedAces = 0; // keep a tally of aces being swapped

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
            if (aceCount == 0)
            {
                if (handValue <= targetVal) {
                    handScore = targetVal - handValue;
                } else {
                    handScore = targetVal;
                }
            }
            if (aceCount == 1)
            {   int swapCheck = handValue - (aceCount * 10); // Variable ascertaining value for when a hand is eligible for a swap
                if (swapCheck > 41) // Condition where it's worth swapping fulfilled
                {
                    handScore = targetVal - swapCheck;
                    swappedAces++;
                }
                if (swapCheck < 41) // Disadvantageous to swap
                {
                    handScore = targetVal - handValue;
                }
                if (swapCheck > 51) // Even with a swap will still exceed target score
                {
                    handScore = targetVal;
                }
            }
            if (aceCount == 2)
            {   int swapCheck = handValue - (aceCount * 10); // Variable ascertaining value for when a hand is eligible for a swap
                if (handValue > 61 && handValue <= 71) // Condition where it's worth swapping fulfilled 50 - 20
                {
                    swappedAces = 2;
                    handScore = targetVal - adjustedHand(handValue, swappedAces);
                    System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces +" )");
                }
                if (handValue >= 51 && handValue <= 61) // Condition where it's worth swapping fulfilled
                {
                    swappedAces = 1;
                    handScore = targetVal - adjustedHand(handValue, swappedAces);
                    System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces +" )");
                }
                if (handValue < 51) // Disadvantageous to swap
                {
                    handScore = targetVal - handValue;
                }
                if (handValue > 71) // Even with a swap will still exceed target score
                {
                    handScore = targetVal;
                }
            }
            if (aceCount == 3)
            {   int swapCheck = handValue - (aceCount * 10); // Variable ascertaining value for when a hand is eligible for a swap
                if (swapCheck > 19) // Condition where it's worth swapping fulfilled
                {
                    handScore = targetVal - swapCheck;
                    swappedAces = 3;
                }
                if (swapCheck < 19) // Disadvantageous to swap
                {
                    handScore = targetVal - handValue;
                }
                if (swapCheck > 51) // Even with a swap will still exceed target score
                {
                    handScore = targetVal;
                }
            }
            if (aceCount == 4)
            {   int swapCheck = handValue - (aceCount * 10); // Variable ascertaining value for when a hand is eligible for a swap
                if (swapCheck > 8) // Condition where it's worth swapping fulfilled
                {
                    handScore = targetVal - swapCheck;
                    swappedAces++;
                }
                if (swapCheck < 8) // Disadvantageous to swap
                {
                    handScore = targetVal - handValue;
                }
                if (swapCheck > 51) // Even with a swap will still exceed target score
                {
                    handScore = targetVal;
                }
            }

        }// end if gameMode == 2
        return handScore;

    }// End method handScore

    private static int adjustedHand(int existingHand, int numberAceSwaps)
    {
        int adjustedScore = existingHand - (10 * numberAceSwaps);
        return adjustedScore;
    }

    private static int generalisedAceSwap (int targetVal, int handValue, int aceCount, int gameMode) {
        int maxPossibleSwap = aceCount * 10;
        int handScore = 0;
        int swappedAces;

        if (gameMode == 2)
        {
            swappedAces = aceCount;
            // Swap all 4 aces in hand
            if (handValue > 81 && handValue <= 91 && maxPossibleSwap == 40)
            {
                System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
                handScore = targetVal - adjustedHand(handValue, swappedAces);
                //System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
            }
            // Swap all 3 aces in hand
            if (handValue > 71 && handValue <= 81 && maxPossibleSwap >= 30)
            {
                System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
                handScore = targetVal - adjustedHand(handValue, swappedAces);
                //System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
            }
            // Swap 2 aces in hand
            if (handValue > 61 && handValue <= 71 && maxPossibleSwap >= 20)
            {
                System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
                handScore = targetVal - adjustedHand(handValue, swappedAces);
                //System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
            }
            // Swap 1 ace held
            if (handValue > 51 && handValue <= 61)
            {
                handScore = targetVal - adjustedHand(handValue, swappedAces);
                //System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
            }
            // Always disadvantageous to swap
            if (handValue < 51)
            {
                handScore = targetVal - handValue;
            }
            // Even with a swap will still exceed target score, score = 51
            if (handValue - maxPossibleSwap > 51)
            {
                handScore = targetVal;
            }

        }// end if (gameMode == 2)

        if (gameMode == 3) {
            // Swap all 4 aces in hand
            if (handValue > 81 && handValue <= 91 && maxPossibleSwap == 40)
            {
                swappedAces = 4;
                System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
                handScore = targetVal - adjustedHand(handValue, swappedAces);
                //System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
            }
            // Swap all 3 aces if 3 held, or 3/4 if beneficial to player
            if (handValue > 71 && handValue <= 81 && maxPossibleSwap >= 30)
            {
                swappedAces = 3;
                System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
                handScore = targetVal - adjustedHand(handValue, swappedAces);
                //System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
            }
            // Swap both if 2 held, or 2 out of total aces in hand
            if (handValue > 61 && handValue <= 71 && maxPossibleSwap >= 20)
            {
                swappedAces = 2;
                System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
                handScore = targetVal - adjustedHand(handValue, swappedAces);
                //System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
            }
            // Swap single ace if 1 held, or 1 out of total aces in hand
            if (handValue > 51 && handValue <= 61) {
                swappedAces = 1;
                System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
                handScore = targetVal - adjustedHand(handValue, swappedAces);
                //System.out.println("\n(Aces Found " + aceCount + ", Aces Swapped " + swappedAces + " )");
            }
            // Always disadvantageous to swap
            if (handValue < 51)
            {
                handScore = targetVal - handValue;
            }
            // Even with a swap will still exceed target score, score = 51
            if (handValue - maxPossibleSwap > 51)
            {
                handScore = targetVal;
            }
        }// end if (gameMode == 3)

        return handScore;
    }// End method generalisedAceSwap

        public static void aceSwapTestMode2 ()
        {
            System.out.println("1 Ace");
            System.out.println("Hand Value 53");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 53, 1, 2));
            System.out.println("\nHand Value 35");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 35, 1, 2));
            System.out.println("\nHand Value 45, Ace Count 0: ");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 45, 0, 2));
            System.out.println("\nHand Value 30");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 30, 1, 2));
            System.out.println("\nHand Value 18");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 18, 1, 2));
            System.out.println("\nHand Value 61 Testing for a score of 0");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 61, 1, 2));

            System.out.println("\n2 Aces");
            System.out.println("\nHand Value 29");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 29, 2, 2));
            System.out.println("\nHand Value 30");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 30, 2, 2));
            System.out.println("\nHand Value 58");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 58, 2, 2));

            System.out.println("\n3 Aces");
            System.out.println("\nHand Value 60");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 60, 3, 2));
            System.out.println("\nHand Value 30");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 30, 3, 2));
            System.out.println("\nHand Value 18");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 18, 3, 2));
            System.out.println("\nHand Value 78");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 78, 3, 2));

            System.out.println("\n4 Aces");
            System.out.println("\nHand Value 46");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 46, 4, 2));
            System.out.println("\nHand Value 89");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 89, 4, 2));
            System.out.println("\nHand Value 82");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 82, 4, 2));
        }

        public static void aceSwapTestMode3 ()
        {
            // Don't need as doesn't have branching conditions
//        System.out.println("1 Ace");
//        System.out.println("Hand Value 53"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 53, 1, 2));
//        System.out.println("\nHand Value 35"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 35, 1, 2));
//        System.out.println("\nHand Value 45, Ace Count 0: "); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 45, 0, 2));
//        System.out.println("\nHand Value 30"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 30, 1, 2));
//        System.out.println("\nHand Value 18"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 18, 1, 2));
//        System.out.println("\nHand Value 61 Testing for a score of 0"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 61, 1, 2));

            System.out.println("\n2 Aces");
            System.out.println("\nHand Value 29");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 29, 2, 2));
            System.out.println("\nHand Value 30");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 30, 2, 2));
            System.out.println("\nHand Value 58");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 58, 2, 2));
            System.out.println("\nHand Value 61");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 61, 2, 2));
            System.out.println("\nHand Value 70");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 70, 2, 2));
            System.out.println("\nHand Value 44");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 44, 2, 2));
            System.out.println("\nHand Value 90");
            System.out.print("Swapped score - ");
            System.out.println(aceTest(51, 90, 2, 2));

            System.out.println("\nGeneralised Ace tests_notes.Test - Game Mode 2");
            System.out.println("\nHand Value 69, Ace Count 3");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 69, 3, 2));
            System.out.println("\nHand Value 91, Ace Count 4");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 91, 4, 2));
            System.out.println("\nHand Value 69, Ace Count 1");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 69, 1, 2));
            System.out.println("\nHand Value 71, Ace Count 2");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 71, 2, 2));
            System.out.println("\nHand Value 70, Ace Count 3");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 70, 3, 2));
            System.out.println("\nHand Value 91, Ace Count 4");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 91, 4, 2));
            System.out.println("\nHand Value 150, Ace Count 4");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 150, 4, 2));

            System.out.println("\nGeneralised Ace tests_notes.Test - Game Mode 3");
            System.out.println("\nHand Value 69, Ace Count 3");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 69, 3, 3));
            System.out.println("\nHand Value 91, Ace Count 4");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 91, 4, 3));
            System.out.println("\nHand Value 69, Ace Count 1");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 69, 1, 3));
            System.out.println("\nHand Value 71, Ace Count 2");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 71, 2, 3));
            System.out.println("\nHand Value 70, Ace Count 3");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 70, 3, 3));
            System.out.println("\nHand Value 91, Ace Count 4");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 91, 4, 3));
            System.out.println("\nHand Value 150, Ace Count 4");
            System.out.print("Swapped score - ");
            System.out.println(generalisedAceSwap(51, 150, 4, 3));

//        System.out.println("\n3 Aces");
//        System.out.println("\nHand Value 60"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 60, 3, 2));
//        System.out.println("\nHand Value 30"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 30, 3, 2));
//        System.out.println("\nHand Value 18"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 18, 3, 2));
//        System.out.println("\nHand Value 78"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 78, 3, 2));

//        System.out.println("\n4 Aces");
//        System.out.println("\nHand Value 46"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 46, 4, 2));
//        System.out.println("\nHand Value 89"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 89, 4, 2));
//        System.out.println("\nHand Value 82"); System.out.print("Swapped score - ");
//        System.out.println(aceTest(51, 82, 4, 2));
        }
        /*
        public static void stackTest()
        {
            objectclasses.objectclasses.CardDeck deck = new objectclasses.objectclasses.CardDeck();
            objectclasses.objectclasses.Card[] shuf = deck.shuffledDeck();
            Stack<objectclasses.objectclasses.Card> test = new Stack<>();
            objectclasses.objectclasses.Card c = new objectclasses.objectclasses.Card();

            for (int i = 0; i < 52; i++)
            {
                objectclasses.objectclasses.CardSuit suit = shuf[i].getSuit2();
                objectclasses.objectclasses.CardValue value = shuf[i].getValue2();
                c.setCard(suit, value);
                test.add(c);
                System.out.println("Added");
            }

            String Ans = "";


            Object[] yargh = test.toArray();
            for (int i = 0; i < 52; i++)
            {
                System.out.println(yargh[i]);
            }

            while (!test.empty())
            {
                test.peek(); System.out.println("Peek");
                test.pop(); System.out.println("Pop");

                if(test.contains(c)){
                System.out.println("Yes");
                }
            }




         }
         */


}// End class test

