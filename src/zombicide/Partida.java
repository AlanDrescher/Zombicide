package zombicide;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	private ArrayList<Zombie> initzombies;
	private Random random;
	private int level;

	public void showMenu() {
		boolean leave = false;
		Scanner leer = new Scanner(System.in);
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
				System.out.println("Zombicide: Se apaga*");
				leave = true;
				break;
			}
			default:
				System.out.println("Opcion no válida, intente otra");
			}
		}

	}

	protected Partida() {

	}

	private void attack() {

	}

	private void specialHability() {
		System.out.println("|---Zombicide---|\r\n" + "Dame el nombre del personaje: ");

	}

	private void switchWeapon() {

	}

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

	private void texto() {
		int random = new Random(Zombicide.initcharacters.size()).nextInt();
		if (random == 1) {
			new ZombieCaminante();
		}
		if (random == 2) {
			new ZombieCorredor();
		}
		if (random == 3) {
			new ZombieGordo();
		}
		System.out.print("|----- NIVEL: " + level + "==|\r\n " + random + " |==\r\n" + "JUGADOR:" + "1- Atacar\r\n"
				+ "2- Habilidad Especial\r\n" + "3- Buscar\r\n" + "4- Cambiar Arma\r\n" + "0- Pasar\r\n");
	}

	public ArrayList<Zombie> getInitzombies() {
		return initzombies;
	}

	public void setInitzombies(ArrayList<Zombie> initzombies) {
		this.initzombies = initzombies;
	}
}
