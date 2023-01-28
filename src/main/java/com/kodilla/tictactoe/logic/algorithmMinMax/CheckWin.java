package com.kodilla.tictactoe.logic.algorithmMinMax;

public class CheckWin {

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

    //Method works for an array of 3 x 3. Method not used!
    public boolean hasPlayerWon(char[][] board, int player) {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player) ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == player)) {
            return true;
        }
        for (int i = 0; i < board.length; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == player))) {
                return true;
            }
        }
        return false;
    }
}
