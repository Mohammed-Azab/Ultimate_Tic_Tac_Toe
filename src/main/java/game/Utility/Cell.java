package game.Utility;

public class Cell {
    private CellState state;

    public Cell() {
        this.state = CellState.EMPTY; // Default state
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
