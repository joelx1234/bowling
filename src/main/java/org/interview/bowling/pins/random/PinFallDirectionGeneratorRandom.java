package org.interview.bowling.pins.random;

import org.interview.bowling.pins.Direction;
import org.interview.bowling.pins.PinFallDirectionGenerator;

public class PinFallDirectionGeneratorRandom implements PinFallDirectionGenerator {
    @Override
    public Direction fall() {
        Double val = Math.random();
        if(val <= 0.2) {
            return Direction.LEFT;
        } else if(val <= 0.4) {
            return Direction.RIGHT;
        } else {
            return Direction.BOTH;
        }
    }
}
