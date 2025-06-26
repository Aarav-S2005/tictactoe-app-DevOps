package com.example;

import java.util.Scanner;

public class App {
    static char[][] board;
    static char currentPlayer;

    public static void main(String[] args) {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();

        boolean isAuto = args.length > 0 && args[0].equalsIgnoreCase("auto");

        System.out.println("Tic Tac Toe Game");
        printBoard();

        if (isAuto) {
            autoPlay(); // Run auto mode (used in Jenkins)
        } else {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (placeMark(row, col)) {
                    printBoard();

                    if (checkWin()) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    } else if (isDraw()) {
                        System.out.println("It's a draw!");
                        break;
                    }

                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }
            scanner.close();
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public static boolean checkWin() {
        // check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    public static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    public static void autoPlay() {
        System.out.println("Running in auto mode...");
        board = new char[][] {
            {'X', 'O', 'X'},
            {'X', 'X', 'O'},
            {'O', 'X', 'O'}
        };
        printBoard();

        if (checkWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else if (isDraw()) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Game is still ongoing.");
        }
    }
}
