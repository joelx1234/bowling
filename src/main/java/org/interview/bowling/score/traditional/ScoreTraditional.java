package org.interview.bowling.score.traditional;

import org.interview.bowling.score.BowlingScoreType;
import org.interview.bowling.score.FrameScore;
import org.interview.bowling.score.Score;

public class ScoreTraditional implements Score {

    private static int NUMBER_OF_ROUNDS = 10;
    private FrameScoreTraditional[] frames;
    private int currentFrame;

    public ScoreTraditional() {
        resetScore();
    }

    @Override
    public void addPoints(int points) {

        if (isGameEnded()) {
            System.out.println("Game has ended...");
            return;
        }

        if (currentFrame <= NUMBER_OF_ROUNDS) {
            if (currentFrame - 1 >= 0) {
                FrameScoreTraditional priorFrame = frames[currentFrame - 1];
                if (priorFrame.isScorePending()) {
                    priorFrame.addBonus(points);
                }
            }
            if (currentFrame - 2 >= 0) {
                FrameScoreTraditional priorFrame = frames[currentFrame - 2];
                if (priorFrame.isScorePending()) {
                    priorFrame.addBonus(points);
                }
            }
        }

        if (currentFrame >= NUMBER_OF_ROUNDS) {
            return;
        }

        FrameScoreTraditional frame;
        if (frames[currentFrame] == null) {
            frame = new FrameScoreTraditional();
            frames[currentFrame] = frame;
        } else {
            frame = frames[currentFrame];
        }

        frame.addScore(points);

        if (frame.isFrameComplete()) {
            currentFrame++;
        }

    }

    @Override
    public int getCurrentScore() {
        int total = 0;
        for (FrameScore f : frames) {
            if (f != null) {
                total += f.getScore();
            }
        }

        return total;
    }

    @Override
    public boolean isGameEnded() {
        FrameScore f = frames[NUMBER_OF_ROUNDS - 1];
        if (f != null && f.isScorePending() == false && f.isFrameComplete()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getCurrentFrame() {
        return this.currentFrame;
    }

    @Override
    public void printScoreBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("Score Card: \n");
        for (FrameScore f : frames) {
            stringBuilder.append(" | ");
            if (f != null) {
                if (f.isFrameComplete() && f.getScoreType() != BowlingScoreType.NORMAL) {
                    stringBuilder.append(f.getScoreType());
                } else if (f.isScorePending()) {
                    stringBuilder.append("?");
                } else {
                    stringBuilder.append(f.getScore());
                }
            }
        }
        stringBuilder.append(" | ");
        stringBuilder.append("\n Total:" + getCurrentScore());
        stringBuilder.append("\n");

        System.out.println(stringBuilder);
    }

    @Override
    public void resetScore() {
        this.frames = new FrameScoreTraditional[NUMBER_OF_ROUNDS];
        this.currentFrame = 0;
    }


}
