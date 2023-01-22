package com.kodilla.tictactoe.logic.win;

import static com.kodilla.tictactoe.logic.win.CheckWin.*;

public class CheckWinner {

    public static boolean checkWinner(char[][] board, char activePlayer){
        return checkOneDiagonal(board, activePlayer) ||
                checkTwoDiagonal(board, activePlayer) ||
                checkWinInColumns(board, activePlayer) ||
                checkWinInRows(board, activePlayer);
    }
}
