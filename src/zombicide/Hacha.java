package zombicide;

public class Hacha extends Arma {

	protected Hacha(String toString, int damage, int range, int hit) {
		super(toString, damage, range, hit);
		super.toString("Mata gratis a 1 gordo.");
	}
}
