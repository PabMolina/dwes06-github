package EjercicioGaraje;

import HerenciaVideoclub.LeerTeclado;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Garaje g;
		String dir;
		int cap;
		System.out.println("Introduce una direccion");
		dir = LeerTeclado.readString();
		System.out.println("Introduce la capacidad del garaje");
		cap = LeerTeclado.readInteger();
		g = new Garaje(dir, cap);

		int x;
		Vehiculo v = null;
		int cont=0;

		do {
			System.out.println("Introduce una opcion \n"
					+ " 1.aparcar vehiculo y revisar ruedas\n" + " 2.sacar vehiculo\n"
					+ " 3.buscar vehiculo\n" + " 4.visualizar garaje\n" + "5.exit\n");

			x = LeerTeclado.readInteger();
			
			switch (x) {
			case 1:
				if(cont<cap){
				String matricula,
				marca,
				modelo;
				int numRuedas;
				System.out
						.println("Introduce la matricula, la marca y el modelo del vechiculo");
				matricula = LeerTeclado.readString();
				marca = LeerTeclado.readString();
				modelo = LeerTeclado.readString();
				System.out
						.println("Introduce el numero de ruedas del vehiculo");
				numRuedas = LeerTeclado.readInteger();

				v = new Vehiculo(matricula, marca, modelo, numRuedas);
				cont++;
				}else
					System.out.println("El parking está completo");
						
				g.aparcar(v);
				break;
				
			case 2:
				System.out.println("Introduce la matricula del coche que quiere sacar");
				String matric1;
				matric1=LeerTeclado.readString();
				g.salir(matric1);
				cont--;
				break;
			case 3:
				System.out.println("Introduce la matricula del vehiculo");
				String m;
				m=LeerTeclado.readString();
				System.out.println(g.buscar(m));
				break;
			case 4:
				System.out.println(g.toString());
			}

		} while (x != 5);
		
		System.out.println("Exit");
	}

}
