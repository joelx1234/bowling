package org.interview.bowling.pins.random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomAimTest {

    @Test
    public void testRandomAim() {
        RandomAim aim = new RandomAim();

        for (int x = 0; x < 100; x++) {
            int result = aim.aim(4);
            Assertions.assertTrue(result <= 8 && result >= 0);
        }
    }

}
