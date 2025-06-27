package com.example;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class AppTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe('X');
    }

    private void setMoves(Player player, int[] moves) throws Exception {
        Field movesField = Player.class.getDeclaredField("moves");
        movesField.setAccessible(true);
        player.moves.clear();
        for (int move : moves) {
            player.moves.add(move);
        }
    }

    @Test
    public void testHorizontalWin() throws Exception {
        setMoves(game.p1, new int[]{1, 2, 3});
        assertEquals(1, game.checkWin());
        assertEquals('X', game.winner);
    }

    @Test
    public void testVerticalWin() throws Exception {
        setMoves(game.p2, new int[]{1, 4, 7});
        game.turn = true; // simulate it's p1's turn so p2 just played
        assertEquals(1, game.checkWin());
        assertEquals('O', game.winner);
    }

    @Test
    public void testDiagonalWin() throws Exception {
        setMoves(game.p1, new int[]{1, 5, 9});
        assertEquals(1, game.checkWin());
    }

    @Test
    public void testDraw() throws Exception {
        setMoves(game.p1, new int[]{1, 3, 6, 8, 7});
        setMoves(game.p2, new int[]{2, 4, 5, 9});
        Field moveNumber = TicTacToe.class.getDeclaredField("move_number");
        moveNumber.setAccessible(true);
        moveNumber.setInt(game, 9);
        assertEquals(0, game.checkWin());
    }
}
