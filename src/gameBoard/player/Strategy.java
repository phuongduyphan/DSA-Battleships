package gameBoard.player;

import gameBoard.Coordinate;
import gameBoard.weapon.Weapon;

public abstract class Strategy {
	private BotPlayer bot;
	
	public void setBot(BotPlayer bot) {
		this.bot = bot;
	}
	
	public BotPlayer getBot() {
		return bot;
	}
	
	public abstract Player pickOpponent();
	public abstract Coordinate pickCoordinate(Player opponent); 
	public abstract Weapon pickWeapon();
	public abstract void runMode();
}
