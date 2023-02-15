package com.kodilla.tictactoe.save;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.display.GameComputerOption;
import com.kodilla.tictactoe.logic.algorithmMinMax.ComputerMoveMinMaxAlgorithm;
import java.util.Scanner;

enum OptionSaveGame {
    SAVE,
    PLAY;

    public static void gameSaveOption(OptionSaveGame option, char[][] board) {
        switch (option) {
            case SAVE -> {
                SaveGameplay saveGameplay = new SaveGameplay();
                if (GameComputerOption.computerHard) {
                    SaveGameplay.saveGame(board, SaveGameplay.savedGameFileMinMaxAlg);
                }
                else
                    SaveGameplay.saveGame(board, SaveGameplay.savedGameFile);
            }
            case PLAY -> {
                if (GameComputerOption.computerHard && GameOptionSaveGame.play) {
                    //GameOptionSaveGame.play = true;
                    SaveGameplay saveGameplay = new SaveGameplay();
                    if (GameComputerOption.computerHard) {
                        SaveGameplay.loadGame(board, SaveGameplay.savedGameFileMinMaxAlg);
                    }
                    else
                        SaveGameplay.loadGame(board, SaveGameplay.savedGameFile);
                    ComputerMoveMinMaxAlgorithm.computerMoveMinMaxAlgorithm(board);
                }
                else
                    System.out.println("Continue playing!");
            }
        }
    }
}

public class GameOptionSaveGame {

    static OptionSaveGame option;
    static Scanner input;
    public static String choice;
    public static boolean play;

    public GameOptionSaveGame(OptionSaveGame option) {
        GameOptionSaveGame.option = option;
    }

    public static void gameChoice(char[][] board) {
        System.out.print("\nGame option:" +
                "\nSAVE - save game state" +
                "\nPLAY - continue game\n" +
                "\nSelect a game option: ");

        input = new Scanner(System.in);
        choice = input.next().toUpperCase();

        String correct = ChoiceController.getCorrectNameConsoleSaveGame(choice);
        if (correct.equals("SAVE") || correct.equals("PLAY"))
            OptionSaveGame.gameSaveOption(OptionSaveGame.valueOf(correct), board);
    }
}
