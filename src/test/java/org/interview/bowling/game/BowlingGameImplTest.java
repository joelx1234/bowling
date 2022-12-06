package org.interview.bowling.game;

import org.interview.bowling.pins.Direction;
import org.interview.bowling.pins.random.PinFallRandom;
import org.interview.bowling.score.traditional.ScoreTraditional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.interview.bowling.BowlingTestUtil.MockPinFallDirectionGenerator;
import static org.interview.bowling.BowlingTestUtil.MockAimCalculator;
import static org.interview.bowling.BowlingTestUtil.MockGameInput;

public class BowlingGameImplTest {

    private MockPinFallDirectionGenerator generator = new MockPinFallDirectionGenerator();
    private MockAimCalculator aimCalculator = new MockAimCalculator();

    private MockGameInput input = new MockGameInput();

    @Test
    public void startGameWithMaxScoreTest() {
        BowlingGame game = new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(generator), aimCalculator, input);
        game.setPinsUp();
        generator.setDirection(Direction.BOTH);
        aimCalculator.setNewPosition(4);
        input.setNewPosition(4);

        game.startGame();
        Assertions.assertEquals(300, game.getScore().getCurrentScore());
        Assertions.assertTrue(game.getScore().isGameEnded());
    }

    @Test
    public void startGameWithMinScoreTest() {
        BowlingGame game = new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(generator), aimCalculator, input);
        game.setPinsUp();
        generator.setDirection(Direction.BOTH);
        aimCalculator.setNewPosition(0);
        input.setNewPosition(4);

        game.startGame();
        Assertions.assertEquals(0, game.getScore().getCurrentScore());
        Assertions.assertTrue(game.getScore().isGameEnded());
    }

    @Test
    public void startGameWithLowScoreTest() {
        BowlingGame game = new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(generator), aimCalculator, input);
        game.setPinsUp();
        generator.setDirection(Direction.LEFT);
        aimCalculator.setNewPosition(1);
        input.setNewPosition(1);

        game.startGame();
        Assertions.assertEquals(10, game.getScore().getCurrentScore());
        Assertions.assertTrue(game.getScore().isGameEnded());
    }

    @Test
    public void testRollStrike() {
        BowlingGame game = new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(generator), aimCalculator, input);
        game.setPinsUp();
        generator.setDirection(Direction.BOTH);
        aimCalculator.setNewPosition(4);
        input.setNewPosition(4);

        int result = game.roll();
        Assertions.assertEquals(10, result); //STRIKE

        game.setPinsUp();
        generator.setDirection(Direction.LEFT);
        aimCalculator.setNewPosition(1);
        result = game.roll();
        Assertions.assertEquals(1, result);

        result = game.roll();
        Assertions.assertEquals(0, result);

    }

    @Test
    public void testRollSpare() {
        BowlingGame game = new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(generator), aimCalculator, input);
        game.setPinsUp();
        generator.setDirection(Direction.BOTH);
        aimCalculator.setNewPosition(0);
        input.setNewPosition(4);

        int result = game.roll();
        Assertions.assertEquals(0, result);

        aimCalculator.setNewPosition(4);
        result = game.roll();
        Assertions.assertEquals(10, result);
    }

    @Test
    public void testRollGutterBall() {
        BowlingGame game = new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(generator), aimCalculator, input);
        game.setPinsUp();
        generator.setDirection(Direction.BOTH);
        aimCalculator.setNewPosition(0);
        input.setNewPosition(4);

        int result = game.roll();
        Assertions.assertEquals(0, result);

        result = game.roll();
        Assertions.assertEquals(0, result);

        result = game.roll();
        Assertions.assertEquals(0, result);
    }

    @Test
    public void rollTestWithNoPins() {
        BowlingGame game = new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(generator), aimCalculator, input);
        int result = game.roll();
        Assertions.assertEquals(0, result);
    }

    @Test
    public void setPinsUpTest() {
        BowlingGame game = new BowlingGameImpl(new ScoreTraditional(), new PinFallRandom(generator), aimCalculator, input);

        int result = game.roll();
        Assertions.assertEquals(0, result);

        game.setPinsUp();

        generator.setDirection(Direction.BOTH);
        aimCalculator.setNewPosition(4);
        input.setNewPosition(4);

        result = game.roll();
        Assertions.assertEquals(10, result);

        result = game.roll();
        Assertions.assertEquals(0, result);

        result = game.roll();
        Assertions.assertEquals(0, result);

        game.setPinsUp();

        result = game.roll();
        Assertions.assertEquals(10, result);
    }

}
