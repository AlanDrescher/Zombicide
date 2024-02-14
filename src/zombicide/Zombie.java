package zombicide;

import java.util.ArrayList;

public class Zombie extends Humanoide{
	private int movement;
	private int damage;
	private String type;
	private static ArrayList<Zombie> initzombies;
	
	protected Zombie() {
		setMovement(movement);
		setDamage(damage);
		setType(type);
	}
	
	//Movimiento
	protected int getMovement() {
		return movement;
	}
	
	private void setMovement(int movement) {
		this.movement = movement;
	}
	
	//Daño
	protected int getDamage() {
		return damage;
	}
	
	private void setDamage(int damage) {
		this.damage = damage;
	}
	
	//Tipo
	protected String getType() {
		return type;
	}
	
	private void setType(String type) {
		this.type = type;
	}
	
	//Init Zombies
	public static ArrayList<Zombie> getInitZombies() {
		return initzombies;
	}

	public static void setInitZombies(ArrayList<Zombie> initzombies) {
		Zombie.initzombies = initzombies;
	}
}
