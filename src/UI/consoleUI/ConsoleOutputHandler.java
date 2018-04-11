package UI.consoleUI;

import gameBoard.Board;
import gameBoard.player.Player;

public class ConsoleOutputHandler extends OutputHandler {
	private static ConsoleOutputHandler instance;

    public static ConsoleOutputHandler getInstance() {
        if (instance == null) instance = new ConsoleOutputHandler();
        return instance;
    }
    @Override
    public void display(Player player) {
        Board board = player.getBoard();
        board.displayBoard();
//        for (int i = 0; i < board.getNumberOfRows(); i++) {
//            for (int j = 0; j < board.getNumberOfColumns(); j++) {
//                Cell cell = board.getCellAt(new Coordinate(i, j));
//                ifSystem.out.print(cell.getShip().toString().charAt(0));
//            }
//        }
    }
}
