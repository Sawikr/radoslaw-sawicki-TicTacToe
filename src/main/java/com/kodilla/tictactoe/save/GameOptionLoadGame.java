package com.kodilla.tictactoe.save;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.display.GameComputerOption;
import com.kodilla.tictactoe.display.GameIntroduction;
import com.kodilla.tictactoe.logic.algorithmMinMax.ComputerMoveMinMaxAlgorithm;
import com.kodilla.tictactoe.running.TicTacToeMainRunning;
import java.util.Scanner;

enum OptionLoadGame {
    LOAD,
    PLAY;

    public static void gameLoadOption(OptionLoadGame option, char[][] board) {
        switch (option) {
            case LOAD -> {
                System.out.println("Game loaded!");
                GameOptionLoadGame.loadGame = true;
                GameComputerOption.gameChoiceLevel(board);
            }
            case PLAY -> {
                if (!GameIntroduction.emptyFile) {
                    TicTacToeMainRunning.mainRunning();
                }
                else if (GameComputerOption.computerHard){
                    ComputerMoveMinMaxAlgorithm.computerMoveMinMaxAlgorithm(board);
                }
                else
                    System.out.println("Continue playing!");
            }
        }
    }
}

public class GameOptionLoadGame {

    static OptionLoadGame option;
    static Scanner input;
    public static String choice;
    public static boolean loadGame;

    public GameOptionLoadGame(OptionLoadGame option) {
        GameOptionLoadGame.option = option;
    }

    public static void gameChoice(char[][] board) {
        System.out.print("\nGame option:" +
                "\nLOAD - load game state" +
                "\nPLAY - start new game\n" +
                "\nSelect a game option: ");

        input = new Scanner(System.in);
        choice = input.next().toUpperCase();

        loadGame = false;
        String correct = ChoiceController.getCorrectNameConsoleSaveGame(choice);
        if (correct.equals("LOAD") || correct.equals("PLAY"))
            OptionLoadGame.gameLoadOption(OptionLoadGame.valueOf(correct), board);
    }
}
