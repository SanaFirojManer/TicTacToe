package org.example.ServiceImpl;

import org.example.Exception.GameOverException;
import org.example.Model.Board;
import org.example.Model.Cell;
import org.example.Model.Enum.CellState;
import org.example.Model.Move;
import org.example.Model.Player;
import org.example.Service.botPlayingStratergy.BotPlayingStratergy;

import java.util.List;

public class RandomBotPlayaingStratergy implements BotPlayingStratergy {
    @Override
    public Move makeMove(Board board, Player bot) {
        List<List<Cell>> matrix = board.getMatrix();
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.size();j++){
                if(matrix.get(i).get(j).getCellState().equals(CellState.EMPTY));{
                    board.getMatrix().get(i).get(j).setPlayer(bot);
                    board.getMatrix().get(i).get(j).setCellState(CellState.FILLED);
                    return new Move(board.getMatrix().get(i).get(j),bot);
                }
            }
        }
        throw new GameOverException("There are no empty cells in the board");
    }
}
