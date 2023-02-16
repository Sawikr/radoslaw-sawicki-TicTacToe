package com.kodilla.tictactoe.display;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.running.javafxboard.gameoption.GameOptionConsoleOrJavaFx;
import com.kodilla.tictactoe.save.GameOptionLoadGame;
import com.kodilla.tictactoe.save.SaveGameplay;
import java.util.Scanner;

public class GameIntroduction {

    public static boolean emptyFile;
    public static boolean emptyFileMinMaxAlg;

    public static void loadBoardGame() throws Exception {
        //Array only required to run the application!
        char[][] boardStart = new char[3][3];

        try {
            SaveGameplay saveGameplay = new SaveGameplay();
            emptyFile = SaveGameplay.savedGameFile.length() == 0;
            emptyFileMinMaxAlg = SaveGameplay.savedGameFileMinMaxAlg.length() == 0;

            nameOfGame();
            if (!emptyFile) {
                GameOptionLoadGame.gameChoice(boardStart);
            }
            else if (!emptyFileMinMaxAlg) {
                GameOptionLoadGame.gameChoice(boardStart);
            }
            else {
                GameOptionConsoleOrJavaFx.gameChoice();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public char[][] printIntroduction() {
        System.out.println("\nEnter the size of the game board [3-10]: ");
        int dimChoice = new Scanner(System.in).nextInt();
        var dim = ChoiceController.getDimFromIntroduction(dimChoice);
        char[][] board = new char[dim][dim];

        int dimMinusOne = dim - 1;
        System.out.println("The size of the game board is: " + dim + " x " + dim + "!\n" +
                "The size of the game board is from 0 to " + dimMinusOne + " rows and columns!");
        return board;
    }

    private static void nameOfGame() {
        System.out.println("\n>>> S T A R T  G A M E <<<");
        System.out.println("    >>> Tic Tac Toe <<<");
    }
}
