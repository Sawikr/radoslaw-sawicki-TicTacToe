package com.kodilla.tictactoe.display;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.logic.move.FirstMove;
import com.kodilla.tictactoe.logic.win.GameWinner;
import com.kodilla.tictactoe.save.GameOptionLoadGame;
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
                if (GameOptionLoadGame.empty) {
                    char[][] board = new char[3][3];
                    System.out.println("Easy game against the computer!");
                    //Drawing the first player
                    char activePlayer = FirstMove.firstPlayerDraw();
                    System.out.println("\nThe game begins with player: '" + activePlayer + "'!");
                    //Check winner!
                    GameWinner.numberOfWinningMoves(board, activePlayer);
                    GameOptionLoadGame.empty = false;
                }
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
