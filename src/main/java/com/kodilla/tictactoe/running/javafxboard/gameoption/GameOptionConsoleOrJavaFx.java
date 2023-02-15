package com.kodilla.tictactoe.running.javafxboard.gameoption;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.running.TicTacToeMainRunning;
import com.kodilla.tictactoe.running.javafxboard.Main;
import java.util.Scanner;
import static com.kodilla.tictactoe.logic.move.PerformMove.movesCounter;

enum OptionJavaFx {
    CONSOLE,
    JAVAFX;

    public static void gameOption(OptionJavaFx option) {
        switch (option) {
            case CONSOLE -> {
                System.out.println("Game on a computer console!");
                GameOptionConsoleOrJavaFx.console = true;
                TicTacToeMainRunning.mainRunning();
            }
            case JAVAFX -> {
                System.out.println("Game on an interactive board!\n");
                Main.javaFx = true;
            }
        }
    }
}

public class GameOptionConsoleOrJavaFx {

    static OptionJavaFx option;
    static Scanner input;
    public static String choice;
    public static boolean console;

    public GameOptionConsoleOrJavaFx(OptionJavaFx option) {
        GameOptionConsoleOrJavaFx.option = option;
    }

    public static void gameChoice() {
        System.out.print("\nGame option:" +
                "\nCONSOLE - game on a computer console " +
                "\nJAVAFX - game on an interactive board\n" +
                "\nSelect a game option: ");

        input = new Scanner(System.in);
        choice = input.next().toUpperCase();

        //Clearing the movesCounter
        movesCounter = 0;

        String correct = ChoiceController.getCorrectNameConsoleOrJavaFx(choice);
        if (correct.equals("CONSOLE") || correct.equals("JAVAFX"))
            OptionJavaFx.gameOption(OptionJavaFx.valueOf(correct));
    }
}
