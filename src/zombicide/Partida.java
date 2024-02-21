package zombicide;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	private ArrayList<Zombie> initzombies;
	private int level;
	protected Partida() {
		initzombies= new ArrayList<Zombie>(Zombicide.getSelectCharacters().size());
	}

	public void showMenu() {
		boolean leave = false;
		Scanner leer = new Scanner(System.in);
		zombirandom();
		while (!leave) {
			texto();
			switch (leer.nextInt()) {
			case 1: {
				attack();
				break;
			}
			case 2: {
				specialHability();
				break;
			}
			case 3: {
				search();
				break;
			}
			case 4: {
				switchWeapon();
				break;
			}
			case 0: {
				System.out.println("Has pasado");
				leave = true;
				break;
			}
			default:
				System.out.println("Opcion no válida, intente otra");
			}
		}

	}


	private void attack() {

	}

	// Habilidad Especial
	private void specialHability() {
		System.out.println("|---Zombicide---|\r\n" + "Dame el nombre del personaje: ");

	}

	// Cambiar Arma
	private void switchWeapon() {

	}

	// Buscar
	private void search() {
		Random random = new Random();
		Arma arma = new Arma();
		int resultado = random.nextInt(100);
		System.out.println("Has Sacado un " + resultado + ". ");
		if (resultado >= 50) {
			System.out.println("Has obtenido: " + arma.getWeapon());
			arma.getWeapon();
		} else {
			System.out.println("No te da nada");
		}

	}

	private void zombirandom() {
		for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
			int random = new Random().nextInt(3);
			if (random == 0) {
				Zombie zombicaminante = new ZombieCaminante();
				setInitzombies(zombicaminante);
			}
			if (random == 2) {
				Zombie zombicorredor = new ZombieCorredor();
				setInitzombies(zombicorredor);
			}
			if (random == 1) {
				Zombie zombigordo = new ZombieGordo();
				setInitzombies(zombigordo);
			}
		}
	}

	// Menú
	private void texto() {
		for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
			System.out.print("|----- NIVEL: " + level + " -----|\r\n ==| " + getInitzombies().get(i).getName()+ " "+getInitzombies().get(i).getType() + " |==\r\n"
					+ "JUGADOR: " + Zombicide.getSelectCharacters().get(i).getName() + "\r\n1- Atacar\r\n"
					+ "2- Habilidad Especial\r\n" + "3- Buscar\r\n" + "4- Cambiar Arma\r\n" + "0- Pasar\r\n");

		}
	}

	public ArrayList<Zombie> getInitzombies() {
		return initzombies;
	}

	public void setInitzombies(Zombie initzombies) {
		this.initzombies.add(initzombies);
	}
}
