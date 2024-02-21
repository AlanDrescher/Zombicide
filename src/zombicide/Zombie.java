package zombicide;

public class Zombie extends Humanoide {

	private int movement;
	private int damage;
	private String type;

	protected Zombie(String name, int health, int maxHealth, boolean status) {
		super(name, health, maxHealth, status);
		setMovement(movement);
		setDamage(damage);
		setType(type);
	}

	// Movimiento
	protected int getMovement() {
		return movement;
	}

	
	protected void setMovement(int movement) {
		this.movement = movement;
	}

	// Daño
	protected int getDamage() {
		return damage;
	}

	
	protected void setDamage(int damage) {
		this.damage = damage;
	}

	// Tipo
	protected String getType() {
		return type;
	}

	
	protected void setType(String type) {
		this.type = type;
	}
}
