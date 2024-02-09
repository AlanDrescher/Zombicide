package zombicide;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
	private String nombreCanal;
	private static ArrayList<Canal> characters;
	private static boolean salir= false; 
	public static void main(String[] args) {
		canales = new ArrayList<Canal>();
		mostrarMenu();
	}

	public static void mostrarMenu() {
		Scanner leer = new Scanner(System.in);
		while (!salir) {
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
			salir = true;
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

	// TEXTO DE CANAL
	public static void texto() {
			System.out.println("|---Zombicide---|\r\n" + "1- Nueva partida\r\n"
					+ "2- Nuevo personaje\r\n"
					+ "0- Salir\r\n");
		}

//SET Y GET DE YOUTUBE
	public void setNombreCanal(String nombre) {
		nombreCanal = nombre;

	}

	public String getNombreCanal() {
		return nombreCanal;
	}
}