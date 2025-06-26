package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class AppTest {

    private char[][] board;

    @Before
    public void setUp() {
        board = new char[][] {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
    }

    @Test
    public void testHorizontalWin() throws Exception {
        board[0][0] = board[0][1] = board[0][2] = 'X';
        assertTrue(invokeCheckWin('X', board));
    }

    @Test
    public void testVerticalWin() throws Exception {
        board[0][1] = board[1][1] = board[2][1] = 'O';
        assertTrue(invokeCheckWin('O', board));
    }

    @Test
    public void testDiagonalWin() throws Exception {
        board[0][0] = board[1][1] = board[2][2] = 'X';
        assertTrue(invokeCheckWin('X', board));
    }

    @Test
    public void testDraw() throws Exception {
        board = new char[][] {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
        };
        assertTrue(invokeIsDraw(board));
    }

    @Test
    public void testNotDraw() throws Exception {
        board[0][0] = 'X';
        assertFalse(invokeIsDraw(board));
    }

    // Helpers to access private static methods in App.java
    private boolean invokeCheckWin(char player, char[][] testBoard) throws Exception {
        setBoard(testBoard);
        setCurrentPlayer(player);

        Method method = App.class.getDeclaredMethod("checkWin");
        method.setAccessible(true);
        return (boolean) method.invoke(null);
    }

    private boolean invokeIsDraw(char[][] testBoard) throws Exception {
        setBoard(testBoard);

        Method method = App.class.getDeclaredMethod("isDraw");
        method.setAccessible(true);
        return (boolean) method.invoke(null);
    }

    // Inject test board into App class
    private void setBoard(char[][] testBoard) throws Exception {
        java.lang.reflect.Field boardField = App.class.getDeclaredField("board");
        boardField.setAccessible(true);
        boardField.set(null, testBoard);
    }

    private void setCurrentPlayer(char player) throws Exception {
        java.lang.reflect.Field currentPlayerField = App.class.getDeclaredField("currentPlayer");
        currentPlayerField.setAccessible(true);
        currentPlayerField.setChar(null, player);
    }
}
