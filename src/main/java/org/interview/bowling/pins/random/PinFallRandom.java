package org.interview.bowling.pins.random;

import org.interview.bowling.pins.Direction;
import org.interview.bowling.pins.PinFall;
import org.interview.bowling.pins.PinFallDirectionGenerator;

public class PinFallRandom implements PinFall {

    private static final char EMPTY = ' ';
    private static final char PIN = 'o';

    private final PinFallDirectionGenerator directionGenerator;

    public PinFallRandom(PinFallDirectionGenerator directionGenerator){
        this.directionGenerator = directionGenerator;
    }

    /**'
     * This method determines if a pin is hit and the way the pin falls, thus determining if it hits other pins.
     * The bowlingLane array is updated accordingly
     * Total pin fall count is returned
     * @param row row of potential pin hit
     * @param position index of potential pin hit
     * @param bowlingLane 2d array representing a bowling lane
     * @param points total pin fall
     * @return
     */
    @Override
    public int calculatePinFall(int row, int position, char[][] bowlingLane, int points) {

        if (bowlingLane[row][position] == PIN) {
            bowlingLane[row][position] = EMPTY;
            points++;

            if(row > 0) {
                Direction direction = directionGenerator.fall();
                if(direction == Direction.LEFT || direction == Direction.BOTH) {
                    if(position > 1) {
                        points = calculatePinFall(row - 1, position - 1, bowlingLane, points);
                    }
                }
                if(direction == Direction.RIGHT || direction == Direction.BOTH) {
                    if(position < 8) {
                        points = calculatePinFall(row - 1, position + 1, bowlingLane, points);
                    }
                }
            }
        }

        return points;
    }

}
