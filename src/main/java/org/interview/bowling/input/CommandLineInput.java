package org.interview.bowling.input;

import java.io.InputStream;
import java.util.Scanner;

public class CommandLineInput implements GameInput {

    private InputStream inputStream;

    public CommandLineInput() {
        this.inputStream = System.in;
    }

    public CommandLineInput(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int getAimPosition() {
        Scanner scanner = new Scanner(inputStream);
        System.out.println("Please aim: [0-8]");
        int result = 0;
        try {
            result = scanner.nextInt();
            if (result < 0 || result > 8) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("Invalid entry...Gutter ball");
            result = 0;
        }

        return result;
    }
}
