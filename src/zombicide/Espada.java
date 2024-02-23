package zombicide;

public class Espada extends Arma {

	protected Espada(String toString, int damage, int range, int hit) {
		super.Arma("Espada corta", 1, 1, 4);
		super.toString("Mata gratis a 2 zombies aleatorios.");
	}
}
