package zombicide;

public class Arco extends Arma {

	protected Arco(String name, int damage, int range, int hit) {
		super.setName(name);
		super.setDamage(damage);
		super.setRange(range);
		super.setHit(hit);
		super.toString("Mata gratis a 1 corredor.");
	}
}
