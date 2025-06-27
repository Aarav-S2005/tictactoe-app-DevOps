package com.example;

import java.util.Arrays;

class TicTacToe {
    //p1==true turn
    //p2==false turn
    Player p1;
    Player p2;
    boolean turn;
    char winner;
    int games_played = 0;
    private final static int[][] winning_combination = {{1,2,3}, {4,5,6}, {7,8,9}, {3,6,9}, {1,4,7}, {2,5,8}, {1,5,9}, {3,5,7}};
    private String current_board = "#---#---#---#\n" +
            "| 1 | 2 | 3 |\n" +
            "#---#---#---#\n" +
            "| 4 | 5 | 6 |\n" +
            "#---#---#---#\n" +
            "| 7 | 8 | 9 |\n" +
            "#---#---#---#";
    private final static String defaultBoard = "#---#---#---#\n" +
            "| 1 | 2 | 3 |\n" +
            "#---#---#---#\n" +
            "| 4 | 5 | 6 |\n" +
            "#---#---#---#\n" +
            "| 7 | 8 | 9 |\n" +
            "#---#---#---#";
    private int[] moves_played = new int[9];
    private int move_number =0;

    TicTacToe(char one){
        p1= new Player(one);
        p2 = (one == 'X')? new Player('O'): new Player('X');
        this.turn = p1.getSymbol()=='X';
    }

    int getMove_number(){
        return move_number;
    }

    boolean movePlayed(int key){
        for(int i=0;i<9;i++){
            if(key==moves_played[i]) return false;
        }
        return true;
    }

    void updateBoard(int key){
        if(this.turn){
            this.current_board= this.current_board.replace((char) (key+48), p1.getSymbol());
            p1.addMove(key);
        }
        else {
            this.current_board= this.current_board.replace((char) (key+48), p2.getSymbol());
            p2.addMove(key);
        }
        move_number++;
        turn = !turn;
    }

    private static boolean contains(int[] subarray, int[] array){

        for(int i=0; i<subarray.length;i++){
            boolean flag = false;
            for(int j=0;j< array.length;j++){
                if(array[j] == subarray[i]){
                    flag= true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }

    int checkWin(){
        //return 1 if someone wins and 0 if the match is draw
        char sym = (!turn)? p1.getSymbol(): p2.getSymbol();
        int[] move= (!turn)? p1.moveArray(): p2.moveArray();
        for(int i=0;i<8;i++){
            if( contains(winning_combination[i], move)){
                winner = sym;
                games_played++;
                if(p1.getSymbol()==sym) p1.addScore();
                else p2.addScore();
                p1.changeSymbol();
                p2.changeSymbol();
                return 1;
            }
        }
        if(move_number==9) games_played++;
        return 0;
    }

    void resetBoard(){
        this.current_board = defaultBoard;
        turn = winner == 'X';
        this.move_number=0;
        winner = 'N';
        Arrays.fill(moves_played, 0);
        p1.changeSymbol();
        p2.changeSymbol();
        p1.moves.clear();
        p2.moves.clear();
    }

    void showBoard(){
        System.out.println(current_board);

    }
}