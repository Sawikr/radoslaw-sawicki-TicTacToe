package com.kodilla.tictactoe.logic.win;

import com.kodilla.tictactoe.logic.move.DrawMove;
import com.kodilla.tictactoe.logic.move.NextMove;
import com.kodilla.tictactoe.logic.move.PerformMove;
import java.util.logging.Logger;
import static com.kodilla.tictactoe.logic.move.NextMove.activeComputer;
import static com.kodilla.tictactoe.logic.move.PerformMove.movesCounter;

public class GameWinner {

    private static final Logger logger = Logger.getLogger(GameWinner.class.getName());

    public static void numberOfWinningMoves(char[][] board, char activePlayer) {
        //Variables
        int dim = board.length;
        char winner = 0;
        boolean won = false;
        boolean draw = false;

        while (!won && !draw && movesCounter < dim * dim) {
            PerformMove.performPlayerMove(board, activePlayer);
            won = CheckWinner.checkWinner(board, activePlayer);
            //logger.info("Won is: " + won);
            if (!won) {
                draw = DrawMove.drawMove(board, movesCounter);
                //logger.info("Draw is: " + draw);
            }
            if (!won && !draw) {
                NextMove.nextMove(board, activePlayer);
            }
        }
        if (draw){
            System.out.println("\nThe game ended in a draw!");
            System.exit(0);}
        else {
            winner = activePlayer;
            if (winner != activeComputer){
                System.out.println("\nWinner is: " + winner + "!");
            }
            else
                System.out.println("\nWinner is computer!");
        }
    }
}
