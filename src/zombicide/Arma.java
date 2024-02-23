package zombicide;

import java.util.ArrayList;
import java.util.Random;

public class Arma {
	private String name;
	private int damage;
	private int range;
	private int hit;
	private ArrayList<Arma> initweapons;

	protected Arma() {
		setName("Daga");
		setDamage(1);
		setRange(1);
		setHit(4);
	}


	// Nombre
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	// Daño
	protected int getDamage() {
		return damage;
	}

	protected void setDamage(int damage) {
		this.damage = damage;
	}

	// Alcance
	protected int getRange() {
		return range;
	}

	protected void setRange(int range) {
		this.range = range;
	}

	// Acierto
	protected int getHit() {
		return hit;
	}

	protected int randomHit() {
		int random = new Random().nextInt(1, 6);
		return random;
	}
	protected void setHit(int hit) {
		this.hit = hit;

	}

	// Init Objetos
	public ArrayList<Arma> getWeapon() {
		return initweapons;
	}

	public void setWeapon(Arma weapons) {
		initweapons.add(weapons);
	}

	// Habilidad Especial

	public String specialattack(String specialAttack) {
		return "specialAttack";
	}
	public String toString() {
		return (getName() + " daño:" + getDamage()  +" dist:"+ getRange() +" acier:"+ getHit()).toUpperCase();
	}

}
