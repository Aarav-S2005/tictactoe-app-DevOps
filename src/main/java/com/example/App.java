package com.example;

import java.util.Scanner;

public class App {

    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("auto")) {
            runAutoMode();
        } else {
            runInteractiveMode();
        }
    }

    // Interactive mode using Scanner
    private static void runInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.printf("Player %s, enter your move (row and column): ", currentPlayer);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            if (checkWin()) {
                printBoard();
                System.out.printf("Player %s wins!\n", currentPlayer);
                break;
            }
            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }

    // Simulated auto mode for CI
    private static void runAutoMode() {
        System.out.println("Running in auto mode...");

        // Predefined moves to simulate a game
        int[][] moves = {
            {0, 0}, {1, 1}, {0, 1}, {1, 0}, {0, 2} // X wins
        };

        for (int[] move : moves) {
            board[move[0]][move[1]] = currentPlayer;
            System.out.printf("Player %s moves to (%d, %d)\n", currentPlayer, move[0], move[1]);
            if (checkWin()) {
                printBoard();
                System.out.printf("Player %s wins!\n", currentPlayer);
                return;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard();
        System.out.println("It's a draw!");
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean checkWin() {
        // Rows, Columns, Diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer) return true;
        }

        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer) return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer) return true;

        return false;
    }

    private static boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }
}
