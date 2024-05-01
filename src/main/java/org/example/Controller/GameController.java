package org.example.Controller;

import org.example.Model.Board;
import org.example.Model.Game;
import org.example.Model.Move;
import org.example.Model.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimention, List<Player> players){

        return null;
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public void gameStatus(Game game){

    }

    public Player getWinner(Game game){
        return null;
    }

    public Move executeMove(Game game){
        return null;
    }

    public Player checkWinner(Game game, Move lastMovePlayed){
        return null;
    }

    public Board undoMove(){
        return null;
    }

    //doremon approch
    public void replayGame(Game game){

    }

}
