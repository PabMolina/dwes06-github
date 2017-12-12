package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		int opcion1,opcion2;
		Scanner teclado=new Scanner(System.in);

		do{
			System.out.println("Selecciona un deporte");
			System.out.println("1.Fútbol");
			System.out.println("2.Baloncesto");
			System.out.println("3.Hockey");
			System.out.println("4.Volver");
			opcion1=teclado.nextInt();
			
			switch(opcion1){
			case 1:
				
				do{
					System.out.println("Has elegido futbol,introduce una opcion entre 0 y 3 para elegir posicion");
					System.out.println("Pulsa 1 para ser delantero");
					System.out.println("Pulsa 2 para ser centrocampista");
					System.out.println("Pulas 3 para ser defensa");
					
					opcion2=teclado.nextInt();
				}while(opcion2>3 || opcion2<0);
				switch(opcion2){
				case 1:System.out.println("Has elegido delantero");break;
				case 2:System.out.println("Has elegido centrocampista");break;
				case 3:System.out.println("Has elegido defensa");break;
				}
				break;
			case 2:
				
				
				do{
					System.out.println("Has elegido baloncesto,introduce una opcion entre 0 y 3 para elegir posicion");
				System.out.println("Pulsa 1 para ser base");
				System.out.println("Pulsa 2 para ser escolta");
				System.out.println("Pulsa 3 para ser pivot");
				opcion2=teclado.nextInt();
				}while(opcion2!=3 || opcion2<3 || opcion2<0);
				switch(opcion2){
				case 1:System.out.println("Has elegido base");break;
				case 2:System.out.println("Has elegido escolta");break;
				case 3:System.out.println("Has elegido pivot");break;
				
				}
				break;
			case 3:
				
				
				do{
					System.out.println("Has elegido hockey,introduce una opcion entre 0 y 3");
					System.out.println("Pulsa 1 para ser delantero");
					System.out.println("Pulsa 2 para ser centrocampista");
					System.out.println("Pulas 3 para ser defensa");
					opcion2=teclado.nextInt();
				}while(opcion2!=3 || opcion2<3 || opcion2<0);
				switch(opcion2){
				case 1:System.out.println("Has elegido delantero");break;
				case 2:System.out.println("Has elegido centrocampista");break;
				case 3:System.out.println("Has elegido defensa");break;
				}
				break;
			}
		}while(opcion1>4 || opcion1<0);
	}

}
