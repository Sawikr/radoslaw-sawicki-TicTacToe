package com.kodilla.tictactoe.logic.algorithmMinMax;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.display.GameBoard;
import com.kodilla.tictactoe.logic.win.GameWinner;
import com.kodilla.tictactoe.running.javafxboard.gameoption.GameOptionConsoleOrJavaFx;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class ComputerMoveMinMaxAlgorithm {

    private static final Logger logger = Logger.getLogger(GameWinner.class.getName());
    public static final Random RANDOM = new Random();

    public static void computerMoveMinMaxAlgorithm(char[][] board) {

        Board boardMinMax = new Board();
        Scanner scanner = new Scanner(System.in);
        int dim = board.length;
        GameBoard.printBoard(board);

        System.out.println("\nSelect turn: \n1 - Computer (X)" + "\n2 - User (O)\n" +
                           "\nSelect a game option:");
        int choice = scanner.nextInt();
        choice = ChoiceController.getCorrectArrayIndexChoice(choice);

        if (choice == Board.PLAYER_X) {
            Point p = new Point(RANDOM.nextInt(dim), RANDOM.nextInt(dim));
            boardMinMax.placeAMove(board, p, Board.PLAYER_X);
            System.out.println("\nComputer made the move!");
            boardMinMax.displayBoard(board);
        }

        while (!boardMinMax.isGameOver(board)) {
            boolean moveOk = true;

            do {
                if (!moveOk) {
                    System.out.println("Cell already filled!");
                }
                System.out.println("Your move: ");
                System.out.println("Player 'O' enter a row number: ");
                int row = new Scanner(System.in).nextInt();
                row = ChoiceController.getCorrectArrayIndex(board, row);
                System.out.println("Player 'O' enter a column number: ");
                int col = new Scanner(System.in).nextInt();
                col = ChoiceController.getCorrectArrayIndex(board, col);

                //Point userMove = new Point(scanner.nextInt(), scanner.nextInt());
                Point userMove = new Point(row, col);
                moveOk = boardMinMax.placeAMove(board, userMove, Board.PLAYER_O);
            } while (!moveOk);

            boardMinMax.displayBoard(board);

            if (boardMinMax.isGameOver(board)) {
                break;
            }

            //MinMaxAlgorithm
            boardMinMax.miniMax(board,0, Board.PLAYER_X);
            System.out.println("Computer made the move!");
            System.out.println("Computer choose position: " + boardMinMax.computerMove);

            boardMinMax.placeAMove(board, boardMinMax.computerMove, Board.PLAYER_X);
            boardMinMax.displayBoard(board);
        }

        if (boardMinMax.hasPlayerWonInGame(board, Board.PLAYER_X)) {
            System.out.println("You lost!");
            GameOptionConsoleOrJavaFx.gameChoice();
        }
        else if (boardMinMax.hasPlayerWonInGame(board, Board.PLAYER_O)) {
            System.out.println("You win!");
            GameOptionConsoleOrJavaFx.gameChoice();
        }
        //else if (DrawMove.drawMove(board, movesCounter)) {
        else {
            System.out.println("Draw!");
            GameOptionConsoleOrJavaFx.gameChoice();
        }
    }
}
