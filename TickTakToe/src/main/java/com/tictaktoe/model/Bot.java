package com.tictaktoe.model;

import com.tictaktoe.botStatergy.BotPlayingStatergy;
import com.tictaktoe.fatory.BotPlayingStatergyFactory;

public class Bot extends Player{
    private final BotLevel botLevel;
    private BotPlayingStatergy botPlayingStatergy;

    public Bot(String name, char symbol, BotLevel botLevel) {
        super(name, symbol);
        this.botLevel = botLevel;
        this.botPlayingStatergy = BotPlayingStatergyFactory.getStatergy(botLevel);
    }

    @Override
    public Pair<Integer,Integer> nextMove(Board board) {
        return botPlayingStatergy.getnextMove(board);
    }
}
