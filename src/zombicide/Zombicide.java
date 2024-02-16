package zombicide;

import java.util.ArrayList;
import java.util.Scanner;

public class Zombicide {
	protected static ArrayList<Jugador> initcharacters = new ArrayList<Jugador>(10);

	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		boolean leave = false;
		Scanner leer = new Scanner(System.in);
		while (!leave) {
			texto();
			switch (leer.nextInt()) {
			case 1: {
				newGame();
				break;
			}
			case 2: {
				newCharacter();
				break;
			}
			case 0: {
				System.out.println("Zombicide: Se apaga");
				leave = true;
				break;
			}
			default:
				System.out.println("Opcion no válida, intente otra");
			}
		}

	}

	// Nueva Partida
	private static void newGame() {
		if (initcharacters.size()>3) {
			System.out.println("Selecciona personajes:");
			for (int x =0;x<initcharacters.size();x++) {
				getCharacters().get(x);
			}
		}
		else {
			System.out.println("Tienes 3 personajes.");
		}
		Partida partida = new Partida();
		partida.showMenu();
	}

	// Nuevo Personaje
	private static void newCharacter() {
		Scanner leer = new Scanner(System.in);
		tittle();
		System.out.println("Dame el nombre del personaje: ");
		String nombre = leer.next();
		Jugador jugador = new Jugador(nombre, 5, 0, true);
		setCharacters(jugador);
		jugador.setWeapon("Daga");
	}

	// Menú del Juego
	public static void texto() {
		tittle();
		System.out.println("1- Nueva partida\r\n" + "2- Nuevo personaje\r\n" + "0- Salir\r\n");
	}
	
	public static void tittle() {
		System.out.println("|---"
						+ "\u001B[40m\u001B[31m"
						+ "Zombi"
						+ "\u001B[30m\u001B[41m"
						+ "cide"
						+ "\u001B[0m---|\r\n");
	}

	// Init Personajes
	public static ArrayList<Jugador> getCharacters() {
		return initcharacters;
	}

	public static void setCharacters(Jugador characters) {
		Zombicide.initcharacters.add(characters);
	}


}