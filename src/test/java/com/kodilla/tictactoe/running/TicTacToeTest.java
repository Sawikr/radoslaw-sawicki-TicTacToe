package com.kodilla.tictactoe.running;

import com.kodilla.tictactoe.controller.ChoiceController;
import com.kodilla.tictactoe.display.GameBoard;
import com.kodilla.tictactoe.display.GameIntroduction;
import com.kodilla.tictactoe.logic.move.DrawMove;
import com.kodilla.tictactoe.logic.win.CheckWin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private static final Logger logger = Logger.getLogger(TicTacToeTest.class.getName());
    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        System.out.println("\nTest Case: begin!");
    }

    @AfterEach
    public void after() {
        System.out.println("\nTest Case: end!");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("Name of test: testWinOInRows")
    @Test
    void testWinOInRows() {
        //Other solution
        char[][] boardOther = {
                { 'X', '0', 'X' },
                { 'X', 'X', 'O' },
                { 'O', 'X', 'X' },
        };

        //Given
        char[][] board = {
                {'O','O','O'},
                { 0,  0,  0 },
                { 0,  0,  0 },
        };
        GameBoard.printBoard(board);
        char activePlayer = 'O';

        //When
        boolean won = CheckWin.checkWinInRows(board, activePlayer);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinOInColumns")
    @Test
    void testWinOInColumns(){
        //Given
        char[][] board = {
                {'O', 0, 0 },
                {'O', 0, 0 },
                {'O', 0, 0 },
        };
        GameBoard.printBoard(board);
        char activePlayer = 'O';

        //When
        boolean won = CheckWin.checkWinInColumns(board, activePlayer);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinOInDiagonalsOne")
    @Test
    void testWinOInDiagonalsOne(){
        //Given
        char[][] board = {
                {'O', 0,  0 },
                { 0, 'O', 0 },
                { 0,  0, 'O'},
        };
        GameBoard.printBoard(board);
        char activePlayer = 'O';

        //When
        boolean won = CheckWin.checkOneDiagonal(board, activePlayer);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinOInDiagonalsTwo")
    @Test
    void testWinOInDiagonalsTwo(){
        //Given
        char[][] board = {
                { 0,  0, 'O'},
                { 0, 'O', 0 },
                {'O', 0,  0 },
        };
        GameBoard.printBoard(board);
        char activePlayer = 'O';

        //When
        boolean won = CheckWin.checkTwoDiagonal(board, activePlayer);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinXInRows")
    @Test
    void testWinXInRows(){
        //Given
        char[][] board = {
                {'X','X','X'},
                { 0,  0,  0 },
                { 0,  0,  0 },
        };
        GameBoard.printBoard(board);
        char activePlayer = 'X';

        //When
        boolean won = CheckWin.checkWinInRows(board, activePlayer);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinXInColumns")
    @Test
    void testWinXInColumns(){
        //Given
        char[][] board = {
                {'X', 0, 0 },
                {'X', 0, 0 },
                {'X', 0, 0 },
        };
        GameBoard.printBoard(board);
        char activePlayer = 'X';

        //When
        boolean won = CheckWin.checkWinInColumns(board, activePlayer);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinXInDiagonalsOne")
    @Test
    void testWinXInDiagonalsOne(){
        //Given
        char[][] board = {
                {'X', 0,  0 },
                { 0, 'X', 0 },
                { 0,  0, 'X'},
        };
        GameBoard.printBoard(board);
        char activePlayer = 'X';

        //When
        boolean won = CheckWin.checkOneDiagonal(board, activePlayer);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinXInDiagonalsTwo")
    @Test
    void testWinXInDiagonalsTwo(){
        //Given
        char[][] board = {
                { 0,  0, 'X'},
                { 0, 'X', 0 },
                {'X', 0,  0 },
        };
        GameBoard.printBoard(board);
        char activePlayer = 'X';

        //When
        boolean won = CheckWin.checkTwoDiagonal(board, activePlayer);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testXOrOInDrawGame")
    @Test
    void testXOrOInDrawGame(){
        //Given
        char[][] board = {
                {'0','0','X'},
                {'X','X','0'},
                {'0','X','0'},
        };
        GameBoard.printBoard(board);
        int movesCounter = 9;

        //When
        boolean won = DrawMove.drawMove(board, movesCounter);
        //logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    //Exceptions in this application are not necessary!
    @DisplayName("Name of test: testXOrOInErrorChoice")
    @Test
    void testXOrOInErrorChoice(){
        //Given
        GameIntroduction gameIntroduction = new GameIntroduction();

        //When
        try {
            gameIntroduction.printIntroduction();
        } catch (NoSuchElementException e) {
            e.fillInStackTrace();
        }

        //Then
        assertThrows(NoSuchElementException.class, () -> ChoiceController.getDimFromIntroduction(2));
    }
}
