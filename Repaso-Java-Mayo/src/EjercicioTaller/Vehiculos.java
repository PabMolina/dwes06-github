package EjercicioTaller;

import java.util.ArrayList;

public abstract class Vehiculos {

	private String matricula;
	private String estado;
	private ArrayList<Averias> averiasVehiculo;
	
	public Vehiculos(String matricula) {
		
		this.matricula = matricula;
		estado = "En espera";
		averiasVehiculo = new ArrayList<Averias>();
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
	
	public double costeReparacion() {
		
		double costeTotal = 0;
		
		for(int i = 0; i < averiasVehiculo.size(); i++) {
			
			if(averiasVehiculo.get(i)!=null) {
				
				costeTotal = costeTotal + (averiasVehiculo.get(i).getCosteAveria());
				
			}
			
		}
		return costeTotal;
		
	}
	
	
}
