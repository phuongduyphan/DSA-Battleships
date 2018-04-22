package gameBoard;

import java.util.ArrayList;
import java.util.HashMap;

import UI.UI;
import gameBoard.player.BotPlayer;
import gameBoard.player.HumanPlayer;
import gameBoard.player.Player;
import gameBoard.ship.ShipType;
import gameBoard.weapon.WeaponType;

public class Configurations {
	public static Integer numberOfColumns = 8;
	public static Integer numberOfRows = 8;
	public static HashMap<WeaponType, String> mapWeaponImage;
	public static ArrayList<Player> listOfPlayer;
	public static ArrayList<UI> listOfUI;
	public static HashMap<ShipType, String> mapShipImage;
	
	public static void initialize() {
		mapWeaponImage = new HashMap<>();
		listOfPlayer = new ArrayList<>();
		listOfUI = new ArrayList<>();
		mapShipImage = new HashMap<>();
	}
}
