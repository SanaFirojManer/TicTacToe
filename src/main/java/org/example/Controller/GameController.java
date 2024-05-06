package org.example.Controller;

import org.example.Model.Board;
import org.example.Model.Enum.GameStatus;
import org.example.Model.Enum.WinningStrategyName;
import org.example.Model.Game;
import org.example.Model.Move;
import org.example.Model.Player;
import org.example.ServiceImpl.WinningStrategyFactory;

import java.util.List;

import static org.example.Model.Game.*;

public class GameController {
    //create game will automatically start the game
    //create game will automatically start the game
    public Game createGame(int dimension, List<Player> players, WinningStrategyName name){
        return builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinningStratergy(name, dimension))
                .build();
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public Move executeMove(Game game, Player player){
        return player.makeMove(game.getCurrentBoard());
    }

    public Player checkWinner(Game game, Move lastMovePlayed){
        return game.getWinningStrategy().checkWinner(game.getCurrentBoard(), lastMovePlayed);
    }

    public Board undoMove(Game game, Move lastPlayedMove){
        return null;
    }

    public void replayGame(Game game){

    }
}
