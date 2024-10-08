package game.entity;

public class Cell {
    private CellState state;
    private int number;

    public Cell() {
        this.state = CellState.EMPTY;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOccupied() {
        return state != CellState.EMPTY;
    }

    public void putMark(Mark mark) {
        switch (mark) {
            case X:
                state = CellState.X;  break;
                case O:
                    state = CellState.O; break;
                    default:
                        state = CellState.EMPTY;
        }
    }

}
