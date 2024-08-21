package game.entity;

public class AiPlayer extends Player {
    public AiPlayer() {
        super.name = "Azab";
    }












    @Override
    public boolean isAiPlayer(){
        return true;
    }
}
