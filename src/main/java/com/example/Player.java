package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Player{
    private char symbol;
    private int score;
    public List<Integer> moves = new ArrayList<>();

    Player(char symbol){
        this.symbol = symbol;
    }

    char getSymbol(){
        return this.symbol;
    }
    int getScore(){
        return this.score;
    }
    void changeSymbol(){
        this.symbol = (this.symbol=='X')? 'O': 'X';
    }
    void addScore(){
        this.score++;
    }
    void addMove(int num){
        moves.add(num);
        Collections.sort(moves);
    }
    int[] moveArray(){
        int[] arr = new int[moves.size()];
        for (int i=0;i<moves.size();i++){
            arr[i] = moves.get(i);
        }
        return arr;
    }
}
