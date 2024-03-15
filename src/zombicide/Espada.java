package zombicide;

public class Espada extends Arma {

	// Constructor
	protected Espada(String name, int damage, int range, int hit) {
		super.setName(name);
		super.setDamage(damage);
		super.setRange(range);
		super.setHit(hit);
	}

	@Override
	public String specialAttack() {
		return "Mata gratis a 2 zombies aleatorios.";
	}
}
