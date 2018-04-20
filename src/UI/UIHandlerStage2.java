package UI;

import gameBoard.Configurations;
import gameBoard.cell.Cell;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;
import gameStage.Stage2;

public class UIHandlerStage2 extends UIHandler {
	public void enableInput() {
		cmd = new CommandStage2();
	}
	
	public void display() {
		Configurations.listOfUI.get(0).displayShipStage2((CommandStage2) cmd);
	}

	public void updateCommand(IClickable i) {
		assert (cmd instanceof CommandStage2);
		CommandStage2 c = (CommandStage2) cmd;
		if (i instanceof ShipType)
			c.setShipType((ShipType) i);
		else if (i instanceof Cell)
			c.setCell((Cell) i);
		else if (i instanceof ShipOrientation) {
			c.setOrientation((ShipOrientation) i);
		} else
			throw new Error(i.getClass() + "is not a valid input for cmdstage2");
		
		System.out.println(c.isCompleted());
		if (c.isCompleted())
			c.onFinished();
	}

	public void placeShip() {
		// TODO Auto-generated method stub
		Stage2.getInstance().processInput((CommandStage2) cmd);
		Configurations.listOfPlayer.get(0).getBoard().displayBoard();
		Configurations.listOfUI.get(0).disableShipStage2((CommandStage2) cmd);
		if (Configurations.listOfPlayer.get(0).getBoard().getListOfShips().size() == 5) Stage2.getInstance().done();
		else enableInput();;
	}
}
