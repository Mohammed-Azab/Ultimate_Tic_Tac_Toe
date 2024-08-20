package game.engine;

public enum CellState {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String symbol;

    CellState(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static CellState fromSymbol(String symbol) {
        for (CellState state : values()) {
            if (state.symbol.equals(symbol)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown symbol: " + symbol);
    }
}
