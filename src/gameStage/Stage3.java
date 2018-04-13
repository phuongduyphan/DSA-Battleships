package gameStage;

import java.util.Iterator;

import UI.CommandStage3;
import UI.UIHandler;
import UI.UIHandlerStage3;
import UI.consoleUI.ConsoleOutputHandler;
import gameBoard.Configurations;
import gameBoard.player.Player;

public class Stage3 implements IStage {
	private static Stage3 instance = null;
	private Iterator<Player> iterator;
	private Player currentPlayer;
	private UIHandler uiHandler;

	private Stage3() {
		uiHandler = new UIHandlerStage3();
		iterator = new Iterator<Player>() {

			@Override
			public Player next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

	public static Stage3 getInstance() {
		if (instance == null) {
			instance = new Stage3();
		}
		return instance;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void handle() {
		// start playing game
		nextTurn();
	}

	public void nextTurn() {
		if (!iterator.hasNext()) {
			iterator = Configurations.listOfPlayer.iterator();
		}
		currentPlayer = iterator.next();
		System.out.println(currentPlayer.getClass());
		currentPlayer.play();
	}

	public void processInput(CommandStage3 o) {
		o.getTargetPlayer().update(o.getWeapon(), o.getCell().getCoordinate());
		System.out.println(o.getTargetPlayer().getBoard().getListOfShips().size());
		// ConsoleOutputHandler.getInstance().display(o.getTargetPlayer());
		uiHandler.display(o, o.getTargetPlayer().getBoard().getListOfExplosion());
	}
	
	public void displayFinish(CommandStage3 o) {
		// TODO Auto-generated method stub
		o.getTargetPlayer().getBoard().clearListOfExplosion();

		if (!checkWin()) {
			UIHandlerStage3 uiTemp = (UIHandlerStage3) uiHandler;
			uiTemp.switchPlayer();
		} 
		else done();
	}
	
	public void switchPlayerFinish() {
		this.nextTurn();
	}

	private boolean checkWin() {
		for (Player player : Configurations.listOfPlayer) {
			if (player != currentPlayer) {
				if (player.canMove())
					return false;
			}
		}
		return true;
	}

	public void reset() {
		this.iterator = null;
		this.currentPlayer = null;
	}

	public void done() {
		app.getInstance().setStateAndStart(Stage4.getInstance());
	}

	public UIHandler getUIHandler() {
		return uiHandler;
	}
}
