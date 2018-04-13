package gameBoard.weapon;

public class WeaponFactory {
	private static WeaponFactory instance;
	
	private WeaponFactory() {
		
	}
	
	public static WeaponFactory getInstance() {
		if (instance == null) {
			instance = new WeaponFactory();
		}
		return instance;
	}
	
	public Weapon create(WeaponType type) {
		switch (type) {
		case BULLET_SHOT: 
			return new BulletWeapon(type);
		case ROCKET: 
			return new RocketWeapon(type);
		case HORIZONTAL_BOMBING: 
			return new HorizontalBombWeapon(type);
		case VERTICAL_BOMBING: 
			return new VerticalBombWeapon(type);
		}
		return null;
	}
}
