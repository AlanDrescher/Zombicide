package zombicide;

import java.util.Scanner;
import java.util.ArrayList;

public class Zombicide {
<<<<<<< HEAD
	private static ArrayList characters;
	private static boolean leave= false; 
=======
	private String nombreCanal;
	private static boolean salir = false; 
	
>>>>>>> 458a8cf1296d374327543fd39884e1bb3d9a0c7a
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


	private static void newGame() {
		
	}

	private static void newCharacter() {
		
	}

	// TEXTO DE JUEGO
	public static void texto() {
			System.out.println("|---Zombicide---|\r\n" + "1- Nueva partida\r\n"
					+ "2- Nuevo personaje\r\n"
					+ "0- Salir\r\n");
		}

	public static ArrayList getCharacters() {
		return characters;
	}

	public static void setCharacters(ArrayList characters) {
		Zombicide.characters = characters;
	}

}