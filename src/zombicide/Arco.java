package zombicide;

public class Arco extends Arma {

	// Constructor
	protected Arco(String name, int damage, int range, int hit) {
		super.setName(name);
		super.setDamage(damage);
		super.setRange(range);
		super.setHit(hit);
	}

	@Override
	public String specialAttack() {
		return "Mata gratis a 1 corredor.";
	}
}
