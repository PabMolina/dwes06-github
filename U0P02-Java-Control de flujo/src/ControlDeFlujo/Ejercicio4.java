package ControlDeFlujo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		int numero = 0;
		Scanner teclado = new Scanner(System.in);
		boolean error = false;

		do {
			try {
				System.out.println("Introduce un numero entre 1 y 10");
				numero = teclado.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				teclado = new Scanner(System.in);
				System.out.println("Por favor,introduce un número");
				error = true;
			}
		} while (error);
		System.out.println("El número introducido es " + numero);
	}
}

