package UI;

import java.util.ArrayList;

import gameBoard.Configurations;
import gameBoard.cell.Cell;
import gameBoard.player.HumanPlayer;
import gameBoard.player.Player;
import gameBoard.weapon.Weapon;
import gameStage.Stage3;

public class UIHandlerStage3 extends UIHandler {
	
	public void enableInput() {
		setCmd(new CommandStage3());
		currentUI = Stage3.getInstance().getCurrentPlayer().getUi();
		if (Stage3.getInstance().getCurrentPlayer() instanceof HumanPlayer) updateCommand(Configurations.listOfPlayer.get(1));
		currentUI.getWeaponPaneStage3().unselected();
		currentUI.enableInputStage3();
	}
	
	public void setReadyToShoot() {
		currentUI.enableShootStage3();
	}
	
	public void shoot() {
		currentUI.shootStage3((CommandStage3) cmd);	
	}
	
	public void updateCommand(IClickable i) {
		assert (cmd instanceof CommandStage3);
        CommandStage3 c = (CommandStage3) cmd;
        if (i instanceof Player) c.setTargetPlayer((Player)i);
        else if (i instanceof Weapon) c.setWeapon((Weapon)i);
        else if (i instanceof Cell) c.setCell((Cell)i);
        else throw new Error(i.getClass() + "is not a valid input for cmdstage3");
      
        System.out.println(c.isCompleted());
        if (c.isCompleted()) c.onFinished();
	}
	
	public void display(Command cmd, ArrayList<Cell> listOfExplosion) {
		for (int i=0; i<Configurations.listOfUI.size(); i++) {
			Configurations.listOfUI.get(i).displayStage3((CommandStage3) cmd,listOfExplosion);
		}
	}
	
	public void switchPlayer() {
		currentUI.switchPlayerStage3();
	}
	
}
