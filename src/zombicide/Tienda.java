package zombicide;

import java.util.Scanner;

public class Tienda {

	int gold;

	protected Tienda(int gold) {
		setGold(gold);
		Menu();
	}

	public void Menu() {
		Scanner leer = new Scanner(System.in);
		boolean salir = false;
		if (gold > 0) {
			System.out
					.println("\r\n¡Bienvenido! \r\n¡Tengo una selección de productos en oferta, extranjero!");
			while (!salir) {
				System.out.println("|-----\033[46m\033[1;30mTienda del buhonero\033[0m-----| \u001B[33mOro\033[0m: " + gold
						+ "\r\n1- Hoja del Olimpo \u001B[33m200 de oro\033[0m \r\n2- Habilidad Extra \u001B[33m250 de oro\033[0m \r\n3- Curación \u001B[33m50 de oro\033[0m \r\n0- Salir");
				switch (leer.next()) {
				case "1": {
					if (gold < 200) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {

					} break;
				}
				case "2": {
					if (gold < 200) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {

					}break;
				}
				case "3": {
					if (gold < 200) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {

					}break;
				}
				case "0": {
					System.out.println("Has salido de la tienda");
					salir = true;
				}
				}
			}
		} else {
			System.out.println("Vuelve cuando tengas \u001B[33moro\033[0m, no somos una ONG");
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
