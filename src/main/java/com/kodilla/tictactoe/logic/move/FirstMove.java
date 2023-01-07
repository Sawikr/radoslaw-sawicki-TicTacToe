package com.kodilla.tictactoe.logic.move;

import java.util.Random;

public class FirstMove {

    public static char firstPlayerDraw() {
        Random random = new Random();
        Character[] playerNames = {'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O'};
        char playerName = 0;
        for (int i = 0; i < playerNames.length; i++) {
            int indexPlayers = random.nextInt(playerNames.length);
            playerName = playerNames[indexPlayers];
        }
        return playerName;
    }
}
