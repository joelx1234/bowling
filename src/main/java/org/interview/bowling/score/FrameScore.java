package org.interview.bowling.score;

public interface FrameScore {

    void addScore(int points);

    void addBonus(int points);

    boolean isScorePending();

    int getScore();

    boolean isFrameComplete();

    BowlingScoreType getScoreType();
}
