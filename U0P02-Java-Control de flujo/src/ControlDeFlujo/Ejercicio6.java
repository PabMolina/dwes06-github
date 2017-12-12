package ControlDeFlujo;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {

	private static Scanner teclado;

	public static void main(String[] args) {
		int a = 0,b=0;
		teclado = new Scanner(System.in);
		boolean error=false;
		
		System.out.println("Introduce dos numeros entre 1 y 10");
		
		do{
		try{
			
			a=teclado.nextInt();
			b=teclado.nextInt();
			error=false;
		}catch(InputMismatchException e){
			teclado=new Scanner(System.in);
			System.out.println("Error,introduce dos números,no introduzcas letras");
			error=true;
		}
		}while((a<1 || a>10) || (b<1 || b>10));
		
		while(a<b || b<a){
			if(a<b){
			a++;
			System.out.print("*");
			}else if(b<a){
			b++;
			System.out.print("*");
			}
			
			
		}
		System.out.println();
		System.out.println("Los dos números ya son iguales");
		
		
		}
		
	}
	


