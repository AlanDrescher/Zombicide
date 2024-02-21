package zombicide;

public class Jugador extends Humanoide{
	private boolean pass;
	private String weapon;
	
	protected Jugador(String name, int hp,int maxhp,boolean status) {
		super(name,hp,maxhp,status);
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
