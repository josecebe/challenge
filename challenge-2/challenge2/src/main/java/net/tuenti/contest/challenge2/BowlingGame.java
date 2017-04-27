package net.tuenti.contest.challenge2;

import java.util.ArrayList;
import java.util.List;

/**
 * TuentiChallenge7 -  Challenge 2
 * @author Jose Cebellán
 */
public class BowlingGame {
    private List<Integer> rolls;

    public BowlingGame(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public List<Integer> getScores() {
        List<Integer> scores = new ArrayList<Integer>();
        boolean nextRound = false;
        int frame = 0;
        int roundScore = 0;
        int roundRoll = 1;

        for (int round = 0; round < 10;) {
            int rollScore = rolls.get(frame);
            roundScore += rollScore;

            switch(roundRoll) {
                case 1:
                    if (isStrikeOrSpare(roundScore)) {
                        roundScore += rolls.get(frame+1);
                        roundScore += rolls.get(frame+2);
                        nextRound = true;
                    }
                    break;

                case 2:
                    if (isStrikeOrSpare(roundScore)) {
                        roundScore += rolls.get(frame+1);
                    }
                    nextRound = true;
                    break;
            }

            if (nextRound) {
                if (scores.isEmpty()) {
                    scores.add(roundScore);
                } else {                    
                    scores.add(scores.get(scores.size()-1) + roundScore);
                }
                round++;
                roundScore = 0;
                roundRoll = 1;
                nextRound = false;
            } else {
                roundRoll++;
            }
            frame++;
        }

        return scores;
    }

    private boolean isStrikeOrSpare(int points) {
        if (points == 10) {
            return true;
        } else {
            return false;
        }
    }
}
