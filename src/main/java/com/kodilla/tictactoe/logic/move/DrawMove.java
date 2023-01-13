package com.kodilla.tictactoe.logic.move;

public class DrawMove {

    public static boolean drawMove(char[][] board, int movesCounter){
        int dim = board.length;
        return (dim * dim == movesCounter);//True
    }
}
