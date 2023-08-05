package com.tictaktoe.model;

import com.tictaktoe.exception.InvalidNumberOfPlayer;
import com.tictaktoe.winstatergy.OrderOneWinningStatergy;
import com.tictaktoe.winstatergy.PlayerWinStatergy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private List<Move> moves;
    private GameStatus gameStatus;

    private PlayerWinStatergy playerWinStatergy;

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Game(GameBuilder builder) {
        this.board = builder.board;
        this.gameStatus = builder.gameStatus;
        this.currentPlayerIndex = builder.currentPlayerIndex;
        this.moves = builder.moves;
        this.players = builder.players;
        this.playerWinStatergy = builder.playerWinStatergy;
    }
    
    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void display(){
        board.display();
    }

    public void makeMove(){

        /*
        1. Get the cell on which the player wants to move,
        2. Validate the cell
        3. If the cell looks good, then make the move
        4. Check for win or draw
        5. If there is a win or a draw, update the game status accordingly
        6. Else increment currentPlayerIndex
         */

        Player currentPlayer = players.get(currentPlayerIndex);
        Pair<Integer,Integer> nextMove = currentPlayer.nextMove(board);
        while (!validate(nextMove)){
            System.out.println("Not a valid move. Please enter new value");
            nextMove = currentPlayer.nextMove(board);
        }

        Cell cell = board.getBoard()[nextMove.getKey()][nextMove.getValue()];
        cell.setPlayer(currentPlayer);
        Move currentMove = new Move(cell,currentPlayer);
        moves.add(currentMove);

        if(checkForWin(currentMove)){
            gameStatus = GameStatus.END;
            return;
        }
        if(checkForDraw()){
            gameStatus = GameStatus.DRAW;
            return;
        }
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
    private boolean checkForWin(Move move){
        return playerWinStatergy.hasWon(move);
    }
    private boolean checkForDraw(){
        return moves.size() == board.getSize() * board.getSize();
    }
    private boolean validate(Pair<Integer,Integer> nextMove){
        boolean isValidCell = 0 <= nextMove.getKey() && nextMove.getKey() < board.getSize() &&
            0 <= nextMove.getValue() && nextMove.getValue() < board.getSize();
        if (!isValidCell){
            return false;
        }
        Cell cell = board.getBoard()[nextMove.getKey()][nextMove.getValue()];
        return cell.getCellStatus().equals(CellStatus.AVAILABLE);
    }
    public static class GameBuilder{
        private Board board;
        private List<Player> players;
        private int currentPlayerIndex;
        private List<Move> moves;
        private GameStatus gameStatus;
        private PlayerWinStatergy playerWinStatergy;
        
        public GameBuilder setPlayer(List<Player> players){
            this.players = players;
            return this;
        }
        public Game build() throws InvalidNumberOfPlayer {
            if(players == null || players.size() == 0){
                throw new InvalidNumberOfPlayer("Number of player is 0");
            }
            
            this.board = new Board(players.size()+1);
            this.gameStatus = GameStatus.IN_PROGRESS;
            this.moves = new ArrayList<>();
            this.currentPlayerIndex = 0;
            this.playerWinStatergy = new OrderOneWinningStatergy(board.getSize());
            return new Game(this);
        }
    }
}
