package org.example.ServiceImpl;

import org.example.Model.Board;
import org.example.Model.Player;
import org.example.Service.botPlayingStratergy.BotPlayingStratergy;

public class BotPlayingStratergyFactory {

    public static BotPlayingStratergy getBotPlayingStratergy(){
        return new RandomBotPlayaingStratergy();
    }
}
