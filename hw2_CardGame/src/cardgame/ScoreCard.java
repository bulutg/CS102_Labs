package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author: Bulut Gozubuyuk
// date: 18.10.2019
public class ScoreCard {
    // properties
    int[] scores;

    // constructors
    public ScoreCard(int noOfPlayers) {
        scores = new int[noOfPlayers];

        // init all scores to zero
        for (int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }

    // methods
    public int getScore(int playerNo) {
        return scores[playerNo];
    }

    public void update(int playerNo, int amount) {
        scores[playerNo] += amount;
    }

    public String toString() {
        String s;
        s = "\n"
                + "_____________\n"
                + "\nPlayer\tScore\n"
                + "_____________\n";

        for (int playerNo = 0; playerNo < scores.length; playerNo++) {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }

        s += "_____________\n";
        return s;
    }

    public int[] getWinners() {
        int highestScore = 0;
        int size = 0;
        int[] winnerSet;
        int[] tmp = new int[4];

        for (int i : scores) {
            if (i > highestScore) highestScore = i;
        }

        for (int j = 0; j < 4; j++) {
            if (scores[j] == highestScore) {
                tmp[size++] = j;
            }
        }

        winnerSet = new int[size];
        for (int k = 0; k < size; k++) {
            winnerSet[k] = tmp[k];
        }

        return winnerSet;
    }

} // end class ScoreCard
