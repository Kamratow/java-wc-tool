package com.kamratow.ccwctool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Ccwctool {
    private void showFileBytes(String filePath) {
        try {
            String userDirectory = System.getProperty("user.dir");
            String fullFilePath = userDirectory + "/" + filePath;

            File file = new File(fullFilePath);

            if (!file.exists()) {
                throw new IllegalArgumentException("It looks like file doesn't exist. Please check this and try again");
            }

            System.out.println(file.length() + " " + filePath);

        } catch (Exception e) {
            System.out.println("Couldn't read the file. Please check your input and try again");
        }
    }

    private void showFileLinesCount(String filePath) {
        String userDirectory = System.getProperty("user.dir");
        String fullFilePath = userDirectory + "/" + filePath;

        try (BufferedReader br = new BufferedReader(new FileReader(fullFilePath))) {
            int numberOfLines = 0;

            while (br.readLine() != null) {
                numberOfLines++;
            }

            System.out.println(numberOfLines + " " + filePath);
        } catch (Exception e) {
            System.out.println("Couldn't read the file. Please check your input and try again");
        }
    }

    private void runCommand(String[] commandArgs) throws IllegalArgumentException {
        if (commandArgs.length < 3) {
            throw new IllegalArgumentException("Cannot read file path - please check your input");
        }

        var filePath = commandArgs[2];

        switch (commandArgs[1]) {
            case "-c":
                showFileBytes(filePath);
                break;
            case "-l":
                showFileLinesCount(filePath);
                break;
            default:
                break;
        }
    }

    public void startToool() {
        System.out.println("ccwc tool started, please provide command to run");
        System.out.println();

        String userInput = "";

        try (Scanner scanner = new Scanner(System.in)) {
            userInput = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Something went wrong. Please check your input and try again");
        }

        String[] commandArgsPassedByUser = userInput.split(" ");

        try {
            if (!commandArgsPassedByUser[0].equals("ccwc")) {
                throw new IllegalArgumentException("Your commad should start with \"ccwc\"");
            }

            runCommand(commandArgsPassedByUser);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
