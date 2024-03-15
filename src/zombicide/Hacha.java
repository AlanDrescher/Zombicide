package zombicide;

public class Hacha extends Arma {

	// Constructor
	protected Hacha(String name, int damage, int range, int hit) {
		super.setName(name);
		super.setDamage(damage);
		super.setRange(range);
		super.setHit(hit);
	}

	@Override
	public String specialAttack() {
		return "Mata gratis a 1 gordo.";

	}
}