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
	public static HashMap<WeaponType, String> mapWeaponImage = new HashMap<>();
	public static ArrayList<Player> listOfPlayer = new ArrayList<>();
	public static ArrayList<UI> listOfUI = new ArrayList<>();
	public static HashMap<ShipType, String> mapShipImage = new HashMap<>();
}
