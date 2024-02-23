package zombicide;

public class Arco  extends Arma{

	protected Arco(String toString, int damage, int range, int hit) {
		super.Arma(toString, damage, range, hit);
		super.toString("Mata gratis a 1 corredor.");
	}
}
