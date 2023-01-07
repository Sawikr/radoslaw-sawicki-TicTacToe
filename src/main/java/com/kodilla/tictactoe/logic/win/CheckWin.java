package com.kodilla.tictactoe.logic.win;

public class CheckWin {

    static int dim;

    static boolean checkOneDiagonal(char[][] board, char activePlayer){
        //Retrieving the length of the board
        dim = board.length;
        for (int i = 0; i < dim; i++){
            if (board[i][i] != activePlayer){
                return false;
            }
        }
        return true;
    }

    static boolean checkTwoDiagonal(char[][] board, char activePlayer){
        for (int i = 0; i < dim; i++){
            if (board[i][dim - i - 1] != activePlayer){
                return false;
            }
        }
        return true;
    }

    static boolean checkWinInRows(char[][] board, char activePlayer){
        //Checking rows from 0 to dim
        for (int row = 0; row < dim; row++){
            //Founding: activePlayer won!
            boolean win = true;
            //Checking columns
            for (int col = 0; col < dim; col++){
                //No activePlayer when win = false
                if (board[row][col] != activePlayer){
                    win = false;
                    //Leaving loop!
                    break;
                }
            }
            //activePlayer won!
            if (win){
                return true;
            }
        }
        return false;
    }

    static boolean checkWinInColumns(char[][] board, char activePlayer){
        //Checking column from 0 to dim
        for (int col = 0; col < dim; col++){
            //Founding: activePlayer won!
            boolean win = true;
            //Checking rows
            for (int row = 0; row < dim; row++){
                //No activePlayer when win = false
                if (board[row][col] != activePlayer){
                    win = false;
                    //Leaving loop!
                    break;
                }
            }
            //activePlayer won!
            if (win){
                return true;
            }
        }
        return false;
    }
}