package org.interview.bowling.game;

import org.interview.bowling.input.GameInput;
import org.interview.bowling.pins.AimCalculator;
import org.interview.bowling.pins.PinFall;
import org.interview.bowling.score.Score;

public class BowlingGameImpl implements BowlingGame {

    private char[][] bowlingLane;
    private final Score scoreCard;
    private final PinFall pinFallCalculator;

    private final AimCalculator aimCalculator;

    private final GameInput input;

    public BowlingGameImpl(Score scoreCard, PinFall pinFallCalculator, AimCalculator aimCalculator, GameInput input) {
        this.scoreCard = scoreCard;
        this.pinFallCalculator = pinFallCalculator;
        this.aimCalculator = aimCalculator;
        this.input = input;
    }

    @Override
    public void setPinsUp() {
        this.bowlingLane = new char[][]{
                {' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' '},
                {' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' '},
                {' ', ' ', ' ', 'o', ' ', 'o', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'o', ' ', ' ', ' ', ' '}
        };

        printBowlingLane();
    }

    @Override
    public void printBowlingLane() {

        String divider = " | ";
        StringBuilder sb = new StringBuilder();

        for (char[] chars : bowlingLane) {
            sb.append(divider);
            for (char c : chars) {
                sb.append(c);
                sb.append(divider);
            }
            sb.append("\n");

        }

        for (int i = 0; i < 9; i++) {
            sb.append(divider);
            sb.append(i);
        }
        sb.append(divider);

        System.out.println(sb);

    }

    @Override
    public int roll() {
        int points = 0;

        if (bowlingLane != null) {

            int inputResult = input.getAimPosition();
            if (inputResult == 0) {
                return 0;
            }
            int result = 0;

            result = aimCalculator.aim(inputResult);


            points = 0;
            for (int x = bowlingLane.length - 1; x >= 0; x--) {

                //Ball is width three
                points = pinFallCalculator.calculatePinFall(x, result, bowlingLane, points);
                if (result > 1 && result < 7) {
                    points = pinFallCalculator.calculatePinFall(x, result + 1, bowlingLane, points);
                    points = pinFallCalculator.calculatePinFall(x, result - 1, bowlingLane, points);
                }
            }

            System.out.println("Pins hit: " + points);

            printBowlingLane();
        } else {
            System.out.println("Bowling Lane has not been set up");
        }

        return points;

    }

    @Override
    public void startGame() {
        System.out.println("Welcome to 10 Pin Bowling!");

        setPinsUp();
        int currentFrame = 0;
        while (!scoreCard.isGameEnded()) {
            int points = roll();

            scoreCard.addPoints(points);
            scoreCard.printScoreBoard();

            if (currentFrame != scoreCard.getCurrentFrame() && !scoreCard.isGameEnded() && scoreCard.getCurrentFrame() != 10) {
                currentFrame = scoreCard.getCurrentFrame();
                System.out.println("Setting Pins up for frame: " + (currentFrame + 1));
                setPinsUp();
            } else if (scoreCard.getCurrentFrame() == 10 && !scoreCard.isGameEnded() && (points == 10 || currentFrame != scoreCard.getCurrentFrame())) {
                currentFrame = scoreCard.getCurrentFrame();
                System.out.println("Setting up pins for bonus rolls on final frame");
                setPinsUp();
            }
        }

        System.out.println("Game Over - Final Score: " + scoreCard.getCurrentScore());
    }

    @Override
    public Score getScore() {
        return this.scoreCard;
    }

}
