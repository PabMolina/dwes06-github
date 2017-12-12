package ControlDeFlujo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7a {

	public static void main(String[] args) {
		int numero;int factorial=1;boolean error=false;
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce un número para calcular factorial");
		do {
		try{
		
		numero=teclado.nextInt();
		do{
			factorial=factorial*numero;
			numero--;
			error=false;
		}while(numero!=0);
		System.out.println("El factorial del número es "+factorial);
		}catch(InputMismatchException e){
			teclado=new Scanner(System.in);
			System.out.println("Error,introduce un numero");
			error=true;
		}
		}while(error);

	}

}
