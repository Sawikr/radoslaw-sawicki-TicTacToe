package com.kodilla.tictactoe.logic.win;

import com.kodilla.tictactoe.logic.move.NextMove;
import com.kodilla.tictactoe.logic.move.PerformMove;
import java.util.logging.Logger;

import static com.kodilla.tictactoe.logic.move.PerformMove.movesCounter;

public class GameWinner {

    private static final Logger logger = Logger.getLogger(GameWinner.class.getName());

    public static void numberOfWinningMoves(char[][] board, char activePlayer) {

        //Variables
        int dim = board.length;
        char winner = 0;
        boolean won = false;

        while(!won && movesCounter < dim * dim) {
            PerformMove.performPlayerMove(board, activePlayer);
            won = CheckWinner.checkWinner(board, activePlayer);
            //logger.info("Won is: " + won);
            if(!won) {
                NextMove.nextMove(board, activePlayer);
            }
        }
        winner = activePlayer;
        System.out.println("\nWinner is: " + winner + "!");
    }
}
