package ejercicio2;
import ejercicio2.LeerTeclado;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Taller t = new Taller();
		int x;
		
		do {
			System.out.println("Introduce una opcion \n"
					+ " 1.Rcepción de vehículo\n" + " 2.Terminación de una reparación\n"
					+ " 3.Entrega de vehículos reparados\n" + "4.exit\n");
			x = LeerTeclado.readInteger();
			
			switch (x) {
			case 1:t.altaVehiculo();
			break;
			case 2: //No me ha dado tiempo a hacer más.. me he entretenido demasiado con el primer ejercicio y con las clases de este.
				break;
			case 3:
				break;
			}
	}while (x!=4);
	
	System.out.println("Exit");
		}
}

