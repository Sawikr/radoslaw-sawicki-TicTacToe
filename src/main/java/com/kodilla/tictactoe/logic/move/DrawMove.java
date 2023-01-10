package com.kodilla.tictactoe.logic.move;

import static com.kodilla.tictactoe.logic.move.PerformMove.movesCounter;

public class DrawMove {

    public static boolean drawMove(char[][] board){
        int dim = board.length;
        return (dim * dim == movesCounter);//True
    }
}
