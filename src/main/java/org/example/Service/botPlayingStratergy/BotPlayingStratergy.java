package org.example.Service.botPlayingStratergy;

import org.example.Model.Board;
import org.example.Model.Move;
import org.example.Model.Player;

public interface BotPlayingStratergy {
    Move makeMove(Board board, Player player);
}
