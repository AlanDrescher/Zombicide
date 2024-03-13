package zombicide;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	// Variables
	private ArrayList<Zombie> initzombies;
	private ArrayList<Arma> initobjetos;
	private int level;
	private int oro;

	// Constructor
	protected Partida() {
		initobjetos = new ArrayList<Arma>();
		initzombies = new ArrayList<Zombie>(Zombicide.getSelectCharacters().size());
		setlevel(Zombicide.getSelectCharacters().size());
		showMenu();
	}

	// Menú
	public void showMenu() {
		Scanner leer = new Scanner(System.in);
		boolean perder = false;
		while (!perder) {
			if (Zombicide.getSelectCharacters().size() == 0) {
				for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
					Zombicide.getSelectCharacters().remove(i);
				}
				System.out.println("Has perdido, más suerte la próxima vez");
				perder = true;
				break;
			}
			zombirandom();
			int sp = 1;
			for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
				texto(i);
				switch (leer.next()) {
				case "1": {
					attack(i);
					break;
				}
				case "2": {
					specialHability(i, sp);
					sp = 0;
					break;
				}
				case "3": {
					setInitobjetos(Zombicide.search());
					break;
				}
				case "4": {
					switchWeapon(i);
					break;
				}
				case "5": {
					switchWeapon(i);
					break;
				}
				case "0": {
					System.out.println("Has pasado");
					break;
				}
				default:
					System.out.println("Opción no válida, intente otra");
					i--;
				}
				if (getInitzombies().size() == 0) {
					setlevel((getlevel() + 1));
					System.out.println("Has pasado al nivel: " + getlevel());
					bossOrHeal();
					i = -1;
					sp = 1;
					zombirandom();
				}
				if (getInitzombies().size() != 0 && i == (Zombicide.getSelectCharacters().size() - 1)) {
					attackZombie();
					setlevel(0);
				}

			}
		}
	}

	// Contenido Menú
	private void texto(int i) {
		System.out.print("\r\n" + "|-----\u001B[45m NIVEL: " + getlevel() + " - " + i
				+ " \u001B[0m-----| \u001B[33m Oro\033[0m: " + getoro() + "\r\n==|\u001B[45m");
		for (int x = 0; x < getInitzombies().size(); x++) {
			System.out.print(getInitzombies().get(x).toString() + " ");
		}
		System.out.print("\u001B[0m|==\r\n" + "\u001B[45mJUGADOR: " + Zombicide.getSelectCharacters().get(i).toString()
				+ " Arma[" + Zombicide.getSelectCharacters().get(i).getWeapon().toString() + "]" + "\u001B[0m\r\n "
				+ "\r\n1- Atacar\r\n" + "2- Habilidad Especial\r\n" + "3- Buscar\r\n" + "4- Cambiar Arma\r\n"
				+ "5- Tienda\r\n" + "0- Pasar\r\n");
	}

	// Zombie Rey y Curación de personajes
	private void bossOrHeal() {
		Random random = new Random();
		int a = random.nextInt(3);
		if (a == 0) {
			System.out.println("Los cadáveres de los zombis se acumulan y se convierte en el jefe");
			setInitzombies(new ZombieRey());
		} else {
			for (int y = 0; y < Zombicide.getSelectCharacters().size(); y++) {
				Zombicide.getSelectCharacters().get(y).setHealth(Zombicide.getSelectCharacters().get(y).getMaxHealth());
			}
			System.out.println("Milagrosamente tus personajes se han curado");

		}
	}

	// Habilidades de los zombies
	private void zombiehability(Zombie zombie, int a) {
		int zombieHability = new Random().nextInt(0, 101);
		if (zombieHability >= 5 && getInitzombies().size() >= 1) {
			System.out.println("¡¡El Zombie " + zombie.getType() + " ha activado su habilidad especial!!");
			switch (zombie.getType()) {
			case "Caminante": {
				getInitzombies().remove(a);
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (getInitzombies().get(x).getType() == "Caminante") {
						setInitzombies(new ZombieCaminante());
					}
				}
				break;
			}
			case "Corredor": {
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (getInitzombies().get(x).getType() == "Corredor") {
						getInitzombies().remove(x);
					}
				}
				break;
			}
			case "Gordo": {
				getInitzombies().remove(a);
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (getInitzombies().get(x).getType() == "Gordo") {
						getInitzombies().remove(x);
						break;
					}
				}
				break;
			}
			case "Rey": {
				break;
			}
			}
		} else {
			getInitzombies().remove(a);
		}
	}

	// Ataque de los personajes
	private void attack(int i) {
		Arma arma = Zombicide.getSelectCharacters().get(i).getWeapon();
		Random random = new Random();
		int a = random.nextInt(getInitzombies().size());
		Zombie zombie = getInitzombies().get(a);
		for (int x = 0; x < arma.getRange(); x++) {
			if (zombie.getStatus() == false) {
				zombie = getInitzombies().get(a);
			} else {
				if (arma.getHit() >= zombie.getHealth()) {
					int randomhit = arma.randomHit();
					if (randomhit >= arma.getHit()) {
						zombie.setHealth(zombie.getHealth() - arma.getDamage());
						System.out.println("¡¡Has herido al zombie!!");
						System.out.println("Zombie " + zombie.toString());
						if (zombie.getHealth() <= 0) {
							zombie.setStatus(false);
							System.out.println(getInitzombies().get(a).getType() + " ha muerto");
							dropGold(zombie);
							zombiehability(zombie, a);
						}
					} else {
						System.out.println("Ha fallado tu ataque con un " + randomhit);
					}
				} else {
					System.out.println(zombie.getType() + " ha evitado el ataque!");
				}
			}

		}

	}

	// Drop Oro Zombie
	private void dropGold(Zombie zombie) {
		switch (zombie.getType()) {
		case "Caminante": {
			setgold(getgold()+20);
			break;
		}
		case "Corredor": {
			break;
		}
		case "Gordo": {

			break;
		}
		case "Rey": {
			break;
		}
		}
	}

	// Habilidad Especial
	private void specialHability(int i, int sp) {
		Arma arma = Zombicide.getSelectCharacters().get(i).getWeapon();
		if (sp == 1) {
			arma.specialAttack();
			if (arma.getName() == "Hacha doble") {
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (getInitzombies().get(x).getType() == "Gordo") {
						getInitzombies().remove(x);
						break;
					}
				}
			} else if (arma.getName() == "Espada corta") {
				Random random = new Random();
				for (int x = 0; x < 2; x++) {
					if (getInitzombies().size() == 0) {
						break;
					} else {
						int a = random.nextInt(getInitzombies().size());
						getInitzombies().remove(a);
					}
				}
			} else if (arma.getName() == "Bola de fuego") {
				int var = 0;
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (var == 2) {
						break;
					} else if (getInitzombies().get(x).getType() == "Caminante") {
						getInitzombies().remove(x);
						var++;
					}
				}
			} else if (arma.getName() == "Arco Largo") {
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (getInitzombies().get(x).getType() == "Corredor") {
						getInitzombies().remove(x);
						break;
					}
				}
			}
		} else {
			System.out.println("Ya has gastado tu ataque especial en esta ronda. ");
		}
	}

	// Cambiar Arma
	private void switchWeapon(int i) {
		Scanner leer = new Scanner(System.in);
		if (getInitobjetos().size() != 0) {
			System.out.println("\u001B[45m Escoge arma \u001B[0m");
			for (int x = 0; x < getInitobjetos().size(); x++) {
				System.out.println((x + 1) + "- " + getInitobjetos().get(x).toString());
			}
			System.out.println(Zombicide.getSelectCharacters().get(i).getName() + " selecciona:");
			int arma = leer.nextInt() - 1;
			Zombicide.getSelectCharacters().get(i).setWeapon(getInitobjetos().get(arma));
			getInitobjetos().remove(arma);
		} else {
			System.out.println("No hay armas.");
		}

	}

	// Generador de Zombies
	private void zombirandom() {
		for (int i = getInitzombies().size(); i < getlevel(); i++) {
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

	// Ataque de los Zombies
	private void attackZombie() {
		Random random = new Random();
		for (int i = 0; i < getInitzombies().size(); i++) {
			for (int x = 0; x < getInitzombies().get(i).getMovement(); x++) {
				if (Zombicide.getSelectCharacters().size() == 0) {
					break;
				} else {
					int a = random.nextInt(Zombicide.getSelectCharacters().size());
					Zombicide.getSelectCharacters().get(a).setHealth(
							Zombicide.getSelectCharacters().get(a).getHealth() - getInitzombies().get(i).getDamage());
					System.out.println("Zombie " + getInitzombies().get(i).toString() + " ha atacado a "
							+ Zombicide.getSelectCharacters().get(a).toString());
					if (Zombicide.getSelectCharacters().get(a).getHealth() <= 0) {
						System.out.println(
								"El personaje: " + Zombicide.getSelectCharacters().get(a).toString() + " ha muerto.");
						Zombicide.getSelectCharacters().remove(a);
					}

				}

			}
		}

	}

	// SETTERS Y GETTERS
	public ArrayList<Zombie> getInitzombies() {
		return initzombies;
	}

	public void setInitzombies(Zombie initzombies) {
		this.initzombies.add(initzombies);
	}

	public void setlevel(int level) {
		this.level = level;
	}

	public int getlevel() {
		return level;
	}

	public void setoro(int oro) {
		this.oro = oro;
	}

	public int getoro() {
		return oro;
	}

	public ArrayList<Arma> getInitobjetos() {
		return initobjetos;
	}

	public void setInitobjetos(Arma initobjetos) {
		if (initobjetos != null) {
			this.initobjetos.add(initobjetos);
		}
	}
}
