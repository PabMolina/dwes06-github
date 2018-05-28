package ejercicioGasolinera;

public class Principal {

	public static void main(String[] args) {

		String respuesta = "";
		int x;
		// CREAMOS LA GASOLINERA
		Gasolinera g1 = new Gasolinera();
		// CREAMOS LOS SURTIDORES
		Surtidor s1 = new Surtidor();
		Surtidor s2 = new Surtidor();
		Surtidor s3 = new Surtidor();
		Surtidor s4 = new Surtidor();
		// AÑADIMOS LOS SURTIDORES A LA LISTA DE SURTIDORES DE LA GASOLINERA
		g1.listaSurtidores.add(s1);
		g1.listaSurtidores.add(s2);
		g1.listaSurtidores.add(s3);
		g1.listaSurtidores.add(s4);
		do {
			System.out.println("Elige una opción:");
			System.out.println("1.Entrada de coche");
			System.out.println("2.Salida de un coche");
			System.out.println("3.Ver Información de la gasolinera");
			x = LeerTeclado.readInteger();
			switch (x) {
			case 1:
				g1.altaCoche();
				break;
			case 2:
				g1.bajaCoche();
				break;
			case 3:
				g1.listadoGeneral();
				break;
			}
			System.out.println("¿Quieres continuar?si|no");
			respuesta = LeerTeclado.readString();
		} while (respuesta.equalsIgnoreCase("si"));
		System.out.println("Fin del programa");

	}

}
