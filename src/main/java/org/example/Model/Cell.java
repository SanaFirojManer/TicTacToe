package org.example.Model;

import org.example.Model.Enum.CellState;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row) {
        this.row = row;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = cellState;
        this.player = player;
    }

    public void displayCell(){
        if(player==null){
            System.out.print("| |");
        }

        else{
            System.out.print("|" +player.getSymbol() + "|");
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
