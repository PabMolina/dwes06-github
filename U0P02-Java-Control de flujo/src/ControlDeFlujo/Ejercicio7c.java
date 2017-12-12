package ControlDeFlujo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7c {

	public static void main(String[] args) {
		int numero;
		int factorial=1;
		boolean error=false;
		Scanner teclado=new Scanner(System.in);

		System.out.println("Introduce un numero");
		do{
		try{
			numero=teclado.nextInt();
		for(int i=1;i<=numero;i++){
			factorial=factorial*i;
			error=false;
		}
		System.out.println("El factorial del número es "+factorial);
		}catch(InputMismatchException e){
			teclado=new Scanner(System.in);
			System.out.println("Error,introduce un numero");
			error=true;
		}
		}while(error);
		
	}

}
