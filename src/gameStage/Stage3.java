package gameStage;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;

import UI.CommandStage3;
import UI.UIHandler;
import UI.UIHandlerStage3;
import UI.gui.Main;
import gameBoard.Configurations;
import gameBoard.player.BotPlayer;
import gameBoard.player.Player;
import javafx.scene.Scene;
import log.Log;

public class Stage3 implements IStage {
	private static Stage3 instance = null;
	private Iterator<Player> iterator;
	private Player currentPlayer;
	private UIHandler uiHandler;
	private int currentTurn;

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
		try {
			Configurations.listOfUI.get(0).createStage3();
			Scene scene = new Scene(Configurations.listOfUI.get(0).getContainerStage3(), 540, 920);
			String css = getClass().getResource("/styles/application.css").toString();
			scene.getStylesheets().add(css);
			Main.primaryStage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextTurn();
	}

	public void nextTurn() {
		if (!iterator.hasNext()) {
			iterator = Configurations.listOfPlayer.iterator();
			currentTurn++;
		}
		currentPlayer = iterator.next();
		Log.logger.log(Level.INFO, ""+currentPlayer.getClass());
		currentPlayer.play();
	}

	public void processInput(CommandStage3 o) {
		o.getTargetPlayer().update(o.getWeapon(), o.getCell().getCoordinate(),currentPlayer);
		if (currentPlayer instanceof BotPlayer) ((BotPlayer) currentPlayer).getMode().update(o.getTargetPlayer().getBoard().getListOfDestroyedCells()
				, o.getTargetPlayer().getBoard().getListOfDestroyedShips());
		
		((UIHandlerStage3) uiHandler).display(o, o.getTargetPlayer().getBoard().getListOfTargetableCells()
				,o.getTargetPlayer().getBoard().getListOfDestroyedShips());
	}

	public void displayFinish(CommandStage3 o) {
		// TODO Auto-generated method stub
		o.getTargetPlayer().getBoard().clearListOfTargetableCells();
		o.getTargetPlayer().getBoard().clearListOfDestroyedCells();
		o.getTargetPlayer().getBoard().clearListOfDestroyedShips();

		if (!checkWin()) {
			UIHandlerStage3 uiTemp = (UIHandlerStage3) uiHandler;
			uiTemp.switchPlayer();
		} else {
			if (Configurations.listOfPlayer.get(0).canMove())
				Configurations.listOfUI.get(0).displayStatusStage3(true);
			else
				Configurations.listOfUI.get(0).displayStatusStage3(false);
		}
	}

	public void switchPlayerFinish() {
		this.nextTurn();
	}

	private boolean checkWin() {
		for (Player player : Configurations.listOfPlayer) {
			if (player != currentPlayer && player.canMove()) {
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
		App.getInstance().setStateAndStart(Stage4.getInstance());
	}

	public UIHandler getUIHandler() {
		return uiHandler;
	}

	public int getCurrentTurn() {
		return currentTurn;
	}
	
}
