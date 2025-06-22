package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testCheckWinRow() {
        App.board = new char[][] {
            {'X', 'X', 'X'},
            {' ', 'O', ' '},
            {'O', ' ', ' '}
        };
        App.currentPlayer = 'X';
        assertTrue(App.checkWin());
    }

    @Test
    public void testCheckWinCol() {
        App.board = new char[][] {
            {'O', 'X', ' '},
            {'O', 'X', ' '},
            {' ', 'X', ' '}
        };
        App.currentPlayer = 'X';
        assertTrue(App.checkWin());
    }

    @Test
    public void testCheckWinDiagonal() {
        App.board = new char[][] {
            {'O', 'X', 'X'},
            {' ', 'O', ' '},
            {' ', ' ', 'O'}
        };
        App.currentPlayer = 'O';
        assertTrue(App.checkWin());
    }

    @Test
    public void testIsDraw() {
        App.board = new char[][] {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
        };
        assertTrue(App.isDraw());
    }
}
