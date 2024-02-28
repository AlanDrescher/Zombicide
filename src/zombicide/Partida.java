package zombicide;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	private ArrayList<Zombie> initzombies;
	private ArrayList<Arma> initobjetos;
	private int level;

	protected Partida() {
		initobjetos = new ArrayList<Arma>();
		initzombies = new ArrayList<Zombie>(Zombicide.getSelectCharacters().size());
		setlevel(Zombicide.getSelectCharacters().size());
		showMenu();
	}

	public void showMenu() {
		zombirandom();
		texto();

	}

	// Ataque y Habilidades de los zombies
	private void attack(int i) {
		Arma arma = Zombicide.getSelectCharacters().get(i).getWeapon();
		int random = new Random().nextInt(getInitzombies().size());
		Zombie zombie = getInitzombies().get(random);
		if (zombie.getStatus() == false) {
			zombie = getInitzombies().get(random);
		} else {
			if (arma.getHit() >= zombie.getHealth()) {
				if (arma.randomHit() >= arma.getHit()) {
					getInitzombies().get(i).setHealth(zombie.getHealth() - arma.getDamage());
					System.out.println("Has herido al zombie!!");
					System.out.println("Zombie " + getInitzombies().get(i).toString());
					if (arma.getDamage() >= zombie.getHealth()) {
						getInitzombies().get(i).setStatus(false);
						System.out.println(getInitzombies().get(i).getType() + " ha muerto");
						int zombieHability = new Random().nextInt(0, 101);
						if (zombieHability >= 95) {
							System.out.println("¡¡El Zombie ha activado su habilidad especial!!");
							if (getInitzombies().get(i).getType() == "Caminante") {
								getInitzombies().get(i * 2).toString();
							} else if (getInitzombies().get(i).getType() == "Corredor") {
								getInitzombies().remove(i);
							} else {
								getInitzombies().remove(i);
							}
						} else {
							getInitzombies().remove(i);
						}
					}
				} else {
					System.out.println(
							"Ha fallado tu ataque con un " + arma.randomHit());
				}

			} else {
				System.out.println(getInitzombies().get(i).getType() + " ha evitado el ataque!");
			}
		}

	}

	// Habilidad Especial
	private void specialHability() {

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

	// Buscar

	private void zombirandom() {
		for (int i = 0; i < getlevel(); i++) {
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
		Scanner leer = new Scanner(System.in);
		boolean perder = false;
		while (perder == false) {
			if (Zombicide.getSelectCharacters().size()==0) {
				System.out.print("Has perdido.");
				perder = true;
				break;
			}
			for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
				System.out.print("|----- NIVEL: " + getlevel() + " - " + i + " -----|\r\n ==| ");
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
					specialHability();
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
					System.out.println("Opcion no válida, intente otra");
				}
			}
			attackZombie();
		}

	}

	private void attackZombie() {
		for (int i = 0; i < getInitzombies().size(); i++) {
			if (getInitzombies().get(i).getStatus() == true) {
				for (int x = 0; x < getInitzombies().get(i).getMovement(); x++) {
					int random = new Random().nextInt(Zombicide.getSelectCharacters().size());
					int a = random;
					Zombicide.getSelectCharacters().get(a).setHealth(Zombicide.getSelectCharacters().get(a).getHealth()- getInitzombies().get(i).getDamage());
					System.out.println("Zombie " + getInitzombies().get(i).toString() + " ha atacado a "
							+ Zombicide.getSelectCharacters().get(a).toString());
					if (Zombicide.getSelectCharacters().get(i).getHealth()==0) {
						System.out.println("El personaje: " + Zombicide.getSelectCharacters().get(a).toString() + " ha muerto.");
						Zombicide.getSelectCharacters().remove(a);
					}
				}
			}
		}

	}

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
