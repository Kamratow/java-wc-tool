package com.kamratow.ccwctool;

import java.util.Scanner;

public class Ccwctool {
    public void startToool() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ccwc tool started, please provide command to run");

        String userInput = scanner.nextLine();

        if (userInput.startsWith("ccwc")) {
            System.out.println("ccwc command running...");
        } else {
            System.out.println("Unable to run provided command - please check your input and try again");
        }

        scanner.close();
    }
}
