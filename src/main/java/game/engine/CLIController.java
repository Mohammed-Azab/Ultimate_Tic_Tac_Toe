package game.engine;

import game.entity.AiPlayer;
import game.entity.Board;
import game.entity.GameStatus;
import game.entity.Player;

public class CLIController {
    GameStatus status= GameStatus.Ongoing;
    private Player player1;
    private Player player2;
    private Board board;
    public CLIController() {
        player1 = new Player();
        player2 = new Player();
        board = new Board(3);
    }
    public void makePlayerAi(){
        player2 =new AiPlayer();
    }

    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public Board getBoard() {
        return board;
    }
    public GameStatus getStatus() {
        return status;
    }


}
