package game.Utility;

public enum GameStatus {
    Win,
    Lost,
    Draw,
    Ongoing;

    public boolean isGameOver() {
        return this == Win || this == Lost || this == Draw;
    }

    public String getMessage() {
        switch (this) {
            case Win:
                return "Congratulations! You've won the game!";
            case Lost:
                return "You lost. Better luck next time!";
            case Draw:
                return "It's a draw. Play again to break the tie!";
            case Ongoing:
                return "The game is still ongoing. Keep playing!";
            default:
                return "";
        }
    }

    public boolean isSuccessful() {
        return this == Win || this == Draw;
    }

    public static GameStatus fromString(String status) {
        switch (status.toLowerCase()) {
            case "win":
                return Win;
            case "lost":
                return Lost;
            case "draw":
                return Draw;
            case "ongoing":
                return Ongoing;
            default:
                throw new IllegalArgumentException("Unknown status: " + status);
        }
    }

    public GameStatus next() {
        switch (this) {
            case Win:
                return Lost;
            case Lost:
                return Draw;
            case Draw:
                return Ongoing;
            case Ongoing:
                return Win;
            default:
                throw new AssertionError("Unknown status: " + this);
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case Win:
                return "Win";
            case Lost:
                return "Lost";
            case Draw:
                return "Draw";
            case Ongoing:
                return "Ongoing";
            default:
                return super.toString();
        }
    }
}
