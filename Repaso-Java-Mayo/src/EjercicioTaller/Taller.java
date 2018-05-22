package EjercicioTaller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Taller {

	ArrayList<Averias> listaAverias;
	LinkedList<Vehiculos> listaVehiculosReparacion;
	Vector<Mecanicos> listaMecanicos;
	LinkedList<Vehiculos> listaEspera; // Debería ser una cola, pero ahora mismo no se hacerlo.

	public Taller() {

		listaAverias = new ArrayList<Averias>();
		listaVehiculosReparacion = new LinkedList<Vehiculos>();
		listaMecanicos = new Vector<Mecanicos>();
		listaEspera = new LinkedList<Vehiculos>();

	}

	// ---------------------------------------1-RECEPCIÓN DE
	// VEHICULOS------------------------------------------------------------------------------

	public void altaVehiculo() {

		String eleccion, mat;
		Vehiculos v = null;
		boolean libre = false;
		Mecanicos mecAux = null;

		System.out.println("¿Su vehículo es un coche o una moto?");
		eleccion = LeerTeclado.readString();
		System.out.println("Escriba la matrícula de su vehiculo");
		mat = LeerTeclado.readString();
		// COCHE------------------------------------------------------------------------------------
		if (eleccion.equalsIgnoreCase("coche")) {
			int plazas;
			System.out.println("¿Cuántas plazas tiene?");
			plazas = LeerTeclado.readInteger();
			v = new Coche(mat, plazas);
			// O
			// MOTO-----------------------------------------------------------------------------------
		} else if (eleccion.equalsIgnoreCase("moto")) {
			int cc;
			System.out.println("¿Cuánta cilindrada tiene?");
			cc = LeerTeclado.readInteger();
			v = new Motocicleta(mat, cc);
		}
		// RECORRO LA LISTA DE MECANICOS PARA VER SI HAY ALGUNO LIBRE, CON UN
		// FOREACH----------------------
		for (Mecanicos m : listaMecanicos) {

			if (m.isLibre() == true) {
				libre = true;// Utilizo esta variable para saber que hay mecánico disponible.
				mecAux = m; // Guardo este mecanico en una variable auxiliar para utilizarlo.
			}
		}
		// SI HAY UN MECÁNICO
		// LIBRE------------------------------------------------------------------------
		if (libre == true) {

			mecAux.setVehiculoReparacion(v);// Asignamos el vehiculo al mecánico.
			mecAux.setLibre(false);// El mecánico ya no está libre.
			v.setEstado("En reparación");// Cambiamos el estado del vehículo (siempre comienza "En espera").
			System.out.println("El vehículo se ha asignado al mecánico " + mecAux.getNombre());
			// SI NO HAY UN MECÁNICO
			// LIBRE----------------------------------------------------------------------
		} else {
			System.out.println("En estos momentos no hay ningún mecánico libre");
			v.setEstado("En espera");// El vehiculo siempre comienza en espera, pero por si acaso.
			listaEspera.add(v);// Añadimos el vehículo a la lista de espera.
		}
	}

	// ---------------------------------------2-TERMINACIÓN DE UNA
	// REPARACIÓN------------------------------------------------------------------------------

	/*
	 * public void buscarMecanico(int codMecanico) {
	 * 
	 * boolean encontrado = false; Mecanicos mec =null;
	 * 
	 * for (int i = 0; i < listaMecanicos.size(); i++) {
	 * 
	 * if (listaMecanicos.get(i).getCodMecanico() == codMecanico) {
	 * 
	 * encontrado = true;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	public void terminarReparacion(int codMecanico) {

		Vehiculos vAux = null;
		boolean encontrado = false;
		boolean foundit = false;
		Averias avAux = null;
		String respuesta;
		//RECORREMOS LA LISTA DE MECÁNICOS CON UN FOREACH-----------------------------
		for (Mecanicos m : listaMecanicos) {

			if (m.getCodMecanico() == codMecanico) { //Si encuentra el codigo de mecánico...
				
				vAux = m.getVehiculoReparacion(); //Cogemos el vehiculo que está reparando este mecánico y lo metemos en una variable.
				encontrado = true;

			}

		}

		if (!encontrado) {

			System.out.println("Este mecánico no existe");

			}
		
			//Damos opcion al cliente de elegir la averia.
		do {
			
			System.out.println("Elige una opci�n:");
			System.out.println("1.Averia 1");
			System.out.println("2.Averia 2");
			System.out.println("3.Averia 3");
			System.out.println("4.Averia 4");
			
			int x=LeerTeclado.readInteger();
			//RECORREMOS CON UN FOREACH LA LISTA ¡¡GENERAL!! DE AVERIAS----------------------------
			for (Averias a : listaAverias) {
				
				if(a.getCodAveria() == (x-1)) {//(x-1)= PORQUE LA PRIMERA POSICION DE LA LISTA ES 0 Y LA ULTIMA 3
					
					avAux = a; //Guardamos la avería en una variable para luego introducirla en la lista de averias ¡¡DEL VEHÍCULO!!
					vAux.getAveriasVehiculo().add(avAux);//Cogemos la lista de averias del vehiculo en concreto y añadimos la averia de la lista general.
					foundit = true;
					
				}
		
			}
			if(!foundit) {
				System.out.println("PRIMO NO TE INVENTES LOS NUMEROS QUE SOLO HAY 4, DEL 1 AL 4");
			}
			
					System.out.println("¿Quieres añadir más averías? si|no");
				 respuesta=LeerTeclado.readString();
					
		}while(respuesta.equalsIgnoreCase("si"));
		
			
			System.out.println(vAux.costeReparacion());
			
		
		
		//AQUI YA SOLO SERIA COMPROBACIONES DE ESTADO "REPARADO" Y DEMASES
		

		}
	}



