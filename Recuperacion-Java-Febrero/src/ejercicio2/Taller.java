package ejercicio2;

import java.util.ArrayList;

public class Taller {
	
	ArrayList<Averias> listaAverias;
	ArrayList<Vehiculos> listaVehiculosReparacion;
	ArrayList<Mecanicos> listaMecanicos;
	ArrayList<Vehiculos> listaEspera;
	
	public Taller() {
		super();
		listaAverias = new ArrayList<>();
		listaVehiculosReparacion = new ArrayList<>();
		listaMecanicos = new ArrayList<>();
		listaEspera = new ArrayList<>();
		
		Mecanicos mec1 = new Mecanicos("Joaquín", 1200, true);
		Mecanicos mec2 = new Mecanicos("Felipe", 1200, false);
		Averias av1 = new Averias();
		
		listaMecanicos.add(mec1);
		listaMecanicos.add(mec2);
		listaAverias.add(av1);
		
		
	}
	public void altaVehiculo() {
		String mat;
		String ans;
		int plazas;
		int cc;
	
		System.out.println("Escribe la matrícula del vehículo");
		mat = LeerTeclado.readString();
		System.out.println("¿Es un coche o una moto?");
		ans = LeerTeclado.readString();
		if(ans.equalsIgnoreCase("coche")) {
			
			System.out.println("Introduce el número de plazas");
			plazas = LeerTeclado.readInteger();
			Coches c1 = new Coches(mat, "En espera", plazas);
			
			for(int i=0; i<listaMecanicos.size(); i++) {
				
				if(listaMecanicos.get(i).getVehiculoReparacion()==null) {
					System.out.println("Tenemos un mecánico disponible. Su vehículo será reparado por "+listaMecanicos.get(i).getNombre());
					c1.setEstado("En reparacion");
					listaMecanicos.get(i).getVehiculoReparacion()[1]= listaVehiculosReparacion.get(i).getMatricula();
					listaVehiculosReparacion.add(c1);
				}else {
					System.out.println("En este momento no tenemos ningún mecanico disponible. Su vehículo pasará a a la lista de espera.");
					listaEspera.add(c1);
				}
			}
			
		}
		if(ans.equalsIgnoreCase("moto")) {
			System.out.println("Introduce la cilindrada");
			cc = LeerTeclado.readInteger();
			Motocicletas m1 = new Motocicletas(mat, "En espera", cc); 
			
			for(int i=0; i<listaMecanicos.size(); i++) {
				
				if(listaMecanicos.get(i).getVehiculoReparacion()==null) {
					
					System.out.println("Tenemos un mecánico disponible. Su vehículo será reparado por "+listaMecanicos.get(i).getNombre());
					m1.setEstado("En reparacion");
					listaMecanicos.get(i).getVehiculoReparacion()[1]=listaVehiculosReparacion.get(i).getMatricula();
					listaVehiculosReparacion.add(m1);
				}else {
					
					System.out.println("En este momento no tenemos ningún mecanico disponible. Su vehículo pasará a a la lista de espera.");
					listaEspera.add(m1);
			}
		
			}
		}
	}

	public ArrayList<Averias> getListaAverias() {
		return listaAverias;
	}

	public void setListaAverias(ArrayList<Averias> listaAverias) {
		this.listaAverias = listaAverias;
	}

	public ArrayList<Vehiculos> getListaVehiculosReparacion() {
		return listaVehiculosReparacion;
	}

	public void setListaVehiculos(ArrayList<Vehiculos> listaVehiculosReparacion) {
		this.listaVehiculosReparacion = listaVehiculosReparacion;
	}

	public ArrayList<Mecanicos> getListaMecanicos() {
		return listaMecanicos;
	}

	public void setListaMecanicos(ArrayList<Mecanicos> listaMecanicos) {
		this.listaMecanicos = listaMecanicos;
	}

	public ArrayList<Vehiculos> getListaEspera() {
		return listaEspera;
	}

	public void setListaEspera(ArrayList<Vehiculos> listaEspera) {
		this.listaEspera = listaEspera;
	}
	
	
}
