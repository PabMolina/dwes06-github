package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leer = new Scanner(System.in);
		int n;
		System.out.println("Introduce un número");
		n=leer.nextInt();
	}
	public void incorrecto() {
		try {
		int numero;
		Scanner leer=new Scanner(System.in);
		System.out.println("Introduce un numero");
		numero=leer.nextInt();	
		System.out.println(numero);
		}catch(Exception e) {
			System.out.println("El valor introducido es incorrecto");
		}
	}
}
