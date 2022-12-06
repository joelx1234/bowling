package org.interview.bowling.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameFactoryTest {

    @Test
    public void createBowlingGameRandomImpl(){
        BowlingGame game = BowlingGameFactory.createBowlingGameRandomImpl();
        Assertions.assertTrue(game instanceof BowlingGameImpl);
    }
}
