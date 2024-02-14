package zombicide;

import java.util.Random;

public class Arma {
	private String name;
	private int damage;
	private int range;
	private int hit;
	
	protected Arma(String name, int damage, int range ,int hit) {
		setName(name);
		setDamage(damage);
		setRange(range);
		setHit(hit);
	}
	
	//Nombre
	protected String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	//Daño
	protected int getDamage() {
		return damage;
	}
	
	private void setDamage(int damage) {
		this.damage = damage;
	}
	
	//Alcance
	protected int getRange() {
		return range;
	}
	
	private void setRange(int range) {
		this.range = range;
	}
	
	//Acierto
	protected int getHit() {
		return hit;
	}
	
	private void setHit(int hit) {
		this.hit = hit;
		Random Random = new Random();
		hit = Random.nextInt(1,6);
	}
	
	//Habilidad Especial
	public String toString() {
		return "No hay habilidad especial";
	}
}
