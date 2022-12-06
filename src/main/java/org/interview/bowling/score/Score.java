package org.interview.bowling.score;

public interface Score {

    void addPoints(int points);

    int getCurrentScore();

    boolean isGameEnded();

    int getCurrentFrame();

    void printScoreBoard();

    void resetScore();

}
