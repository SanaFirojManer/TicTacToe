package org.example.Model;

import org.example.Model.Enum.BotDifficultyLevel;
import org.example.Model.Enum.PlayerType;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "CHITTI", symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        return null;
    }
}
