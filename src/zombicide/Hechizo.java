package zombicide;

public class Hechizo extends Arma {

	protected Hechizo(String name, int damage, int range, int hit) {
		super(name, damage, range, hit);
		super.toString("Mata gratis a 2 caminantes.");
	}

}
