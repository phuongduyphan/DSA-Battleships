package UI;

import gameBoard.cell.Cell;
import gameBoard.player.Player;
import gameBoard.weapon.Weapon;
import gameStage.App;

public class CommandStage3 extends Command {
    private Player targetPlayer;
    private Weapon weapon;
    private Cell cell;

    @Override
    public boolean isCompleted() {
        return (targetPlayer != null && weapon != null && cell != null);
    }

    @Override
    public void onFinished() {
        UIHandlerStage3 uiHandler = (UIHandlerStage3)App.getInstance().getCurrentState().getUIHandler();
        uiHandler.setReadyToShoot();
    }

    public Player getTargetPlayer() { return targetPlayer; }

    public void setTargetPlayer(Player targetPlayer) { this.targetPlayer = targetPlayer; }

    public Weapon getWeapon() { return weapon; }

    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    public Cell getCell() { return cell; }

    public void setCell(Cell cell) { this.cell = cell; }
}
