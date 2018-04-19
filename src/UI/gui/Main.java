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
import gameStage.Stage2;
import gameStage.Stage3;
import gameStage.app;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import log.Log;

public class Main extends Application {
	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws IOException {
		new Log("game.log");
		primaryStage.setTitle("BattleShip");

		Board humanBoard = new Board(8, 8);
//		humanBoard.createShip(new Coordinate(4, 4), ShipOrientation.VERTICAL, ShipType.PATROL_BOAT);
//		humanBoard.createShip(new Coordinate(2, 2), ShipOrientation.HORIZONTAL, ShipType.DESTROYER);
		Board botBoard = new Board(8, 8);
		botBoard.createShip(new Coordinate(3, 3), ShipOrientation.VERTICAL, ShipType.PATROL_BOAT);
		ArrayList<Weapon> listWeaponOfHuman = new ArrayList<>();
		ArrayList<Weapon> listWeaponOfBot = new ArrayList<>();
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT,
				Configurations.numberOfColumns * Configurations.numberOfRows));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.ROCKET, 3));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.HORIZONTAL_BOMBING, 1));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.VERTICAL_BOMBING, 2));
		
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT,
				Configurations.numberOfColumns * Configurations.numberOfRows));
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.HORIZONTAL_BOMBING, 100));

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
		Configurations.mapShipImage.put(ShipType.AIRCRAFT_CARRIER, "AIRCRAFT_CARRIER");
		Configurations.mapShipImage.put(ShipType.BATTLESHIP, "BATTLESHIP");
		Configurations.mapShipImage.put(ShipType.DESTROYER, "DESTROYER");
		Configurations.mapShipImage.put(ShipType.PATROL_BOAT, "PATROL_BOAT");
		Configurations.mapShipImage.put(ShipType.SUBMARINE, "SUBMARINE");

		GUI humanGUI = new GUI(human);
		human.setUi(humanGUI);
		Configurations.listOfUI.add(humanGUI);
//		humanGUI.createStage3();

		app.getInstance().setStateAndStart(Stage2.getInstance());
		
		this.primaryStage = primaryStage;
		Scene scene = new Scene(humanGUI.getContainerStage2(), 540, 920);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
