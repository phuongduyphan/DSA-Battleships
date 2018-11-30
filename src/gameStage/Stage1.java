package gameStage;

import java.io.IOException;

import UI.CommandStage1;
import UI.UIHandler;
import UI.UIHandlerStage1;
import UI.gui.Main;
import gameBoard.Configurations;
import gameBoard.player.BotPlayer;
import gameBoard.player.HumanPlayer;
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
		}
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		Player human = new HumanPlayer();
		((HumanPlayer) human).createGUI();
		
		Configurations.initialize();
		
		Configurations.listOfPlayer.add(human);
		Configurations.mapWeaponImage.put(WeaponType.BULLET_SHOT, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.ROCKET, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.HORIZONTAL_BOMBING, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.VERTICAL_BOMBING, "rocket.png");
		Configurations.mapShipImage.put(ShipType.AIRCRAFT_CARRIER, "aircraft_carrier");
		Configurations.mapShipImage.put(ShipType.BATTLESHIP, "battleship");
		Configurations.mapShipImage.put(ShipType.DESTROYER, "destroyer");
		Configurations.mapShipImage.put(ShipType.PATROL_BOAT, "patrol_boat");
		Configurations.mapShipImage.put(ShipType.SUBMARINE, "submarine");
		Configurations.listOfUI.add(human.getUi());
		
		try {
			Configurations.listOfUI.get(0).createStage1();
			StackPane menuBoard = Configurations.listOfUI.get(0).getContainerStage1();
			Scene scene = new Scene(menuBoard,1280,720);
			String css = getClass().getResource("/styles/application.css").toString();
			scene.getStylesheets().add(css);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.centerOnScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uiHandler.enableInput();
	}
	
	public void createGame(CommandStage1 cmd) {
		Player human = Configurations.listOfPlayer.get(0);
		Strategy humanStrategy = cmd.getMode();
		((HumanPlayer) human).create(humanStrategy);
		
		Strategy botStrategy = cmd.getMode();
		Player bot = new BotPlayer();
		botStrategy.setBot((BotPlayer) bot);
		((BotPlayer) bot).create(botStrategy);
		Configurations.listOfPlayer.add(bot);
		
		done();
	}
	
	
	
	public void done() {
		App.getInstance().setStateAndStart(Stage2.getInstance());
	}

	@Override
	public UIHandler getUIHandler() {
		return uiHandler;
	}
}
