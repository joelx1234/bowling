package org.interview.bowling.traditional.score;

import org.interview.bowling.score.Score;
import org.interview.bowling.score.traditional.ScoreTraditional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreTraditionalTest {

    @Test
    public void addPointsTest() {
        Score score = new ScoreTraditional();
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(10); //Frame 1
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(5); //Frame 2
        Assertions.assertEquals(0, score.getCurrentScore());
        score.addPoints(4);
        Assertions.assertEquals(28, score.getCurrentScore());

        score.addPoints(9); //Frame 3
        Assertions.assertEquals(28, score.getCurrentScore());
        score.addPoints(1);
        Assertions.assertEquals(28, score.getCurrentScore());

        score.addPoints(5); //Frame 4
        Assertions.assertEquals(43, score.getCurrentScore());
        score.addPoints(1);
        Assertions.assertEquals(49, score.getCurrentScore());

        score.addPoints(1); //Frame 5
        Assertions.assertEquals(49, score.getCurrentScore());
        score.addPoints(1);
        Assertions.assertEquals(51, score.getCurrentScore());

        score.addPoints(1); //Frame 6
        Assertions.assertEquals(51, score.getCurrentScore());
        score.addPoints(1);
        Assertions.assertEquals(53, score.getCurrentScore());

        score.addPoints(1); //Frame 7
        Assertions.assertEquals(53, score.getCurrentScore());
        score.addPoints(1);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(0); //Frame 8
        Assertions.assertEquals(55, score.getCurrentScore());
        score.addPoints(0);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(0); //Frame 9
        Assertions.assertEquals(55, score.getCurrentScore());
        score.addPoints(0);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(0); //Frame 10
        Assertions.assertEquals(55, score.getCurrentScore());
        score.addPoints(0);
        Assertions.assertEquals(55, score.getCurrentScore());
    }

    @Test
    public void tripleStikeInFinalFrameTest() {
        Score score = new ScoreTraditional();
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(10); //Frame 1
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(5); //Frame 2
        score.addPoints(4);
        Assertions.assertEquals(28, score.getCurrentScore());

        score.addPoints(9); //Frame 3
        score.addPoints(1);
        Assertions.assertEquals(28, score.getCurrentScore());

        score.addPoints(5); //Frame 4
        score.addPoints(1);
        Assertions.assertEquals(49, score.getCurrentScore());

        score.addPoints(1); //Frame 5
        score.addPoints(1);
        Assertions.assertEquals(51, score.getCurrentScore());

        score.addPoints(1); //Frame 6
        score.addPoints(1);
        Assertions.assertEquals(53, score.getCurrentScore());

        score.addPoints(1); //Frame 7
        score.addPoints(1);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(0); //Frame 8
        score.addPoints(0);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(0); //Frame 9
        score.addPoints(0);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(10); //Frame 10
        Assertions.assertEquals(55, score.getCurrentScore());
        score.addPoints(10);
        Assertions.assertEquals(55, score.getCurrentScore());
        score.addPoints(10);
        Assertions.assertEquals(85, score.getCurrentScore());
    }

    @Test
    public void maxPointTest() {
        Score score = new ScoreTraditional();
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10); //Frame 10
        score.addPoints(10);
        score.addPoints(10);

        Assertions.assertEquals(300, score.getCurrentScore());
    }

    @Test
    public void addPointsAfterGameFinishTest() {
        Score score = new ScoreTraditional();
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        score.addPoints(10);
        Assertions.assertEquals(300, score.getCurrentScore());

        score.addPoints(10);
        Assertions.assertEquals(300, score.getCurrentScore());
    }

    @Test
    public void addPointSpareTest() {
        Score score = new ScoreTraditional();
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(9); //Frame 1
        score.addPoints(1);
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(5); //Frame 2
        score.addPoints(5);
        Assertions.assertEquals(15, score.getCurrentScore());

        score.addPoints(5); //Frame 3
        score.addPoints(5);
        Assertions.assertEquals(30, score.getCurrentScore());

        score.addPoints(0); //Frame 4
        score.addPoints(10);
        Assertions.assertEquals(40, score.getCurrentScore());

        score.addPoints(5); //Frame 5
        score.addPoints(5);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(9); //Frame 6
        score.addPoints(1);
        Assertions.assertEquals(74, score.getCurrentScore());

        score.addPoints(1); //Frame 7
        score.addPoints(9);
        Assertions.assertEquals(85, score.getCurrentScore());

        score.addPoints(0); //Frame 8
        score.addPoints(10);
        Assertions.assertEquals(95, score.getCurrentScore());

        score.addPoints(2); //Frame 9
        score.addPoints(8);
        Assertions.assertEquals(107, score.getCurrentScore());

        score.addPoints(3); //Frame 10
        score.addPoints(7);
        Assertions.assertEquals(120, score.getCurrentScore());

        score.addPoints(7); //Frame 10
        Assertions.assertEquals(137, score.getCurrentScore());
        Assertions.assertTrue(score.isGameEnded());

        score.addPoints(7);
        Assertions.assertEquals(137, score.getCurrentScore());
        Assertions.assertTrue(score.isGameEnded());
    }

    @Test
    public void spareInFinalFrameTest() {
        Score score = new ScoreTraditional();
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(10); //Frame 1
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(5); //Frame 2
        score.addPoints(4);
        Assertions.assertEquals(28, score.getCurrentScore());

        score.addPoints(9); //Frame 3
        score.addPoints(1);
        Assertions.assertEquals(28, score.getCurrentScore());

        score.addPoints(5); //Frame 4
        score.addPoints(1);
        Assertions.assertEquals(49, score.getCurrentScore());

        score.addPoints(1); //Frame 5
        score.addPoints(1);
        Assertions.assertEquals(51, score.getCurrentScore());

        score.addPoints(1); //Frame 6
        score.addPoints(1);
        Assertions.assertEquals(53, score.getCurrentScore());

        score.addPoints(1); //Frame 7
        score.addPoints(1);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(0); //Frame 8
        score.addPoints(0);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(0); //Frame 9
        score.addPoints(0);
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(5); //Frame 10
        score.addPoints(5); //Frame 10
        Assertions.assertEquals(55, score.getCurrentScore());

        score.addPoints(10);
        Assertions.assertEquals(75, score.getCurrentScore());

    }

    @Test
    public void resetScoreTest() {
        Score score = new ScoreTraditional();
        Assertions.assertEquals(0, score.getCurrentScore());

        score.addPoints(10); //Frame 1
        score.addPoints(1);  //Frame 2
        score.addPoints(2);
        Assertions.assertEquals(16, score.getCurrentScore());

        score.resetScore();
        Assertions.assertEquals(0, score.getCurrentScore());
        Assertions.assertEquals(0, score.getCurrentFrame());

        score.resetScore();
        Assertions.assertEquals(0, score.getCurrentScore());
        Assertions.assertEquals(0, score.getCurrentFrame());
    }
}
