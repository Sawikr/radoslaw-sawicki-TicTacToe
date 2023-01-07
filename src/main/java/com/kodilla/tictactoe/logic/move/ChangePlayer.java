package com.kodilla.tictactoe.logic.move;

public class ChangePlayer {

    public static char changePlayer(char activePlayer) {
        //Changing of player
        activePlayer = activePlayer == 'X' ? 'O' : 'X';
        return activePlayer;
    }
}
