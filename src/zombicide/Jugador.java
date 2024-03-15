package zombicide;

public class Jugador extends Humanoide {
	// Variables
	private boolean pass;
	private Arma weapon;

	// Constructor
	protected Jugador(String name, int hp, int maxhp, boolean status) {
		super(name, hp, maxhp, status);
	}

	// SETTERS Y GETTERS
	// Arma
	public Arma getWeapon() {
		return weapon;
	}

	public void setWeapon(Arma arma) {
		this.weapon = arma;
	}

	// Pasar
	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public String toString() {
		return getName() + " S:" + getHealth() + "/" + getMaxHealth();
	}

}
