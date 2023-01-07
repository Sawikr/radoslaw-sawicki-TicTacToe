package com.kodilla.tictactoe.logic.move;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.display.GameBoard;
import java.util.Scanner;

public class PerformMove {

    public static int movesCounter = 0;

    public static void performPlayerMove(char[][] board, char activePlayer){
        int dim = board.length;
        System.out.println("\nPlayer '" + activePlayer + "', enter a row number: ");
        int row = new Scanner(System.in).nextInt();
        while (row < 0 || row >= dim){
            System.out.println("Player '" + activePlayer + "', enter a row number: ");
            row = new Scanner(System.in).nextInt();
        }

        System.out.println("Player '" + activePlayer + "', enter a column number: ");
        int col = new Scanner(System.in).nextInt();
        while (col < 0 || col >= dim){
            System.out.println("Player '" + activePlayer + "', enter a column number: ");
            row = new Scanner(System.in).nextInt();
        }
        if (board[row][col] == 0){//If a field is free
            board[row][col] = activePlayer;
            //Move correct
            System.out.println("\nPlayer '" + activePlayer + "' look at the board:");
            GameBoard.printBoard(board);//Prints a board
            movesCounter++;
        }else {
            //Move incorrect, the field is not free
            ChoiceController.getIndexFromBoard(board, activePlayer);
        }
    }
}
