package com.tictaktoe.model;

public class Cell {
    
    private int row;
    private int col;
    private Player player;

    public Cell(int row, int col, CellStatus cellStatus) {
        this.row = row;
        this.col = col;
        this.cellStatus = cellStatus;
    }

    private CellStatus cellStatus;

    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.cellStatus = CellStatus.OCCUPIED;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public void remove(){
        this.cellStatus = CellStatus.AVAILABLE;
        this.player = null;
    }
}
