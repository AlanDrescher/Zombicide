package zombicide;

import java.util.ArrayList;
import java.util.Scanner;

public class Zombicide {
	protected static ArrayList<Jugador> initcharacters = new ArrayList<Jugador>(10);
	protected static ArrayList<Jugador> initselectcharacter = new ArrayList<Jugador>(7);

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
		Jugador jugador3 = new Jugador("James", 7, 7, true);
		Jugador jugador1 = new Jugador("Marie", 5, 5, true);
		Jugador jugador2 = new Jugador("Jaci", 5, 5, true);
		setCharacters(jugador1);
		setCharacters(jugador2);
		setCharacters(jugador3);
		if (initcharacters.size()>3) {
			System.out.println("Selecciona personajes:");
			for (int x =0;x<initcharacters.size();x++) {
				System.out.println("Selecciona entre 3 y 6 personajes: "+getCharacters().get(x));
	
			}
			System.out.println("Selecciona entre 3 y 6 personajes: ");
			
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
		Jugador jugador = new Jugador(nombre);
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
						+ "💀Zombi"
						+ "\u001B[30m\u001B[41m"
						+ "cide💀"
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