package org.interview.bowling.pins.random;

import org.interview.bowling.pins.Direction;
import org.interview.bowling.pins.PinFall;
import org.interview.bowling.BowlingTestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.interview.bowling.BowlingTestUtil.MockPinFallDirectionGenerator;

public class PinFallRandomTest {

    private MockPinFallDirectionGenerator generator = new MockPinFallDirectionGenerator();

    @Test
    public void calculatePinFallWithNoHit() {
        PinFall fall = new PinFallRandom(generator);
        generator.setDirection(Direction.LEFT);

        char[][] bowlinglane = BowlingTestUtil.createBowlingLane();

        char[][] expectedBowlingLane = BowlingTestUtil.createBowlingLane();

        int points = fall.calculatePinFall(3, 5, bowlinglane, 0);

        Assertions.assertArrayEquals(expectedBowlingLane, bowlinglane);
        Assertions.assertEquals(0, points);
    }

    @Test
    public void calculatePinFallLeftTest() {
        PinFall fall = new PinFallRandom(generator);
        generator.setDirection(Direction.LEFT);

        char[][] bowlinglane = BowlingTestUtil.createBowlingLane();

        char[][] expectedBowlingLane = new char[][]{
                {' ', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' '},
                {' ', ' ', ' ', ' ', 'o', ' ', 'o', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', 'o', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        int points = fall.calculatePinFall(3, 4, bowlinglane, 0);

        Assertions.assertArrayEquals(expectedBowlingLane, bowlinglane);
        Assertions.assertEquals(4, points);
    }

    @Test
    public void calculatePinFallRightTest() {
        PinFall fall = new PinFallRandom(generator);
        generator.setDirection(Direction.RIGHT);

        char[][] bowlinglane = BowlingTestUtil.createBowlingLane();

        char[][] expectedBowlingLane = new char[][]{
                {' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', ' '},
                {' ', ' ', 'o', ' ', 'o', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'o', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        int points = fall.calculatePinFall(3, 4, bowlinglane, 0);

        Assertions.assertArrayEquals(expectedBowlingLane, bowlinglane);
        Assertions.assertEquals(4, points);
    }

    @Test
    public void calculatePinFallLeftMissingPinTest() {
        PinFall fall = new PinFallRandom(generator);
        generator.setDirection(Direction.LEFT);

        char[][] bowlinglane = new char[][]{
                {' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' '},
                {' ', ' ', ' ', ' ', 'o', ' ', 'o', ' ', ' '},
                {' ', ' ', ' ', 'o', ' ', 'o', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'o', ' ', ' ', ' ', ' '}
        };

        char[][] expectedBowlingLane = new char[][]{
                {' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' '},
                {' ', ' ', ' ', ' ', 'o', ' ', 'o', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', 'o', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        int points = fall.calculatePinFall(3, 4, bowlinglane, 0);

        Assertions.assertArrayEquals(expectedBowlingLane, bowlinglane);
        Assertions.assertEquals(2, points);

    }

    @Test
    public void calculatePinFallRightMissingPinTest() {
        PinFall fall = new PinFallRandom(generator);
        generator.setDirection(Direction.RIGHT);

        char[][] bowlinglane = new char[][]{
                {' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' '},
                {' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' '},
                {' ', ' ', ' ', 'o', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'o', ' ', ' ', ' ', ' '}
        };

        char[][] expectedBowlingLane = new char[][]{
                {' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' '},
                {' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' '},
                {' ', ' ', ' ', 'o', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        int points = fall.calculatePinFall(3, 4, bowlinglane, 0);

        Assertions.assertArrayEquals(expectedBowlingLane, bowlinglane);
        Assertions.assertEquals(1, points);

    }

    @Test
    public void calculatePinFallLeftAndRightTest() {
        PinFall fall = new PinFallRandom(generator);
        generator.setDirection(Direction.LEFT);

        char[][] bowlinglane = BowlingTestUtil.createBowlingLane();

        int points = fall.calculatePinFall(3, 4, bowlinglane, 0);
        Assertions.assertEquals(4, points);

        generator.setDirection(Direction.RIGHT);
        points = fall.calculatePinFall(2, 5, bowlinglane, points);

        char[][] expectedBowlingLane = new char[][]{
                {' ', ' ', ' ', 'o', ' ', 'o', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'o', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        Assertions.assertArrayEquals(expectedBowlingLane, bowlinglane);
        Assertions.assertEquals(7, points);
    }


    @Test
    public void calculatePinFallBoth() {
        PinFall fall = new PinFallRandom(generator);
        generator.setDirection(Direction.BOTH);

        char[][] bowlinglane = BowlingTestUtil.createBowlingLane();

        int points = fall.calculatePinFall(3, 4, bowlinglane, 0);

        char[][] expectedBowlingLane = BowlingTestUtil.createEmptyBowlingLane();

        Assertions.assertArrayEquals(expectedBowlingLane, bowlinglane);
        Assertions.assertEquals(10, points);
    }


}
