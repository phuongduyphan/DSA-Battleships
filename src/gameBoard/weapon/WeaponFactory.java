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
	
	public Weapon create(WeaponType type,int numberOfWeapon) {
		switch (type) {
		case BULLET_SHOT: 
			return new BulletWeapon(type,numberOfWeapon);
		case ROCKET: 
			return new RocketWeapon(type,numberOfWeapon);
		case HORIZONTAL_BOMBING: 
			return new HorizontalBombWeapon(type,numberOfWeapon);
		case VERTICAL_BOMBING: 
			return new VerticalBombWeapon(type,numberOfWeapon);
		default:
			return null;
		}
	}
}
