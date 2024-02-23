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

	private void attack() {
	}

	// Habilidad Especial
	private void specialHability() {
		
	}

	// Cambiar Arma
	private void switchWeapon() {

	}

	// Buscar

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
		Scanner leer = new Scanner(System.in);
		for (int i = 0; i < Zombicide.getSelectCharacters().size(); i++) {
			System.out.print("|----- NIVEL: " + getlevel() + " - " + i + " -----|\r\n ==| ");
			for (int x = 0; x < getInitzombies().size(); x++) {
				System.out.print(getInitzombies().get(x).toString() + " ");
			}
			System.out.print("|==\r\n" + Zombicide.getSelectCharacters().get(i).toString() + " Arma["
					+ Zombicide.getSelectCharacters().get(i).getWeapon().toString() + "] " + "\r\n1- Atacar\r\n"
					+ "2- Habilidad Especial\r\n" + "3- Buscar\r\n" + "4- Cambiar Arma\r\n" + "0- Pasar\r\n");
			switch (leer.nextInt()) {
			case 1: {
				Arma arma = Zombicide.getSelectCharacters().get(i).getWeapon();
				int zombie = getInitzombies().get(i).getHealth();
				getInitzombies().get(i).setHealth(zombie - arma.getDamage());
				System.out.println("La salud del zombie es de " + getInitzombies().get(i).getHealth()+"/"+zombie);
				if (arma.getDamage() >= zombie) {
					getInitzombies().get(i).setStatus(false);
					System.out.println("El zombie ha muerto");
				} else {
					if (getInitzombies().get(i).getStatus() == false) {
						break;
					}
					
				}
				break;
			}
			case 2: {
				specialHability();
				break;
			}
			case 3: {
				System.out.println(Zombicide.search());
				break;
			}
			case 4: {
				for (int x = 0; x < getInitobjetos().size(); x++) {
					System.out.println(x + "- " + getInitobjetos().get(x).toString());
				}
				System.out.println("Escoge arma: ");
				Zombicide.getSelectCharacters().get(i).setWeapon(getInitobjetos().get(leer.nextInt()));
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
		this.initobjetos.add(initobjetos);
	}
}
