package com.kodilla.tictactoe.display;

import com.kodilla.tictactoe.controller.ChoiceController;

import java.util.Scanner;

public class GameIntroduction {

    public char[][] printIntroduction() {
        System.out.println("\nEnter the size of the game board [3-10]: ");
        int dimChoice = new Scanner(System.in).nextInt();
        var dim = ChoiceController.getDimFromIntroduction(dimChoice);
        char[][] board = new char[dim][dim];

        int dimMinusOne = dim - 1;
        System.out.println("The size of the game board is: " + dim + " x " + dim + "!\n" +
                "The size of the game board is from 0 to " + dimMinusOne + " rows and columns!");
        return board;
    }


}
