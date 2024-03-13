package zombicide;

import java.util.Scanner;

public class Tienda {
	
	int gold;
	
	protected Tienda(int gold) {
		Menu();
		this.gold = gold;	
	}
	
	public void Menu() {
		Scanner leer = new Scanner(System.in);
		if (gold > 0) {
			System.out.println("Oro: " + gold);
			System.out.println("¡Bienvenido! \r\n ¡Tengo una selección de buenos productos en venta, extranjero! \r\n 1- Hoja del Olimpo oro \\r\\n 2-");
		} else {
			System.out.println("Vuelve cuando tengas dinero, no somos una ONG");
			return;
		}
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold() {
		return gold;
	}
}
