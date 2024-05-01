package org.example.Service.WinningStratergiy;

import org.example.Model.Board;
import org.example.Model.Move;
import org.example.Model.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
