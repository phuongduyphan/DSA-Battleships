package gameStage;

import java.io.IOException;

import UI.UIHandler;
import UI.gui.Main;
import gameBoard.Configurations;
import javafx.scene.Scene;

public class Stage4 implements IStage{
	private static Stage4 instance = null;

	public static Stage4 getInstance() {
		if (instance == null)
			return new Stage4();
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		Configurations.listOfUI.get(0).createStage4();
		Scene scene = new Scene(Configurations.listOfUI.get(0).getContainerStage4(), 540, 920);
		String url = "file:/D:/IU/DSA/DSA-Battleships/target/classes/UI/gui/application.css";
		scene.getStylesheets().add(url);
		Main.primaryStage.setScene(scene);
	}
	
	public void done() {
		app.getInstance().setStateAndStart(Stage1.getInstance());
	}
	
	public void exitGame() {
		Main.primaryStage.close();
	}

	@Override
	public UIHandler getUIHandler() {
		// TODO Auto-generated method stub
		return null;
	}
}
