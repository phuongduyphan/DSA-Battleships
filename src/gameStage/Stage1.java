package gameStage;

import java.io.IOException;

import UI.CommandStage1;
import UI.UIHandler;
import UI.UIHandlerStage1;
import UI.gui.Main;
import gameBoard.Configurations;
import gameBoard.player.BotPlayer;
import gameBoard.player.EasyMode;
import gameBoard.player.HumanPlayer;
import gameBoard.player.NormalMode;
import gameBoard.player.Player;
import gameBoard.player.Strategy;
import gameBoard.ship.ShipType;
import gameBoard.weapon.WeaponType;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Stage1 implements IStage {
	private static Stage1 instance = null;
	private UIHandler uiHandler;
	
	private Stage1() {
		uiHandler = new UIHandlerStage1();
	}
	
	public static Stage1 getInstance() {
		if (instance == null) {
			instance = new Stage1();
		};
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		Player human = new HumanPlayer();
		((HumanPlayer) human).create();
		
		Configurations.initialize();
		
		Configurations.listOfPlayer.add(human);
		Configurations.mapWeaponImage.put(WeaponType.BULLET_SHOT, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.ROCKET, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.HORIZONTAL_BOMBING, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.VERTICAL_BOMBING, "rocket.png");
		Configurations.mapShipImage.put(ShipType.AIRCRAFT_CARRIER, "AIRCRAFT_CARRIER");
		Configurations.mapShipImage.put(ShipType.BATTLESHIP, "BATTLESHIP");
		Configurations.mapShipImage.put(ShipType.DESTROYER, "DESTROYER");
		Configurations.mapShipImage.put(ShipType.PATROL_BOAT, "PATROL_BOAT");
		Configurations.mapShipImage.put(ShipType.SUBMARINE, "SUBMARINE");
		Configurations.listOfUI.add(human.getUi());
		
		try {
			Configurations.listOfUI.get(0).createStage1();
			StackPane menuBoard = Configurations.listOfUI.get(0).getContainerStage1();
			Scene scene = new Scene(menuBoard,1280,720);
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
	
	public void createGame(CommandStage1 cmd) {
		Strategy botStrategy = cmd.getMode();
		Player bot = new BotPlayer();
		botStrategy.setBot((BotPlayer) bot);
		((BotPlayer) bot).create(botStrategy);
		Configurations.listOfPlayer.add(bot);
		
		done();
	}
	
	
	
	public void done() {
		app.getInstance().setStateAndStart(Stage2.getInstance());
	}

	@Override
	public UIHandler getUIHandler() {
		return uiHandler;
	}
}
