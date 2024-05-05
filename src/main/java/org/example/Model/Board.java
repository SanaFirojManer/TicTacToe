package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> matrix;

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Board(int dimension) {
        this.dimension = dimension;
        matrix = new ArrayList<>(); //for outer list
        for(int i=0;i<dimension;i++){
            matrix.add(new ArrayList<>()); //adding internal array list
            for(int j=0;j<dimension;j++){
                matrix.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        for(int i=0;i<dimension; i++){
            List<Cell> cells = new ArrayList<>();

            for(Cell cell : cells){
                cell.displayCell();
            }
            System.out.println();
        }
    }


}
