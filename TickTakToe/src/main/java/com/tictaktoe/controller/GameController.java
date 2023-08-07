package com.tictaktoe.controller;

import com.tictaktoe.exception.InvalidNumberOfPlayer;
import com.tictaktoe.model.Game;
import com.tictaktoe.model.Player;

import java.util.List;

public class GameController {

    public Game getGame(List<Player> players) throws InvalidNumberOfPlayer {
        return Game.getBuilder()
                .setPlayer(players)
                .build();
    }

    public void display(Game game){
        game.display();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undo(Game game){
       game.undo();
    }
}
