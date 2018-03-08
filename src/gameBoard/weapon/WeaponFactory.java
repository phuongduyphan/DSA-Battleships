package gameBoard.weapon;

public class WeaponFactory {
	private static WeaponFactory instance;
	
	private WeaponFactory() {
		
	}
	
	public WeaponFactory getInstance() {
		if (instance == null) {
			instance = new WeaponFactory();
		}
		return instance;
	}
	
	public Weapon create(WeaponType type) {
		switch (type) {
		case BULLET_SHOT: 
			return new bulletWeapon();
		case ROCKET: 
			return new rocketWeapon();
		case HORIZONTAL_BOMBING: 
			return new horizontalBombWeapon();
		case VERTICAL_BOMBING: 
			return new verticalBombWeapon();
		}
		return null;
	}
}
