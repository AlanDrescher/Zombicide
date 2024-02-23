package zombicide;

public class Hechizo extends Arma {

	protected Hechizo(String name, int damage, int range, int hit) {
		super.setName(name);
		super.setDamage(damage);
		super.setRange(range);
		super.setHit(hit);
		super.toString("Mata gratis a 2 caminantes.");
	}

}
