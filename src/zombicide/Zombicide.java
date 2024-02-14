package zombicide;

import java.util.Scanner;
import java.util.ArrayList;

public class Zombicide {
	private static ArrayList<String> initcharacters= new ArrayList<String>(10);
	private static ArrayList<Arma> initweapons;

	private static boolean leave= false; 
		
	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		Scanner leer = new Scanner(System.in);
		while (!leave) {
		texto();
		switch (leer.nextInt()) {
		//CREAR CANAL
		case 1: {
			newGame();
			break;
		}
		//SELCCIONAR CANAL
		case 2: {
			newCharacter();
			break;
		}
		//SALIR DE YOUTUBE
		case 0: {
			System.out.println("Zombicide: Se apaga*");
			leave = true;
			break;
		}
		default:
			System.out.println("Opcion no válida, intente otra");
		}}

	}

	//Nueva Partida
	private static void newGame() {
		
	}

	//Nuevo Personaje
	private static void newCharacter() {
		System.out.println("|---Zombicide---|\r\n" + "Dame el nombre del personaje: ");
		
	}

	// Menú del Juego
	public static void texto() {
			System.out.println("|---Zombicide---|\r\n" + "1- Nueva partida\r\n"
					+ "2- Nuevo personaje\r\n"
					+ "0- Salir\r\n");
		}

	//Init Personajes
	public static ArrayList<String> getCharacters() {
		return initcharacters;
	}

	public static void setCharacters(ArrayList<String> characters) {
		Zombicide.initcharacters = characters;
	}

	//Init Objetos
	public static ArrayList<Arma> getInitweapons() {
		return initweapons;
	}

	public static void setInitweapons(ArrayList<Arma> initweapons) {
		Zombicide.initweapons = initweapons;
	}

}