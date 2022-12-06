package org.interview.bowling.game;

import org.interview.bowling.input.CommandLineInput;
import org.interview.bowling.pins.random.PinFallDirectionGeneratorRandom;
import org.interview.bowling.pins.random.PinFallRandom;
import org.interview.bowling.pins.random.RandomAim;
import org.interview.bowling.score.traditional.ScoreTraditional;

public final class BowlingGameFactory {

    private BowlingGameFactory() {
    }

    public static BowlingGame createBowlingGameRandomImpl() {
        return new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(new PinFallDirectionGeneratorRandom()), new RandomAim(), new CommandLineInput());
    }

}
