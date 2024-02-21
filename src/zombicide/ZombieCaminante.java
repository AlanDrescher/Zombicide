package zombicide;

public class ZombieCaminante extends Zombie{

	protected ZombieCaminante() {
		super("Zombi", 1, 1, true);
		super.setMovement(1);
		super.setDamage(1);
		super.setType("Caminante");
		//super.setInitZombies();
	}
}
