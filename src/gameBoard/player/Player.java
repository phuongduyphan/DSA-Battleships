package gameBoard.player;

import gameBoard.Board;
import gui.Command;
import gui.CommandStage3;
import gui.IClickable;

public abstract class Player implements IClickable {
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

    @Override
    public void onClick(Command targetCommand) {
        if(targetCommand instanceof CommandStage3) {
            CommandStage3 cmd3 = (CommandStage3)targetCommand;
            cmd3.setTargetPlayer(this);
        } else throw new Error("In Player.java, onClick(), the targetCmd is not the right type of Cmd to be used with Player");
    }
}
