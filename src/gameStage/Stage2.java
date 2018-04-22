package gameStage;

import java.io.IOException;

import UI.CommandStage2;
import UI.UIHandler;
import UI.UIHandlerStage2;
import UI.gui.Main;
import gameBoard.Configurations;
import javafx.scene.Scene;

public class Stage2 implements IStage {
	private static Stage2 instance = null;
	private UIHandler uiHandler;

	private Stage2() {
		uiHandler = new UIHandlerStage2();
	}

	public static Stage2 getInstance() {
		if (instance == null) {
			instance = new Stage2();
		}
		return instance;
	}

	public void handle() {
		// TODO implement each state handle

		try {
			Configurations.listOfUI.get(0).createStage2();
			Scene scene = new Scene(Configurations.listOfUI.get(0).getContainerStage2(),540,920);
			String url = "file:/D:/IU/DSA/DSA-Battleships/target/classes/UI/gui/application.css";
			scene.getStylesheets().add(url);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.centerOnScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		uiHandler.enableInput();
	}
	
	public void processInput(CommandStage2 cmd) {
		Configurations.listOfPlayer.get(0).getBoard().createShip(cmd.getCell().getCoordinate(), cmd.getOrientation(), cmd.getShipType());
		((UIHandlerStage2) uiHandler).display();
	}

	public void done() {
		App.getInstance().setStateAndStart(Stage3.getInstance());
	}

	public UIHandler getUIHandler() {
		return uiHandler;
	}
}
