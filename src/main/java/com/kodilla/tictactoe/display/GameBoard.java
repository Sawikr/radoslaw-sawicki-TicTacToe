package com.kodilla.tictactoe.display;

public class GameBoard {

    public static void printBoard(char[][] board){
        System.out.print("\nGame board:\n");
        int dim = board.length;
        //Columns headers
        System.out.print("\t");
        for (int i = 0; i < dim; i++){
            System.out.print(i + ".\t");
        }
        System.out.println();
        for (int row = 0; row < dim; row++){
            System.out.print(row + ".\t");
            for (int column = 0; column < dim; column++){
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }
}
