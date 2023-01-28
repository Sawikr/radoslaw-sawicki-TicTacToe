package com.kodilla.tictactoe.controller;

import com.kodilla.tictactoe.exception.DimFromIntroductionException;
import com.kodilla.tictactoe.logic.move.PerformMove;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChoiceController {

    public static int getDimFromIntroduction(int dim) {
        while (dim < 3 || dim > 10) {
            try {
                try {
                    System.out.println("Choice invalid, please try again!" +
                            "\nEnter the size of the game board [3-10]:");
                    //Created one exception as an exercise!
                    throw new NoSuchElementException();
                } catch (NoSuchElementException e) {
                    throw new DimFromIntroductionException("We caught exception: DimFromIntroductionException!");
                }
            } catch (DimFromIntroductionException e) {
                System.out.println("We caught exception DimFromIntroductionException: " + e.getCause() + "!");
            } finally {
                dim = new Scanner(System.in).nextInt();
            }
        }
        return dim;
    }

    public static void getIndexFromBoard(char[][] board, char activePlayer){
        System.out.println("Move invalid, please try again!");
        PerformMove.performPlayerMove(board, activePlayer);
    }

    public static int getCorrectArrayIndex(char[][] board, int rowOrCol){
        int dim = board.length;
        while (rowOrCol < 0 || rowOrCol >= dim) {
            System.out.println("Move invalid, please try again!");
            rowOrCol = new Scanner(System.in).nextInt();
        }
        return rowOrCol;
    }

    public static int getCorrectArrayIndexChoice(int choice){
        while (choice <= 0 || choice > 2) {
            System.out.println("Move invalid, please try again!");
            choice = new Scanner(System.in).nextInt();
        }
        return choice;
    }

    public static String getCorrectName(String choice){
        while (!choice.equals("USER") && !choice.equals("COMPUTER") &&
                !choice.equals("EASY") && !choice.equals("HARD")) {
            System.out.println("Choice invalid, please try again!");
            Scanner input = new Scanner(System.in);
            choice = input.next().toUpperCase();
        }
        return choice;
    }

    public static String getCorrectNameConsoleOrJavaFx(String choice){
        while (!choice.equals("CONSOLE") && !choice.equals("JAVAFX")) {
            System.out.println("Choice invalid, please try again!");
            Scanner input = new Scanner(System.in);
            choice = input.next().toUpperCase();
        }
        return choice;
    }
}
