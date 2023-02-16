package com.kodilla.tictactoe.display;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.logic.algorithmMinMax.ComputerMoveMinMaxAlgorithm;
import com.kodilla.tictactoe.logic.move.FirstMove;
import com.kodilla.tictactoe.logic.win.GameWinner;
import com.kodilla.tictactoe.running.TicTacToeMainRunning;
import com.kodilla.tictactoe.running.javafxboard.gameoption.GameOptionConsoleOrJavaFx;
import com.kodilla.tictactoe.save.GameOptionLoadGame;
import com.kodilla.tictactoe.save.SaveGameplay;
import java.util.Scanner;
import static com.kodilla.tictactoe.display.GameIntroduction.emptyFile;
import static com.kodilla.tictactoe.display.GameIntroduction.emptyFileMinMaxAlg;

enum OptionLevel {
    EASY,
    HARD;

    public static void gameOptionLevel(OptionLevel option, char[][] board) {
        switch (option) {
            case EASY -> {
                if (GameOptionLoadGame.loadGame) {
                    if (!emptyFile && !emptyFileMinMaxAlg) {
                        SaveGameplay saveGameplay = new SaveGameplay();
                        SaveGameplay.loadGame(board, SaveGameplay.savedGameFile);
                        saveGameplay.nextMoveMinMaxAlgorithm(board);
                    }
                    else {
                        System.out.println("\nNo saved game!\nNew game!");
                        GameOptionLoadGame.empty = true;
                        TicTacToeMainRunning.mainRunning();
                    }
                }
                else if (GameOptionConsoleOrJavaFx.console) {
                    System.out.println("Easy game against the computer!");
                    //Drawing the first player
                    char activePlayer = FirstMove.firstPlayerDraw();
                    System.out.println("\nThe game begins with player: '" + activePlayer + "'!");
                    //Check winner!
                    GameWinner.numberOfWinningMoves(board, activePlayer);
                }
            }
            case HARD -> {
                if (GameOptionLoadGame.loadGame) {
                    if (!emptyFile && !emptyFileMinMaxAlg) {
                        SaveGameplay saveGameplay = new SaveGameplay();
                        SaveGameplay.loadGame(board, SaveGameplay.savedGameFileMinMaxAlg);
                        GameComputerOption.computerHard = true;
                        saveGameplay.nextMoveMinMaxAlgorithm(board);
                    }
                    else {
                        System.out.println("\nNo saved game!\nNew game!\n");
                        GameOptionLoadGame.empty = true;
                        System.out.println("Hard game against the computer (MinMaxAlgorithm)!");
                        GameComputerOption.computerHard = true;
                        ComputerMoveMinMaxAlgorithm.computerMoveMinMaxAlgorithm(board);
                    }
                }
                else {
                    System.out.println("Hard game against the computer (MinMaxAlgorithm)!");
                    GameComputerOption.computerHard = true;
                    ComputerMoveMinMaxAlgorithm.computerMoveMinMaxAlgorithm(board);
                }
            }
        }
    }
}

public class GameComputerOption {

    static OptionLevel option;
    static String choice;
    static Scanner input;
    public static boolean computerHard;

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
