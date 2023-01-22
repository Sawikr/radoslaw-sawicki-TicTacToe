package com.kodilla.tictactoe.display;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.logic.algorithmMinMax.ComputerMoveMinMaxAlgorithm;
import com.kodilla.tictactoe.logic.move.FirstMove;
import com.kodilla.tictactoe.logic.win.GameWinner;
import java.util.Scanner;

enum OptionLevel {
    EASY,
    HARD;

    public static void gameOptionLevel(OptionLevel option, char[][] board) {
        switch (option) {
            case EASY -> {
                System.out.println("Easy game against the computer!");
                //Drawing the first player
                char activePlayer = FirstMove.firstPlayerDraw();
                System.out.println("\nThe game begins with player: '" + activePlayer + "'!");
                //Check winner!
                GameWinner.numberOfWinningMoves(board, activePlayer);
            }
            case HARD -> {
                System.out.println("Hard game against the computer (MinMaxAlgorithm)!");
                ComputerMoveMinMaxAlgorithm.computerMoveMinMaxAlgorithm(board);
            }
        }
    }
}

public class GameComputerOption {

    static OptionLevel option;
    static String choice;
    static Scanner input;

    public GameComputerOption(OptionLevel option) {
        GameComputerOption.option = option;
    }

    public static void gameChoiceLevel(char[][] board) {
        System.out.print("\nGame option:" +
                "\nEASY - easy game" +
                "\nHARD - hard game\n" +
                "\nSelect a game option: ");

        input = new Scanner(System.in);
        choice = input.next().toUpperCase();

        String correct = ChoiceController.getCorrectName(choice);
        if (correct.equals("EASY") || correct.equals("HARD"))
            OptionLevel.gameOptionLevel(OptionLevel.valueOf(correct), board);
    }
}
