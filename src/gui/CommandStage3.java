package gui;

import gameBoard.Coordinate;
import gameBoard.GameHandler;
import gameBoard.player.Player;
import gameBoard.weapon.Weapon;

public class CommandStage3 extends Command {
    private Player targetPlayer;
    private Weapon weapon;
    private Coordinate coor;

    @Override
    public boolean isCompleted() {
        if (targetPlayer != null && weapon != null && coor != null) return true;
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

    public Coordinate getCoor() { return coor; }

    public void setCoor(Coordinate coor) { this.coor = coor; }
}
