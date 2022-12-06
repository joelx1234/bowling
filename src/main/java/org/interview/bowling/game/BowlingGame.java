package org.interview.bowling.game;

import org.interview.bowling.score.Score;

public interface BowlingGame {

    void setPinsUp();

    void printBowlingLane();

    int roll();

    void startGame();

    Score getScore();
}
