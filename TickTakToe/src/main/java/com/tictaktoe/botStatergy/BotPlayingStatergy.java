package com.tictaktoe.botStatergy;

import com.tictaktoe.model.Board;
import com.tictaktoe.model.Pair;

public interface BotPlayingStatergy {

    public Pair<Integer,Integer> getnextMove(Board board);
}
