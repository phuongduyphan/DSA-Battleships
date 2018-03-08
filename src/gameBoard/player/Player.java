package gameBoard.player;

import gameBoard.Board;

public abstract class Player {
    private Player nextPlayer;
    private Board board;

    public abstract void play();

    public abstract boolean checkWin();

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public Board getBoard() {
        return board;
    }
}
