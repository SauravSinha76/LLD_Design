package com.tictaktoe.botStatergy;

import com.tictaktoe.exception.InvalidGameStatergyException;
import com.tictaktoe.model.Board;
import com.tictaktoe.model.CellStatus;
import com.tictaktoe.model.Pair;

public class EasyBotPayingStatergy implements BotPlayingStatergy{

    @Override
    public Pair<Integer, Integer> getnextMove(Board board) {
        for(int i = 0;i< board.getSize();i++){
            for(int j =0;j<board.getSize();j++){
                if(board.getBoard()[i][j].getCellStatus().equals(CellStatus.AVAILABLE)){
                    return new Pair<>(i,j);
                }
            }
        }
        throw new InvalidGameStatergyException("No valid move left for bot");
    }

}
