package game.entity;

public enum Mark {
    X,
    O,
    EMPTY;

    @Override
    public String toString() {
        switch (this) {
            case X:
                return "X";
            case O:
                return "O";
                case EMPTY:
                    return "Empty";
            default:
                throw new AssertionError("Unknown mark: " + this);
        }
    }

    public Mark opposite() {
        return this == X ? O : X;
    }
}
