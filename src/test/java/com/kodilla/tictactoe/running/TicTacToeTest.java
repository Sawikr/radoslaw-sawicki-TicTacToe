package com.kodilla.tictactoe.running;

import com.kodilla.tictactoe.display.GameBoard;
import com.kodilla.tictactoe.logic.win.CheckWin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        System.out.println("Test Case: end!\n");
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
                { 'X', 'X', '0' },
                { 'O', 'X', 'X' },
        };

        //Given
        char[][] board = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 },
        };

        char activePlayer = '0';
        GameBoard.printBoard(board);

        //When
        board[0][0] = activePlayer;
        board[0][1] = activePlayer;
        board[0][2] = activePlayer;
        GameBoard.printBoard(board);

        boolean won = CheckWin.checkWinInRows(board, activePlayer);
        logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinOInColumns")
    @Test
    void testWinOInColumns(){
        //Given
        char activePlayer = '0';
        char[][] board = new char[3][3];
        GameBoard.printBoard(board);

        //When
        board[0][0] = activePlayer;
        board[1][0] = activePlayer;
        board[2][0] = activePlayer;
        GameBoard.printBoard(board);

        boolean won = CheckWin.checkWinInColumns(board, activePlayer);
        logger.info("Won is: " + won);

        //Then
        assertTrue(won);

    }

    @DisplayName("Name of test: testWinOInDiagonals")
    @Test
    void testWinOInDiagonals(){
        //Given


        //When


        //Then

    }

    @DisplayName("Name of test: testWinXInRows")
    @Test
    void testWinXInRows(){
        //Given


        //When


        //Then

    }

    @DisplayName("Name of test: testWinXInColumns")
    @Test
    void testWinXInColumns(){
        //Given


        //When


        //Then

    }

    @DisplayName("Name of test: testWinXInDiagonals")
    @Test
    void testWinXInDiagonals(){
        //Given


        //When


        //Then

    }

    @DisplayName("Name of test: testXOrOInDrawGame")
    @Test
    void testXOrOInDrawGame(){
        //Given


        //When


        //Then

    }

    @DisplayName("Name of test: testXOrOInErrorMove")
    @Test
    void testXOrOInErrorMove(){
        //Given


        //When


        //Then

    }
}
