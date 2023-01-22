package com.kodilla.tictactoe.display;

import com.kodilla.tictactoe.controller.ChoiceController;
import java.util.Scanner;

enum Option {
    USER,
    COMPUTER;

    public static void gameOption(Option option) {
        switch (option) {
            case USER -> {
                System.out.println("Game with user!");
                GameOption.computerMove = false;
            }
            case COMPUTER -> {
                System.out.println("Game with computer!");
                GameOption.computerMove = true;
            }
        }
    }
}

public class GameOption {

    static Option option;
    static Scanner input;
    public static String choice;
    public static boolean computerMove;

    public GameOption(Option option) {
        GameOption.option = option;
    }

    public static void gameChoice() {
        System.out.print("\nGame option:" +
                "\nUSER - game with user" +
                "\nCOMPUTER - game with computer\n" +
                "\nSelect a game option: ");

        input = new Scanner(System.in);
        choice = input.next().toUpperCase();

        String correct = ChoiceController.getCorrectName(choice);
        if (correct.equals("USER") || correct.equals("COMPUTER"))
            Option.gameOption(Option.valueOf(correct));
    }
}
