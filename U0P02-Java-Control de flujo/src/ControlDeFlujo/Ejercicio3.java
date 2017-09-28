package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio3 {

	private static Scanner leer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		leer = new Scanner(System.in);
		int n, suma=0;
		do{
			System.out.println("Introduce un número");
			n=leer.nextInt();
			suma=suma+n;
			}while(suma<=50);
			System.out.println("La suma es "+suma);
			}
					
	}


