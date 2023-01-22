package com.kodilla.tictactoe.logic.move;

import com.kodilla.tictactoe.display.GameBoard;
import com.kodilla.tictactoe.logic.win.GameWinner;
import java.util.Random;
import java.util.logging.Logger;

public class ComputerMove {

    private static final Logger logger = Logger.getLogger(GameWinner.class.getName());

    public static void computerMove(char[][] board, char activePlayer){

        int dim = board.length;
        Random random = new Random();
        boolean computerMoveIsCorrect = false;

        while (!computerMoveIsCorrect) {
            int row = random.nextInt(0, dim);
            int col = random.nextInt(0, dim);

            if (board[row][col] == 0) {//If a field is free
                board[row][col] = activePlayer;
                //Move correct
                System.out.println("\nComputer look at the board:");
                GameBoard.printBoard(board);//Prints a board
                computerMoveIsCorrect = true;
            }
        }
    }
}
