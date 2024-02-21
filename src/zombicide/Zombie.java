package zombicide;

<<<<<<< Updated upstream
import java.util.ArrayList;

public class Zombie extends Humanoide {
=======
public class Zombie extends Humanoide{
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

	private void setMovement(int movement) {
=======
	
	protected void setMovement(int movement) {
>>>>>>> Stashed changes
		this.movement = movement;
	}

	// Daño
	protected int getDamage() {
		return damage;
	}
<<<<<<< Updated upstream

	private void setDamage(int damage) {
=======
	
	protected void setDamage(int damage) {
>>>>>>> Stashed changes
		this.damage = damage;
	}

	// Tipo
	protected String getType() {
		return type;
	}
<<<<<<< Updated upstream

	private void setType(String type) {
=======
	
	protected void setType(String type) {
>>>>>>> Stashed changes
		this.type = type;
	}
}
