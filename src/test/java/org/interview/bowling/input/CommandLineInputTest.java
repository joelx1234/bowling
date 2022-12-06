package org.interview.bowling.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CommandLineInputTest {

    @Test
    public void getAimPositionForValidInputTest() {
        sendInput("0", 0);
        sendInput("1", 1);
        sendInput("2", 2);
        sendInput("3", 3);
        sendInput("4", 4);
        sendInput("5", 5);
        sendInput("6", 6);
        sendInput("7", 7);
        sendInput("8", 8);
    }

    @Test
    public void getAimPositionForInvalidInputTest() {
        sendInput("-1", 0);
        sendInput("9", 0);
        sendInput("44", 0);
        sendInput("-1244", 0);
        sendInput("A4", 0);
        sendInput("Four", 0);
        sendInput("X", 0);
        sendInput("", 0);
        sendInput(" ", 0);
        sendInput("4.2", 0);
    }

    private static void sendInput(String userInput, int expectedResult) {
        CommandLineInput input = new CommandLineInput(new ByteArrayInputStream(userInput.getBytes()));
        int result = input.getAimPosition();
        Assertions.assertEquals(expectedResult, result);
    }

}
