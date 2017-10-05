package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner leer=new Scanner(System.in);
		System.out.println("Introduce la primera cadena");
		String cadena1=leer.nextLine();
		System.out.println("Introduce la segunda cadena");
		String cadena2=leer.nextLine();
		System.out.println("Introduce la tercera cadena");
		String cadena3=leer.nextLine();
		System.out.println("Introduce la cuarta cadena");
		String cadena4=leer.nextLine();
		System.out.println("Introduce la quinta cadena");
		String cadena5=leer.nextLine();
		System.out.println("UNIMOS LAS CADENAS");
		String union=cadena1.concat(cadena2).concat(cadena3).concat(cadena4).concat(cadena5);
		System.out.println(union);
	}

}
