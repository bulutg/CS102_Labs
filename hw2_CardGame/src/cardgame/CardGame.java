package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Bulut Gozubuyuk
// date: 18.10.2019
public class CardGame {
    // properties
    Cards fullPack;
    ArrayList<Player> players;
    ArrayList<Integer> roundWinners;
    ScoreCard scoreCard;
    Cards[] cardsOnTable;
    Player[] winnerSet;
    int roundNo;
    int turnOfPlayer;

    // constructors
    public CardGame(Player p1, Player p2, Player p3, Player p4) {
        roundNo = 1;
        turnOfPlayer = 1;

        players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);

        fullPack = new Cards(true);
        fullPack.shuffle();

        scoreCard = new ScoreCard(players.size());
        cardsOnTable = new Cards[52];

        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < 13; j++) {
                players.get(i).add(fullPack.getTopCard());
            }
        }
    }

    // methods
    public boolean playTurn(Player p, Card c) {
        if (isGameOver()) {
            return false;
        } else if (!isTurnOf(p)) {
            return false;
        } else {

            Card card = p.playCard();
            if (!c.equals(card)) {
                // if not end of round then
                p.add(card);
                if (turnOfPlayer != 4) {
                    // move to next players turn
                    turnOfPlayer++;
                } else {
                    turnOfPlayer = 1;
                    if (roundNo < 14) {
                        roundNo++;
                    }
                }

                return false;
            } else {
                // p's turn so take p's card & put on table
                cardsOnTable[roundNo].addTopCard(card);

                if (turnOfPlayer != 4) {
                    turnOfPlayer++;
                } else {
                    turnOfPlayer = 1;
                    roundWinners = new ArrayList<>();
                    Card highestCard = new Card(0);
                    int tableLength = cardsOnTable[roundNo].cards.length;

                    for (int i = 0; i < tableLength; i++) {
                        if (cardsOnTable[roundNo].cards[i].getFaceValue() > highestCard.getFaceValue()) {
                            highestCard = cardsOnTable[roundNo].cards[i];
                        }
                    }

                    for (int i = 0; i < tableLength; i++) {
                        if (cardsOnTable[roundNo].cards[i].getFaceValue() == highestCard.getFaceValue()) {
                            roundWinners.add(i);
                        }
                    }

                    // end of round, update scores
                    for (int i : roundWinners) {
                        scoreCard.update(i, 1);
                    }
                    if (roundNo < 14) {
                        roundNo++;
                    }
                }
                return true;
            }
        }
    }

    public boolean isTurnOf(Player p) {
        if (p.equals(players.get(0))) {
            if (turnOfPlayer == 1) return true;
        } else if (p.equals(players.get(1))) {
            if (turnOfPlayer == 2) return true;
        } else if (p.equals(players.get(2))) {
            if (turnOfPlayer == 3) return true;
        } else if (p.equals(players.get(3))) {
            if (turnOfPlayer == 4) return true;
        }
        return false;
    }

    public boolean isGameOver() {
        if (roundNo == 14) {
            return true;
        } else {
            return false;
        }
    }

    public int getScore(int playerNumber) {
        return scoreCard.getScore(playerNumber);
    }

    public String getName(int playerNumber) {
        return players.get(playerNumber).getName();
    }

    public int getRoundNo() {
        return roundNo;
    }

    public int getTurnOfPlayerNo() {
        return turnOfPlayer;
    }

    public Player[] getWinners() {
        winnerSet = new Player[scoreCard.getWinners().length];

        for (int i = 0; i < scoreCard.getWinners().length; i++) {
            winnerSet[i] = players.get(scoreCard.getWinners()[i]);
        }
        return winnerSet;
    }

    public String showScoreCard() {
        return scoreCard.toString();
    }

}