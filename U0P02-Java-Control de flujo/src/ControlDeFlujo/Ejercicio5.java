package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio5 {


	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			scan = new Scanner(System.in);  
			int n;
			int r;
			System.out.println("¿Qué mes del año es?");
			
			n=scan.nextInt();
			
			System.out.println("¿Es año bisiesto? (1:Sí 2:No)");
			
			
			r=scan.nextInt();
			
				
			switch(n) {
			
			case 1:System.out.println("Enero, 31 días");break;
			case 2:
				if(r==1) {
					System.out.println("Febrero, 29 días");
				}else
					System.out.println("Febrero, 28 días");break;
			case 3:System.out.println("Marzo, 31 días");break;
			case 4:System.out.println("Abril, 30 días");break;
			case 5:System.out.println("Mayo, 31 días");break;
			case 6:System.out.println("Junio, 30 días");break;
			case 7:System.out.println("Julio, 31 días");break;
			case 8:System.out.println("Agosto, 31 días");break;
			case 9:System.out.println("Septiembre, 30 días");break;
			case 10:System.out.println("Octubre, 31 días");break;
			case 11:System.out.println("Noviembre, 30 días");break;
			case 12:System.out.println("Diciembre, 31 días");break;
			default:System.out.println("Dato erróneo");
		
			
			
		}

	}
	
		
	}


