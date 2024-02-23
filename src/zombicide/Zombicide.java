package zombicide;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Zombicide {
	protected static ArrayList<Jugador> initcharacters;
	protected static ArrayList<Jugador> initselectcharacter;
	protected static ArrayList<Arma> initObjetos;

	public static void main(String[] args) {
		initObjetos= new ArrayList<Arma>(4);
		initcharacters = new ArrayList<Jugador>(10);
		defaultCharacter();
		defaultArmas();
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
		Jugador marie = new Jugador("Marie", 5, 5, true);
		marie.setWeapon(new Arma());
		setCharacters(marie);
		Jugador jaci = new Jugador("Jaci", 5, 5, true);
		jaci.setWeapon(new Arma());
		setCharacters(jaci);
		Jugador james = new Jugador("James", 5, 5, true);
		james.setWeapon(new Arma());
		setCharacters(james);
	}
	private static void defaultArmas() {
		setObject(new Arco("Arco Largo", 1, 2, 3));
		setObject(new Hacha("Hacha doble", 2,1,3));
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
		Partida partida = new Partida();
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
	// Buscar Arma
	public static String search() {
		Random random = new Random();
		int resultadoarma = random.nextInt(4);
		int resultado = random.nextInt(100);
		System.out.println("Has Sacado un " + resultado + ". ");
		if (resultado >= 70) {
			setObject(getObject().get(resultadoarma));
			return "Has obtenido: "+getObject().get(resultadoarma).getName();
		} else {
			if (resultado >= 50) {
				setObject(new Arma());
				return "Has obtenido: " + new Arma().getName();
			}
			else {
				return "No te da nada";
			}

		}

	}

	// Nuevo Personaje
	private static void newCharacter() {
		Scanner leer = new Scanner(System.in);
		tittle();
		System.out.println("Dame el nombre del personaje: ");
		String nombre = leer.next();
		Jugador jugador = new Jugador(nombre, 5, 5, true);
		jugador.setWeapon(new Arma());
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