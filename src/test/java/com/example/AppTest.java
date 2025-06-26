package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    @Before
    public void resetBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                App.board[i][j] = '\0'; // Clear board
    }

    @Test
    public void testHorizontalWin() {
        App.board[0][0] = 'X';
        App.board[0][1] = 'X';
        App.board[0][2] = 'X';
        assertTrue(App.checkWin('X'));
    }

    @Test
    public void testVerticalWin() {
        App.board[0][0] = 'O';
        App.board[1][0] = 'O';
        App.board[2][0] = 'O';
        assertTrue(App.checkWin('O'));
    }

    @Test
    public void testDiagonalWin() {
        App.board[0][0] = 'X';
        App.board[1][1] = 'X';
        App.board[2][2] = 'X';
        assertTrue(App.checkWin('X'));
    }

    @Test
    public void testDraw() {
        char[][] drawBoard = {
            {'X', 'O', 'X'},
            {'X', 'X', 'O'},
            {'O', 'X', 'O'}
        };
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                App.board[i][j] = drawBoard[i][j];

        assertTrue(App.isDraw());
    }

    @Test
    public void testNotDraw() {
        App.board[0][0] = 'X';
        App.board[0][1] = 'O';
        App.board[0][2] = 'X';
        // rest of board is empty
        assertFalse(App.isDraw());
    }
}
