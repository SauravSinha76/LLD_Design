import com.tictaktoe.controller.GameController;
import com.tictaktoe.exception.InvalidNumberOfPlayer;
import com.tictaktoe.model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class TicTakToe {
    public static void main(String[] args) throws InvalidNumberOfPlayer {
        Scanner sc = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        System.out.println("Enter the number of human player");
        int n = sc.nextInt();
        for(int i =0;i<n;i++){
            System.out.println("Enter the name of human player");
            String name = sc.next();
            System.out.println("Enter the symbol for the player");
            char symbol = sc.next().charAt(0);
            players.add(new HumanPlayer(name,symbol));
        }
        System.out.println("Does it have bot? Y/N");
        String res = sc.next();
        if(res.equalsIgnoreCase("y")){
            players.add(new Bot("Bot-1",'B', BotLevel.EASY));
        }
        GameController gameController = new GameController();
        Game game = gameController.getGame(players);
        boolean isFirstMove = true;
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            gameController.makeMove(game);
            if(!isFirstMove){
                gameController.undo(game);
            } else {
                isFirstMove = false;
            }
            gameController.display(game);
        }

        if(game.getGameStatus().equals(GameStatus.END)){
            Player currentPlayer = game.getPlayers().get(game.getCurrentPlayerIndex());
            System.out.println(currentPlayer.getName() +" has won!");
        }

        if(game.getGameStatus().equals(GameStatus.DRAW)){
            System.out.println("Game has drawn");

        }
    }
}
