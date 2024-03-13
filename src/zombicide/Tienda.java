package zombicide;

import java.util.Scanner;

public class Tienda {

	private int gold;
	
	protected Tienda() {
		
	}
	
	public void Menu() {
		Scanner leer = new Scanner(System.in);
		System.out.println("¡Bienvenido! \r\n ¡Tengo una selección de buenos productos en venta, extranjero!");
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold() {
		return gold;
	}
}
