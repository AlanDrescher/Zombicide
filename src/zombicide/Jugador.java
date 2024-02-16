package zombicide;

public class Jugador extends Humanoide{
	private boolean pass;
	private String weapon;
	
	protected Jugador(String name, int health, int maxHealth, boolean status) {
		super(name, health, maxHealth, status);
		
	}

	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
