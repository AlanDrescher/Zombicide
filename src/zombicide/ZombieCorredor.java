package zombicide;

public class ZombieCorredor extends Zombie {

	// Constructor
	protected ZombieCorredor() {
		super("Zombie", 1, 1, true);
		super.setMovement(2);
		super.setDamage(1);
		super.setType("Corredor");
	}
}
