package com.tictaktoe.model;

import java.util.Scanner;

public class Player {
    
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }


    public Pair<Integer,Integer> nextMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println(name+"'s turn, please enter rwo and column");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new Pair<>(row,col);
    }
}
