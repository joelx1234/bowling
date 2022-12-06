package org.interview.bowling.score;

public enum BowlingScoreType {
    STRIKE("X"),
    SPARE("/"),
    NORMAL(" ");

    public final String value;

    BowlingScoreType(String label) {
        this.value = label;
    }

    @Override
    public String toString() {
        return value;
    }
}
