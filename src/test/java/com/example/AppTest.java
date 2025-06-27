package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe('X');
    }

    @Test
    public void testHorizontalWin() {
        // X: 1, X: 2, X: 3 (interleaved with dummy O moves)
        game.updateBoard(1); // X
        game.updateBoard(4); // O
        game.updateBoard(2); // X
        game.updateBoard(5); // O
        game.updateBoard(3); // X

        assertEquals(1, game.checkWin());
        assertEquals('X', game.winner);
    }

    @Test
    public void testVerticalWin() {
        // O: 1, 4, 7 (X starts first)
        game.updateBoard(2); // X
        game.updateBoard(1); // O
        game.updateBoard(3); // X
        game.updateBoard(4); // O
        game.updateBoard(5); // X
        game.updateBoard(7); // O

        assertEquals(1, game.checkWin());
        assertEquals('O', game.winner);
    }

    @Test
    public void testDiagonalWin() {
        // X: 1, 5, 9 (with O moves in between)
        game.updateBoard(1); // X
        game.updateBoard(2); // O
        game.updateBoard(5); // X
        game.updateBoard(3); // O
        game.updateBoard(9); // X

        assertEquals(1, game.checkWin());
        assertEquals('X', game.winner);
    }

    @Test
    public void testDraw() {
        // Fill the board without a win
        int[] sequence = {1, 2, 3, 5, 4, 6, 8, 7, 9}; // Ends in draw
        for (int move : sequence) {
            game.updateBoard(move);
        }

        assertEquals(0, game.checkWin()); // 0 = draw
    }
}
