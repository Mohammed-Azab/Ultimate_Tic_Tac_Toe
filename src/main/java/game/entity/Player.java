package game.entity;

public class Player {
    protected String name;
    protected int score;
    protected Mark mark;
    PlayerState playerState;

    public Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public Mark getMark() {
        return mark;
    }
    public void setMark(Mark mark) {
        this.mark = mark;
    }


    public boolean isAiPlayer(){
        return false;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }
    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }



}
