package EjercicioTaller;

public class Mecanicos {

	private int codMecanico;
	private String nombre;
	private double sueldo;
	private boolean libre;
	private Vehiculos vehiculoReparacion;
	private static int cont;
	
	public Mecanicos(String nombre, double sueldo, Vehiculos v) {
		
		this.codMecanico = cont;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.vehiculoReparacion = v;
		if(v==null) {
			this.libre=true;
		}else
			this.libre=false;
		
		cont++;
	}

	public int getCodMecanico() {
		return codMecanico;
	}

	public void setCodMecanico(int codMecanico) {
		this.codMecanico = codMecanico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Vehiculos getVehiculoReparacion() {
		return vehiculoReparacion;
	}

	public void setVehiculoReparacion(Vehiculos vehiculoReparacion) {
		this.vehiculoReparacion = vehiculoReparacion;
	}

	@Override
	public String toString() {
		return "Mecanicos [codMecanico=" + codMecanico + ", nombre=" + nombre + ", sueldo=" + sueldo + ", libre="
				+ libre + ", vehiculoReparacion=" + vehiculoReparacion + "]";
	}
}
