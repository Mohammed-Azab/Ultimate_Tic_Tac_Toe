package game.engine;

import game.entity.*;

public class CLIController {
    GameStatus status= GameStatus.Ongoing;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    public CLIController() {
        player1 = new Player();
        player2 = new Player();
        currentPlayer = player1;
        player1.setPlayerState(PlayerState.ACTIVE);
        player2.setPlayerState(PlayerState.INACTIVE);
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
    public GameStatus getGameStatus() {
        return status;
    }
    public void setGameStatus(GameStatus status) {
        this.status = status;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }


}
