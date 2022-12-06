package org.interview.bowling.pins.random;

import org.interview.bowling.pins.AimCalculator;

public class RandomAim implements AimCalculator {

    /**
     * 70% chance to hit your position
     * 10% chance to fully miss
     * 10% chance to miss slightly left
     * 10% chance to miss slightly right
     */
    @Override
    public int aim(int position) {
        double val = Math.random();

        if (val < 0.1) {
            return 0;
        } else if (val < 0.2) {
            return Math.max(0, position - 1);
        } else if (val < 0.3) {
            return Math.min(8, position + 1);
        } else {
            return position;
        }
    }

}
