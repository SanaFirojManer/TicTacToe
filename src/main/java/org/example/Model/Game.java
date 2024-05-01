package org.example.Model;

import org.example.Exception.InvalidBotCountException;
import org.example.Exception.InvalidPlayerSizeException;
import org.example.Exception.InvalidSymbolSetupExxception;
import org.example.Model.Enum.GameStatus;
import org.example.Model.Enum.PlayerType;
import org.example.Service.WinningStratergiy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Board currentBoard;

    private List<Player> players;

    private GameStatus gameStatus;

    private Player currentPlayer;

    private List<Move> moves;

    private List<Board> boardStates;

    private WinningStrategy winningStrategy;

    private int numberOfSymbols;


    //builder design pattern
    private Game(Board currentBoard, List<Player> payers, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = payers;
       this.currentPlayer = null;
        this.gameStatus = gameStatus;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = 0;
    }

    public Builder builder(){
        return new Builder();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public List<Player> getPayers() {
        return players;
    }

//    public Player getCurrentPlayer() {
//        return currentPlayer;
//    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setPayers(List<Player> payers) {
        this.players = payers;
    }

//    public void setCurrentPlayer(Player currentPlayer) {
//        this.currentPlayer = currentPlayer;
//    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public static class Builder{
        private Board currentBoard;

        private List<Player> players;

        private WinningStrategy winningStrategy;

        private int dimension;

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPayers(List<Player> payers) {
            this.players = payers;
            return this;
        }


        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this ;
        }

        private void validateNumberOfPlayers(){
            //N, no bot, players-->N-1
            //N, bot, players -->N-2
            if(players.size()< currentBoard.getDimension()-2 || players.size() >= currentBoard.getDimension()){
                throw new InvalidPlayerSizeException("Player size should ne N-2 or N-1 as per board size");
            }

        }

        private void validatePlayerSymbol(){
            HashSet<Character> symbols = new HashSet<>();
            for(Player player : players){
                symbols.add(player.getSymbol());
            }

            if(symbols.size() != players.size()){
                throw new InvalidSymbolSetupExxception("There should be unique symbol for all the plyayers ");
            }
        }

        private void validateBotCount(){
            int botCount =0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if(botCount > 1 || botCount<0){
                throw new InvalidBotCountException("We can have maximum one bot a game");
            }
        }

        private void validate(){
            validateBotCount();
            validateNumberOfPlayers();
            validatePlayerSymbol();
        }

        public Game build(){
            validate();
            return new Game(new Board(dimension),players,winningStrategy);
        }
    }
}
