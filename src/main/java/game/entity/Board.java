package game.entity;

public class Board {
    protected final int size=3;
    private MiniBoard[][] miniBoards;
    protected Mark winnerMark;

    public Board(int size) {
        this.miniBoards = new MiniBoard[size][size];
        initializeBoard();
    }
    public Board() {
    }

    protected void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                miniBoards[i][j] = new MiniBoard();
            }
        }
    }

    public MiniBoard getMiniBoard(int row, int col) {
        validateCoordinates(row, col);
        return miniBoards[row][col];
    }

    public void setMiniBoardCell(int miniBoardRow, int miniBoardCol, int cellRow, int cellCol, CellState state) {
        validateCoordinates(miniBoardRow, miniBoardCol);
        miniBoards[miniBoardRow][miniBoardCol].setCell(cellRow, cellCol, state);
    }

    protected void validateCoordinates(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid board coordinates.");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!miniBoards[i][j].isFull()) {
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
            if (miniBoards[i][0].getWinnerMark() != Mark.EMPTY &&
                    miniBoards[i][0].getWinnerMark() == miniBoards[i][1].getWinnerMark() &&
                    miniBoards[i][1].getWinnerMark() == miniBoards[i][2].getWinnerMark()) {
                winnerMark= miniBoards[i][0].getWinnerMark();
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < size; i++) {
            if (miniBoards[0][i].getWinnerMark() != Mark.EMPTY &&
                    miniBoards[0][i].getWinnerMark() == miniBoards[1][i].getWinnerMark() &&
                    miniBoards[1][i].getWinnerMark() == miniBoards[2][i].getWinnerMark()) {
                winnerMark= miniBoards[0][i].getWinnerMark();
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (miniBoards[0][0].getWinnerMark() != Mark.EMPTY &&
                miniBoards[0][0].getWinnerMark() == miniBoards[1][1].getWinnerMark() &&
                miniBoards[1][1].getWinnerMark() == miniBoards[2][2].getWinnerMark()) {
            winnerMark= miniBoards[1][1].getWinnerMark();
            return true;
        }
        if (miniBoards[0][2].getWinnerMark() != Mark.EMPTY &&
                miniBoards[0][2].getWinnerMark() == miniBoards[1][1].getWinnerMark() &&
                miniBoards[1][1].getWinnerMark() == miniBoards[2][0].getWinnerMark()) {
            winnerMark= miniBoards[1][1].getWinnerMark();
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public Mark getWinnerMark() {
        return winnerMark;
    }

}
