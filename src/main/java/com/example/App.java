package com.example;

public class App {
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("auto")) {
            autoPlay();
        } else {
            interactivePlay();
        }
    }

    public static void interactivePlay() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Tic Tac Toe Game");

        int moves = 0;
        while (moves < 9) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '\0') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            moves++;
        }

        printBoard();
        System.out.println("Game Over!");
        scanner.close();
    }

    public static void autoPlay() {
        System.out.println("Auto-playing Tic Tac Toe...");
        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3;
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard();
        System.out.println("Auto game complete.");
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print((board[i][j] == '\0' ? " " : board[i][j]) + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // These are used in tests
    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '\0') return false;
        return !checkWin('X') && !checkWin('O');
    }
}
