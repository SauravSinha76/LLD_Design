package com.tictaktoe.winstatergy;

import com.tictaktoe.model.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStatergy implements PlayerWinStatergy{

    private List<Map<Character,Integer>> rows;

    private List<Map<Character,Integer>> cols;

    private Map<Character,Integer> diagonal;
    private Map<Character,Integer> antiDiagonal;


    public OrderOneWinningStatergy(int n) {
        rows = new ArrayList<>();
        cols = new ArrayList<>();
        for(int i =0;i< n;i++){
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
        }
        diagonal = new HashMap<>();
        antiDiagonal = new HashMap<>();

    }



    @Override
    public boolean hasWon(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        Map<Character,Integer> map = rows.get(row);
        map.put(symbol, map.getOrDefault(symbol,0)+1);

        map = cols.get(col);
        map.put(symbol, map.getOrDefault(symbol,0)+1);

        if(row == col){
            diagonal.put(symbol,diagonal.getOrDefault(symbol,0)+1);
        }
        int n = rows.size();
        if(row + col == n-1){
            antiDiagonal.put(symbol,antiDiagonal.getOrDefault(symbol,0)+1);
        }

        boolean wonByRow = rows.get(row).getOrDefault(symbol,0) == n;
        boolean wonByCol = cols.get(col).getOrDefault(symbol,0) == n;
        boolean wonByDiagonal = diagonal.getOrDefault(symbol,0) == n;
        boolean wonByAntiDiagonal = antiDiagonal.getOrDefault(symbol,0) == n;

        return wonByRow || wonByCol || wonByDiagonal || wonByAntiDiagonal;

    }
}
