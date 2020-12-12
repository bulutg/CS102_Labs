package cardgame;

import java.util.Random;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: Bulut Gozubuyuk
// date: 18.10.2019
public class Cards {

    private final Random random;
    final int NOOFCARDSINFULLPACK = 52;

    // properties
    Card[] cards;
    int valid;  // number of cards currently in collection

    // constructors
    public Cards(boolean fullPack) {
        cards = new Card[NOOFCARDSINFULLPACK];
        valid = 0;

        random = new Random();

        if (fullPack)
            createFullPackOfCards();
    }

    // methods
    public Card getTopCard() {
        Card tmp;

        if (valid <= 0)
            return null;
        else {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }

    public boolean addTopCard(Card c) {
        if (valid < cards.length) {
            cards[valid] = c;   // should this be cloned?
            valid++;
            return true;
        }
        return false;
    }

    private void createFullPackOfCards() {
        for (int i = 0; i < NOOFCARDSINFULLPACK; i++) {
            Card card = new Card(i);
            addTopCard(card);
        }
//        addTopCard( new Card(0) );
//        addTopCard( new Card(25) );
//        addTopCard( new Card(13) );
    }

    public void shuffle() {
        for (int i = cards.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Card a = cards[index];
            cards[index] = cards[i];
            cards[i] = a;
        }
    }


    // For testOnly... remove from production version!
    public void testOnlyPrint() {
        for (int i = 0; i < valid; i++) {
            System.out.println(cards[i]);
        }
    }

} // end class Cards
