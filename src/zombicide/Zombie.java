package zombicide;

public class Zombie extends Humanoide{
	private int movement;
	private int damage;
	private String type;
	
	protected Zombie() {
		setMovement(movement);
		setDamage(damage);
		setType(type);
	}
	
	protected int getMovement() {
		return movement;
	}
	
	private void setMovement(int movement) {
		this.movement = movement;
	}
	
	protected int getDamage() {
		return damage;
	}
	
	private void setDamage(int damage) {
		this.damage = damage;
	}
	
	protected String getType() {
		return type;
	}
	
	private void setType(String type) {
		this.type = type;
	}
}
