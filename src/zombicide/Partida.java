package zombicide;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Partida {
	private ArrayList<Zombie> initzombies;
	private static boolean leave;
	private Random random;
	public static void showMenu() {
		leave =true;
		Scanner leer = new Scanner(System.in);
		while (!leave) {
		texto();
		switch (leer.nextInt()) {
		//CREAR CANAL
		case 1: {
			newGame();
			getArma();
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
	private static void getArma() {
		Random random = new Random();
		int resultado = random.nextInt(100);
		System.out.println("Has Sacado un "+ resultado+". ");
		if (resultado >= 50) {
			System.out.println("Has obtenido: "+ getInitweapons());
			getInitweapons();
		}
		else {
			System.out.println("No te da nada");
		}
		
	}
	private static void texto(){
		System.out.print("1- Atacar\r\n"
				+ "2- Habilidad Especial\r\n"
				+ "3- Buscar\r\n"
				+ "4- Cambiar Arma\r\n"
				+ "0- Pasar");
		}
	}
