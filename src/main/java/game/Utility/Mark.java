package game.Utility;

public enum Mark {
    X,
    O;

    @Override
    public String toString() {
        switch (this) {
            case X:
                return "X";
            case O:
                return "O";
            default:
                throw new AssertionError("Unknown mark: " + this);
        }
    }

    public Mark opposite() {
        return this == X ? O : X;
    }
}
