package ejercicio2;


import java.util.ArrayList;

public abstract class Vehiculos {
	
	private String matricula;
	private String estado;
	private ArrayList<Averias> averiasVehiculo;
	double costeTotal=0;
	
	
	public Vehiculos(String matricula, String estado) {
		super();
		this.matricula = matricula;
		this.estado = estado;
		averiasVehiculo = new ArrayList<>();
	}
	
	public void costeReparacion() {
		
	for(int i=0; i<averiasVehiculo.size(); i++) {
		if(averiasVehiculo.get(i)!=null) {
			costeTotal = costeTotal + (averiasVehiculo.get(i).getCosteAveria());
		}
	}
		
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public ArrayList<Averias> getAveriasVehiculo() {
		return averiasVehiculo;
	}


	public void setAveriasVehiculo(ArrayList<Averias> averiasVehiculo) {
		this.averiasVehiculo = averiasVehiculo;
	}


	@Override
	public String toString() {
		return "Vehiculos [matricula=" + matricula + ", estado=" + estado + ", averiasVehiculo=" + averiasVehiculo
				+ "]";
	}

}
