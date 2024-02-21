package zombicide;

import java.util.ArrayList;
import java.util.Random;

public class Arma {
	private String name;
	private int damage;
	private int range;
	private int hit;
	private static ArrayList<Arma> initweapons;

	protected void Arma(String name, int damage, int range, int hit) {
		setName(name);
		setDamage(damage);
		setRange(range);
		setHit(hit);
	}

	public Arma() {
		Arma("Daga", 1, 1, 4);
	}

	// Nombre
	protected String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	// Daño
	protected int getDamage() {
		return damage;
	}

	private void setDamage(int damage) {
		this.damage = damage;
	}

	// Alcance
	protected int getRange() {
		return range;
	}

	private void setRange(int range) {
		this.range = range;
	}

	// Acierto
	protected int getHit() {
		return hit;
	}

	private void setHit(int hit) {
		this.hit = hit;
		Random Random = new Random();
		hit = Random.nextInt(1, 6);
	}

	// Init Objetos
	public static ArrayList<Arma> getWeapon() {
		return initweapons;
	}

	public void setWeapon(ArrayList<Arma> weapons) {
		initweapons = weapons;
	}

	// Habilidad Especial
	public String toString() {
		return "No hay habilidad especial";
	}
}
