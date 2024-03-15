package zombicide;

import java.util.Scanner;

public class Tienda{

	// Variables
	int gold;

	// Constructor
	protected Tienda(int gold) {
		setGold(gold);
		Menu();
	}

	// Menú
	public void Menu() {
		Scanner leer = new Scanner(System.in);
		boolean salir = false;
		if (gold > 0) {
			System.out
					.println("\r\n¡Bienvenido! \r\n¡Tengo una selección de productos en oferta, extranjero!");
			while (!salir) {
				System.out.println("|-----\033[46m\033[1;30mTienda del buhonero\033[0m-----| \u001B[33mOro\033[0m: " + gold
						+ "\r\n1- Hoja del Olimpo \u001B[33m200 de oro\033[0m \r\n2- Habilidad Extra \u001B[33m250 de oro\033[0m \r\n"
						+ "3- Curación Total\u001B[33m50 de oro\033[0m \r\n4- Aumento de Vida Máxima \u001B[33m150 de oro\033[0m \r\n0- Salir");
				switch (leer.next()) {
				case "1": {
					if (gold < 0) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {
						Arma olimpo = new Espada("\033[47m\033[1;36m\033[4;34mHoja del Olimpo\033[0m", 7, 3, 3);
						Partida partida = new Partida();
						partida.setInitobjetos(olimpo);
						System.out.println("Has comprado la \033[47m\033[1;36m\033[4;34mHoja del Olimpo\033[0m \r\n");
						gold -= 200;
					} break;
				}
				case "2": {
					if (gold < 0) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {
						Partida partida2 = new Partida();
						partida2.setsp(partida2.getsp()+1);
						System.out.println("Has comprado la \033[47m\033[1;31m\033[4;31mHabilidad Extra\033[0m \r\n");
						gold -= 250;
					}break;
				}
				case "3": {
					if (gold < 0) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {
						for(int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
							Zombicide.getSelectCharacters().get(i).setHealth(Zombicide.getSelectCharacters().get(i).getMaxHealth());
						}
						System.out.println("Has comprado \033[47m\033[1;32m\033[4;32mCuración Total\033[0m \r\n");
						gold -= 50;
						
					}break;
				}
				case "4": {
					if (gold < 0) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {
						for(int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
							Zombicide.getSelectCharacters().get(i).setMaxHealth(Zombicide.getSelectCharacters().get(i).getMaxHealth()+1);
						}
						System.out.println("Has comprado \033[47m\033[1;32m\033[4;32mAumento de Vida Máxima\033[0m \r\n");
						gold -= 150;
						
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
