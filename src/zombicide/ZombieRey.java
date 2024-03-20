package zombicide;

public class ZombieRey extends Zombie {

	// Constructor
	protected ZombieRey() {
		super("Zombie", 5, 5, true);
		super.setMovement(1);
		super.setDamage(2);
		super.setType("Rey");
	}
}
