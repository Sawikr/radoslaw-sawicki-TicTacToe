package com.kodilla.tictactoe.logic.algorithmMinMax;

import com.kodilla.tictactoe.logic.win.GameWinner;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Board {

    private static final Logger logger = Logger.getLogger(GameWinner.class.getName());

    public static final int NO_PLAYER = 0;
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    public Point computerMove;

    public boolean isGameOver(char[][] board) {
        return (hasPlayerWon(board, PLAYER_X) || hasPlayerWon(board, PLAYER_O) || getAvailableCells(board).isEmpty());
    }

    public boolean hasPlayerWon(char[][] board, int player) {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player) ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == player)) {
            return true;
        }
        for (int i = 0; i < board.length; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == player))) {
                return true;
            }
        }
        return false;
    }

    public List<Point> getAvailableCells(char[][] board) {
        int dim = board.length;
        List<Point> availableCells = new ArrayList<>();
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (board[row][col] == NO_PLAYER) {
                    availableCells.add(new Point(row, col));
                }
            }
        }
        return availableCells;
    }

    public boolean placeAMove(char[][] board, Point point, int player) {
        if (board[point.x][point.y] != NO_PLAYER)
            return false;

        board[point.x][point.y] = (char) player;
        return true;
    }

    public void displayBoard(char[][] board) {
        System.out.print("\nGame board:\n");
        int dim = board.length;
        System.out.print("\t");
        for (int i = 0; i < dim; i++) {
            System.out.print(i + ".\t");
        }
        System.out.println();
        for (int row = 0; row < dim; row++) {
            System.out.print(row + ".\t");
            for (int col = 0; col < dim; col++) {
                //String value = "?";
                //Filling  empty array!
                String value = board[row][col] + "";
                if (board[row][col] == PLAYER_X)
                    value = "X";
                else if (board[row][col] == PLAYER_O)
                    value = "O";

                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int miniMax(char[][] board, int depth, int turn) {
        if (hasPlayerWon(board, PLAYER_X))
            return 1;
        if (hasPlayerWon(board, PLAYER_O))
            return -1;

        List<Point> availableCells = getAvailableCells(board);

        if (availableCells.isEmpty())
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < availableCells.size(); i++) {
            Point point = availableCells.get(i);

            if (turn == PLAYER_X) {
                placeAMove(board, point, PLAYER_X);
                int currentScore = miniMax(board, depth + 1, PLAYER_O);
                max = Math.max(currentScore, max);

                if (depth == 0)
                    System.out.println("Score for position "+ point + " = " + currentScore);

                if (currentScore >= 0){
                    if (depth == 0)
                        computerMove = point;
                }

                if (currentScore == 1){
                    board[point.x][point.y] = NO_PLAYER;
                    break;
                }

                if (i == availableCells.size() - 1 && max < 0) {
                    if (depth == 0)
                        computerMove = point;
                }

            } else if (turn == PLAYER_O) {
                placeAMove(board, point, PLAYER_O);
                int currentScore = miniMax(board,depth + 1, PLAYER_X);
                min = Math.min(currentScore, min);

                if (min == -1) {
                    board[point.x][point.y] = NO_PLAYER;
                    break;
                }
            }
            board[point.x][point.y] = NO_PLAYER;
        }
        return turn == PLAYER_X ? max : min;
    }
}
