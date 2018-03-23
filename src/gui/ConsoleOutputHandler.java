package gui;

import gameBoard.Board;
import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.player.Player;

public class ConsoleOutputHandler extends OutputHandler {
    @Override
    public void display(Player player) {
        Board board = player.getBoard();
        for (int i = 0; i < board.getRow(); i++) {
            for (int j = 0; j < board.getRow(); j++) {
                Cell cell = board.getCellAt(new Coordinate(i, j));
                System.out.print(cell.getShip().toString().charAt(0));
            }
        }
    }
}
