package zombicide;

public class ZombieRey extends Zombie{
	
		protected ZombieRey() {
		super("Zombie", 7, 7, true);
		super.setMovement(1);
		super.setDamage(2);
		super.setType("Rey 1");
	}
}
