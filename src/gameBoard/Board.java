package gameBoard;

import java.util.ArrayList;

public class Board {
    private Integer numberOfRow;
    private Integer numberOfCol;
    private ArrayList<Cell> cells;

    public Board(Integer numberOfRow, Integer numberOfCol) {
        this.numberOfRow = numberOfRow;
        this.numberOfCol = numberOfCol;
        cells = new ArrayList<>();
        for(int row = 0; row < numberOfRow; row++)
            for (int col = 0; col < numberOfCol; col++)
                cells.add(new Cell(new Coordinate(row, col), null));
    }

    public Cell getCell(Integer row, Integer col) {
        assert(row < numberOfRow && col < numberOfCol);
        return cells.get(numberOfCol * row + col);
    }

    public Cell getCell(Integer idx) {
        assert (idx < cells.size());
        return cells.get(idx);
    }
}
