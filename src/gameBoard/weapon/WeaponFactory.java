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
			return new BulletWeapon();
		case ROCKET: 
			return new RocketWeapon();
		case HORIZONTAL_BOMBING: 
			return new HorizontalBombWeapon();
		case VERTICAL_BOMBING: 
			return new VerticalBombWeapon();
		}
		return null;
	}
}
