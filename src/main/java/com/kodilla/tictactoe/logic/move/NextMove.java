package com.kodilla.tictactoe.logic.move;

import static com.kodilla.tictactoe.display.GameOption.computerMove;

public class NextMove {

    public static char activeComputer;

    public static void nextMove(char[][] board, char activePlayer) {
        //Next move
        if (!computerMove) {
            PerformMove.performPlayerMove(board, ChangePlayer.changePlayer(activePlayer));
        }
        else {
            activePlayer = ChangePlayer.changePlayer(activePlayer);
            System.out.println("\nComputer is: " + activePlayer + "\nComputer made the move!");
            activeComputer = activePlayer;
            ComputerMove.computerMove(board, activePlayer);
        }
    }
}
