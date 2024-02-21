package zombicide;

public class ZombieCorredor extends Zombie {

	protected ZombieCorredor() {
		super("Zombie", 1, 1, true);
		super.setMovement(1);
		super.setDamage(1);
		super.setType("Corredor");
	}
}
