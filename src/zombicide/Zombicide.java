package zombicide;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Zombicide {
	protected static ArrayList<Jugador> initcharacters;
	protected static ArrayList<Jugador> initselectcharacter;
	protected static ArrayList<Arma> initObjetos;

	public static void main(String[] args) {
		initObjetos = new ArrayList<Arma>(4);
		initcharacters = new ArrayList<Jugador>(10);
		defaultCharacter();
		defaultArmas();
		showMenu();
	}

	// Menú principal
	public static void showMenu() {
		initselectcharacter = new ArrayList<Jugador>(6);
		boolean leave = false;
		Scanner leer = new Scanner(System.in);
		while (!leave) {
			texto();
			switch (leer.next()) {
			case "1": {
				// nueva partida
				newGame();
				break;
			}
			case "2": {
				// nuevo personaje
				newCharacter();
				break;
			}
			case "3": {
				// borrar personaje
				delCharacter();
				break;
			}
			case "0": {
				tittle();
				System.out.println("Se apaga");
				leave = true;
				leer.close();
				break;
			}
			default:
				System.out.println("Opción no válida, intente otra");
			}
		}

	}

	// Generador de Personajes
	private static void defaultCharacter() {
		Jugador marie = new Jugador("Marie", 5, 5, true);
		Arma b = new Arma();
		Arma a = new Arma();
		a.Daga();
		marie.setWeapon(a);
		setCharacters(marie);
		Jugador jaci = new Jugador("Jaci", 5, 5, true);
		jaci.setWeapon(b);
		setCharacters(jaci);
		Jugador james = new Jugador("James", 7, 7, true);
		b.Mandoble();
		james.setWeapon(b);
		setCharacters(james);
	}

	// Generador de Armas
	private static void defaultArmas() {
		setObject(new Arco("Arco Largo", 1, 2, 3));
		setObject(new Hacha("Hacha doble", 2, 1, 3));
		setObject(new Hechizo("Bola de fuego", 1, 3, 4));
		setObject(new Espada("Espada corta", 1, 1, 4));
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
		// Max vida de personajes seleccionados
		for (int y = 0; y < getSelectCharacters().size(); y++) {
			getSelectCharacters().get(y).setHealth(getSelectCharacters().get(y).getMaxHealth());
		}
		Partida partida = new Partida();
	}

	// Selección de Personaje
	private static void seleccionPersonaje() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Selecciona personajes:");
		System.out.println("Selecciona entre 3 y 6 personajes: ");
		for (int x = 0; x < 6 && getCharacters().size() != 0; x++) {
			for (int y = 0; y < getCharacters().size(); y++) {
				System.out.println((y + 1) + "- " + getCharacters().get(y).getName());
			}
			if (getSelectCharacters().size() == 3) {
				System.out.println("Para salir de la selección de personajes escriba 0. ");
			}
			System.out.println("Selecciona el personaje " + (x + 1) + ": ");
			int seleccion = leer.nextInt();
			if (seleccion == 0) {
				break;
			}
			setSelectCharacters(getCharacters().get(seleccion - 1));
			getCharacters().remove(seleccion - 1);
		}

	}

	// Borrar Personaje
	private static void delCharacter() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Personajes para borrar:");
		for (int x = 0; x < getCharacters().size(); x++) {
			System.out.println((x + 1) + "- " + getCharacters().get(x).getName());
		}
		System.out.println("Para salir de borrar de personajes escriba 0. ");
		for (int x = 0; x < getCharacters().size() && x <= 6; x++) {
			System.out.println("Borrar el personaje " + (x + 1) + ": ");
			int seleccion = leer.nextInt() - 1;
			if (seleccion + 1 == 0) {
				break;
			}
			getCharacters().remove(seleccion);
		}
	}

	// Buscar Arma
	public static Arma search() {
		Random random = new Random();
		int resultadoarma = random.nextInt(4);
		int resultado = random.nextInt(100);
		System.out.println("Has Sacado un " + resultado + ". ");
		if (resultado >= 70) {
			System.out.println("Has obtenido: " + getObject().get(resultadoarma).getName());
			return getObject().get(resultadoarma);
		} else {
			if (resultado >= 50) {
				Arma arma = new Arma();
				arma.Daga();
				System.out.println("Has obtenido: " + arma.getName());
				return arma;
			} else {
				System.out.println("No te da nada");
				return null;
			}

		}

	}

	// Nuevo Personaje
	private static void newCharacter() {
		Scanner leer = new Scanner(System.in);
		Arma a = new Arma();
		a.Daga();
		if (getCharacters().size() < 10) {
			tittle();
			System.out.println("Dame el nombre del personaje: ");
			String nombre = leer.next();
			Jugador jugador = new Jugador(nombre, 5, 5, true);
			jugador.setWeapon(a);
			setCharacters(jugador);
		} else {
			System.out.println("Has superado el límite de personajes: ");
		}

	}

	// Menú del Juego
	public static void texto() {
		tittle();
		System.out.println(
				"1- Nueva partida\r\n" + "2- Nuevo personaje\r\n" + "3- Remover personaje\r\n" + "0- Salir\r\n");
	}
	// Título del Juego

	public static void tittle() {
		System.out.println(
				"|---" + "\u001B[40m\u001B[31m" + "💀Zombi" + "\u001B[30m\u001B[41m" + "cide💀" + "\u001B[0m---|\r\n");
	}

	// SETTERS Y GETTERS
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

	public static void setSelectCharacters(Jugador initObjetos) {
		Zombicide.initselectcharacter.add(initObjetos);
	}

	// Init Objetos
	public static ArrayList<Arma> getObject() {
		return initObjetos;
	}

	public static void setObject(Arma initObjetos) {
		Zombicide.initObjetos.add(initObjetos);
	}
}