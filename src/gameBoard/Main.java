package gameBoard;
import java.util.ArrayList;

import gameBoard.player.BotPlayer;
import gameBoard.player.EasyMode;
import gameBoard.player.HumanPlayer;
import gameBoard.player.Player;
import gameBoard.player.Strategy;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;
import gameBoard.weapon.Weapon;
import gameBoard.weapon.WeaponFactory;
import gameBoard.weapon.WeaponType;
import gameState.State1;
import gameState.State3;
import gameState.app;

public class Main {

    public static void main(String[] args) {

    	Board humanBoard = new Board(8,8);
    	
    	humanBoard.createShip(new Coordinate(4, 4), ShipOrientation.NORTH, ShipType.PATROL_BOAT);
    	Board botBoard = new Board(8,8);
    	botBoard.createShip(new Coordinate(3, 3), ShipOrientation.NORTH, ShipType.PATROL_BOAT);
    	ArrayList<Weapon> listWeaponOfHuman = new ArrayList<>();
    	ArrayList<Weapon> listWeaponOfBot = new ArrayList<>();
    	listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT));
    	listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT));
    	
    	Strategy mode = new EasyMode();
    	
    	Player human = new HumanPlayer(humanBoard,listWeaponOfHuman);
    	Player bot = new BotPlayer(botBoard,listWeaponOfBot,mode);
    	mode.setBot((BotPlayer) bot);
    	
    	GameHandler.getInstance().addPlayers(human);
    	GameHandler.getInstance().addPlayers(bot);
    	System.out.println(GameHandler.getInstance().getPlayers().size());
    	
    	
    	app.getInstance().setStateAndStart(State3.getInstance());
    }

}
