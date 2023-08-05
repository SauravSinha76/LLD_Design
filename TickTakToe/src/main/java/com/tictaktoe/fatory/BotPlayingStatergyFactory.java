package com.tictaktoe.fatory;

import com.tictaktoe.botStatergy.BotPlayingStatergy;
import com.tictaktoe.botStatergy.EasyBotPayingStatergy;
import com.tictaktoe.exception.InvalidGameStatergyException;
import com.tictaktoe.model.Board;
import com.tictaktoe.model.BotLevel;

public class BotPlayingStatergyFactory {

    public static BotPlayingStatergy getStatergy(BotLevel level){
        switch (level){
            case EASY: return new EasyBotPayingStatergy();
            case MEDIUM:
            case HARD:
            default: throw new InvalidGameStatergyException("Not statrgy defined");
        }
    }
}
