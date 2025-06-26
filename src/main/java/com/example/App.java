package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("auto")) {
            autoPlay();
        } else {
            interactivePlay();
        }
    }

    public static void interactivePlay() {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        char currentPlayer = 'X';

        System.out.println("Tic Tac Toe Game");

        int moves = 0;
        while (moves < 9) {
            printBoard(board);
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

        printBoard(board);
        System.out.println("Game Over!");
        scanner.close();
    }

    public static void autoPlay() {
        char[][] board = new char[3][3];
        char currentPlayer = 'X';

        System.out.println("Auto-playing Tic Tac Toe...");

        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3;
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard(board);
        System.out.println("Auto game complete.");
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print((board[i][j] == '\0' ? " " : board[i][j]) + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}
