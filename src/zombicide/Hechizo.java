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
	public void specialAttack() {
		System.out.println("Mata gratis a 2 caminantes.");
	}

}
