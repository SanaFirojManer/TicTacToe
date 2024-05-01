package org.example.Model;

import org.example.Model.Enum.PlayerType;

public class Player {
    private char symbol;

    private PlayerType playerType;

    public char getSymbol() {
        return symbol;

    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
