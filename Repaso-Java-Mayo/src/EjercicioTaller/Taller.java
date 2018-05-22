package EjercicioTaller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import Ejercicio2.Averias;


public class Taller {

	ArrayList<Averias> listaAverias;
	LinkedList<Vehiculos> listaVehiculosReparacion;
	Vector<Mecanicos> listaMecanicos;
	LinkedList<Vehiculos> listaEspera; //Debería ser una cola, pero ahora mismo no se hacerlo.

	public Taller() {

		listaAverias = new ArrayList<Averias>();
		listaVehiculosReparacion = new LinkedList<Vehiculos>();
		listaMecanicos = new Vector<Mecanicos>();
		listaEspera = new LinkedList<Vehiculos>();
		
	}

	// ---------------------------------------1-RECEPCIÓN DE VEHICULOS------------------------------------------------------------------------------

	public void altaVehiculo() {

		String eleccion, mat;
		Vehiculos v = null;
		boolean libre=false;
		Mecanicos mecAux=null;

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
		// O MOTO-----------------------------------------------------------------------------------
		} else if (eleccion.equalsIgnoreCase("moto")) {
			int cc;
			System.out.println("¿Cuánta cilindrada tiene?");
			cc = LeerTeclado.readInteger();
			v = new Motocicleta(mat, cc);
		}
		//RECORRO LA LISTA DE MECANICOS PARA VER SI HAY ALGUNO LIBRE, CON UN FOREACH----------------------
		for (Mecanicos m : listaMecanicos) {

			if (m.isLibre() == true) {
				libre = true;// Utilizo esta variable para saber que hay mecánico disponible.
				mecAux = m; // Guardo este mecanico en una variable auxiliar para utilizarlo.
			}
		}
		//SI HAY UN MECÁNICO LIBRE------------------------------------------------------------------------
		if(libre == true) {
			
				mecAux.setVehiculoReparacion(v);//Asignamos el vehiculo al mecánico.
				mecAux.setLibre(false);//El mecánico ya no está libre.
				v.setEstado("En reparación");//Cambiamos el estado del vehículo (siempre comienza "En espera").
				System.out.println("El vehículo se ha asignado al mecánico "+mecAux.getNombre());
		//SI NO HAY UN MECÁNICO LIBRE----------------------------------------------------------------------		
			}else {
				System.out.println("En estos momentos no hay ningún mecánico libre");
				v.setEstado("En espera");//El vehiculo siempre comienza en espera, pero por si acaso.
				listaEspera.add(v);//Añadimos el vehículo a la lista de espera.
			}
		}
	
	// ---------------------------------------2-TERMINACIÓN DE UNA REPARACIÓN------------------------------------------------------------------------------
	public void terminarReparacion(int codMecanico) {
		
		Mecanicos mecAux=null;
		Vehiculos vAux=null;
		boolean encontrado = false;
		Averias avAux = null;
		int codAux;
		
		for (Mecanicos m : listaMecanicos) {
			
			if(m.getCodMecanico() == codMecanico) {
				
				mecAux = m;
				vAux = m.getVehiculoReparacion();
				encontrado = true;
				
			}else {
				
				System.out.println("No existe un mecánico con este código");
			}
			
			if(encontrado = true) {
				
				for (int i = 0; i < listaAverias.size(); i++) {
					
				
					}
					
				}
				
				
			}
		}
		
	}

}

