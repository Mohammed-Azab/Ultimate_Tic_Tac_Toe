package game.engine;

import game.Utility.AiPlayer;
import game.Utility.GameStatus;
import game.Utility.Player;

public class Contoller {
    GameStatus status= GameStatus.Ongoing;
    Player player1;
    Player player2;
    public Contoller() {
        player1 = new Player();
        player2 = new Player();

    }

    public void makePlayerAi(){
        player2 =new AiPlayer();
    }

}
