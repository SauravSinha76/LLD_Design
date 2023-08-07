package com.tictaktoe.winstatergy;

import com.tictaktoe.model.Move;

public interface PlayerWinStatergy {

    public boolean hasWon(Move move);

    public void handleUndo(Move move);
}
