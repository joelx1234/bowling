package org.interview.bowling;

import org.interview.bowling.input.GameInput;
import org.interview.bowling.pins.AimCalculator;
import org.interview.bowling.pins.Direction;
import org.interview.bowling.pins.PinFallDirectionGenerator;

public class BowlingTestUtil {

    public static char[][] createBowlingLane() {
        return new char[][]{
                {' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' '},
                {' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' '},
                {' ', ' ', ' ', 'o', ' ', 'o', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'o', ' ', ' ', ' ', ' '}
        };
    }

    public static char[][] createEmptyBowlingLane() {
        return new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
    }

    public static class MockPinFallDirectionGenerator implements PinFallDirectionGenerator {

        Direction direction = Direction.LEFT;

        @Override
        public Direction fall() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }
    }

    public static class MockAimCalculator implements AimCalculator {

        private int newPosition = 0;

        @Override
        public int aim(int position) {
            return this.newPosition;
        }

        public void setNewPosition(int newPosition) {
            this.newPosition = newPosition;
        }
    }

    public static class MockGameInput implements GameInput {

        private int newPosition = 4;

        @Override
        public int getAimPosition() {
            return newPosition;
        }

        public void setNewPosition(int newPosition) {
            this.newPosition = newPosition;
        }
    }

}
