package zombicide;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	private ArrayList<Zombie> initzombies;
	private ArrayList<Arma> initobjetos;
	private int level;

	// Menú
	private void texto() {
		Scanner leer = new Scanner(System.in);
		boolean perder = false;
		while (perder == false) {
			if (Zombicide.getSelectCharacters().size() == 0) {
				System.out.println("Has perdido, más suerte la próxima vez");
				perder = true;
				break;
			}
			zombirandom();
			for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
				System.out.print("\r\n|----- NIVEL: " + getlevel() + " - " + i + " -----|\r\n \r\n==| ");
				for (int x = 0; x < getInitzombies().size(); x++) {
					System.out.print(getInitzombies().get(x).toString() + " ");
				}
				System.out.print("|==\r\n" + "JUGADOR: " + Zombicide.getSelectCharacters().get(i).toString() + " Arma["
						+ Zombicide.getSelectCharacters().get(i).getWeapon().toString() + "] " + "\r\n1- Atacar\r\n"
						+ "2- Habilidad Especial\r\n" + "3- Buscar\r\n" + "4- Cambiar Arma\r\n" + "0- Pasar\r\n");
				switch (leer.nextInt()) {
				case 1: {
					attack(i);
					break;
				}
				case 2: {
					specialHability(i);
					break;
				}
				case 3: {
					setInitobjetos(Zombicide.search());
					break;
				}
				case 4: {
					switchWeapon(i);
					break;
				}
				case 0: {
					System.out.println("Has pasado");
					break;
				}
				default:
					System.out.println("Opción no válida, intente otra");
				}
				if (getInitzombies().size() == 0) {
					setlevel((getlevel() + 1));
					System.out.println("Has pasado al nivel: " + getlevel());
					for (int y = 0; y < Zombicide.getSelectCharacters().size(); y++) {
						Zombicide.getSelectCharacters().get(y)
								.setHealth(Zombicide.getSelectCharacters().get(y).getMaxHealth());
					}
					System.out.println("Milagrosamente tus personajes se han regenerado");
					i = -1;
					zombirandom();

				}
				if (getInitzombies().size() != 0 && i == (Zombicide.getSelectCharacters().size() - 1)) {
					attackZombie();
					setlevel(0);
				}

			}
		}

	}

	protected Partida() {
		initobjetos = new ArrayList<Arma>();
		initzombies = new ArrayList<Zombie>(Zombicide.getSelectCharacters().size());
		setlevel(Zombicide.getSelectCharacters().size());
		showMenu();
	}

	public void showMenu() {
		texto();
	}

	private void zombiehability(Zombie zombie, int a) {
		int zombieHability = new Random().nextInt(0, 101);
		if (zombieHability >= 95 && getInitzombies().size() >= 1) {
			System.out.println("¡¡El Zombie " + zombie.getType() + " ha activado su habilidad especial!!");
			if (zombie.getType() == "Caminante") {
				getInitzombies().remove(a);
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (getInitzombies().get(x).getType() == "Caminante") {
						setInitzombies(new ZombieCaminante());
					}
				}
			} else if (zombie.getType() == "Corredor") {
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (getInitzombies().get(x).getType() == "Corredor") {
						getInitzombies().remove(x);
					}
				}
			} else {
				getInitzombies().remove(a);
				for (int x = (getInitzombies().size() - 1); x >= 0; x--) {
					if (getInitzombies().get(x).getType() == "Gordo") {
						getInitzombies().remove(x);
						break;
					}
				}
			}
		} else {
			getInitzombies().remove(a);
		}
	}

	// Ataque y Habilidades de los zombies
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
							zombiehability(zombie, a);
						}
					} else {
						System.out.println("Ha fallado tu ataque con un " + randomhit);
					}

				} else {
					System.out.println(getInitzombies().get(i).getType() + " ha evitado el ataque!");
				}
			}

		}

	}

	// Habilidad Especial
	private void specialHability(int i) {
		System.out.println(Zombicide.getSelectCharacters().get(i).getWeapon().getspecialattack());
	}

	// Cambiar Arma
	private void switchWeapon(int i) {
		Scanner leer = new Scanner(System.in);
		for (int x = 0; x < getInitobjetos().size(); x++) {
			System.out.println(x + "- " + getInitobjetos().get(x).toString());
		}
		System.out.println("Escoge arma: ");
		int arma = leer.nextInt();
		Zombicide.getSelectCharacters().get(i).setWeapon(getInitobjetos().get(arma));
		getInitobjetos().remove(arma);
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

	public ArrayList<Arma> getInitobjetos() {
		return initobjetos;
	}

	public void setInitobjetos(Arma initobjetos) {
		if (initobjetos != null) {
			this.initobjetos.add(initobjetos);
		}
	}
}
