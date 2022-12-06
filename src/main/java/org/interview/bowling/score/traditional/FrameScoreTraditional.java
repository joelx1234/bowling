package org.interview.bowling.score.traditional;

import org.interview.bowling.score.BowlingScoreType;
import org.interview.bowling.score.FrameScore;

public class FrameScoreTraditional implements FrameScore {

    private int score;
    private int turn;
    private int bonusScoreCounter;
    private BowlingScoreType scoreType = BowlingScoreType.NORMAL;

    @Override
    public BowlingScoreType getScoreType() {
        return scoreType;
    }

    @Override
    public void addScore(int points) {
        if (!isFrameComplete()) {
            this.score = this.score + points;

            if (turn == 0 && score == 10) {
                scoreType = BowlingScoreType.STRIKE;
            } else if (turn == 1 && score == 10) {
                scoreType = BowlingScoreType.SPARE;
            } else {
                scoreType = BowlingScoreType.NORMAL;
            }

            turn++;
        }
    }

    @Override
    public void addBonus(int points) {
        if (isScorePending()) {
            this.score = this.score + points;
            bonusScoreCounter++;
        }
    }

    @Override
    public boolean isScorePending() {

        if (scoreType == BowlingScoreType.STRIKE && bonusScoreCounter == 2) {
            return false;
        } else if (scoreType == BowlingScoreType.SPARE && bonusScoreCounter == 1) {
            return false;
        } else if (scoreType == BowlingScoreType.NORMAL && turn == 2) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int getScore() {
        if (isScorePending()) {
            return 0;
        } else {
            return score;
        }
    }

    @Override
    public boolean isFrameComplete() {
        if (scoreType != BowlingScoreType.NORMAL) {
            return true;
        } else {
            return turn > 1;
        }
    }

}
