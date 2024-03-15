package zombicide;

public class Hechizo extends Arma {

	// Constructor
	protected Hechizo(String name, int damage, int range, int hit) {
		super.setName(name);
		super.setDamage(damage);
		super.setRange(range);
		super.setHit(hit);
	}

	@Override
	public String specialAttack() {
		return "Mata gratis a 2 caminantes.";
	}

}
