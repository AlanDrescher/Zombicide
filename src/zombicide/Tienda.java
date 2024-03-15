package zombicide;

import java.util.Scanner;

public class Tienda {
	// Variables
	int sp;
	int gold;
	int espada;

	// Constructor
	protected Tienda(int gold) {
		setGold(gold);
		Menu();
	}

	// Menú
	public void Menu() {
		Scanner leer = new Scanner(System.in);
		boolean salir = false;
		if (getGold() > 0) {
			System.out.println("\r\n¡Bienvenido! \r\n¡Tengo una selección de productos en oferta, extranjero!");
			while (!salir) {
				System.out.println("|-----\033[46m\033[1;30mTienda del buhonero\033[0m-----| \u001B[33mOro\033[0m: "
						+ gold
						+ "\r\n1- Hoja del Olimpo \u001B[33m200 de oro\033[0m \r\n2- Habilidad Extra \u001B[33m250 de oro\033[0m \r\n"
						+ "3- Curación Total \u001B[33m50 de oro\033[0m \r\n4- Aumento de Vida Máxima \u001B[33m150 de oro\033[0m \r\n0- Salir");
				switch (leer.next()) {
				case "1": {
					if (getGold() < 200) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {
						setespada(1);
						System.out.println("Has comprado la \033[47m\033[1;36m\033[4;34mHoja del Olimpo\033[0m \r\n");
						gold -= 200;
					}
					break;
				}
				case "2": {
					if (getGold() < 250) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {
						setSp(getSp() + 1);
						System.out.println("Has comprado la \033[47m\033[1;31m\033[4;31mHabilidad Extra\033[0m \r\n");
						gold -= 250;
					}
					break;
				}
				case "3": {
					if (getGold() < 50) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {
						for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
							Zombicide.getSelectCharacters().get(i)
									.setHealth(Zombicide.getSelectCharacters().get(i).getMaxHealth());
						}
						System.out.println("Has comprado \033[47m\033[1;32m\033[4;32mCuración Total\033[0m \r\n");
						gold -= 50;

					}
					break;
				}
				case "4": {
					if (getGold() < 150) {
						System.out.println("No tienes \u001B[33moro\033[0m suficiente");
					} else {
						for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
							Zombicide.getSelectCharacters().get(i)
									.setMaxHealth(Zombicide.getSelectCharacters().get(i).getMaxHealth() + 1);
						}
						System.out
								.println("Has comprado \033[47m\033[1;32m\033[4;32mAumento de Vida Máxima\033[0m \r\n");
						gold -= 150;

					}
					break;
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

	// GETTERS Y SETTERS
	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold() {
		return gold;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getSp() {
		return sp;
	}

	public void setespada(int espada) {
		this.espada = espada;
	}

	public int getespada() {
		return espada;
	}
}
