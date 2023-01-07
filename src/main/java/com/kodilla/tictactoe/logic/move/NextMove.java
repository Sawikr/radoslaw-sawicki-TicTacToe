package com.kodilla.tictactoe.logic.move;

public class NextMove {

    public static void nextMove(char[][] board, char activePlayer) {
        //Next move
        PerformMove.performPlayerMove(board, ChangePlayer.changePlayer(activePlayer));
    }
}
