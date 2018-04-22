package UI.gui;

import java.io.IOException;

import gameStage.Stage1;
import gameStage.App;
import javafx.application.Application;
import javafx.stage.Stage;
import log.Log;

public class Main extends Application {
	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws IOException {
		new Log("game.log");
		primaryStage.setTitle("BattleShip");
		primaryStage.setResizable(false);
		
		Main.primaryStage = primaryStage;
		App.getInstance().setStateAndStart(Stage1.getInstance());
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
