package com.kodilla.tictactoe.running;

import com.kodilla.tictactoe.display.GameBoard;
import com.kodilla.tictactoe.display.GameIntroduction;
import com.kodilla.tictactoe.logic.move.FirstMove;
import com.kodilla.tictactoe.logic.win.GameWinner;

/**
 * @author Radoslaw Sawicki
 * @version 0.0.3
 * @apiNote Task: 9.2
 */

public class TicTacToeMainRunning {

    public static void main(String[] args) {

        //Game introduction
        GameIntroduction gameIntroduction = new GameIntroduction();
        char[][] choiceBoard = gameIntroduction.printIntroduction();

        //Print board
        GameBoard.printBoard(choiceBoard);

        //Drawing the first player
        char activePlayer = FirstMove.firstPlayerDraw();
        System.out.println("\nThe game begins with player: '" + activePlayer + "'!");

        //Check winner!
        GameWinner.numberOfWinningMoves(choiceBoard, activePlayer);
    }
}
