package game.Utility;

public class Board {
    protected final int size;
    protected final Cell[][] cells;

    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int col) {
        validateCoordinates(row, col);
        return cells[row][col];
    }

    public void setCell(int row, int col, CellState state) {
        validateCoordinates(row, col);
        cells[row][col].setState(state);
    }

    private void validateCoordinates(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid board coordinates.");
        }
    }

    public int getSize() {
        return size;
    }

    // Optionally add methods for checking the status of the board
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getState() == CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
