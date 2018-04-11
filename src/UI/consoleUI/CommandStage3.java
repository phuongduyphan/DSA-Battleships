package gui;

import gameBoard.Coordinate;
import gameBoard.GameHandler;
import gameBoard.cell.Cell;
import gameBoard.player.Player;
import gameBoard.weapon.Weapon;

public class CommandStage3 extends Command {
    private Player targetPlayer;
    private Weapon weapon;
    private Cell cell;

    @Override
    public boolean isCompleted() {
        if (targetPlayer != null && weapon != null && cell != null) return true;
        return false;
    }

    @Override
    public void onFinished() {
        GameHandler.getInstance().input(this);
    }

    public Player getTargetPlayer() { return targetPlayer; }

    public void setTargetPlayer(Player targetPlayer) { this.targetPlayer = targetPlayer; }

    public Weapon getWeapon() { return weapon; }

    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    public Cell getCell() { return cell; }

    public void setCell(Cell cell) { this.cell = cell; }
}
