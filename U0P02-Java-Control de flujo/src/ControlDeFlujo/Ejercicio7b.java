package ControlDeFlujo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7b {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		int factorial=1;
		boolean error=false;
		// leer numero
		System.out.println("Introduce un número:");
		do{
		try{
		
		numero = teclado.nextInt();
		while(numero!=0){
			factorial=factorial*numero;
			numero--;
			error=false;
		}
		System.out.println("El factorial del número es "+factorial);
		}catch(InputMismatchException e){
			teclado = new Scanner(System.in);
			System.out.println("Error,introduce un numero");
			error=true;
		}
		}while(error);
	
		

}
}