import java.util.Scanner;

import cardgame.*;

// CardGameTest
// author: Bulut Gozubuyuk
// date: 18.10.2019
public class CardGameTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Start of CardGameTest\n");

        // CONSTANTS

        // VARIABLES
        Card c;
        Cards cards;
        ScoreCard scores;
        Player p;
        CardGame game;

        // PROGRAM CODE

        // test Card class
        c = new Card(1);
        System.out.println(c);
        System.out.println();

        // test Cards class
        cards = new Cards(true);
        cards.addTopCard(c);
        cards.testOnlyPrint();  // remove method after testing!

        // test ScoreCard class
        scores = new ScoreCard(4);
        scores.update(3, 1);
        scores.update(1, 2);
        System.out.println("\n" + scores);

        // test Player class
        p = new Player("Bulut");

        // test CardGame class too?
        game = new CardGame(p, new Player("Berk"), new Player("Onat"), new Player("Kutsal"));

        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.

        System.out.println("\nEnd of CardGameTest\n");
    }

} // end of class CardGameTest
