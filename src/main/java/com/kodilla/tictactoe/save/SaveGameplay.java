package com.kodilla.tictactoe.save;

import com.kodilla.tictactoe.display.GameBoard;
import com.kodilla.tictactoe.display.GameComputerOption;
import com.kodilla.tictactoe.logic.algorithmMinMax.Board;
import com.kodilla.tictactoe.logic.algorithmMinMax.ComputerMoveMinMaxAlgorithm;
import com.kodilla.tictactoe.logic.move.FirstMove;
import com.kodilla.tictactoe.logic.win.GameWinner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SaveGameplay {

    public File savedGameFile;

    public SaveGameplay() {
        savedGameFile = new File("saveGame.txt");
    }

    public static void saveGame(char[][] board, File savedGame) {
        try {
            FileOutputStream oos = new FileOutputStream(savedGame, false);
            int dim = board.length;
            for (int row = 0; row < dim; row++){
                for (int column = 0; column < dim; column++){
                    oos.write(board[row][column]);
                }
            }
            System.out.println("\nThe game is saved!\nLook at the board!");

            if (GameComputerOption.computerHard) {
                GameComputerOption.computerHard = false;
                Board boardSaveComputerHard = new Board();
                boardSaveComputerHard.displayBoard(board);
            }
            else
                GameBoard.printBoard(board);

            System.out.println("\nEND GAME!");
            oos.flush();
            oos.close();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public char[][] loadGame(char[][] board, File savedGame) {
        System.out.println();
        try {
            FileInputStream ois = new FileInputStream(savedGame);
            int dim = board.length;
            System.out.print("\t");
            for (int i = 0; i < dim; i++) {
                System.out.print(i + ".\t");
            }
            System.out.println();
            for (int row = 0; row < dim; row++) {
                System.out.print(row + ".\t");
                for (int column = 0; column < dim; column++) {
                    int character = ois.read();
                    System.out.print((char) character + "\t");
                    board[row][column] = (char) character;
                }
                System.out.println();
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }

    public void nextMoveMinMaxAlgorithm(char[][] board) {
        if (GameComputerOption.computerHard) {
            ComputerMoveMinMaxAlgorithm.computerMoveMinMaxAlgorithm(board);
        }
        else {
            System.out.println("\nEasy game against the computer!");
            //Drawing the first player
            char activePlayer = FirstMove.firstPlayerDraw();
            System.out.println("\nThe game begins with player: '" + activePlayer + "'!");
            //Check winner!
            GameWinner.numberOfWinningMoves(board, activePlayer);
        }
    }
}
