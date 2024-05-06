package org.example.ServiceImpl;

import org.example.Model.Board;
import org.example.Model.Cell;
import org.example.Model.Move;
import org.example.Model.Player;
import org.example.Service.WinningStratergiy.WinningStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStratergy implements WinningStrategy {
    private int dimension;

    private List<HashMap<Character,Integer>> rowHashMapLlist;

    private List<HashMap<Character,Integer>> colHashMapList;

    private HashMap<Character,Integer> leftDigonal;

    private HashMap<Character,Integer> rightDigonal;

    private HashMap<Character,Integer> cornerHashMap;

    public OrderOneWinningStratergy(int dimension) {
        this.dimension = dimension;
        this.rowHashMapLlist = new ArrayList<>();
        this.colHashMapList = new ArrayList<>();
        this.leftDigonal = new HashMap<>();
        this.rightDigonal = new HashMap<>();
        this.cornerHashMap = new HashMap<>();

        for(int i=0;i<dimension;i++){
            rowHashMapLlist.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean winnerResult = winnerCheckForCorners(board.getMatrix(),symbol)
                || checkAndUpdateForRowHashMap(row,symbol)
                || checkAndUpdateForColHashMap(col,symbol)
                || (checkLeftDigonal(row,col) && checkAndUpdateLeftDigonalHashMap(symbol))
                || (checkRightDigonal(row,col) && checkAndUpdateRightDigonalHashMap(symbol));

                if (winnerResult)
                    return player;
                else
                    return null;

    }

    private boolean checkAndUpdateForRowHashMap(int row, char symbol){
        HashMap<Character,Integer> rowHashMap = rowHashMapLlist.get(row);
        if(rowHashMap.containsKey(symbol)){
            rowHashMap.put(symbol,rowHashMap.get(symbol)+1);
            return rowHashMap.get(symbol) == dimension;
        } else{
            rowHashMap.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateForColHashMap(int col, char symbol){
        HashMap<Character,Integer> colHashMap = rowHashMapLlist.get(col);
        if(colHashMap.containsKey(symbol)){
            colHashMap.put(symbol,colHashMap.get(symbol)+1);
            return colHashMap.get(symbol) == dimension;
        } else{
            colHashMap.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateLeftDigonalHashMap(char symbol){
        if(leftDigonal.containsKey(symbol)){
            leftDigonal.put(symbol,leftDigonal.get(symbol)+1);
            return leftDigonal.get(symbol)== dimension;
        } else {
            leftDigonal.put(symbol,1);

        }
        return  false;
    }

    private boolean checkAndUpdateRightDigonalHashMap(char symbol){
        if(rightDigonal.containsKey(symbol)){
            rightDigonal.put(symbol,rightDigonal.get(symbol)+1);
            return rightDigonal.get(symbol)== dimension;
        } else {
            rightDigonal.put(symbol,1);
        }
        return  false;
    }

    private boolean winnerCheckForCorners(List<List<Cell>> matrix, char symbol){
        if(cornerHashMap.containsKey(symbol)){
            cornerHashMap.put(symbol,cornerHashMap.get(symbol)+1);
            return cornerHashMap.get(symbol)== 4;
        } else {
            cornerHashMap.put(symbol,1);
        }
        return  false;
    }

    private boolean checkLeftDigonal(int row, int col){
        return row == col;
    }

    private boolean checkRightDigonal(int row, int col){
        return (row + col) == (dimension-1);
    }

}
