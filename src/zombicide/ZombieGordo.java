package zombicide;

public class ZombieGordo extends Zombie {

	// Constructor
	protected ZombieGordo() {
		super("Zombie", 2, 2, true);
		super.setMovement(1);
		super.setDamage(1);
		super.setType("Gordo");
	}
}
