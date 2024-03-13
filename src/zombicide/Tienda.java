package zombicide;

import java.util.Scanner;

public class Tienda {

	private int gold;
	
	protected Tienda() {
		
	}
	
	public void Menu() {
		Scanner leer = new Scanner(System.in);
		System.out.println("\u001B[33mOro\u001B[45m: " + gold);
		System.out.println("¡Bienvenido! \r\n ¡Tengo una selección de buenos productos en venta, extranjero!");
		
		if (gold > 0) {
			
		} else {
			System.out.println("Vuelve cuando tengas \u001B[33mdinero\u001B[45m, no somos una ONG");
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
