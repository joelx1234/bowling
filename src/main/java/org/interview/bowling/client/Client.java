package org.interview.bowling.client;

import org.interview.bowling.game.BowlingGame;
import org.interview.bowling.game.BowlingGameFactory;

public class Client {

    public static void main(String args[]) {
        BowlingGame game = BowlingGameFactory.createBowlingGameRandomImpl();
        game.startGame();
    }

}
