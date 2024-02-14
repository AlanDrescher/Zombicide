package zombicide;

public class Jugador extends Humanoide{
	private boolean pass;
	private String weapon;
	
	
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
