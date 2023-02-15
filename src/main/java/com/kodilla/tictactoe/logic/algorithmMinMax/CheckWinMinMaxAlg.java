package com.kodilla.tictactoe.logic.algorithmMinMax;

public class CheckWinMinMaxAlg {

    public static boolean checkOneDiagonal(char[][] board, int player) {
        int dim = board.length;

        for (int i = 0; i < dim; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        //logger.info(player + " is true");
        return true;
    }

    public static boolean checkTwoDiagonal(char[][] board, int player) {
        int dim = board.length;

        for (int i = 0; i < dim; i++) {
            if (board[i][dim - i - 1] != player) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWinInRows(char[][] board, int player) {
        int dim = board.length;

        for (int row = 0; row < dim; row++){
            boolean win = true;
            for (int col = 0; col < dim; col++){
                if (board[row][col] != player){
                    win = false;
                    break;
                }
            }
            if (win){
                //logger.info(player + " is true");
                return true;
            }
        }
        return false;
    }

    public static boolean checkWinInColumns(char[][] board, int player) {
        int dim = board.length;

        for (int col = 0; col < dim; col++) {
            boolean win = true;
            for (int row = 0; row < dim; row++) {
                if (board[row][col] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                //logger.info(player + " is true");
                return true;
            }
        }
        return false;
    }
}
