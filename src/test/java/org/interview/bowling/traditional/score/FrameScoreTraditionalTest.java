package org.interview.bowling.traditional.score;

import org.interview.bowling.score.BowlingScoreType;
import org.interview.bowling.score.FrameScore;
import org.interview.bowling.score.traditional.FrameScoreTraditional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrameScoreTraditionalTest {

    @Test
    public void addScoreTest() {
        FrameScore f = new FrameScoreTraditional();
        f.addScore(1);


        Assertions.assertEquals(0, f.getScore());
        Assertions.assertTrue(f.isScorePending());
        Assertions.assertFalse(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.NORMAL);

        f.addScore(3);

        Assertions.assertEquals(4, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.NORMAL);
    }

    @Test
    public void addScoreToCompletedFrameTest() {
        FrameScore f = new FrameScoreTraditional();
        f.addScore(1);
        f.addScore(3);

        Assertions.assertEquals(4, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());

        f.addScore(3);

        Assertions.assertEquals(4, f.getScore()); //score remains unchanged
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
    }

    @Test
    public void addScoreWithStikeTest() {
        FrameScore f = new FrameScoreTraditional();
        f.addScore(10);

        Assertions.assertEquals(0, f.getScore());
        Assertions.assertTrue(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.STRIKE);

        f.addBonus(4);

        Assertions.assertEquals(0, f.getScore());
        Assertions.assertTrue(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.STRIKE);

        f.addBonus(3);

        Assertions.assertEquals(17, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.STRIKE);
    }

    @Test
    public void addScoreWithStikeToCompletedFrameTest() {
        FrameScore f = new FrameScoreTraditional();
        f.addScore(10);
        f.addBonus(4);
        f.addBonus(3);

        Assertions.assertEquals(17, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());

        f.addScore(2);
        Assertions.assertEquals(17, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());

        f.addBonus(5);
        Assertions.assertEquals(17, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());

        f.addBonus(6);
        Assertions.assertEquals(17, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());

    }

    @Test
    public void addScoreWithSpareTest() {
        FrameScore f = new FrameScoreTraditional();
        f.addScore(6);

        Assertions.assertEquals(0, f.getScore());
        Assertions.assertTrue(f.isScorePending());
        Assertions.assertFalse(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.NORMAL);

        f.addScore(4);

        Assertions.assertEquals(0, f.getScore());
        Assertions.assertTrue(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.SPARE);

        f.addBonus(3);

        Assertions.assertEquals(13, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.SPARE);
    }


    @Test
    public void addScoreWithSpareToCompletedFrameTest() {
        FrameScore f = new FrameScoreTraditional();
        f.addScore(6);
        f.addScore(4);
        f.addBonus(3);

        Assertions.assertEquals(13, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.SPARE);

        f.addScore(9);
        Assertions.assertEquals(13, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.SPARE);

        f.addScore(7);
        Assertions.assertEquals(13, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.SPARE);

        f.addBonus(8);
        Assertions.assertEquals(13, f.getScore());
        Assertions.assertFalse(f.isScorePending());
        Assertions.assertTrue(f.isFrameComplete());
        Assertions.assertEquals(f.getScoreType(), BowlingScoreType.SPARE);

    }

}
