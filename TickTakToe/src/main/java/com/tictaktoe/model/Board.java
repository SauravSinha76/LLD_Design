package com.tictaktoe.model;

public class Board {
    private Cell[][] board;
    private int size;

    public int getSize() {
        return size;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Board(int n){
        this.size = n;
        this.board = new Cell[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = new Cell(i,j,CellStatus.AVAILABLE);
            }
        }
    }

    public void display(){
        for(int i =0 ;i < size;i++){
            for(int j =0;j< size;j++){
                if(board[i][j].getCellStatus().equals(CellStatus.AVAILABLE)){
                    System.out.print(" _ ");
                }else {
                    System.out.print(" "+board[i][j].getPlayer().getSymbol()+" ");
                }
            }
            System.out.println();
        }
    }
}
