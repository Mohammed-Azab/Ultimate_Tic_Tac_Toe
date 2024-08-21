package game.entity;

public class MiniBoard extends Board {
    private final Cell[][] cells;

    public MiniBoard() {
        super();
        cells = new Cell[size][size];
        initializeMiniBoard();
    }

    private void initializeMiniBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setNumber((i+1)*10+j);
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

    @Override
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

    public boolean hasWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < size; i++) {
            if (cells[i][0].getState() != CellState.EMPTY &&
                    cells[i][0].getState() == cells[i][1].getState() &&
                    cells[i][1].getState() == cells[i][2].getState()) {
                winnerMark= cells[i][0].getState()==CellState.O? Mark.O : Mark.X;
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < size; i++) {
            if (cells[0][i].getState() != CellState.EMPTY &&
                    cells[0][i].getState() == cells[1][i].getState() &&
                    cells[1][i].getState() == cells[2][i].getState()) {
                winnerMark= cells[0][i].getState()==CellState.O? Mark.O : Mark.X;
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (cells[0][0].getState() != CellState.EMPTY &&
                cells[0][0].getState() == cells[1][1].getState() &&
                cells[1][1].getState() == cells[2][2].getState()) {
            winnerMark= cells[1][1].getState()==CellState.O? Mark.O : Mark.X;
            return true;
        }
        if (cells[0][2].getState() != CellState.EMPTY &&
                cells[0][2].getState() == cells[1][1].getState() &&
                cells[1][1].getState() == cells[2][0].getState()) {
            winnerMark= cells[1][1].getState()==CellState.O? Mark.O : Mark.X;
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getState() != CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


}
