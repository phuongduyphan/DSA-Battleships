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
import gameStage.Stage1;
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
		primaryStage.setResizable(false);
		
		this.primaryStage = primaryStage;
		app.getInstance().setStateAndStart(Stage1.getInstance());
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
