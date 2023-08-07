package com.tictaktoe.model;

import java.util.Scanner;

public class HumanPlayer extends Player implements Undoable{
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    public Pair<Integer,Integer> nextMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println(this.getName()+"'s turn, please enter rwo and column");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new Pair<>(row,col);
    }
    @Override
    public boolean undo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to do? Y/N");
        char input = scanner.next().charAt(0);
        return input == 'y' || input == 'Y';
    }
}
