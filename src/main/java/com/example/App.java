package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char p1_symbol = ' ';
        while (p1_symbol != 'X' && p1_symbol != 'O') {
            System.out.print("Player one: ");
            p1_symbol = sc.nextLine().charAt(0);
        }
        TicTacToe board = new TicTacToe(p1_symbol);

        System.out.println("\n🎮 Starting Tic Tac Toe Game\n");

        while (board.checkWin() == 0) {
            System.out.println();
            board.showBoard();

            if ((board.turn)) {
                System.out.println("\nPlayer one's turn:");
            } else {
                System.out.println("\nPlayer two's turn:");
            }

            System.out.print("\nEnter key: ");
            int key = sc.nextInt();

            if (!board.movePlayed(key)) {
                System.out.println("Enter valid number\n");
                continue;
            }

            board.updateBoard(key);

            if (board.getMove_number() == 9 && board.checkWin() == 0) {
                System.out.println("\nGame Drawn\n");
                board.showBoard();
                return;
            }
        }

        board.showBoard();
        if (board.winner == board.p1.getSymbol()) {
            System.out.println("\nCongratulations Player two\n");
        } else {
            System.out.println("\nCongratulations Player one\n");
        }
    }
}
