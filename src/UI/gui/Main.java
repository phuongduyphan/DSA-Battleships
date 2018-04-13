package UI.gui;

import java.io.IOException;
import java.util.ArrayList;

import gameBoard.Board;
import gameBoard.Configurations;
import gameBoard.Coordinate;
import gameBoard.player.BotPlayer;
import gameBoard.player.EasyMode;
import gameBoard.player.HumanPlayer;
import gameBoard.player.Player;
import gameBoard.player.Strategy;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;
import gameBoard.weapon.BulletWeapon;
import gameBoard.weapon.Weapon;
import gameBoard.weapon.WeaponFactory;
import gameBoard.weapon.WeaponType;
import gameStage.Stage3;
import gameStage.app;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Board humanBoard = new Board(8, 8);

		humanBoard.createShip(new Coordinate(4, 4), ShipOrientation.NORTH, ShipType.PATROL_BOAT);
		Board botBoard = new Board(8, 8);
		botBoard.createShip(new Coordinate(3, 3), ShipOrientation.NORTH, ShipType.PATROL_BOAT);
		ArrayList<Weapon> listWeaponOfHuman = new ArrayList<>();
		ArrayList<Weapon> listWeaponOfBot = new ArrayList<>();
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.ROCKET));
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT));

		Strategy mode = new EasyMode();

		Player human = new HumanPlayer(humanBoard, listWeaponOfHuman);
		Player bot = new BotPlayer(botBoard, listWeaponOfBot, mode);
		mode.setBot((BotPlayer) bot);

		Configurations.listOfPlayer.add(human);
		Configurations.listOfPlayer.add(bot);
		Configurations.mapWeaponImage.put(WeaponType.BULLET_SHOT, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.ROCKET, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.HORIZONTAL_BOMBING, "rocket.png");
		Configurations.mapWeaponImage.put(WeaponType.VERTICAL_BOMBING, "rocket.png");
		 
		GUI humanGUI = new GUI(human);
		Configurations.listOfUI.add(humanGUI);
		humanGUI.createStage3();
		
		Scene scene = new Scene(humanGUI.getContainerStage3(),540,920);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		app.getInstance().setStateAndStart(Stage3.getInstance());

	}

	public static void main(String[] args) {
		launch(args);
	}
}
