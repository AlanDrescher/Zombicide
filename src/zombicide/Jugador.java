package zombicide;

public class Jugador extends Humanoide {
	private boolean pass;
	private Arma weapon;

	protected Jugador(String name, int hp, int maxhp, boolean status) {
		super(name, hp, maxhp, status);
	}

	public Arma getWeapon() {
		return weapon;
	}

	public void setWeapon(Arma arma) {
		this.weapon = arma;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

}
