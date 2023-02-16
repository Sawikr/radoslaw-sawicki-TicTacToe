package com.kodilla.tictactoe.logic.move;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.display.GameBoard;
import com.kodilla.tictactoe.save.GameOptionSaveGame;
import java.util.Scanner;

public class PerformMove {

    public static int movesCounter = 0;

    public static void performPlayerMove(char[][] board, char activePlayer){

        //Choice save game!
        GameOptionSaveGame.gameChoice(board);

        System.out.println("\nPlayer '" + activePlayer + "', enter a row number: ");
        int row = new Scanner(System.in).nextInt();
        row = ChoiceController.getCorrectArrayIndex(board, row);

        System.out.println("Player '" + activePlayer + "', enter a column number: ");
        int col = new Scanner(System.in).nextInt();
        col = ChoiceController.getCorrectArrayIndex(board, col);

        if (board[row][col] == 0) {//If a field is free
            board[row][col] = activePlayer;
            //Move correct
            System.out.println("\nPlayer '" + activePlayer + "' look at the board:");
            GameBoard.printBoard(board);//Prints a board
            movesCounter++;
        } else {
            //Move incorrect, the field is not free
            ChoiceController.getIndexFromBoard(board, activePlayer);
        }
    }
}
