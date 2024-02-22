package zombicide;

import java.util.ArrayList;
import java.util.Scanner;

public class Zombicide {
	protected static ArrayList<Jugador> initcharacters;
	protected static ArrayList<Jugador> initselectcharacter;

	public static void main(String[] args) {
		initcharacters = new ArrayList<Jugador>(10);
		defaultCharacter();
		showMenu();
	}

	public static void showMenu() {
		initselectcharacter = new ArrayList<Jugador>(7);
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
				tittle();
				System.out.print("Se apaga*");
				leave = true;
				break;
			}
			default:
				System.out.println("Opcion no válida, intente otra");
			}
		}

	}

	private static void defaultCharacter() {
		setCharacters(new Jugador("Marie", 5, 5, true));
		setCharacters(new Jugador("Jaci", 5, 5, true));
		setCharacters(new Jugador("James", 7, 7, true));
	}

	// Nueva Partida
	private static void newGame() {

		if (getCharacters().size() > 3) {
			seleccionPersonaje();
		} else {
			System.out.println("Tienes solo 3 personajes. Empezaremos con esos 3");
			for (int x = 0; x < getCharacters().size(); x++) {
				setSelectCharacters(getCharacters().get(x));
			}
		}
		Partida partida = new Partida();
		partida.showMenu();
	}

	private static void seleccionPersonaje() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Selecciona personajes:");
		for (int x = 0; x < getCharacters().size(); x++) {
			System.out.println(x + "- " + getCharacters().get(x).getName());

		}
		System.out.println("Selecciona entre 3 y 6 personajes: ");
		boolean salir= false;
		for (int x = 0; x < getCharacters().size() && x <= 6; x++) {
			if (getSelectCharacters().size() == 3) {
				System.out.println("Para salir de la selección de personajes escriba 99. ");
			}
			System.out.println("Selecciona el personaje " + x + ": ");
			int seleccion = leer.nextInt();
			if (seleccion == 99) {
				break;
			}
			setSelectCharacters(getCharacters().get(seleccion));
		}

	}

	// Nuevo Personaje
	private static void newCharacter() {
		Scanner leer = new Scanner(System.in);
		tittle();
		System.out.println("Dame el nombre del personaje: ");
		String nombre = leer.next();
		Jugador jugador = new Jugador(nombre, 5, 5, true);
		jugador.setWeapon("Daga");
		setCharacters(jugador);
	}

	// Menú del Juego
	public static void texto() {
		tittle();
		System.out.println("1- Nueva partida\r\n" + "2- Nuevo personaje\r\n" + "0- Salir\r\n");
	}

	public static void tittle() {
		System.out.println(
				"|---" + "\u001B[40m\u001B[31m" + "💀Zombi" + "\u001B[30m\u001B[41m" + "cide💀" + "\u001B[0m---|\r\n");
	}

//SETTERS Y GETTERS

	// Init Personajes
	public static ArrayList<Jugador> getCharacters() {
		return initcharacters;
	}

	public static void setCharacters(Jugador characters) {
		Zombicide.initcharacters.add(characters);
	}

	// Init Seleccionados
	public static ArrayList<Jugador> getSelectCharacters() {
		return initselectcharacter;
	}

	public static void setSelectCharacters(Jugador characters) {
		Zombicide.initselectcharacter.add(characters);
	}

}