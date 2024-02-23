package zombicide;

public class Hacha extends Arma {

	protected Hacha(String name, int damage, int range, int hit) {
		super.setName(name);
		super.setDamage(damage);
		super.setRange(range);
		super.setHit(hit);
		super.specialattack("Mata gratis a 1 gordo.");
	}
}
