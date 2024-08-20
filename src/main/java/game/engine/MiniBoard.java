package game.engine;

public class MiniBoard extends Board {

    public MiniBoard() {
        super(3);
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (getCell(i, j).getState() == CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner() {
        // Check rows, columns, and diagonals for a winner
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < getSize(); i++) {
            if (getCell(i, 0).getState() != CellState.EMPTY &&
                    getCell(i, 0).getState() == getCell(i, 1).getState() &&
                    getCell(i, 1).getState() == getCell(i, 2).getState()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < getSize(); i++) {
            if (getCell(0, i).getState() != CellState.EMPTY &&
                    getCell(0, i).getState() == getCell(1, i).getState() &&
                    getCell(1, i).getState() == getCell(2, i).getState()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (getCell(0, 0).getState() != CellState.EMPTY &&
                getCell(0, 0).getState() == getCell(1, 1).getState() &&
                getCell(1, 1).getState() == getCell(2, 2).getState()) {
            return true;
        }
        if (getCell(0, 2).getState() != CellState.EMPTY &&
                getCell(0, 2).getState() == getCell(1, 1).getState() &&
                getCell(1, 1).getState() == getCell(2, 0).getState()) {
            return true;
        }
        return false;
    }
}
